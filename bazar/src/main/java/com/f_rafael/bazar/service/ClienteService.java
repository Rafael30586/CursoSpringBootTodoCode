/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.f_rafael.bazar.service;

import com.f_rafael.bazar.model.Cliente;
import java.util.List;

/**
 *
 * @author User
 */
public interface ClienteService {
    
    public void guardar(Cliente cliente);
    
    public List<Cliente> encontrarTodos();
    
    public void borrarPorId(Long id);
    
    public void editar(Long id,String nombre, String apellido, String dni);
    
    public Cliente encontrarPorId(Long id);
    
}
