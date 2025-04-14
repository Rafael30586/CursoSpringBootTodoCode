/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.f_rafael.demoJPA.service;

import com.f_rafael.demoJPA.model.Mascota;
import java.util.List;

/**
 *
 * @author User
 */
public interface IMascotaService {
    
    public List<Mascota> getMascotas();
    
    public void saveMascota(Mascota mascota);
    
    public void deleteMascota(Long id_mascota);
    
    public Mascota findMascota(Long id_mascota);
    
    public void editMascota(Long id_original, Long id_mascotaNueva,
            String nuevoNombre,
            String nuevaEspecie,
            String nuevaRaza,
            String nuevoColor);
    
}
