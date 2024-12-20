package com.programming.techie.domain.model;

import com.programming.techie.domain.entity.Cliente;

import lombok.Data;

@Data
public class ClienteInput {
	
	private String cpf;
	private String nome;
	private Integer idade;

	public Cliente toModel() {
		return new Cliente(cpf, nome, idade);
	}

}
