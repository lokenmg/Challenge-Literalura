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
public class ApiRecord {
    @JsonAlias("results")
    private List<LibroRecord> resultados;

    public List<LibroRecord> getResultados() {
        return resultados;
    }

    public void setResultados(List<LibroRecord> resultados) {
        this.resultados = resultados;
    }
    
    
}
