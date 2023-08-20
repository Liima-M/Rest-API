package com.matheus.beicinhofoodapi.domain.repository;

import com.matheus.beicinhofoodapi.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
