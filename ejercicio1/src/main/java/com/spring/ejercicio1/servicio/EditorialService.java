/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ejercicio1.servicio;

import com.spring.ejercicio1.entidades.Editorial;
import com.spring.ejercicio1.entidades.Libro;
import com.spring.ejercicio1.repositorios.EditorialRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author silvia
 */
public class EditorialService {
    @Autowired
    private EditorialRepositorio repositorio;
    @Autowired
    private LibroService ls;
    
    @Transactional
    public void crearEditorial(String nombre){
        Editorial editorial = new Editorial(nombre, true);
        repositorio.save(editorial);
    }
    
    @Transactional(readOnly = true)
    public List<Editorial> obtenerEditoriales(){
        return repositorio.findAll();
    }
    
    public void modificarEditorial(String id, String nombre,Boolean alta ){
        repositorio.modificarEditorial(id, nombre, alta);
    }
    
    public void altaEditorial(String id){
        Editorial editorial = repositorio.findById(id).get();
        modificarEditorial(id, editorial.getNombre(), true);
    }
    
    public void bajaEditorial(String id){
        Editorial editorial = repositorio.findById(id).get();
        modificarEditorial(id, editorial.getNombre(), false);
        List<Libro> libros = ls.obtenerLibros();
        for (Libro libro : libros) {
            if (libro.getEditorial().getId().equals(id)) {
                ls.bajaLibro(libro.getId());
            }
        }
    }
}
