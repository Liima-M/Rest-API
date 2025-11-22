package com.matheus.beicinhofoodapi.domain.service;

import com.matheus.beicinhofoodapi.domain.filter.VendaDiariaFilter;

public interface VendaReportService {

    byte[] emitirVendasDiarias(VendaDiariaFilter filtro, String timeOffset);
}
