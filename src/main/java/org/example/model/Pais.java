package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "paises")
public class Pais {

    public Pais() {

    }

    @Id
    private String id;

    private String nombre;

    private String organizacion;

    private String[] partidos;

    @JsonProperty("id_presidente")
    private String id_presidente;

    // ---------- GET y SET --------------


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String[] getPartidos() {
        return partidos;
    }

    public void setPartidos(String[] partidos) {
        this.partidos = partidos;
    }

    public String getId_presidente() {
        return id_presidente;
    }

    public void setId_presidente(String id_presidente) {
        this.id_presidente = id_presidente;
    }
}
