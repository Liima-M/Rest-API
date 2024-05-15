package com.matheus.beicinhofoodapi.api.controller;

import com.matheus.beicinhofoodapi.api.assembler.PedidoModelAssembler;
import com.matheus.beicinhofoodapi.api.model.PedidoModel;
import com.matheus.beicinhofoodapi.domain.model.Pedido;
import com.matheus.beicinhofoodapi.domain.repository.PedidoRepository;
import com.matheus.beicinhofoodapi.domain.service.EmissaoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private EmissaoPedidoService pedidoService;

    @Autowired
    private PedidoModelAssembler pedidoModelAssembler;

    @GetMapping
    public List<PedidoModel> listar(){
        List<Pedido> todosPedidos = pedidoRepository.findAll();
        return  pedidoModelAssembler.toCollectionModel(todosPedidos);
    }

    @GetMapping("/{pedidoId}")
    public PedidoModel buscar(@PathVariable Long pedidoId){
        Pedido pedido = pedidoService.buscarOuFalhar(pedidoId);

        return pedidoModelAssembler.toModel(pedido);
    }
}
