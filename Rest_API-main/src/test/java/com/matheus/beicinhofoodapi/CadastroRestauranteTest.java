package com.matheus.beicinhofoodapi;

import com.matheus.beicinhofoodapi.api.assembler.RestauranteInputDisassembler;
import com.matheus.beicinhofoodapi.api.assembler.RestauranteModelAssembler;
import com.matheus.beicinhofoodapi.api.controller.RestauranteController;
import com.matheus.beicinhofoodapi.api.model.input.RestauranteInput;
import com.matheus.beicinhofoodapi.domain.model.Restaurante;
import com.matheus.beicinhofoodapi.domain.service.CadastroRestauranteService;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CadastroRestauranteTest {

    @InjectMocks
    RestauranteController restauranteController;

    @Mock
    private CadastroRestauranteService restauranteService;

    private Restaurante restaurante;

    private RestauranteModelAssembler restauranteModelAssembler;
    private RestauranteInputDisassembler restauranteInputDisassembler;

    private RestauranteInput restauranteInput;

    //@BeforeEach
//    public void setUp(){
//        restauranteInput = new RestauranteInput();
//        restauranteInput.setNome("sde");
//        restauranteInput.setTaxaFrete(new BigDecimal(10));
//        restauranteInput.setCozinha(8L);
//        restauranteInput.setEndereco("rua castro alves");
//    }

//    @Test
//    public void deveAdicionarUmRestaurante(){
//        when(restauranteInputDisassembler.toDomainObject(restauranteInput)).thenReturn(restauranteModelAssembler.toModel(restauranteService.salvar(restauranteInput)));
//    }
}
