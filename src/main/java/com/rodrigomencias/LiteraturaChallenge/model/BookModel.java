/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rodrigomencias.LiteraturaChallenge.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author loken
 */
@Entity
@Table(name = "Books")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String aLanguage;
    private int dowloads;

    @ManyToOne
    private AuthorModel author;

    public BookModel() {
    }

    public BookModel(String name, String language, int dowloads, AuthorModel author) {
        this.name = name;
        this.aLanguage = language;
        this.dowloads = dowloads;
        this.author = author;
    }

    public BookModel(LibroRecord b) {
        this.name = b.getNombre();
        this.dowloads = b.getDescargas();
        this.author = getAnAutor(b.getAutores());
        this.aLanguage = getALanguaje(b.getIdiomas());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return aLanguage;
    }

    public void setLanguages(String language) {
        this.aLanguage = language;
    }

    public int getDowloads() {
        return dowloads;
    }

    public void setDowloads(int dowloads) {
        this.dowloads = dowloads;
    }

    public AuthorModel getAuthor() {
        return author;
    }

    public void setAuthor(AuthorModel author) {
        this.author = author;
    }

    private String getALanguaje(List<String> languajes) {
        var languaje = languajes.stream().findFirst();
        if (languaje.isPresent()) {
            return languaje.get();
        } else {
            return "no data";
        }
    }

    private AuthorModel getAnAutor(List<AutorRecord> authors) {
        var author = authors.stream().findFirst();
        if (author.isPresent()) {
            return new AuthorModel(author.get().getNombre(), author.get().getAnioNacimiento(), author.get().getAnioDefuncion());
        } else {
            return new AuthorModel("not name", 0000, 0000);
        }
    }
}
