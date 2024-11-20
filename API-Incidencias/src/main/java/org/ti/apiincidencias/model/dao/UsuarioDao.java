package org.ti.apiincidencias.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.ti.apiincidencias.model.Reporte;
import org.ti.apiincidencias.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.Id = :id")
    Optional<Usuario> FiltroIDU(@Param("id") Long id);
    @Query("SELECT u FROM Usuario u WHERE u.email = :correo")
    Optional<Usuario> findByCorreo(@Param("correo") String correo);


}
