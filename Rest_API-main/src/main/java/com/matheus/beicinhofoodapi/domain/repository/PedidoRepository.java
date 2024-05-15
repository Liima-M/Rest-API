package com.matheus.beicinhofoodapi.domain.repository;

import com.matheus.beicinhofoodapi.domain.model.Pedido;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CustomJpaRepository<Pedido, Long> {
}
