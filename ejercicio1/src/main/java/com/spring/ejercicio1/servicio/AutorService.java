/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ejercicio1.servicio;

import com.spring.ejercicio1.entidades.Autor;
import com.spring.ejercicio1.entidades.Libro;
import com.spring.ejercicio1.repositorios.AutorRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author silvia
 */
public class AutorService {
    @Autowired
    private LibroService ls;
    
    @Autowired
    private AutorRepositorio repositorio;
    
    @Transactional
    public void crearAutor(String nombre){
        Autor autor = new Autor(nombre, true);
        repositorio.save(autor);
    }
    
    @Transactional(readOnly = true)
    public List<Autor> obtenerAutores(){
        return repositorio.findAll();
    }
    
    public void modificarAutor(String id, String nombre, Boolean alta){
        repositorio.modificarAutor(id, nombre, alta);
    }
    
    public void altaAutor(String id){
        Autor autor = repositorio.findById(id).get();
        repositorio.modificarAutor(id, autor.getNombre(),true);
    }
    
    public void bajaAutor(String id){
        Autor autor = repositorio.findById(id).get();
        repositorio.modificarAutor(id, autor.getNombre(),false);
        List<Libro> libros =ls.obtenerLibros();
        for (Libro libro : libros) {
            if (libro.getAutor().getId().equals(id)) {
                ls.bajaLibro(libro.getId());
            }
        }
    }
}
