package org.ti.apiincidencias.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.ti.apiincidencias.model.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {

}