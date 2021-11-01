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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author silvia
 */
@Controller
@RequestMapping("/autorMenu")
public class AutorControlador {
    
    @Autowired
    private AutorService as;
    
    @GetMapping()
    public ModelAndView menuAutores(){
        return new ModelAndView("autorMenu");
    }
    @GetMapping("/todos")
    public ModelAndView mostrarAutores(){
        ModelAndView mav = new ModelAndView("autorTodos");
        List<Autor> autores = as.obtenerAutores();
        mav.addObject("autores", autores);
        return mav;
    }
    
    @GetMapping("/ingresar")
    public ModelAndView ingresarAutor(){
        ModelAndView mav = new ModelAndView("ingresarAutor");
        
        return mav;
    }
    
    @PostMapping("/guardar")
    public RedirectView guardar(@RequestParam String nombre){
        as.crearAutor(nombre);
        return new RedirectView("/autorMenu");
    }
    
    @GetMapping("/altaBaja")
    public ModelAndView altaBajaAutor(){
         ModelAndView mv = new ModelAndView("altaBajaAutor");
         return mv;
    }
    
    @PostMapping("/alta")
    public RedirectView altaAutor(@RequestParam Integer id){
        as.altaAutor(id);
        return new RedirectView("/autorMenu");
    }
    
    @PostMapping("/baja")
    public RedirectView bajaAutor(@RequestParam Integer id){
        as.bajaAutor(id);
        return new RedirectView("/autorMenu");
    }
    
    @GetMapping("/modificar")
    public ModelAndView modificarAutor(){
        return new ModelAndView("autorModificar");
    }
    
    @PostMapping("/guardarModificacion")
    public RedirectView guardarModificacionAutor(@RequestParam Integer id, @RequestParam String nombre, @RequestParam Boolean alta){
        as.modificarAutor(id, nombre, alta);
        return new RedirectView("/autorMenu");
    }
    
}
