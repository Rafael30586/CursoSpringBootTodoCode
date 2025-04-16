/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.veterinaria.controller;

import com.f_rafael.veterinaria.model.Mascota;
import com.f_rafael.veterinaria.service.IMascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
public class MascotaController {
    
    @Autowired
    private IMascotaService service;
    
    @GetMapping("/mascota")
    public List<Mascota> listarTodas(){
        return service.encotrarTodas();
    }
    
    @PostMapping("/mascota")
    public String crear(@RequestBody Mascota mascota){
        service.guardar(mascota);
        return "La mascota se ha creado correctamente";
    }
    
    @GetMapping("/mascota/{id}")
    public Mascota mostrarUna(@PathVariable Long id){
        return service.encontrarPorId(id);
    }
    
    @DeleteMapping("/mascota/{id}")
    public String borrar(@PathVariable Long id){
        service.borrarPorId(id);
        return "La mascota se ha borrado correctamente";
    }
    
    @PutMapping("/mascota")
    public String modificar(@RequestBody Mascota mascota){
        service.editar(mascota);
        return "La mascota se ha modificado correctamente";
    }
    
}
