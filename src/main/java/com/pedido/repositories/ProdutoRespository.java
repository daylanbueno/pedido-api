package com.pedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedido.domain.Produto;

@Repository
public interface ProdutoRespository extends JpaRepository<Produto, Integer> {}
