/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.bazar.controller;

import com.f_rafael.bazar.model.Cliente;
import com.f_rafael.bazar.model.Producto;
import com.f_rafael.bazar.service.ClienteService;
import com.f_rafael.bazar.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService service;
    
    @PostMapping("/crear")
    public void crear(@RequestBody Cliente cliente){
        service.guardar(cliente);
    }
    
    @GetMapping("/")
    public List<Cliente> listarTodos(){
        return service.encontrarTodos();
    }
    
    @GetMapping("/{id_cliente}")
    public Cliente buscarPorId(@PathVariable Long id_cliente){
        return service.encontrarPorId(id_cliente);
    }
    
    @DeleteMapping("/eliminar/{id_cliente}")
    public void eliminar(@PathVariable Long id_cliente){
        service.borrarPorId(id_cliente);
    }
    
    @PutMapping("/editar/{id_cliente}")
    public void editar(@PathVariable Long id_cliente, @RequestBody Cliente cliente){
        service.editar(id_cliente, cliente.getNombre(), cliente.getApellido(), cliente.getDni());
    }
    
    
}
