package org.ti.apiincidencias.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ti.apiincidencias.model.Anuncios;
import org.ti.apiincidencias.model.Reporte;
import org.ti.apiincidencias.model.dao.AnuncioDao;
import org.ti.apiincidencias.model.dao.ReporteDao;
import org.ti.apiincidencias.response.AnuncioResponse;
import org.ti.apiincidencias.response.AnuncioResponseRest;
import org.ti.apiincidencias.response.ReporteResponseRest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnuncioServiceImpl implements IAnuncioService {
    private static final Logger log = LoggerFactory.getLogger(ReporteServiceImpl.class);
    @Autowired
    private AnuncioDao anuncioDao;
//ADMINISTRADOR--Metodo para ver todos los estados
    @Transactional(readOnly = true)
    public ResponseEntity<AnuncioResponseRest> todosA() {
        AnuncioResponseRest response = new AnuncioResponseRest();
        try {
            List<Anuncios> anuncio = (List<Anuncios>) anuncioDao.findAll();
            log.info("INICIO DEL METODO PARA BUSCAR TODOS ANUNCIOS");
            response.getResponseAnuncio().setAnuncios(anuncio);
            response.setMetadata("CORRECTO", "1", "SE ENVIO RESPUESTA");
        } catch (Exception e) {
            log.info("ERROR AL BUSCAR LOS ANUNCIOS");
            response.setMetadata("ERROR", "-1", "ERROR DE RESPUESTA");
            return new ResponseEntity<AnuncioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //ADMINISTRADOR--Metodo para actualizar los anuncios
    @Override
    @Transactional
    public ResponseEntity<AnuncioResponseRest> eliminarA(Anuncios anuncios,Long id) {
        AnuncioResponseRest response = new AnuncioResponseRest();
        List<Anuncios> list = new ArrayList<>();

        try {
            Optional<Anuncios> buscado = anuncioDao.findById(id);
            if (buscado.isPresent()) {
                buscado.get().setImagen(anuncios.getImagen());
                Anuncios actualizado = anuncioDao.save(buscado.get());
                if (actualizado != null) {
                    list.add(actualizado);
                    response.getResponseAnuncio().setAnuncios(list);
                    response.setMetadata("CORRECTO", "1", "SE ELIMINO LOGICAMENTE");
                } else {
                    response.setMetadata("ERROR", "-1", "ERROR DE ELIMINACION");
                    return new ResponseEntity<AnuncioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                log.info("ANUNCIO NO ENCONTRADO");
                response.setMetadata("ERROR", "-1", "ERROR DE ELIMINACION");
                return new ResponseEntity<AnuncioResponseRest>(response, HttpStatus.NOT_FOUND);
            }

        }catch (Exception e) {
            response.setMetadata("ERROR", "-1", "ERROR DE ELIMINACION");
            log.info("ERROR AL ELIMINAR EL ANUNCIO");
            return new ResponseEntity<AnuncioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<AnuncioResponseRest>(response, HttpStatus.OK);
    }

}

