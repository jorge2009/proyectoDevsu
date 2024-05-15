/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devsu.proyectoDevsu.Controlador;

import com.devsu.proyectoDevsu.Modelo.Cuenta;
import com.devsu.proyectoDevsu.Servicio.CuentaServicio;
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
@RequestMapping("/cuentas")
public class CuentaController {
     @Autowired
    CuentaServicio cuentaServicio;
    
    @GetMapping
    public ArrayList<Cuenta> ObtenerCliente(){
    return cuentaServicio.obtenerCuenta();
    
    }
    
     @GetMapping(path="/{id}")
    public ArrayList<Cuenta> ClientePodId(@PathVariable("id") int id){
    return cuentaServicio.ObtenerPorId(id);
    }
    
    @PostMapping
    public Cuenta GuardarCuenta(@RequestBody Cuenta cuenta){
        Cuenta cue=cuentaServicio.guardarCuenta(cuenta);
        System.err.println("Inserto cuenta "+cue.getCuentaId());
    return cue;
    }
    
    @PutMapping
     public Cuenta ActualizarCuenta(@RequestBody Cuenta cuenta){
        
             Cuenta cue=cuentaServicio.ActualizarCuenta(cuenta);
        System.err.println("Actualizo Cuenta "+cue.getCuentaId());
    return cue;
        
       
    }
     
     @DeleteMapping(path="/{id}")
     public String EliminarPorId(@PathVariable("id") int id){
     boolean ok = cuentaServicio.EliminarCuenta(id);
    if(ok){
    return "Se elimino el cuenta con id "+id;
    }else{
    return "No se pudo eliminar el cuenta con id "+id;
    }
     }
}
