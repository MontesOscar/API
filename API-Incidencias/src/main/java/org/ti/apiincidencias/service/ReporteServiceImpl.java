package org.ti.apiincidencias.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ti.apiincidencias.model.Reporte;
import org.ti.apiincidencias.model.dao.ReporteDao;
import org.ti.apiincidencias.response.ReporteResponseRest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReporteServiceImpl implements IReporteService {
    private static final Logger log = LoggerFactory.getLogger(ReporteServiceImpl.class);
    @Autowired
    private ReporteDao reporteDao;
//ADMINISTRADOR--Metodo para ver todos los reportes
    @Transactional(readOnly = true)
    public ResponseEntity<ReporteResponseRest> todosR() {
        ReporteResponseRest response = new ReporteResponseRest();
        try {
            List<Reporte> reportes = (List<Reporte>) reporteDao.findAll();
            log.info("INICIO DEL METODO PARA BUSCAR TODOS LOS REPORTES");
            response.getResponseReporte().setReporte(reportes);
            response.setMetadata("CORRECTO", "1", "SE ENVIO RESPUESTA");
        }catch (Exception e) {
            log.info("ERROR AL BUSCAR LOS REPORTES");
            response.setMetadata("ERROR", "-1", "ERROR DE RESPUESTA");
            return new ResponseEntity<ReporteResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //ADMINISTRADOR--Metodo para ver todos los reportes filtrandolos por el estado
    @Transactional(readOnly = true)
    public ResponseEntity<ReporteResponseRest> todosE(Reporte reporte) {
        ReporteResponseRest response = new ReporteResponseRest();
        try {
            // Obtener el estado del cuerpo de la solicitud
            String estado = reporte.getEstado();
            List<Reporte> reportes;
            if (estado != null && !estado.isEmpty()) {
                reportes = reporteDao.FiltroDeReporte(estado);
            } else {
                reportes = (List<Reporte>) reporteDao.findAll();
            }

            log.info("INICIO DEL METODO PARA BUSCAR REPORTES FILTRADOS POR ESTADO");
            response.getResponseReporte().setReporte(reportes);
            response.setMetadata("CORRECTO", "1", "SE ENVIO RESPUESTA");

        } catch (Exception e) {
            log.error("ERROR AL BUSCAR LOS REPORTES", e);
            response.setMetadata("ERROR", "-1", "ERROR DE RESPUESTA");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //ADMINISTRADOR-----Metodo para eliminar cualquier reporte
    @Override
    @Transactional
    public ResponseEntity<ReporteResponseRest> eliminarR(Reporte reporte,Long id) {
        ReporteResponseRest response = new ReporteResponseRest();
        List<Reporte> list = new ArrayList<>();

        try {
            Optional<Reporte> buscado = reporteDao.findById(id);
            if (buscado.isPresent()) {
                buscado.get().setEstado(reporte.getEstado());
                Reporte actualizado = reporteDao.save(buscado.get());
                if (actualizado != null) {
                    list.add(actualizado);
                    response.getResponseReporte().setReporte(list);
                    response.setMetadata("CORRECTO", "1", "SE ELIMINO LOGICAMENTE");
                } else {
                    response.setMetadata("ERROR", "-1", "ERROR DE ELIMINACION");
                    return new ResponseEntity<ReporteResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                log.info("REPORTE NO ENCONTRADO");
                response.setMetadata("ERROR", "-1", "ERROR DE ELIMINACION");
                return new ResponseEntity<ReporteResponseRest>(response, HttpStatus.NOT_FOUND);
            }

        }catch (Exception e) {
            response.setMetadata("ERROR", "-1", "ERROR DE ELIMINACION");
            log.info("ERROR AL ELIMINAR EL REPORTE");
            return new ResponseEntity<ReporteResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<ReporteResponseRest>(response, HttpStatus.OK);
    }
    //USUARIO--Metodo para crear un reporte
    @Override
    @Transactional
    public ResponseEntity<ReporteResponseRest> crearR(Reporte reporte){
        ReporteResponseRest response = new ReporteResponseRest();
        List<Reporte> list = new ArrayList<>();
        try{
            log.info("INICIO DEL METODO PARA CREAR UN REPORTE NUEVO");
            Reporte guardar = reporteDao.save(reporte);
            if(guardar != null){
                log.info("SE VALIDA QUE NO ESTA VACIO");
                list.add(guardar);
                response.getResponseReporte().setReporte(list);
                response.setMetadata("BIEN", "1", "REPORTE CREADO");
            }else {
                log.info("SE VALIDA QUE ESTA VACIO");
                response.setMetadata("ERROR", "-1", "ERROR AL CREAR EL REPORTE");
                return new ResponseEntity<ReporteResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception e){
            log.info("ERROR CREAR REPORTE");
            response.setMetadata("ERROR", "-1", "ERROR DE RESPUESTA");
            return new ResponseEntity<ReporteResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<ReporteResponseRest>(response, HttpStatus.OK);
    }
    //ADMINSTRADOR---Metodo para actualizar el estado de cualquier reporte
    @Override
    @Transactional
    public ResponseEntity<ReporteResponseRest> actualizarR(Reporte reporte, Long id){
        ReporteResponseRest response = new ReporteResponseRest();
        List<Reporte> list = new ArrayList<>();
        try{
            Optional<Reporte> Buscada = reporteDao.findById(id);
            if (Buscada.isPresent()) {
                Buscada.get().setEstado(reporte.getEstado());
                Reporte actualizado = reporteDao.save(Buscada.get());
                if (actualizado != null) {
                    list.add(actualizado);
                    response.getResponseReporte().setReporte(list);
                    response.setMetadata("BIEN", "1", "ESTADO ACTUALIZALDO CORRECTAMENTE");
                }else {
                    response.setMetadata("ERROR", "-1", "ERROR AL ACTUALIZAR EL ESTADO DEL REPORTE");
                    return new ResponseEntity<ReporteResponseRest>(response, HttpStatus.BAD_REQUEST);
                }
            }else{
                log.info("NO EXISTE EL REPORTE");
                response.setMetadata("ERROR", "-1", "ERROR AL ACTUALIZAR EL ESTADO DEL REPORTE");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            response.setMetadata("ERROR", "-1", "ERROR AL HACER LA SOLICITUD");
            log.info("ERROR AL ACTUALIZAR");
            return new ResponseEntity<ReporteResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //FALTAN DETALLES
    //USUARIO--Metodo para ver solo los reportes del mismo usuario
    //Aqui el id del usuario al cual se le van a mostrar los reportes se envia por el body NO por URL
    /*@Transactional
    public ResponseEntity<ReporteResponseRest> TodosU(Reporte reporte) {
        ReporteResponseRest response = new ReporteResponseRest();
        try {
            int id = reporte.getId();
            List<Reporte> reportes;
            reportes = reporteDao.FiltroID(id);


            log.info("INICIO DEL METODO PARA BUSCAR REPORTES FILTRADOS POR USUARIO");
            response.getResponseReporte().setReporte(reportes);
            response.setMetadata("CORRECTO", "1", "SE ENVIO RESPUESTA");

        } catch (Exception e) {
            log.error("ERROR AL BUSCAR LOS REPORTES", e);
            response.setMetadata("ERROR", "-1", "ERROR DE RESPUESTA");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
*/
    //USUARIO--Actualizar los datos del reporte si este reporte le pertenece al mismo usuario que lo va a actualizar
  /* @Override
    @Transactional
    public ResponseEntity<ReporteResponseRest> actualizarR(Reporte reporte, Long id){
        ReporteResponseRest response = new ReporteResponseRest();
        List<Reporte> list = new ArrayList<>();
        try{
            List<Reporte> Buscada = reporteDao.ReportesDeUsuario(id);
            if (Buscada) {
                Buscada.get().setTitulo(reporte.getTitulo());
                Buscada.get().setDescripcion(reporte.getDescripcion());
                Buscada.get().setImagen(reporte.getImagen());
                Reporte actualizado = reporteDao.save(Buscada.get());
                if (actualizado != null) {
                    list.add(actualizado);
                    response.getResponseReporte().setReporte(list);
                    response.setMetadata("BIEN", "1", "REPORTE ACTUALIZADO");
                }else {
                    response.setMetadata("ERROR", "-1", "ERROR AL ACTUALIZAR EL REPORTE");
                    return new ResponseEntity<ReporteResponseRest>(response, HttpStatus.BAD_REQUEST);
                }
            }else{
                log.info("NO EXISTE EL REPORTE");
                response.setMetadata("ERROR", "-1", "ERROR AL ACTUALIZAR EL REPORTE");
                return new ResponseEntity<ReporteResponseRest>(response, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            response.setMetadata("ERROR", "-1", "ERROR AL ACTUALIZAR EL REPORTE");
            log.info("ERROR AL ACTUALIZAR");
            return new ResponseEntity<ReporteResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<ReporteResponseRest>(response, HttpStatus.OK);
    }*/

    //FALTANTES
    //USUARIO---Eliminar los reportes correspondientes al usuario


}
