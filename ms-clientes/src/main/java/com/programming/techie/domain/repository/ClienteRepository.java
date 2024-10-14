package com.programming.techie.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programming.techie.domain.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findByCpf(String cpf);


}
