package org.ti.apiincidencias.service;

import org.springframework.http.ResponseEntity;
import org.ti.apiincidencias.model.Reporte;
import org.ti.apiincidencias.response.ReporteResponseRest;

public interface IReporteService {
public ResponseEntity<ReporteResponseRest> todosR();
public ResponseEntity<ReporteResponseRest> eliminarR(Reporte reporte, Long id);
public ResponseEntity<ReporteResponseRest> actualizarR(Reporte reporte, Long id);
public ResponseEntity<ReporteResponseRest>  RactualizarEdo(Reporte reporte, Long id);
public ResponseEntity<ReporteResponseRest> crearR(Reporte reporte);

}
