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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author silvia
 */
@Service
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
    
    @Transactional
    public void modificarAutor(Integer id, String nombre, Boolean alta){
        repositorio.modificarAutor(id, nombre, alta);
    }
    
    @Transactional
    public void altaAutor(Integer id){
        Autor autor = repositorio.findById(id).get();
        repositorio.modificarAutor(id, autor.getNombre(),true);
    }
    
    @Transactional
    public void bajaAutor(Integer id){
        Autor autor = repositorio.findById(id).get();
        repositorio.modificarAutor(id, autor.getNombre(),false);
        List<Libro> libros =ls.obtenerLibros();
        for (Libro libro : libros) {
            if (libro.getAutor().getId()==id) {
                ls.baja(libro.getId());
            }
        }
    }
}
