/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.f_rafael.veterinaria.service;

import com.f_rafael.veterinaria.model.Duenio;
import com.f_rafael.veterinaria.model.Mascota;
import com.f_rafael.veterinaria.repository.IDuenioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author User
 */
public interface IDuenioService {
    
    public void guardar(Duenio duenio);
    
    public List<Duenio> encotrarTodas();
    
    public Duenio encontrarPorId(Long id);
    
    public void borrarPorId(Long id);
    
    public void editar(Duenio duenio);
    
}
