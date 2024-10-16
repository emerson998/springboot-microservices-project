package com.programming.techie.infra.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.programming.techie.domain.model.CartaoCliente;


@FeignClient(value = "mscartoes", path = "/cartoes" )
public interface CartoesResourceClient {


	@GetMapping(params = "cpf")
	List<CartaoCliente> listCartoesByCpf(@RequestParam("cpf") String cpf);

}
