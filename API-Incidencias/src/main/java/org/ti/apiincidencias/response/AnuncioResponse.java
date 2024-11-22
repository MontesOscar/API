package org.ti.apiincidencias.response;

import org.ti.apiincidencias.model.Anuncios;

import java.util.List;

public class AnuncioResponse {
    private List<Anuncios> anuncios;
    public List<Anuncios> getAnuncios() {
        return anuncios;
    }
    public void setAnuncios(List<Anuncios> anuncios) {
        this.anuncios = anuncios;
    }
}
