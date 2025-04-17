/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.veterinaria.controller;

import com.f_rafael.veterinaria.model.Duenio;
import com.f_rafael.veterinaria.model.Mascota;
import com.f_rafael.veterinaria.service.IDuenioService;
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
public class DuenioController {
    
    @Autowired
    private IDuenioService service;
    
    
    @GetMapping("/duenio")
    public List<Duenio> listarTodas(){
        return service.encotrarTodos();
    }
    
    @PostMapping("/duenio")
    public String crear(@RequestBody Duenio duenio){
        service.guardar(duenio);
        return "El dueño se ha creado correctamente";
    }
    
    @GetMapping("/duenio/{id}")
    public Duenio mostrarUna(@PathVariable Long id){
        return service.encontrarPorId(id);
    }
    
    @DeleteMapping("/duenio/{id}")
    public String borrar(@PathVariable Long id){
        service.borrarPorId(id);
        return "El dueño se ha borrado correctamente";
    }
    
    @PutMapping("/duenio")
    public String modificar(@RequestBody Duenio duenio){
        service.editar(duenio);
        return "El dueño se ha modificado correctamente";
    }
    
    
}
