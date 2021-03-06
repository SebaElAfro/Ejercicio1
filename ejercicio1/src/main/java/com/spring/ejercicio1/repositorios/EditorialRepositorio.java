/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ejercicio1.repositorios;

import com.spring.ejercicio1.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author silvia
 */
@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, Integer> {
    @Modifying
    @Query("update Editorial e set e.nombre = :nombre, e.alta = :alta where e.id = :id")
    public void modificarEditorial(@Param("id") Integer id, @Param("nombre") String nombre, @Param("alta") Boolean alta);
}
