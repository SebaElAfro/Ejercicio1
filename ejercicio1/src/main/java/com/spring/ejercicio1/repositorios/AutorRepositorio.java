/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ejercicio1.repositorios;

import com.spring.ejercicio1.entidades.Autor;
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
public interface AutorRepositorio extends JpaRepository<Autor, Integer> {
    @Modifying
    @Query("update Autor a set a.nombre = :nombre, a.alta = :alta where a.id = :id")
    public void modificarAutor(@Param("id") Integer id, @Param("nombre") String nombre, @Param("alta") Boolean alta);
}
