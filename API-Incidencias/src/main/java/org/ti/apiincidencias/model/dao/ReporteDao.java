package org.ti.apiincidencias.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.ti.apiincidencias.model.Reporte;

import java.util.List;
import java.util.Optional;

public interface ReporteDao extends CrudRepository<Reporte, Long> {
    @Query("SELECT r FROM Reporte r WHERE r.estado = :estado")
    List<Reporte> FiltroDeReporte(String estado);
    @Query("SELECT r FROM Reporte r WHERE r.usuario = :id")
    List<Reporte> FiltroID(@Param("id") int id);




}
