package com.matheus.beicinhofoodapi.api.controller;

import com.matheus.beicinhofoodapi.api.assembler.GrupoModelAssembler;
import com.matheus.beicinhofoodapi.api.assembler.PermissaoModelAssembler;
import com.matheus.beicinhofoodapi.api.model.GrupoModel;
import com.matheus.beicinhofoodapi.api.model.PermissaoModel;
import com.matheus.beicinhofoodapi.domain.model.Grupo;
import com.matheus.beicinhofoodapi.domain.model.Usuario;
import com.matheus.beicinhofoodapi.domain.service.CadastroGrupoService;
import com.matheus.beicinhofoodapi.domain.service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios/{usuarioId}/grupos")
public class UsuarioGrupoController {

    @Autowired
    private CadastroUsuarioService cadastroUsuario;

    @Autowired
    private GrupoModelAssembler grupoModelAssembler;

    @GetMapping
    public List<GrupoModel> listar(@PathVariable Long usuarioId) {
        Usuario usuario = cadastroUsuario.buscarOufalhar(usuarioId);

        return grupoModelAssembler.toCollectionModel(usuario.getGrupos());
    }

    @DeleteMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociar( @PathVariable Long usuarioId,@PathVariable Long grupoId) {
        cadastroUsuario.desassociarGrupo( usuarioId, grupoId);
    }

    @PutMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associar( @PathVariable Long usuarioId,@PathVariable Long grupoId) {
        cadastroUsuario.associarGrupo( usuarioId, grupoId);
    }

}