/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.demoJPA.service;

import com.f_rafael.demoJPA.model.Mascota;
import com.f_rafael.demoJPA.repository.MascotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class MascotaService implements IMascotaService{
    
    @Autowired
    private MascotaRepository mascotaRepository;

    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> listaMascotas = mascotaRepository.findAll();
        return listaMascotas;
    }

    @Override
    public void saveMascota(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

    @Override
    public void deleteMascota(Long id_mascota) {
       mascotaRepository.deleteById(id_mascota);
    }

    @Override
    public Mascota findMascota(Long id_mascota) {
        return mascotaRepository.findById(id_mascota).orElse(null);
    }

    @Override
    public void editMascota(Long id_original, Long id_mascotaNueva, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor) {
        Mascota mascota = this.findMascota(id_original);
        
        mascota.setId_mascota(id_mascotaNueva);
        mascota.setNombre(nuevoNombre);
        mascota.setEspecie(nuevaEspecie);
        mascota.setRaza(nuevaRaza);
        mascota.setColor(nuevoColor);
        
        this.saveMascota(mascota);
    }
    
}
