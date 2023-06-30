package com.matheus.beicinhofoodapi.core.validation.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.matheus.beicinhofoodapi.api.model.mixin.CidadeMixin;
import com.matheus.beicinhofoodapi.api.model.mixin.CozinhaMixin;
import com.matheus.beicinhofoodapi.domain.model.Cidade;
import com.matheus.beicinhofoodapi.domain.model.Cozinha;
import com.matheus.beicinhofoodapi.domain.model.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModule extends SimpleModule {

    public JacksonMixinModule() {
        setMixInAnnotation(Cidade.class, CidadeMixin.class);
        setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
    }
}
