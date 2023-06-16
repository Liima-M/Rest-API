package com.matheus.beicinhofoodapi.domain.repository;

import com.matheus.beicinhofoodapi.domain.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {

  /*  List<FormaPagamento> list();
    FormaPagamento buscar(Long id);

    FormaPagamento salvar(FormaPagamento formaPagamento);
    void remover(Long id);
*/
}
