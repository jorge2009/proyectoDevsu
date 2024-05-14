/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devsu.proyectoDevsu.Servicio;

import com.devsu.proyectoDevsu.Modelo.Persona;
import com.devsu.proyectoDevsu.Repositorio.PersonaRepositorio;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class PersonaServicio {
    @Autowired
     PersonaRepositorio personaRepositorio;
    public ArrayList<Persona> obtenerPersona(){
    return (ArrayList<Persona>) personaRepositorio.findAll();
    }
    
     public ArrayList<Persona> ObtenerPorId(Integer id){
         ArrayList<Persona> ListaPersona=new ArrayList<>();
         ArrayList<Persona> ListaNPersona=new ArrayList<>();
         ListaPersona=(ArrayList<Persona>)personaRepositorio.findAll();
        Persona per=new Persona();
        
        int idPersona=0;
         for(int i=0;i<ListaPersona.size();i++){
         per=new Persona();
         idPersona=ListaPersona.get(i).getPersonaId();
         if(idPersona==id){
         per.setDireccion(ListaPersona.get(i).getDireccion());
         per.setGenero(ListaPersona.get(i).getGenero());
         per.setIdentificacion(ListaPersona.get(i).getIdentificacion());
         per.setPersonaId(idPersona);
         per.setTelefono(ListaPersona.get(i).getTelefono());
          per.setNombre(ListaPersona.get(i).getNombre());
         ListaNPersona.add(per);
         }
             
         }
    return ListaNPersona;
    }
    
    
    public Persona guardarPersona(Persona persona){
    return personaRepositorio.save(persona);
    }
    
    public Persona ActualizarPersona(Persona persona){
        Persona up=new Persona();
        up.setDireccion(persona.getDireccion());
        up.setEdad(persona.getEdad());
        up.setGenero(persona.getGenero());
        up.setIdentificacion(persona.getIdentificacion());
        up.setNombre(persona.getNombre());
        up.setPersonaId(persona.getPersonaId());
        up.setTelefono(persona.getTelefono());
       
    return personaRepositorio.save(up);
    }
    
    public boolean EliminarPersona(Integer id){
    try {
            personaRepositorio.deleteById(id);
            return true;
        } catch (Exception e) {
        return false;
        }
    }
    
    
}
