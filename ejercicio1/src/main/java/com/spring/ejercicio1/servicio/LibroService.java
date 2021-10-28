/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ejercicio1.servicio;

import com.spring.ejercicio1.entidades.*;
import com.spring.ejercicio1.repositorios.LibroRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroService {

    @Autowired
    private LibroRepositorio repositorio;

    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Autor autor, Editorial editorial) {
        Libro libro = new Libro(isbn, titulo, anio, ejemplares, 0, ejemplares, true, autor, editorial);
        repositorio.save(libro);
    }

    @Transactional
    public void modificarLibro(String id, Long isbn, String titulo, Integer anio,
            Integer ejemplares, Integer ejemplaresPrestados, Boolean alta, Autor autor, Editorial editorial) {
        Libro libro = repositorio.findById(id).get();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setEjemplaresPrestados(ejemplaresPrestados);
        libro.setAlta(alta);
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        repositorio.save(libro);
    }

    @Transactional
    private void bajaAlta(String id, Boolean alta) {
        Libro libro = repositorio.getById(id);
        libro.setAlta(alta);
        repositorio.save(libro);
    }

    public void bajaLibro(String id) {
        bajaAlta(id, false);
    }

    public void alta(String id) {
        bajaAlta(id, true);
    }

    @Transactional(readOnly = true)
    public List<Libro> obtenerLibros() {
        List<Libro> libros = repositorio.findAll();
        return libros;
    }
}
