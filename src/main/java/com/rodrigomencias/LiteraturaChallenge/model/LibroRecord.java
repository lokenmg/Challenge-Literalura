/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rodrigomencias.LiteraturaChallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author loken
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LibroRecord {
    @JsonAlias("title")
    private String nombre;
    @JsonAlias("languages")
    private List<String> idiomas;
    @JsonAlias("download_count")
    private int descargas;
    @JsonAlias("authors")
    private List<AutorRecord> autores;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public int getDescargas() {
        return descargas;
    }

    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }

    public List<AutorRecord> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorRecord> autores) {
        this.autores = autores;
    }
}
