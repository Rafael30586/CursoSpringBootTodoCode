/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.f_rafael.bazar.service;

import com.f_rafael.bazar.model.Producto;
import java.util.List;

/**
 *
 * @author User
 */
public interface ProductoService {
    
    public void guardar(Producto producto);
    
    public List<Producto> encontrarTodos();
    
    public void borrarPorId(Long id);
    
    public void editar(Long codigo_producto, String nombre, String marca, Double costo, Double cantidad_disponible);
    
    public Producto encontrarPorId(Long id);
    
    public List<Producto> encontrarCantidadMenorQueCinco();
    
}
