/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.f_rafael.demoJPA.service;

import com.f_rafael.demoJPA.model.Tema;
import com.f_rafael.demoJPA.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author User
 */
public interface ITemaService {
    
    public void guardar(Tema tema);
    
    public Tema encontrarPorId(Long id);
    
    public Tema encontrarPorNombre(String nombre);
}
