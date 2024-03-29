package com.matheus.beicinhofoodapi.api.assembler;

import com.matheus.beicinhofoodapi.api.model.PermissaoModel;
import com.matheus.beicinhofoodapi.domain.model.Permissao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PermissaoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public PermissaoModel toModel(Permissao permissao){
        return modelMapper.map(permissao, PermissaoModel.class);
    }

    public List<PermissaoModel> toCollectionModel(Collection<Permissao> permissoes){
        return permissoes.stream().map(permissao -> toModel(permissao))
                .collect(Collectors.toList());
    }
}
