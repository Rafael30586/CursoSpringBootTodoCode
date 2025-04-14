/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.f_rafael.demoJPA.service;

import com.f_rafael.demoJPA.model.Persona;
import java.util.List;

/**
 *
 * @author User
 */
public interface IPersonaService {
    
    public List<Persona> getPersonas();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
    
    public void editPersona(Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad);
    
    public void editPersona(Persona persona);
    
}
