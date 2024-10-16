package com.programming.techie.infra.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.programming.techie.domain.model.Cartao;
import com.programming.techie.domain.model.DadosCliente;

@FeignClient(value = "msclientes", path = "/clientes" )
public interface ClienteResourceClient {


	@GetMapping(params = "cpf")
	ResponseEntity<DadosCliente> dadosCliente(@RequestParam("cpf") String cpf);
	
	@GetMapping(params = "renda")
	List<Cartao> getCartoesRendaAte(@RequestParam("renda") Long renda);



}
	