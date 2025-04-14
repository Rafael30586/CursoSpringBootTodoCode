/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.demoJPA.controller;

import com.f_rafael.demoJPA.model.Mascota;
import com.f_rafael.demoJPA.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
public class MascotaController {
    
    @Autowired
    private IMascotaService mascotaService;
    
    @PostMapping("/mascotas/crear")
    public String createPet(@RequestBody Mascota mascota){
        mascotaService.saveMascota(mascota);
        return "La mascota fue creada correctamente";
    }
    
}
