package com.matheus.beicinhofoodapi.api.assembler;

import com.matheus.beicinhofoodapi.api.model.input.RestauranteInput;
import com.matheus.beicinhofoodapi.domain.model.Cozinha;
import com.matheus.beicinhofoodapi.domain.model.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class RestauranteInputDisassembler {

    public Restaurante toDomainObject(RestauranteInput restauranteInput) {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(restauranteInput.getNome());
        restaurante.setTaxaFrete(restauranteInput.getTaxaFrete());

        Cozinha cozinha = new Cozinha();
        cozinha.setId(restauranteInput.getCozinha().getId());

        restaurante.setCozinha(cozinha);

        return restaurante;
    }
}
