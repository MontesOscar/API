package org.ti.apiincidencias.service;

import org.springframework.http.ResponseEntity;
import org.ti.apiincidencias.model.Reporte;
import org.ti.apiincidencias.response.ReporteResponseRest;

public interface IReporteService {
    //ADMINISTRADOR- VER TODOS LOS REPORTES
public ResponseEntity<ReporteResponseRest> todosR();
//ADMINSTRADOR - VER LOS REPORTES FILTRANDO POR ESTADO
public ResponseEntity<ReporteResponseRest> todosE(Reporte reporte);
//USUARIO--VER LOS REPORTES DEL MISMO USUARIO
//public ResponseEntity<ReporteResponseRest> TodosU(Reporte reporte);
//ADMINISTRADOR--ELIMINAR CUALQUIER REPORTE
public ResponseEntity<ReporteResponseRest> eliminarR(Reporte reporte, Long id);
//ADMINSTRADOR---Actualizar el estado de cualquier reporte
public ResponseEntity<ReporteResponseRest>  actualizarR(Reporte reporte, Long id);
//USUARIO--CREAR LOS REPORTES
public ResponseEntity<ReporteResponseRest> crearR(Reporte reporte);
}