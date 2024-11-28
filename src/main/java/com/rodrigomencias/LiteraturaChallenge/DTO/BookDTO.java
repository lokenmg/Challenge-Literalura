/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rodrigomencias.LiteraturaChallenge.DTO;

import com.rodrigomencias.LiteraturaChallenge.model.BookModel;

/**
 *
 * @author loken
 */
public class BookDTO {
    
    private String name;
    private String author;
    private String languaje;
    private int dowloads;
    

    public BookDTO(String name, String author, String languaje, int dowloads) {
        this.name = name;
        this.author = author;
        this.languaje = languaje;
        this.dowloads = dowloads;
    }

    public BookDTO() {
    }

    public BookDTO(BookModel bookModel){
        this.name = bookModel.getName();
        this.author = bookModel.getAuthor().getName();
        this.dowloads = bookModel.getDowloads();
        this.languaje = bookModel.getLanguage();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguaje() {
        return languaje;
    }

    public void setLanguaje(String languaje) {
        this.languaje = languaje;
    }

    public int getDowloads() {
        return dowloads;
    }

    public void setDowloads(int dowloads) {
        this.dowloads = dowloads;
    }

    @Override
    public String toString() {
        return "\n-------Libro-------\n " + 
                "\n name: " + name + 
                "\n Autor: " + author + 
                "\n Idioma: " + languaje + 
                "\n Descargas: " + dowloads +
                "\n-------------------\n";
    }
    
    
}
