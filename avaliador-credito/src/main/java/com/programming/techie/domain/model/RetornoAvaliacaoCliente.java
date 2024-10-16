package com.programming.techie.domain.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class RetornoAvaliacaoCliente {
	
	List<CartaoAprovado> cartoes;

}
