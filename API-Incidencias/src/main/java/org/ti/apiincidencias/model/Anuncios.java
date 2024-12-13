package org.ti.apiincidencias.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Anuncios implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String imagen; // Esta es la cadena Base64 que representa la imagen

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
