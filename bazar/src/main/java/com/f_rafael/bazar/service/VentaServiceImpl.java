/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.bazar.service;

import com.f_rafael.bazar.dto.MayorVentaDto;
import com.f_rafael.bazar.model.Cliente;
import com.f_rafael.bazar.model.Producto;
import com.f_rafael.bazar.model.Venta;
import com.f_rafael.bazar.repository.VentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class VentaServiceImpl implements VentaService{
    
    @Autowired
    private VentaRepository repository;

    @Override
    public void guardar(Venta venta) {
        repository.save(venta);
    }

    @Override
    public List<Venta> encontrarTodas() {
        return repository.findAll();
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Venta encontrarPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void editar(Long codigo_venta, LocalDate fecha_venta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        Venta venta = repository.findById(codigo_venta).get();
        
        if(!fecha_venta.equals(null)) venta.setFecha_venta(fecha_venta);
        if(!total.equals(null)) venta.setTotal(total);
        if(!listaProductos.equals(null)) venta.setListaProductos(listaProductos);
        if(!unCliente.equals(null)) venta.setUnCliente(unCliente);
        
        repository.save(venta);
    }

    @Override
    public List<Venta> encontrarPorDia(LocalDate dia) {
        List<Venta> listaVentas = repository.findAll();
        List<Venta> ventasPorDia = new ArrayList();
        
        for(Venta venta : listaVentas){
            if(venta.getFecha_venta().equals(dia)) ventasPorDia.add(venta);
        }
        
        return ventasPorDia;
    }

    @Override
    public MayorVentaDto encontrarMayorVenta() {
        List<Venta> listaVentas = repository.findAll();
        Double mayorTotalVenta = 0.0;
        Venta mayorVenta = null;
        MayorVentaDto mayorVentaDto;
        
        for(Venta venta : listaVentas){
            if(venta.getTotal()>=mayorTotalVenta) mayorVenta = venta; 
        }
        
        mayorVentaDto = new MayorVentaDto(mayorVenta.getCodigo_venta(),
                                          mayorVenta.getTotal(),
                                          mayorVenta.getListaProductos().size(), 
                                          mayorVenta.getUnCliente().getNombre(),
                                          mayorVenta.getUnCliente().getApellido());
        
        return mayorVentaDto;
    }
    
    

    
}
