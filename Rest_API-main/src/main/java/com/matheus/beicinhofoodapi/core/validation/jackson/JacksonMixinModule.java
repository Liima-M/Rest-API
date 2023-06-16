package com.matheus.beicinhofoodapi.core.validation.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.matheus.beicinhofoodapi.api.model.mixin.RestauranteMixin;
import com.matheus.beicinhofoodapi.domain.model.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModule extends SimpleModule {

    public JacksonMixinModule() {
        setMixInAnnotation(Restaurante.class, RestauranteMixin.class);
    }
}
