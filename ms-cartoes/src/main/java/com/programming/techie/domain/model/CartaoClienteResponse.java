package com.programming.techie.domain.model;

import java.math.BigDecimal;

import com.programming.techie.domain.entity.ClienteCartao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartaoClienteResponse {


	private String nome;
	private String bandeira;
	private BigDecimal limiteLiberado;
	
	public static CartaoClienteResponse toModel(ClienteCartao model) {
		return new CartaoClienteResponse(
				model.getCartao().getNome(),
				model.getCartao().getBandeira().toString(),
				model.getLimite()
				);
		
	}

}
