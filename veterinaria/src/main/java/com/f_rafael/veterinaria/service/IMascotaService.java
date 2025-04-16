/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.f_rafael.veterinaria.service;

import com.f_rafael.veterinaria.model.Mascota;
import java.util.List;

/**
 *
 * @author User
 */
public interface IMascotaService {
    
    public void guardar(Mascota mascota);
    
    public List<Mascota> encotrarTodas();
    
    public Mascota encontrarPorId(Long id);
    
    public void borrarPorId(Long id);
    
    public void editar(Mascota mascota);
    
}
