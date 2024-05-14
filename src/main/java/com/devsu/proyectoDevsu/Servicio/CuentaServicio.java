/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devsu.proyectoDevsu.Servicio;

import com.devsu.proyectoDevsu.Modelo.Cliente;
import com.devsu.proyectoDevsu.Modelo.Cuenta;
import com.devsu.proyectoDevsu.Repositorio.CuentaRepositorio;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Jorge
 */
@Service
public class CuentaServicio {
     @Autowired
     CuentaRepositorio cuentaRepositorio;
    public ArrayList<Cuenta> obtenerCuenta(){
    return (ArrayList<Cuenta>) cuentaRepositorio.findAll();
    }
    
     public ArrayList<Cuenta> ObtenerPorId(Integer id){
         ArrayList<Cuenta> ListaCuenta=new ArrayList<>();
         ArrayList<Cuenta> ListaNCuenta=new ArrayList<>();
         ListaCuenta=(ArrayList<Cuenta>)cuentaRepositorio.findAll();
        Cuenta cue=new Cuenta();
        Cliente cli=new Cliente();
        int idCuenta=0;
         for(int i=0;i<ListaCuenta.size();i++){
         cli=new Cliente();
         idCuenta=ListaCuenta.get(i).getCuentaId();
         if(idCuenta==id){
         
         cue.setCuentaId(ListaCuenta.get(i).getCuentaId());
         cue.setEstado(ListaCuenta.get(i).isEstado());
         cue.setNumero_cuenta(ListaCuenta.get(i).getNumero_cuenta());
         cue.setSaldo_inicial(ListaCuenta.get(i).getSaldo_inicial());
         cue.setTipo_cuenta(ListaCuenta.get(i).getTipo_cuenta());
         cli.setClienteId(ListaCuenta.get(i).getCliente().getClienteId());
         cue.setCliente(cli);
         
         ListaNCuenta.add(cue);
         }
             
         }
    return ListaNCuenta;
    }
    
    
    public Cuenta guardarCuenta(Cuenta cuenta){
    return cuentaRepositorio.save(cuenta);
    }
    
    public Cuenta ActualizarCuenta(Cuenta cuenta){
        Cuenta up=new Cuenta();
        Cliente cli=new Cliente();
        up.setCliente(cli);
        up.setCuentaId(cuenta.getCuentaId());
        up.setEstado(cuenta.isEstado());
        up.setNumero_cuenta(cuenta.getNumero_cuenta());
        up.setSaldo_inicial(cuenta.getSaldo_inicial());
        up.setTipo_cuenta(cuenta.getTipo_cuenta());
        cli.setClienteId(cuenta.getCliente().getClienteId());
        up.setCliente(cli);
        
    return cuentaRepositorio.save(up);
    }
    
    public boolean EliminarCuenta(Integer id){
    try {
            cuentaRepositorio.deleteById(id);
            return true;
        } catch (Exception e) {
        return false;
        }
    }
       
}
