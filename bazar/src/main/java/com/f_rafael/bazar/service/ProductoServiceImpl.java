/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.bazar.service;

import com.f_rafael.bazar.model.Producto;
import com.f_rafael.bazar.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class ProductoServiceImpl implements ProductoService{
    
    @Autowired
    private ProductoRepository repository;

    @Override
    public void guardar(Producto producto) {
        repository.save(producto);
    }

    @Override
    public List<Producto> encontrarTodos() {
        return repository.findAll();
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Producto encontrarPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void editar(Long codigo_producto, String nombre, String marca, Double costo, Double cantidad_disponible) {
        Producto producto = repository.findById(codigo_producto).get();
        
        if(nombre!=null) producto.setNombre(nombre);
        if(marca!=null) producto.setMarca(marca);
        if(costo!=null) producto.setCosto(costo);
        if(cantidad_disponible!=null) producto.setCantidad_disponible(cantidad_disponible);
        
        repository.save(producto);
    }

    @Override
    public List<Producto> encontrarCantidadMenorQueCinco() {
        return repository.encontrarCantidadMenorQueCinco();
    }
    
}
