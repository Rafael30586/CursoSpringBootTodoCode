/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todocodeacademy.prueba;

/**
 *
 * @author User
 */
public class Propiedad {
    
    private Long id;
    private String tipo;
    private String direccion;
    private Double metros_cuadrados;
    private Double precio_alquiler;

    public Propiedad() {
    }

    public Propiedad(Long id, String tipo, String direccion, Double metros_cuadrados, Double precio_alquiler) {
        this.id = id;
        this.tipo = tipo;
        this.direccion = direccion;
        this.metros_cuadrados = metros_cuadrados;
        this.precio_alquiler = precio_alquiler;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getMetros_cuadrados() {
        return metros_cuadrados;
    }

    public void setMetros_cuadrados(Double metros_cuadrados) {
        this.metros_cuadrados = metros_cuadrados;
    }

    public Double getPrecio_alquiler() {
        return precio_alquiler;
    }

    public void setPrecio_alquiler(Double precio_alquiler) {
        this.precio_alquiler = precio_alquiler;
    }
    
    
    
}
