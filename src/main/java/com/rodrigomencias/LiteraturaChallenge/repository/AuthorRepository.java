/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rodrigomencias.LiteraturaChallenge.repository;

import com.rodrigomencias.LiteraturaChallenge.model.AuthorModel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author loken
 */
@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel, Long>{
    
    public Optional<AuthorModel> findByNameContainingIgnoreCase(String name);
    
    @Query("SELECT a from AuthorModel a WHERE :year > a.birthYear AND :year < a.deathYear ORDER BY a.name")
    public List<AuthorModel> findAuthorLifeInAYear(int year);
}
