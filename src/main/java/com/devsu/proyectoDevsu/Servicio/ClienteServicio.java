/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devsu.proyectoDevsu.Servicio;

import com.devsu.proyectoDevsu.Modelo.Cliente;
import com.devsu.proyectoDevsu.Modelo.Persona;
import com.devsu.proyectoDevsu.Repositorio.ClienteRepositorio;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class ClienteServicio {
  @Autowired
     ClienteRepositorio clienteRepositorio;
    public ArrayList<Cliente> obtenerCliente(){
    return (ArrayList<Cliente>) clienteRepositorio.findAll();
    }
    
     public ArrayList<Cliente> ObtenerPorId(Integer id){
         ArrayList<Cliente> ListaCliente=new ArrayList<>();
         ArrayList<Cliente> ListaNCliente=new ArrayList<>();
         ListaCliente=(ArrayList<Cliente>)clienteRepositorio.findAll();
        Cliente cli=new Cliente();
        Persona per=new Persona();
        int idCliente=0;
         for(int i=0;i<ListaCliente.size();i++){
         cli=new Cliente();
         idCliente=ListaCliente.get(i).getClienteId();
         if(idCliente==id){
         cli.setContrasena(ListaCliente.get(i).getContrasena());
         cli.setEstado(ListaCliente.get(i).getEstado());
         per.setPersonaId(ListaCliente.get(i).getPersona().getPersonaId());
         cli.setPersona(per);
         ListaNCliente.add(cli);
         }
             
         }
    return ListaNCliente;
    }
    
    
    public Cliente guardarCliente(Cliente cliente){
    return clienteRepositorio.save(cliente);
    }
    
    public Cliente ActualizarCliente(Cliente cliente){
        Cliente up=new Cliente();
        Persona per=new Persona();
        up.setClienteId(cliente.getClienteId());
        up.setContrasena(cliente.getContrasena());
        up.setEstado(cliente.getEstado());
        per.setPersonaId(cliente.getPersona().getPersonaId());
        up.setPersona(per);
        
    return clienteRepositorio.save(up);
    }
    
    public boolean EliminarCliente(Integer id){
    try {
            clienteRepositorio.deleteById(id);
            return true;
        } catch (Exception e) {
        return false;
        }
    }
       
}
