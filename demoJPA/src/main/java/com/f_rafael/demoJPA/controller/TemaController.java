/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.f_rafael.demoJPA.controller;

import com.f_rafael.demoJPA.model.Curso;
import com.f_rafael.demoJPA.model.Tema;
import com.f_rafael.demoJPA.service.ICursoService;
import com.f_rafael.demoJPA.service.ITemaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TemaController {
    
    @Autowired
    private ITemaService service;
    @Autowired
    private ICursoService cursoService;
    
    @PostMapping("/tema")
    public String crear(@RequestBody Tema tema,@RequestParam Long idCurso){
        service.guardar(tema);
        Curso curso = cursoService.encontrarPorId(idCurso);
        List<Tema> listaTemas = curso.getListaDeTemas();
        Tema elMismoTema = service.encontrarPorNombre(tema.getNombre());
       
        listaTemas.add(elMismoTema);
        curso.setListaDeTemas(listaTemas);
        cursoService.guardar(curso);
        
        return "El tema se ha creado correctamente y se ha asignado al curso "+curso.getNombre();
    }
    @PutMapping("/tema")//Revisar este metodo
    public String modificarTema(@RequestBody Tema tema){
        service.guardar(tema);
        return "El tema ha sido modificado correctamente";
    }
    
}
