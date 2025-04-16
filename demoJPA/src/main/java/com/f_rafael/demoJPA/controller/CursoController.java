/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.demoJPA.controller;

import com.f_rafael.demoJPA.model.Curso;
import com.f_rafael.demoJPA.model.Tema;
import com.f_rafael.demoJPA.service.ICursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
public class CursoController {
    
    @Autowired
    private ICursoService service;
    
    @PostMapping("/curso")
    public String crear(@RequestBody Curso curso){
        service.guardar(curso);
        return "El curso se ha creado correctamente";
    }
    @GetMapping("/curso")
    public List<Curso> obtenerTodos(){
        return service.encontrarTodos();
    }
    @GetMapping("/temas")
    public List<Tema> ObtenerTemas(@RequestParam Long idCurso){
        return service.encontrarPorId(idCurso).getListaDeTemas();
    }
    @GetMapping("/cursos-java")
    public List<Curso> obtenerCursosJava(){
        return service.encontrarCursosJava();
    }
    @PutMapping("/curso")
    public String modificar(@RequestBody Curso curso){
        service.guardar(curso);
        return "El curso ha sido modificado";
    }
    
}
