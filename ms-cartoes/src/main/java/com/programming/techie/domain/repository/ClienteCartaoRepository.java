package com.programming.techie.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programming.techie.domain.entity.ClienteCartao;


public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, Long>{


	List<ClienteCartao> findByCpf(String cpf);
}


