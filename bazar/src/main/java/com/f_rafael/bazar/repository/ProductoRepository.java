/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.f_rafael.bazar.repository;

import com.f_rafael.bazar.model.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long>{
    
    @Query("SELECT p FROM Producto p WHERE p.cantidad_disponible<5")
    public List<Producto> encontrarCantidadMenorQueCinco();
    
}
