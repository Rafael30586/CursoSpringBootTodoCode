/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.veterinaria.service;

import com.f_rafael.veterinaria.dto.MascotaDuenioDto;
import com.f_rafael.veterinaria.model.Duenio;
import com.f_rafael.veterinaria.model.Mascota;
import com.f_rafael.veterinaria.repository.IMascotaRepository;
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
    private IMascotaRepository repository;

    @Override
    public void guardar(Mascota mascota) {
         repository.save(mascota);
    }

    @Override
    public List<Mascota> encotrarTodas() {
        return repository.findAll();
    }

    @Override
    public Mascota encontrarPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void editar(Mascota mascota) {
        repository.save(mascota);
    }

    @Override
    public List<Mascota> encontrarCaniches() {
        return repository.econtrarCaniches();
    }

    @Override
    public MascotaDuenioDto devolverMascotaYDuenio(Long id) {
        Mascota mascota = repository.findById(id).get();
        Duenio duenio = mascota.getDuenio();
        MascotaDuenioDto dto = new MascotaDuenioDto();
        dto.setNombre_mascota(mascota.getNombre());
        dto.setEspecie(mascota.getEspecie());
        dto.setRaza(mascota.getRaza());
        dto.setNombre_duenio(duenio.getNombre());
        dto.setApellido_duenio(duenio.getApellido());
        return dto;
    }
    
}
