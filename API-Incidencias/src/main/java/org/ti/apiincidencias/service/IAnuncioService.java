package org.ti.apiincidencias.service;

import org.springframework.http.ResponseEntity;
import org.ti.apiincidencias.model.Anuncios;
import org.ti.apiincidencias.response.AnuncioResponseRest;

public interface IAnuncioService {
    public ResponseEntity<AnuncioResponseRest> todosA();
    public ResponseEntity<AnuncioResponseRest> eliminarA(Anuncios anuncio, Long id);
}
