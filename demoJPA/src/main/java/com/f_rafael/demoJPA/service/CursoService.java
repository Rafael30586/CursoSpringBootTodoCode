/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.demoJPA.service;

import com.f_rafael.demoJPA.model.Curso;
import com.f_rafael.demoJPA.repository.CursoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class CursoService implements ICursoService{
    
    @Autowired
    private CursoRepository repository;

    @Override
    public void guardar(Curso curso) {
        repository.save(curso);
    }

    @Override
    public Curso encontrarPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Curso> encontrarTodos() {
        return repository.findAll();
    }

    @Override
    public List<Curso> encontrarCursosJava() {
        return repository.encontrarCursosJava();
    }
    
}
