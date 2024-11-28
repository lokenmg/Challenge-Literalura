/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rodrigomencias.LiteraturaChallenge.service;

import com.rodrigomencias.LiteraturaChallenge.model.ApiRecord;
import com.rodrigomencias.LiteraturaChallenge.model.BookModel;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author loken
 */

@Service
public class ServiceApi {
    private ConsumoApi consumoAPI = new ConsumoApi();
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();
    
    public Optional<BookModel> findBook(String name){
        
        var json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + name.replace(" ", "%20"));
        //System.out.println(json);
        var data = conversor.obtenerDatos(json, ApiRecord.class);
        var book= data.getResultados().stream().findFirst().map(b -> new BookModel(b));
        if(book.isPresent()){
            return book;
        }else{
            return Optional.empty();
        }
    }
}
