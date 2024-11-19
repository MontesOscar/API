package org.ti.apiincidencias.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.ti.apiincidencias.model.Reporte;
import org.ti.apiincidencias.model.Usuario;

import java.util.List;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {

}
