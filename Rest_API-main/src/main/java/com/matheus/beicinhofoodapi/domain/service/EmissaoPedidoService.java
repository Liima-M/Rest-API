package com.matheus.beicinhofoodapi.domain.service;

import com.matheus.beicinhofoodapi.domain.exception.PedidoNaoEncontradoException;
import com.matheus.beicinhofoodapi.domain.model.Pedido;
import com.matheus.beicinhofoodapi.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmissaoPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscarOuFalhar(Long pedidoId){
        return pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new PedidoNaoEncontradoException(pedidoId));
    }

}
