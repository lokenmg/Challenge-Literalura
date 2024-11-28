/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rodrigomencias.LiteraturaChallenge.service;

import com.rodrigomencias.LiteraturaChallenge.DTO.BookDTO;
import com.rodrigomencias.LiteraturaChallenge.service.BookService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 *
 * @author loken
 */
@Service
public class Menu {

    private Scanner sc = new Scanner(System.in);

    private final BookService bookService;
    private final AuthorService authorService;

    public Menu(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    public void showMenu() {
        var opcion = -1;
        while (opcion != 0) {
            String menu
                    = "1 - Buscar libro \n"
                    + "2 - Mostrar libros guardados \n"
                    + "3 - Mostrar todos los autores \n"
                    + "4 - Mostrar autores vivos en x año \n"
                    + "0 - Salir \n";
            System.out.println(menu);
            opcion = intIn("digité una opcion");

            switch (opcion) {
                case 1:
                    saveBook();
                    break;
                case 2:
                    getAllBooks();
                    break;
                case 3:

                    getAllAuthors();
                    break;
                case 4:
                    getAuthorslifeInAyear();
                    break;
                case 5: 
                    getBooksByLanguageMenu();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }

    public void getAllBooks() {
        bookService.getAllBooks().stream().
                sorted(Comparator.comparing(BookDTO::getName))
                .forEach(System.out::print);
    }

    public void saveBook() {
        try {
            var title = textIn("digité el titulo del libro que quiera buscar");
            var newBook = bookService.saveBook(title);
            System.out.println(newBook);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private String textIn(String message) {
        System.out.println(message);
        sc.next();
        String text = sc.nextLine();
        return text;
    }

    private void getAllAuthors() {
        authorService.findAllAthors().stream().forEach(System.out::print);
    }

    private void getAuthorslifeInAyear() {
        int year = 0;
        year = intIn("digité el año");

        if (year != -1) {
            authorService.findAuthorLifeByAYear(year).stream().forEach(System.out::print);
        }
    }

    private int intIn(String message) {
        int number = -1;
        System.out.println(message);
        try {
            number = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n-----ERROR-------\n Entrada inválida, inténtelo de nuevo \n------------\n");
            sc.nextLine();
        }
        return number;
    }

    private void getBooksByLanguageMenu(){
        int language = intIn("Digité el número del libro que quiera buscar \n"
                + "1.- es \n"
                + "2.- en \n"
                + "3.- fr\n");
        
        switch (language){
            case 1:
                getBooksByLanguage("es");
                break;
            case 2:
                getBooksByLanguage("en");
                break;
            case 3:
                getBooksByLanguage("fr");
                break;
            default:
                System.out.println("Error, lenguaje no encontrado");
        }
    }

    private void getBooksByLanguage(String language) {
        List<BookDTO> books = new ArrayList<>();
        try {
            books = bookService.getBooksByLanguage(language);
            System.out.println("usted tiene: " + books.size());
            books.stream().forEach(b -> {
                System.out.println("\n Nombre: " + b.getName());
            });
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
