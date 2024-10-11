package com.programming.techie.domain.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programming.techie.domain.entity.Cartao;
import com.programming.techie.domain.repository.CartaoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartaoService {

	private final CartaoRepository cartaoRepository;
	
	@Transactional
	public Cartao save(Cartao cartao) {
		return cartaoRepository.save(cartao);
	}
	
	public List<Cartao> recuperarCartoesPorRendaMenorIgual(Long renda) {
		
		BigDecimal rendaDecimal = BigDecimal.valueOf(renda);
		
		return cartaoRepository.findByRendaLessThanEqual(rendaDecimal);
	}

	
}
