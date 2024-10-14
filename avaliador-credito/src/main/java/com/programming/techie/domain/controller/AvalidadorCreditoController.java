package com.programming.techie.domain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.programming.techie.domain.model.SituacaoCliente;
import com.programming.techie.domain.service.AvalidadorCreditoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/avaliacoes-credito")
@RequiredArgsConstructor
public class AvalidadorCreditoController {

	private final AvalidadorCreditoService avaliadorCreditoService;
	
	@GetMapping("")
	public String hello() {
		return "Hello World";
	}
	
	
	
	@GetMapping(value = "/situacao-cliente", params = "cpf")
	public ResponseEntity<SituacaoCliente> consultarSituacaoCliente(@RequestParam("cpf") String cpf) {

		SituacaoCliente situacao = avaliadorCreditoService.obterSituacaoCliente(cpf);
		
		return ResponseEntity.ok(situacao);
	}
	

	
}
