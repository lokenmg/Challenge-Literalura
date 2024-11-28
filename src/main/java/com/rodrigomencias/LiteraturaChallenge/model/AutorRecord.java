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
public class  AutorRecord {
    
    @JsonAlias("name")
    private String nombre;
    @JsonAlias("birth_year")
    private int anioNacimiento;
    @JsonAlias("death_year")
    private int anioDefuncion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public int getAnioDefuncion() {
        return anioDefuncion;
    }

    public void setAnioDefuncion(int anioDefuncion) {
        this.anioDefuncion = anioDefuncion;
    }
    
        
}
