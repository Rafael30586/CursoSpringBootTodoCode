/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.bazar.service;

import com.f_rafael.bazar.model.Cliente;
import com.f_rafael.bazar.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteRepository repository;

    @Override
    public void guardar(Cliente cliente) {
       repository.save(cliente);
    }

    @Override
    public List<Cliente> encontrarTodos() {
        return repository.findAll();
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void editar(Long id,String nombre, String apellido, String dni) {
        
        Cliente cliente = repository.findById(id).get();
        
        if(nombre!=null) cliente.setNombre(nombre);
        if(apellido!=null) cliente.setApellido(apellido);
        if(dni!=null) cliente.setDni(dni);
        
        repository.save(cliente);
        
    }

    @Override
    public Cliente encontrarPorId(Long id) {
        return repository.findById(id).get();
    }
    
}
