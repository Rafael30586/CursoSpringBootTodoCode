/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.f_rafael.demoJPA.service;

import com.f_rafael.demoJPA.model.Curso;
import java.util.List;

/**
 *
 * @author User
 */
public interface ICursoService {
    
    public void guardar(Curso curso);
    
    public Curso encontrarPorId(Long id);
    
    public List<Curso> encontrarTodos();
    
    public List<Curso> encontrarCursosJava();
    
}
