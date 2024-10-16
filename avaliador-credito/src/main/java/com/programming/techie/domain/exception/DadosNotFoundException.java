package com.programming.techie.domain.exception;

public class DadosNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DadosNotFoundException () {
		super("Dados não encontrados");
	}

}
