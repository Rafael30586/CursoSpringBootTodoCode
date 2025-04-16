/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.demoJPA.service;

import com.f_rafael.demoJPA.model.Tema;
import com.f_rafael.demoJPA.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class TemaService implements ITemaService{
    
    @Autowired
    private TemaRepository repository;

    @Override
    public void guardar(Tema tema) {
         repository.save(tema);
    }

    @Override
    public Tema encontrarPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Tema encontrarPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }
    
    
}
