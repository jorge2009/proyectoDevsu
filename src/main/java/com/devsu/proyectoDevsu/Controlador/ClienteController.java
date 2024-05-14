/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devsu.proyectoDevsu.Controlador;

import com.devsu.proyectoDevsu.Modelo.Cliente;
import com.devsu.proyectoDevsu.Modelo.Persona;
import com.devsu.proyectoDevsu.Servicio.ClienteServicio;
import com.devsu.proyectoDevsu.Servicio.PersonaServicio;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/clientes")
public class ClienteController {
     @Autowired
    ClienteServicio clienteServicio;
    
    @GetMapping
    public ArrayList<Cliente> ObtenerCliente(){
    return clienteServicio.obtenerCliente();
    }
    
     @GetMapping(path="/{id}")
    public ArrayList<Cliente> ClientePodId(@PathVariable("id") int id){
    return clienteServicio.ObtenerPorId(id);
    }
    
    @PostMapping
    public Cliente GuardarCliente(@RequestBody Cliente cliente){
        Cliente cli=clienteServicio.guardarCliente(cliente);
        System.err.println("Inserto cliente "+cli.getClienteId());
    return cli;
    }
    
    @PutMapping
     public Cliente ActualizarCliente(@RequestBody Cliente cliente){
        
             Cliente cli=clienteServicio.ActualizarCliente(cliente);
        System.err.println("Actualizo Cliente "+cli.getClienteId());
    return cli;
        
       
    }
     
     @DeleteMapping(path="/{id}")
     public String EliminarPorId(@PathVariable("id") int id){
     boolean ok = clienteServicio.EliminarCliente(id);
    if(ok){
    return "Se elimino el cliente con id "+id;
    }else{
    return "No se pudo eliminar el cliente con id "+id;
    }
     }
}
