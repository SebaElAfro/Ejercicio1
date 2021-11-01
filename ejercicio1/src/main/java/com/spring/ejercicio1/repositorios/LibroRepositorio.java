/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ejercicio1.repositorios;

import com.spring.ejercicio1.entidades.Autor;
import com.spring.ejercicio1.entidades.Editorial;
import com.spring.ejercicio1.entidades.Libro;
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
public interface LibroRepositorio extends JpaRepository<Libro, Integer>{
//    @Modifying
//    @Query("UPDATE Libro l set l.isbn =:isbn, l.titulo = :titulo, l.anio= :anio, l.ejemplares= :ejemplares,"
//            + "l.ejemplaresPrestados= :ejemplaresPrestados, l.ejemplaresRestantes= :ejemplares - :ejemplaresPrestados,"
//            + "l.alta= alta,l.autor= :autor, l.editorial=editorial where l.id= :id ")
//    void modificar(@Param("id") String id, @Param("isbn") Long isbn, @Param("titulo") String titulo,@Param("anio") Integer anio,
//            @Param("ejemplares") Integer ejemplares,@Param("ejemplaresPrestados") Integer ejemplaresPrestados, 
//            @Param("alta") Boolean alta, @Param("autor") Autor autor, @Param("editorial") Editorial editorial);
}
