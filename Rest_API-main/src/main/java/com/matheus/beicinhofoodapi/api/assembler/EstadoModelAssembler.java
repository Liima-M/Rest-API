package com.matheus.beicinhofoodapi.api.assembler;

import com.matheus.beicinhofoodapi.api.model.EstadoModel;
import com.matheus.beicinhofoodapi.api.model.RestauranteModel;
import com.matheus.beicinhofoodapi.domain.model.Estado;
import com.matheus.beicinhofoodapi.domain.model.Restaurante;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstadoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;
    public EstadoModel toModel(Estado estado) {
        return modelMapper.map(estado, EstadoModel.class);
    }

    public List<EstadoModel> toCollectionModel(List<Estado> estados) {
        return estados.stream()
                .map(estado -> toModel(estado))
                .collect(Collectors.toList());
    }
}
