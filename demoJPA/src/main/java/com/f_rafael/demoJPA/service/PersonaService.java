/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.demoJPA.service;

import com.f_rafael.demoJPA.model.Persona;
import com.f_rafael.demoJPA.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class PersonaService implements IPersonaService{
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> getPersonas() {
         List<Persona> listaPersonas = personaRepository.findAll();
         return listaPersonas;
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = personaRepository.findById(id).orElse(null);
        return persona;
    }
    @Override
    public void editPersona(Long idOriginal,Long idNueva, String nuevoNombre, String nuebvoApellido,int nuevaEdad){
        
        Persona persona = findPersona(idOriginal);
        persona.setId(idNueva);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuebvoApellido);
        persona.setEdad(nuevaEdad);
        
        savePersona(persona);
    }

    @Override
    public void editPersona(Persona persona) {
        this.savePersona(persona);
    }
    
    
    
}
