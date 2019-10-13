package com.felipe.xavier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.xavier.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
