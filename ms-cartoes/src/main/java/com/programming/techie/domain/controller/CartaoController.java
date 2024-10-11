package com.programming.techie.domain.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programming.techie.domain.entity.Cartao;
import com.programming.techie.domain.model.CartaoClienteResponse;
import com.programming.techie.domain.model.CartaoInput;
import com.programming.techie.domain.service.CartaoService;
import com.programming.techie.domain.service.ClienteCartaoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CartaoController {

	private final CartaoService cartaoService;
	
	private final ClienteCartaoService clienteCartaoService;

	
	@GetMapping
	public String status() {
		return "OK";
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void cadastra(@RequestBody CartaoInput cartaoInput) {
		cartaoService.save(cartaoInput.toModel());
	}
	
	@GetMapping
	public List<Cartao> getCartoesRendaAte(@RequestParam("renda") Long renda){
		return cartaoService.recuperarCartoesPorRendaMenorIgual(renda);
	}
	
	@GetMapping
	public List<CartaoClienteResponse> listCartoesByCpf(@RequestParam("cpf") String cpf){
		return clienteCartaoService.listCartoesByCpf(cpf);
	}
	
}
