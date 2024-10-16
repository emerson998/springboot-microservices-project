package com.programming.techie.domain.exception;

import lombok.Getter;

public class ErroComunicacaoMicroservicesException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	@Getter
	private final Integer status;
	
	public ErroComunicacaoMicroservicesException(String msg, Integer status) {
		super(msg);
		this.status = status;
	}

}
