package com.felipe.xavier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.xavier.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
