/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rodrigomencias.LiteraturaChallenge.service;

import com.rodrigomencias.LiteraturaChallenge.DTO.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rodrigomencias.LiteraturaChallenge.model.AuthorModel;
import com.rodrigomencias.LiteraturaChallenge.repository.AuthorRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 *
 * @author loken
 */
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Optional<AuthorModel> findAuthorByName(String name) {
        return authorRepository.findByNameContainingIgnoreCase(name);
    }

    public AuthorModel saveAuthor(AuthorModel author) {
        return authorRepository.save(author);
    }
    
    public List<AuthorDTO> findAllAthors(){
        return authorRepository.findAll().stream().map(a-> new AuthorDTO(a)).collect(Collectors.toList());
    }
    
    public List<AuthorDTO> findAuthorLifeByAYear(int year){
        return authorRepository.findAuthorLifeInAYear(year).stream().map(a-> new AuthorDTO(a)).collect(Collectors.toList());
    }
}
