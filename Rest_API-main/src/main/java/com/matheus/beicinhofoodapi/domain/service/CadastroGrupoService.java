package com.matheus.beicinhofoodapi.domain.service;

import com.matheus.beicinhofoodapi.domain.exception.EntidadeEmUsoException;
import com.matheus.beicinhofoodapi.domain.exception.GrupoNaoEncontradoException;
import com.matheus.beicinhofoodapi.domain.model.Grupo;
import com.matheus.beicinhofoodapi.domain.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroGrupoService {

    private static final String MSG_GRUPO_EM_USO
            = "Grupo de código %d não pode ser removido, pois esta em uso";

    @Autowired
    public GrupoRepository grupoRepository;

    @Transactional
    public Grupo salvar(Grupo grupo){
        return grupoRepository.save(grupo);
    }

    public void excluir (Long grupoId){
        try {
            grupoRepository.deleteById(grupoId);
             grupoRepository.flush();
        }catch (EmptyResultDataAccessException e){
            throw new GrupoNaoEncontradoException(grupoId);
        }catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(String.format(MSG_GRUPO_EM_USO, grupoId));
        }
    }

    public Grupo buscarOuFalhar(Long grupoId){
        return grupoRepository.findById(grupoId)
                .orElseThrow(() -> new GrupoNaoEncontradoException(grupoId));
    }
}
