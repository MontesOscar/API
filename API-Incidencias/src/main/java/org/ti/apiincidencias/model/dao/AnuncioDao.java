package org.ti.apiincidencias.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.ti.apiincidencias.model.Anuncios;

public interface AnuncioDao extends CrudRepository<Anuncios, Long> {
}
