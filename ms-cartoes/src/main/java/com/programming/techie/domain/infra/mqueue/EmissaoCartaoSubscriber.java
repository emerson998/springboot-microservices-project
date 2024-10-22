package com.programming.techie.domain.infra.mqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.programming.techie.domain.entity.Cartao;
import com.programming.techie.domain.entity.ClienteCartao;
import com.programming.techie.domain.model.DadosSolicitacaoEmissaoCartao;
import com.programming.techie.domain.repository.CartaoRepository;
import com.programming.techie.domain.repository.ClienteCartaoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmissaoCartaoSubscriber {

	private final CartaoRepository cartaoRepository;
	
	private final ClienteCartaoRepository clienteCartaoRepository;

	@RabbitListener(queues = "${mq.q.emissao-cartoes}")
	public void receberSolicitacaoEmissao(@Payload String payload) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			DadosSolicitacaoEmissaoCartao dados = mapper.readValue(payload, DadosSolicitacaoEmissaoCartao.class);
			Cartao cartao = cartaoRepository.findById(dados.getIdCartao()).orElseThrow();
			
			ClienteCartao clienteCartao = new ClienteCartao();
			clienteCartao.setCartao(cartao);
			clienteCartao.setCpf(dados.getCpf());
			clienteCartao.setLimite(dados.getLimiteLiberado());
			
			clienteCartaoRepository.save(clienteCartao);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
