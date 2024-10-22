package com.programming.techie.domain.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.programming.techie.domain.model.DadosSolicitacaoEmissaoCartao;

@Configuration
public class MQConfig {
	
	@Value("${mq.q.emissao-cartoes}")
	private String emissaoCartoesFila;

	public Queue queueEmissaoCartoes() {
		return new Queue(emissaoCartoesFila, true);
	}
	
}
