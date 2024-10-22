package com.programming.techie.domain.infra.mqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmissaoCartaoSubscriber {
	

	@RabbitListener(queues = "${mq.q.emissao-cartoes}")
	public void receberSolicitacaoEmissao(@Payload String payload) {
		System.out.println(payload);
	}
}
