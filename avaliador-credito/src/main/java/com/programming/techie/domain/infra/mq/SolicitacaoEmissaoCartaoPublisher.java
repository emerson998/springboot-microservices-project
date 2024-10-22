package com.programming.techie.domain.infra.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.programming.techie.domain.model.DadosSolicitacaoEmissaoCartao;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SolicitacaoEmissaoCartaoPublisher {

	
	private final RabbitTemplate rabbitTemplate;
	
	private final Queue queueEmissaoCartoes;
	
	public void solicitarCartao(DadosSolicitacaoEmissaoCartao dados) throws JsonProcessingException {
		String json = convertToJson(dados);
		rabbitTemplate.convertAndSend(queueEmissaoCartoes.getName(), json);
		
	}
	
	
	private String convertToJson(DadosSolicitacaoEmissaoCartao dados) throws JsonProcessingException {
		ObjectMapper objMapper = new ObjectMapper();
		var json = objMapper.writeValueAsString(dados);
		return json;
	}
}
