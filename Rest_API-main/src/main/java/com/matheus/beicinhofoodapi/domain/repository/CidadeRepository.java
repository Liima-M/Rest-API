package com.matheus.beicinhofoodapi.domain.repository;

import com.matheus.beicinhofoodapi.domain.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long> {

    /*List<Cidade> list();
    Cidade buscar(Long id);

    Cidade salvar(Cidade cidade);

    void remover(Long id);
     void deleteById(Long id);*/
}
