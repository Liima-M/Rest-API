package com.matheus.beicinhofoodapi.domain.service;


import com.matheus.beicinhofoodapi.domain.exception.NegocioException;
import com.matheus.beicinhofoodapi.domain.model.Pedido;
import com.matheus.beicinhofoodapi.domain.model.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
public class FluxoPedidoService {

    @Autowired
    private EmissaoPedidoService emissaoPedido;

    @Transactional
    public void confirmar(String codigoPedido){
        Pedido pedido = emissaoPedido.buscarOuFalhar(codigoPedido);

        pedido.confirmar();
    }

    @Transactional
    public void cancelar(String codigoPedido){
        Pedido pedido = emissaoPedido.buscarOuFalhar(codigoPedido);

        pedido.cancelar();
    }

    @Transactional
    public void entregar(String codigoPedido){
        Pedido pedido = emissaoPedido.buscarOuFalhar(codigoPedido);

        pedido.entregar();
    }
}
