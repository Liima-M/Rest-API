package com.matheus.beicinhofoodapi.domain.service;

import com.matheus.beicinhofoodapi.domain.exception.ProdutoNaoEncontradoException;
import com.matheus.beicinhofoodapi.domain.model.Produto;
import com.matheus.beicinhofoodapi.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroProdutoService {
    private static final String MSG_PRODUTO_EM_USO
            = "Produto de código %d não pode ser removido, pois esta em uso";

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto buscarOuFalhar(Long restauranteId,Long produtoId){
        return produtoRepository.findById(restauranteId, produtoId)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(restauranteId,produtoId));
    }


}
