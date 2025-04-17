/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.bazar.controller;

import com.f_rafael.bazar.model.Producto;
import com.f_rafael.bazar.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
public class ProductoController {
    
    @Autowired
    private ProductoService service;
    
    @PostMapping("/productos/crear")
    public void crear(@RequestBody Producto producto){
        service.guardar(producto);
    }
    
    @GetMapping("/productos")
    public List<Producto> listarTodos(){
        return service.encontrarTodos();
    }
    
    @GetMapping("/productos/{id}")
    public Producto buscarPorId(@PathVariable Long id){
        return service.encontrarPorId(id);
    }
    
    @DeleteMapping("/productos/eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        service.borrarPorId(id);
    }
    
}
