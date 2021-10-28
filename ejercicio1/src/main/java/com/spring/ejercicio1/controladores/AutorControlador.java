/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ejercicio1.controladores;

import com.spring.ejercicio1.entidades.Autor;
import com.spring.ejercicio1.servicio.AutorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author silvia
 */
@Controller
@RequestMapping("/autor")
public class AutorControlador {
    
    @Autowired
    private AutorService as;
    
    @GetMapping("/todos")
    public ModelAndView mostrarAutores(){
        ModelAndView mav = new ModelAndView("autorTodos");
        List<Autor> autores = as.obtenerAutores();
        mav.addObject("autores", autores);
        return mav;
    }
    
//    @GetMapping("/crearAutor")
//    public ModelAndView ingresarAutor(){
//        ModelAndView mav = new ModelAndView("ingresarAutor");
//        
//    }
}
