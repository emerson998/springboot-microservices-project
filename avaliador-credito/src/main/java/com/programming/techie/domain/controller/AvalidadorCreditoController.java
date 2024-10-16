package com.programming.techie.domain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.programming.techie.domain.exception.DadosNotFoundException;
import com.programming.techie.domain.exception.ErroComunicacaoMicroservicesException;
import com.programming.techie.domain.model.DadosAvialiacao;
import com.programming.techie.domain.model.RetornoAvaliacaoCliente;
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
	public ResponseEntity<?> consultarSituacaoCliente(@RequestParam("cpf") String cpf) {

		try {
			SituacaoCliente situacao = avaliadorCreditoService.obterSituacaoCliente(cpf);

			return ResponseEntity.ok(situacao);
		} catch (DadosNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (ErroComunicacaoMicroservicesException e) {
			return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
		}
	}
	
	
	@PostMapping
	public ResponseEntity<?> realizarAvaliacao(@RequestBody DadosAvialiacao dados) {

		try {

			RetornoAvaliacaoCliente retorno = avaliadorCreditoService.realizarAvaliacao(dados);
			return ResponseEntity.ok(retorno);
		} catch (DadosNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (ErroComunicacaoMicroservicesException e) {
			return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
		}
	}



}
