/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.demoJPA.controller;

import com.f_rafael.demoJPA.model.Persona;
import com.f_rafael.demoJPA.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
public class PersonaController {
    
    @Autowired
    IPersonaService service;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersonas(){
        return service.getPersonas();
    }
    
    @PostMapping("/personas/crear")
    public String createStudent(@RequestBody Persona persona){
        service.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        
        service.deletePersona(id);
        
        return "La persona fue eliminada correctamente";
    }
    
    @PutMapping("/personas/editar/{id_original}")
    public Persona editPersona(@PathVariable Long id_original,
            @RequestParam(required=false, name="id") Long nuevaId,
            @RequestParam(required=false,name="nombre") String nuevoNombre,
            @RequestParam(required=false, name="apellido") String nuevoApellido,
            @RequestParam(required=false,name="edad") int edad){
        
        service.editPersona(id_original, nuevaId, nuevoNombre, nuevoApellido, edad);
        
        Persona persona = service.findPersona(id_original);
        
        return persona;
    }
    
}
