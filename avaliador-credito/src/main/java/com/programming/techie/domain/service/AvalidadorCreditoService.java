package com.programming.techie.domain.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.programming.techie.domain.exception.DadosNotFoundException;
import com.programming.techie.domain.exception.ErroComunicacaoMicroservicesException;
import com.programming.techie.domain.model.Cartao;
import com.programming.techie.domain.model.CartaoAprovado;
import com.programming.techie.domain.model.CartaoCliente;
import com.programming.techie.domain.model.DadosAvialiacao;
import com.programming.techie.domain.model.DadosCliente;
import com.programming.techie.domain.model.RetornoAvaliacaoCliente;
import com.programming.techie.domain.model.SituacaoCliente;
import com.programming.techie.infra.clients.CartoesResourceClient;
import com.programming.techie.infra.clients.ClienteResourceClient;

import feign.FeignException.FeignClientException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvalidadorCreditoService {
	
	private final ClienteResourceClient clientResourceClient;
	
	private final CartoesResourceClient cartoesResourceClient;

	
	public SituacaoCliente obterSituacaoCliente(String cpf) {
		
		try {
			
		
		ResponseEntity<DadosCliente> dadosCliente = clientResourceClient.dadosCliente(cpf);
		
		List<CartaoCliente> cartaoCliente = cartoesResourceClient.listCartoesByCpf(cpf);

		
		return SituacaoCliente.builder()
				.cliente(dadosCliente.getBody())
				.cartoes(cartaoCliente)
				.build();
		
		} catch (FeignClientException e) {
			int status = e.status();
			
			if(HttpStatus.NOT_FOUND.value() == status) {
				throw new DadosNotFoundException();
			} else {
				throw new ErroComunicacaoMicroservicesException("Erro comunicação microservice", status);
			}
		}
		
	}


	public RetornoAvaliacaoCliente realizarAvaliacao(DadosAvialiacao dados) {
		
		try {
			
			ResponseEntity<DadosCliente> dadosClienteResponse = clientResourceClient.dadosCliente(dados.getCpf());
			List<Cartao> cartoesRendaAte = clientResourceClient.getCartoesRendaAte(dados.getRenda());
			
			List<CartaoAprovado> cartoesAprovados = cartoesRendaAte.stream().map(cartao -> {
				
				Integer idade = dadosClienteResponse.getBody().getIdade();
				
				BigDecimal limiteBasico = cartao.getLimiteBasico();
				
				BigDecimal idadeBD = BigDecimal.valueOf(idade); 
				
				var fator = idadeBD.divide(BigDecimal.valueOf(10));
				BigDecimal limiteAprovado = fator.multiply(limiteBasico);
				
				CartaoAprovado cartaoAprovado = CartaoAprovado.builder()
						.bandeira(cartao.getBandeira())
						.cartao(cartao.getNome())
						.limiteAprovado(limiteAprovado)
						.build();
				return cartaoAprovado;
			}).collect(Collectors.toList());
			
			return RetornoAvaliacaoCliente.builder().cartoes(cartoesAprovados).build();
			
		} catch (FeignClientException e) {
			int status = e.status();
			
			if(HttpStatus.NOT_FOUND.value() == status) {
				throw new DadosNotFoundException();
			} else {
				throw new ErroComunicacaoMicroservicesException("Erro comunicação microservice", status);
			}
		}
	}
		

}
