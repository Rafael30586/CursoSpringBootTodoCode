/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.veterinaria.service;

import com.f_rafael.veterinaria.model.Duenio;
import com.f_rafael.veterinaria.repository.IDuenioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class DuenioService implements IDuenioService{
    
    @Autowired
    private IDuenioRepository repository;

    @Override
    public void guardar(Duenio duenio) {
        repository.save(duenio);
        
    }

    @Override
    public List<Duenio> encotrarTodos() {
        return repository.findAll();
    }

    @Override
    public Duenio encontrarPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void editar(Duenio duenio) {
         repository.save(duenio);
    }
    
}
