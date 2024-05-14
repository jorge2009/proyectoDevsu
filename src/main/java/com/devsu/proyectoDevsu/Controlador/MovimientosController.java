/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devsu.proyectoDevsu.Controlador;

import com.devsu.proyectoDevsu.Modelo.Movimientos;
import com.devsu.proyectoDevsu.Servicio.MovimientosServicio;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jorge
 */
@RestController
@RequestMapping("/movimientos")
public class MovimientosController {
    
     @Autowired
    MovimientosServicio movimientosServicio;
    
    @GetMapping
    public ArrayList<Movimientos> ObtenerCliente(){
    return movimientosServicio.obtenerMovimientos();
    }
    
     @GetMapping(path="/{id}")
    public ArrayList<Movimientos> ClientePodId(@PathVariable("id") int id){
    return movimientosServicio.ObtenerPorId(id);
    }
    
    @PostMapping
    public String GuardarMovimientos(@RequestBody Movimientos movimientos){
        String mensaje;
        boolean mov=movimientosServicio.guardarMovimientos(movimientos);
        if(mov){
            mensaje="Movimiento realizado correctamente";
        System.err.println("Movimiento realizado correctamente ");
        }else{
            System.err.println("Saldo no disponible");
            mensaje="Saldo no disponible";
        }
        
    return mensaje;
    }
    
    @PutMapping
     public Movimientos ActualizarMovimientos(@RequestBody Movimientos movimientos){
        
             Movimientos mov=movimientosServicio.ActualizarMovimientos(movimientos);
        System.err.println("Actualizo Movimientos "+mov.getMovimientoId());
    return mov;
        
       
    }
     
     @DeleteMapping(path="/{id}")
     public String EliminarPorId(@PathVariable("id") int id){
     boolean ok = movimientosServicio.EliminarMovimientos(id);
    if(ok){
    return "Se elimino el movimientos con id "+id;
    }else{
    return "No se pudo eliminar el movimientos con id "+id;
    }
     }
     
     
     @GetMapping(value = "/{id}/{fecha}/{fecha2}")
    public ArrayList<String> MovimientosPorFecha(@PathVariable int id,
            @PathVariable String fecha,@PathVariable String fecha2){
        DateFormat formateador= new SimpleDateFormat("yyyy-MM-dd");
        Date nfecha=new Date();
        Date nfecha2=new Date();
         try {
             nfecha=formateador.parse(fecha);
             nfecha2=formateador.parse(fecha2);
         } catch (Exception e) {
             System.err.println("Error fechas "+e.getMessage());
         }
        
    return movimientosServicio.MovimientosPorFecha(nfecha, nfecha2, id);
    }
     
}
