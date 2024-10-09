package com.programming.techie.domain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programming.techie.domain.model.CartaoInput;
import com.programming.techie.domain.service.CartaoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CartaoController {

	private final CartaoService cartaoService;
	
	@GetMapping
	public String status() {
		return "OK";
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void cadastra(@RequestBody CartaoInput cartaoInput) {
		cartaoService.save(cartaoInput.toModel());
	}
	
}
