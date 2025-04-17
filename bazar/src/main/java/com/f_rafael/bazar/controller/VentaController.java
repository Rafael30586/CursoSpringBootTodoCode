/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.bazar.controller;

import com.f_rafael.bazar.model.Cliente;
import com.f_rafael.bazar.model.Venta;
import com.f_rafael.bazar.service.ClienteService;
import com.f_rafael.bazar.service.VentaService;
import java.time.LocalDate;
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
@RequestMapping("/ventas")
public class VentaController {
    
    @Autowired
    private VentaService service;
    
    @PostMapping("/crear")
    public void crear(@RequestBody Venta venta){
        service.guardar(venta);
    }
    
    @GetMapping("/")
    public List<Venta> listarTodas(){
        return service.encontrarTodas();
    }
    
    @GetMapping("/{codigo_venta}")
    public Venta buscarPorId(@PathVariable Long codigo_venta){
        return service.encontrarPorId(codigo_venta);
    }
    
    @DeleteMapping("/eliminar/{codigo_venta}")
    public void eliminar(@PathVariable Long codigo_venta){
        service.borrarPorId(codigo_venta);
    }
    
    @PutMapping("/editar/{codigo_venta}")
    public void editar(@PathVariable Long codigo_venta, @RequestBody Venta venta){
        service.editar(codigo_venta, venta.getFecha_venta(), venta.getTotal(), venta.getListaProductos(), venta.getUnCliente());
    }
    
}
