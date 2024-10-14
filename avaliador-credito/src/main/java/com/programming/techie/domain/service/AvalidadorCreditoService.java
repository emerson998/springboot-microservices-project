package com.programming.techie.domain.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.programming.techie.domain.model.DadosCliente;
import com.programming.techie.domain.model.SituacaoCliente;
import com.programming.techie.infra.clients.ClienteResourceClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvalidadorCreditoService {
	
	private final ClienteResourceClient clientResourceClient;
	
	public SituacaoCliente obterSituacaoCliente(String cpf) {
		
		ResponseEntity<DadosCliente> dadosCliente = clientResourceClient.dadosCliente(cpf);
		
		return SituacaoCliente.builder()
				.cliente(dadosCliente.getBody())
				.build();
		
	}

}
