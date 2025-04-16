/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.f_rafael.demoJPA.repository;


import com.f_rafael.demoJPA.model.Curso;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface CursoRepository extends JpaRepository<Curso,Long>{
    
    @Query("SELECT c FROM Curso c WHERE c.nombre LIKE '%Java%' OR c.nombre LIKE '%java%' OR c.nombre LIKE '%JAVA%'")
    public List<Curso> encontrarCursosJava();
    
}
