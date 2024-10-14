package com.programming.techie.domain.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.programming.techie.domain.entity.Cliente;
import com.programming.techie.domain.model.ClienteInput;
import com.programming.techie.domain.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

	private final ClienteService clienteService;
	
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> cadastra(@RequestBody ClienteInput cartaoInput) {
		Cliente cliente = clienteService.salvar(cartaoInput.toModel());
		
		URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest().query("cpf={cpf}").buildAndExpand(cliente.getCpf()).toUri();
		return ResponseEntity.created(headerLocation).build();
	}
	
	
	@GetMapping(params = "cpf")
	public ResponseEntity<Cliente> dadosCliente(@RequestParam("cpf") String cpf){
		Cliente cliente = clienteService.recuperarPorCpf(cpf);
		
		if(cliente == null) {
			return ResponseEntity.notFound().build();
		}
		
		else return ResponseEntity.ok(cliente);
	}
}
