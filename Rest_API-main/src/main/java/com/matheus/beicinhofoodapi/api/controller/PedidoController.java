package com.matheus.beicinhofoodapi.api.controller;

import com.matheus.beicinhofoodapi.api.assembler.PedidoInputDisassembler;
import com.matheus.beicinhofoodapi.api.assembler.PedidoModelAssembler;
import com.matheus.beicinhofoodapi.api.assembler.PedidoResumoModelAssembler;
import com.matheus.beicinhofoodapi.api.model.PedidoModel;
import com.matheus.beicinhofoodapi.api.model.PedidoResumoModel;
import com.matheus.beicinhofoodapi.api.model.input.PedidoInput;
import com.matheus.beicinhofoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.matheus.beicinhofoodapi.domain.exception.NegocioException;
import com.matheus.beicinhofoodapi.domain.model.Pedido;
import com.matheus.beicinhofoodapi.domain.model.Usuario;
import com.matheus.beicinhofoodapi.domain.repository.PedidoRepository;
import com.matheus.beicinhofoodapi.domain.repository.filter.PedidoFilter;
import com.matheus.beicinhofoodapi.domain.service.EmissaoPedidoService;
import com.matheus.beicinhofoodapi.infrastructure.repository.spec.PedidoSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private EmissaoPedidoService emissaoPedido;

    @Autowired
    private PedidoModelAssembler pedidoModelAssembler;

    @Autowired
    private PedidoInputDisassembler pedidoInputDisassembler;

    @Autowired
    private PedidoResumoModelAssembler pedidoResumoModelAssembler;
    @GetMapping
    public Page<PedidoResumoModel> pesquisar(PedidoFilter filtro, Pageable pageable) {
        Page<Pedido> todosPedidos = pedidoRepository.findAll(PedidoSpecs.usandoFiltro(filtro), pageable);

        List<PedidoResumoModel> pedidoResumoModels =  pedidoResumoModelAssembler.toCollectionModel(todosPedidos.getContent());

        Page<PedidoResumoModel> pedidoResumoModelPage = new PageImpl<>(pedidoResumoModels, pageable, todosPedidos.getTotalElements());

        return pedidoResumoModelPage;
    }

    @GetMapping("/{codigoPedido}")
    public PedidoModel buscar(@PathVariable String codigoPedido) {
        Pedido pedido = emissaoPedido.buscarOuFalhar(codigoPedido);

        return pedidoModelAssembler.toModel(pedido);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoModel adicionar(@Valid @RequestBody PedidoInput pedidoInput) {
        try {
            Pedido novoPedido = pedidoInputDisassembler.toDomainObject(pedidoInput);

            // TODO pegar usuário autenticado
            novoPedido.setCliente(new Usuario());
            novoPedido.getCliente().setId(1L);

            novoPedido = emissaoPedido.emitir(novoPedido);

            return pedidoModelAssembler.toModel(novoPedido);
        } catch (EntidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }
}
