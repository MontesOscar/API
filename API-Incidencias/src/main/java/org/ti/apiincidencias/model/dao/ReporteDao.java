package org.ti.apiincidencias.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.ti.apiincidencias.model.Reporte;

public interface ReporteDao extends CrudRepository<Reporte, Long> {
}
