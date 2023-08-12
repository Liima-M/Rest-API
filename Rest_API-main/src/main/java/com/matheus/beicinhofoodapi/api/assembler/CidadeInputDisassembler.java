package com.matheus.beicinhofoodapi.api.assembler;

import com.matheus.beicinhofoodapi.api.model.input.CidadeInput;
import com.matheus.beicinhofoodapi.domain.model.Cidade;
import com.matheus.beicinhofoodapi.domain.model.Estado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CidadeInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cidade toDomainObject(CidadeInput cidadeInput){
        return modelMapper.map(cidadeInput, Cidade.class);
    }

    public void copyToDomainObject(CidadeInput cidadeInput, Cidade cidade){

        cidade.setEstado(new Estado());

        modelMapper.map(cidadeInput, cidade);
    }
}
