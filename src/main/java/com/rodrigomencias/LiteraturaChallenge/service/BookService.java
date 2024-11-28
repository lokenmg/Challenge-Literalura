/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rodrigomencias.LiteraturaChallenge.service;

import com.rodrigomencias.LiteraturaChallenge.DTO.BookDTO;
import com.rodrigomencias.LiteraturaChallenge.model.BookModel;
import com.rodrigomencias.LiteraturaChallenge.repository.BookRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author loken
 */
@Service
public class BookService {
    private final ServiceApi serviceApi;
    private final AuthorService authorService;
    private final BookRepository bookRepository;

    @Autowired
    public BookService(ServiceApi serviceApi, AuthorService authorService, BookRepository bookRepository) {
        this.serviceApi = serviceApi;
        this.authorService = authorService;
        this.bookRepository = bookRepository;
    }

    public BookDTO saveBook(String name) throws Exception {
        var book = serviceApi.findBook(name);
        if (book.isPresent()) {
                if (bookRepository.findByNameContainingIgnoreCase(book.get().getName()).isPresent()){
                    throw new Exception("El libro ya ha sido guardado");
                }

            var author = authorService.findAuthorByName(book.get().getAuthor().getName());
            if (author.isPresent()) {
                var newBook = bookRepository.save(new BookModel(
                        book.get().getName(),
                        book.get().getLanguage(),
                        book.get().getDowloads(),
                        author.get()));
                return new BookDTO(newBook);
            } else {
                var newAuthor = authorService.saveAuthor(book.get().getAuthor());
                var newBook = bookRepository.save(new BookModel(
                        book.get().getName(),
                        book.get().getLanguage(),
                        book.get().getDowloads(),
                        newAuthor));
                return new BookDTO(newBook);
            }
        } else {
            return null;
        }
    }
    
    public List<BookDTO> getAllBooks(){
        List<BookModel> books = bookRepository.findAll();
        return books.stream().map(b -> new BookDTO(b)).collect(Collectors.toList());
    }
    
    public List<BookDTO> getBooksByLanguage(String language) throws Exception{
        List<BookModel> books = bookRepository.findByaLanguage(language);
        if(books.isEmpty()){
            throw new Exception("No se han encontrado libros");
        }
        return books.stream().map(b -> new BookDTO(b)).collect(Collectors.toList());
        
    }
}
