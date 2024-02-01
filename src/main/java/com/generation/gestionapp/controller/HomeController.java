package com.generation.gestionapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller//Esta anotación es para indicar que es un controlador que maneja vistas de Spring MVC
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    //Request mapping se usa para indicar la ruta y el tipo de solicitud
    public String mostrarHome() {
        return "home";
    }


}
