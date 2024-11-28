/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rodrigomencias.LiteraturaChallenge.repository;

import com.rodrigomencias.LiteraturaChallenge.model.BookModel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author loken
 */
@Repository
public interface BookRepository extends JpaRepository<BookModel, Long>{
    
    public Optional<BookModel> findByNameContainingIgnoreCase(String name);
    public List<BookModel> findByaLanguage(String languaje);
}
