package com.matheus.beicinhofoodapi.domain.service;

import com.matheus.beicinhofoodapi.domain.filter.VendaDiariaFilter;
import com.matheus.beicinhofoodapi.domain.model.dto.VendaDiaria;

import java.util.List;

public interface VendaQueryService {

    List<VendaDiaria> consultarVendasDiarias(VendaDiariaFilter filtro, String timeOffset);

}
