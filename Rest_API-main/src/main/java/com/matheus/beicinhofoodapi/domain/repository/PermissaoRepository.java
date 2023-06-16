package com.matheus.beicinhofoodapi.domain.repository;

import com.matheus.beicinhofoodapi.domain.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

   /* List<Permissao> list();
    Permissao buscar(Long id);

    Permissao salvar(Permissao permissao);

    void remover(Long id);
*/
}
