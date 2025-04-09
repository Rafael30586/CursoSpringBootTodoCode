/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todocodeacademy.prueba.controllers;

import com.todocodeacademy.prueba.Cliente;
import com.todocodeacademy.prueba.Inquilino;
import com.todocodeacademy.prueba.Paciente;
import com.todocodeacademy.prueba.Plato;
import com.todocodeacademy.prueba.Propiedad;
import com.todocodeacademy.prueba.PropiedadDTO;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
public class HelloController {
    
    List<Paciente> listaPacientes = List.of(new Paciente(1L,"Mariana","Villegas",LocalDate.of(1986,Month.MAY,23)),
            new Paciente(2L,"Fernando","Perez",LocalDate.of(1971,Month.FEBRUARY,3)),
            new Paciente(3L,"Nicolás","Giuliani",LocalDate.of(1967,Month.DECEMBER,10)),
            new Paciente(9L,"Laura","Fernandez",LocalDate.of(2014,Month.APRIL,24)),
            new Paciente(4L,"Jorge","Weiss",LocalDate.of(1991,Month.JULY,20)),
            new Paciente(5L,"Norma","Piatti",LocalDate.of(2015,Month.JANUARY,2)),
            new Paciente(6L,"Julia","Moreyra",LocalDate.of(1993,Month.JUNE,28)),
            new Paciente(7L,"Ezequiel","Menendez",LocalDate.of(1973,Month.OCTOBER,15)),
            new Paciente(8L,"Javier","Soza",LocalDate.of(2010,Month.SEPTEMBER,5)));
    
    @GetMapping("/saludo")
    public String saludar(@RequestParam String nombre, @RequestParam int edad){
        return "Hola "+nombre+ " de "+edad+" años";
    }
    
    @GetMapping("/despedida/{profesion}/{nombre}/{edad}")
    public String despedir(@PathVariable String profesion, @PathVariable String nombre,@PathVariable int edad){
        return "Chau "+profesion+" "+nombre+ " de "+edad+" años.";
    }
    
    @GetMapping("/suma")
    public int sumarDosNumeros(@RequestParam int primerNumero, @RequestParam int segundoNumero){
    return primerNumero+segundoNumero;
    }
    
    @GetMapping("/imc")
    public String calcularImc(@RequestParam double peso, @RequestParam double altura){
        
        double imc = peso/(Math.pow(altura, 2));
        String condicion="";
        
        if(imc>0&&imc<=18.5){
            condicion = "Insuficiente";
        }else if(imc>18.5&&imc<=24.9){
            condicion = "Peso normal";
        }else if(imc>24.9&&imc<=29.9){
            condicion = "Sobre peso";
        }else {
            condicion = "Obesidad";
        }
        
        return condicion;
        } 
    
    @GetMapping("/litros")
    public double calcularLitros(@RequestParam double galones){
        return galones*3.78541;
    }
    
    @PostMapping("/cliente")
    public void crearCliente(@RequestBody Cliente cliente){
        
        System.out.println("Cliente creado");
        System.out.println("Nombre: "+cliente.getNombre());
        System.out.println("Apellido: "+cliente.getApellido());
    }
    
    @GetMapping("/cliente/traer")
    @ResponseBody
    public List<Cliente> traerClientes(){
        List<Cliente> listaClientes = new ArrayList();
        
        listaClientes.add(new Cliente(1L,"Rafael","Alvarez"));
        listaClientes.add(new Cliente(2L,"Roberto","Rodriguez"));
        listaClientes.add(new Cliente(3L,"Mariela","Quintana"));
        
        return listaClientes;
    }
    
    @GetMapping("/pruebaresponse")
    public ResponseEntity<String> traerRespuesta(){
        return new ResponseEntity("Esto es una prueba de response",HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/plato/{id}")
    public Plato mopstrarPlato(@PathVariable Long id){
        List<Plato> listaPlatos = new ArrayList();
        
        listaPlatos.add(new Plato(1L,"Fideos",4000.0,"Fideos con salsa y pollo"));
        listaPlatos.add(new Plato(2L,"Ñoquis",5000.0,"Ñoquis con salsa y carne"));
        listaPlatos.add(new Plato(3L,"Milanesas",5000.0,"Milanesas de carne con puré"));
        listaPlatos.add(new Plato(4L,"Pizza",4500.0,"Pizza con mozzarela, aceitunas y jamón"));
        listaPlatos.add(new Plato(5L,"Filette de merluza",6000.0,"Merluzza con ensalada de tomate y lechuga"));
        
        Plato platoElegido;
        
        for(Plato plato : listaPlatos){
            if(id == plato.getId()){
                platoElegido = plato;
                return plato;
            }
        }
        return null;
    }
    
    @GetMapping("/paciente")
    public List<Paciente> mostrarPacientes(){
        return listaPacientes;
    }
    
    @GetMapping("/menores-de-edad")
    public List<Paciente> moestrarMenores(){
        List<Paciente> menoresDeEdad = new ArrayList();
        for(Paciente paciente : listaPacientes){
            if(Period.between(paciente.getFechaDeNacimiento(), LocalDate.now()).getYears()<18){
                menoresDeEdad.add(paciente);
            }
        }
        return menoresDeEdad;
    }
    
    @GetMapping("/propiedad/{id}")
    public PropiedadDTO devolverPropiedad(@PathVariable Long id){
        
        Propiedad propiedad = new Propiedad(1L,"Casa","Jorge Washington 113",200.0,4000.0);
        Inquilino inquilino = new Inquilino(1L,32361730L, "Rafael", "Alvarez","Desarrollador backend");
        
        PropiedadDTO dto = new PropiedadDTO();
        
        dto.setId_propiedad(propiedad.getId());
        dto.setPrecio_alquiler(propiedad.getPrecio_alquiler());
        dto.setTipo_propiedad(propiedad.getTipo());
        dto.setNombre(inquilino.getNombre());
        dto.setApellido(inquilino.getApellido());
        dto.setDireccion(propiedad.getDireccion());
        
        return dto;
    }
    
}
