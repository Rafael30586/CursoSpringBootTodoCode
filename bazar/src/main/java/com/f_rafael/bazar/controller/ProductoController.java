/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.bazar.controller;

import com.f_rafael.bazar.model.Producto;
import com.f_rafael.bazar.service.ProductoService;
import com.f_rafael.bazar.service.VentaService;
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
    @Autowired
    private VentaService ventaService;
    
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
    @GetMapping("/productos/falta-stock")
    public List<Producto> listarCantidadMenorQueCinco(){
        return service.encontrarCantidadMenorQueCinco();
    }
    
    @GetMapping("/productos/lista-por-venta/{codigo_venta}")
    public List<Producto> listarPorVenta(@PathVariable Long codigo_venta){
        return ventaService.encontrarPorId(codigo_venta).getListaProductos();
    }
    
}
