package com.matheus.beicinhofoodapi.domain.repository;

import com.matheus.beicinhofoodapi.domain.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

   /* List<Estado> list();
    Estado buscar(Long id);

    Estado salvar(Estado estado);
    void remover(Long id);
*/

}