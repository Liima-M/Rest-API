package com.matheus.beicinhofoodapi.api.model;

import com.matheus.beicinhofoodapi.domain.model.Cidade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class EnderecoModel {

    private String cep;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private CidadeResumoModel cidade;
}
