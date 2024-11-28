/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rodrigomencias.LiteraturaChallenge.DTO;

import com.rodrigomencias.LiteraturaChallenge.model.AuthorModel;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author loken
 */
public class AuthorDTO {
    private String name;
    private int birthYear;
    private int deathYear;
    private List<String> books;
    
    AuthorDTO(){
        
    }
    
    public AuthorDTO(AuthorModel author){
        this.name = author.getName();
        this.birthYear = author.getBirthYear();
        this.deathYear = author.getDeathYear();
        this.books = author.getBooks().stream().map(b -> b.getName()).collect(Collectors.toList());
    }



    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public List<String> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "\n-------Autor-------\n" + 
                "\n name: " + name + 
                "\n año nacimiento: " + birthYear + 
                "\n año desceso: " + deathYear + 
                "\n books: " + books +
                "\n-------------------\n";
                
    }
    
    
}
