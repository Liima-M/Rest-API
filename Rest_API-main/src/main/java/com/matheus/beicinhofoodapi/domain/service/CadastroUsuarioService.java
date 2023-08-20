package com.matheus.beicinhofoodapi.domain.service;

import com.matheus.beicinhofoodapi.domain.exception.EntidadeEmUsoException;
import com.matheus.beicinhofoodapi.domain.exception.NegocioException;
import com.matheus.beicinhofoodapi.domain.exception.UsuarioNaoEncontradoException;
import com.matheus.beicinhofoodapi.domain.model.Usuario;
import com.matheus.beicinhofoodapi.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroUsuarioService {

    private static final String MSG_USUARIO_EM_USO
            = "Usuario de código %d não pode ser removido, pois esta em uso";

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void alterarSenha(Long usuarioId, String senhaAtual, String senhaNova){
        Usuario usuario = buscarOufalhar(usuarioId);

        if (usuario.senhaNaoCoincideCom(senhaAtual)){
            throw new NegocioException("Senha atual informada não coincide com a senha do usuário.");
        }
        usuario.setSenha(senhaNova);
    }

    public Usuario buscarOufalhar(Long usuarioId){
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId));
    }
}
