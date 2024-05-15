package com.matheus.beicinhofoodapi.domain.exception;

public class PedidoNaoEncontradoException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;
    public PedidoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public PedidoNaoEncontradoException(Long pedidoId){
        this(String.format("Não existe um pedido com codigo %d", pedidoId));
    }
}
