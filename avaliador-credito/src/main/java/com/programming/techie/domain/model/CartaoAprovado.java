package com.programming.techie.domain.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CartaoAprovado {
	
	private String cartao;
	private String bandeira;
	private BigDecimal limiteAprovado;

}
