/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devsu.proyectoDevsu.Controlador;

import com.devsu.proyectoDevsu.Modelo.Persona;
import com.devsu.proyectoDevsu.Servicio.PersonaServicio;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jorge
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    PersonaServicio personaServicio;
    
    @GetMapping
    public ArrayList<Persona> ObtenerPersona(){
    return personaServicio.obtenerPersona();
    }
    
     @GetMapping(path="/{id}")
    public ArrayList<Persona> PersonaPodId(@PathVariable("id") int id){
    return personaServicio.ObtenerPorId(id);
    }
    
    @PostMapping
    public Persona GuardarPersona(@RequestBody Persona persona){
        Persona per=personaServicio.guardarPersona(persona);
        System.err.println("Inserto persona "+per.getNombre());
    return per;
    }
    
    @PutMapping
     public Persona ActualizarPersona(@RequestBody Persona persona){
        Persona per=personaServicio.guardarPersona(persona);
        System.err.println("Actualizo persona "+per.getNombre());
    return per;
    }
     
     @DeleteMapping(path="/{id}")
     public String EliminarPorId(@PathVariable("id") int id){
     boolean ok = personaServicio.EliminarPersona(id);
    if(ok){
    return "Se elimino la persona con id "+id;
    }else{
    return "No se pudo eliminar la Persona con id "+id;
    }
     }
     
}
