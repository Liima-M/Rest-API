package com.matheus.beicinhofoodapi.infrastructure.service.report;

import com.matheus.beicinhofoodapi.domain.filter.VendaDiariaFilter;
import com.matheus.beicinhofoodapi.domain.service.VendaReportService;
import org.springframework.stereotype.Service;

@Service
public class PdfVendaReportService implements VendaReportService {
    @Override
    public byte[] emitirVendasDiarias(VendaDiariaFilter filtro, String timeOffset) {
        return null;
    }
}
