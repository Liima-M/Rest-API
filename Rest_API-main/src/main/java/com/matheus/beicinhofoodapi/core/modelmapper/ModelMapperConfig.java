package com.matheus.beicinhofoodapi.core.modelmapper;

import com.matheus.beicinhofoodapi.api.model.RestauranteModel;
import com.matheus.beicinhofoodapi.domain.model.Restaurante;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        var modelMapper = new ModelMapper();

//        modelMapper.createTypeMap(Restaurante.class, RestauranteModel.class)
//                .addMapping(Restaurante::getTaxaFrete, RestauranteModel::setPrecoFrete);

        return modelMapper;

    }
}
