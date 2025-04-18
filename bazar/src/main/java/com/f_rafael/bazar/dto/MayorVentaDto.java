/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.bazar.dto;

/**
 *
 * @author User
 */
public class MayorVentaDto {
    private Long codigo_venta;
    private Double total;
    private int cantidad_de_productos;
    private String nombre_cliente;
    private String apellido_cliente;

    public MayorVentaDto() {
    }

    public MayorVentaDto(Long codigo_venta, Double total, int cantidad_de_productos, String nombre_cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidad_de_productos = cantidad_de_productos;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }

    public Long getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(Long codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getCantidad_de_productos() {
        return cantidad_de_productos;
    }

    public void setCantidad_de_productos(int cantidad_de_productos) {
        this.cantidad_de_productos = cantidad_de_productos;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }
    
    
    
}
