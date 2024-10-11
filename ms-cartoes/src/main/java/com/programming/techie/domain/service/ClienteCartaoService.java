package com.programming.techie.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.programming.techie.domain.entity.ClienteCartao;
import com.programming.techie.domain.model.CartaoClienteResponse;
import com.programming.techie.domain.repository.ClienteCartaoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {
	
	private final ClienteCartaoRepository clienteCartaoRepository;
	
	public List<CartaoClienteResponse> listCartoesByCpf(String cpf){
		
		 List<ClienteCartao> results = clienteCartaoRepository.findByCpf(cpf);
	
		 List<CartaoClienteResponse> list = results.stream().map(CartaoClienteResponse::toModel).toList();
		 
		 return list;
		
	}

}
