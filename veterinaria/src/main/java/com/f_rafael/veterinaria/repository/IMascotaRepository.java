/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.f_rafael.veterinaria.repository;

import com.f_rafael.veterinaria.model.Mascota;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface IMascotaRepository extends JpaRepository<Mascota, Long>{
    
    @Query("SELECT m FROM Mascota m WHERE m.especie LIKE 'perro' AND m.raza LIKE 'caniche'")
    public List<Mascota> econtrarCaniches();
    
}
