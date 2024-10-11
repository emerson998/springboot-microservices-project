package com.programming.techie.domain.model;

import java.math.BigDecimal;

import com.programming.techie.domain.entity.Cartao;
import com.programming.techie.domain.enumerator.BandeiraCartao;

import lombok.Data;

@Data
public class CartaoInput {

	private Long id;
	private String nome;
	private BandeiraCartao bandeira;
	private BigDecimal renda;
	private BigDecimal limiteBasico;
	
	public Cartao toModel() {
		return new Cartao(nome, bandeira, renda, limiteBasico);
	}
}
