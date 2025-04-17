/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.f_rafael.bazar.service;

import com.f_rafael.bazar.model.Cliente;
import com.f_rafael.bazar.model.Producto;
import com.f_rafael.bazar.model.Venta;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author User
 */
public interface VentaService {
    
    public void guardar(Venta venta);
    
    public List<Venta> encontrarTodas();
    
    public void borrarPorId(Long codigo_venta);
    
    public void editar(Long codigo_venta,LocalDate fecha_venta, Double total, List<Producto> listaProductos, Cliente unCliente);
    
    public Venta encontrarPorId(Long codigo_venta);
    
    public List<Venta> encontrarPorDia(LocalDate dia);
    
}
