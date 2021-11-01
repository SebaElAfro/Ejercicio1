/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ejercicio1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author silvia
 */
@Controller
@RequestMapping("/editorialMenu")
public class EditorialControlador {
    
    @GetMapping()
    public ModelAndView menuEditorial(){
        return new ModelAndView("editorialMenu");
    }
    
    
}
