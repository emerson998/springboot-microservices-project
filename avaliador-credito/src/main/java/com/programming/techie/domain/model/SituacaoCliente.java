package com.programming.techie.domain.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SituacaoCliente {
	
	private DadosCliente cliente;
	private List<CartaoCliente> cartoes;

}
