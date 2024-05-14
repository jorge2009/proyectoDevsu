/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devsu.proyectoDevsu.Servicio;

import com.devsu.proyectoDevsu.Modelo.Cliente;
import com.devsu.proyectoDevsu.Modelo.Cuenta;
import com.devsu.proyectoDevsu.Modelo.Movimientos;
import com.devsu.proyectoDevsu.Repositorio.CuentaRepositorio;
import com.devsu.proyectoDevsu.Repositorio.MovimientosRepositorio;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class MovimientosServicio {
    @Autowired
     MovimientosRepositorio movimientosRepositorio;
    
     @Autowired
     CuentaRepositorio cuentaRepositorio;
      @Autowired
     CuentaServicio cuentaServicio;
    public ArrayList<Movimientos> obtenerMovimientos(){
    return (ArrayList<Movimientos>) movimientosRepositorio.findAll();
    }
    
     public ArrayList<Movimientos> ObtenerPorId(Integer id){
         ArrayList<Movimientos> ListaMovimientos=new ArrayList<>();
         ArrayList<Movimientos> ListaNMovimientos=new ArrayList<>();
         ListaMovimientos=(ArrayList<Movimientos>)movimientosRepositorio.findAll();
        Movimientos mov=new Movimientos();
        Cuenta cue=new Cuenta();
        int idMovimientos=0;
         for(int i=0;i<ListaMovimientos.size();i++){
         mov=new Movimientos();
         idMovimientos=ListaMovimientos.get(i).getMovimientoId();
         if(idMovimientos==id){
         mov.setMovimientoId(ListaMovimientos.get(i).getMovimientoId());
         mov.setCuenta(ListaMovimientos.get(i).getCuenta());
         mov.setFecha(ListaMovimientos.get(i).getFecha());
         mov.setSaldo(ListaMovimientos.get(i).getSaldo());
         mov.setTipo_movimiento(ListaMovimientos.get(i).getTipo_movimiento());
                  
         cue.setCuentaId(ListaMovimientos.get(i).getCuenta().getCuentaId());
         mov.setCuenta(cue);
         
         ListaNMovimientos.add(mov);
         }
             
         }
    return ListaNMovimientos;
    }
    
         public ArrayList<Movimientos> MovimientoObtenerPorCuenta(Integer id){
         ArrayList<Movimientos> ListaMovimientos=new ArrayList<>();
         ArrayList<Movimientos> ListaNMovimientos=new ArrayList<>();
         ListaMovimientos=(ArrayList<Movimientos>)movimientosRepositorio.findAll();
        Movimientos mov=new Movimientos();
        Cuenta cue=new Cuenta();
        int idCuenta=0;
         for(int i=0;i<ListaMovimientos.size();i++){
         mov=new Movimientos();
         idCuenta=ListaMovimientos.get(i).getCuenta().getCuentaId();
         if(idCuenta==id){
         cue.setNumero_cuenta(ListaMovimientos.get(i).getCuenta().getNumero_cuenta());
         cue.setSaldo_inicial(ListaMovimientos.get(i).getCuenta().getSaldo_inicial());
                          
         mov.setCuenta(cue);
         ListaNMovimientos.add(mov);
         }
             
         }
    return ListaNMovimientos;
    }
    
    public boolean guardarMovimientos(Movimientos movimiento){
        ArrayList<Movimientos> ListaMovimientos=new ArrayList<>();
        ArrayList<Cuenta> ListaCuenta=new ArrayList<>();
       boolean realizado=false;
        double saldoini=0;
       double valor=0;
       double saldo=0;
       int cuenta=0;
       int cliente=0;
      // saldoini=movimiento.getCuenta().getSaldo_inicial();
       System.err.println("Cuenta "+movimiento.getCuenta().getCuentaId());
       cuenta=movimiento.getCuenta().getCuentaId();
       ListaCuenta=cuentaServicio.ObtenerPorId(cuenta);
        
        System.err.println("Total cuentas "+ListaCuenta.size());
        for(Cuenta cu3: ListaCuenta){
        cliente=cu3.getCliente().getClienteId();
        saldoini=cu3.getSaldo_inicial();
        System.err.println("El cliente de la cuenta es "+cliente+' '+saldoini);
        }
       ListaMovimientos=MovimientoObtenerPorCuenta(cuenta);
        
       //for(Movimientos mo : ListaMovimientos){
       //  saldoini= mo.getCuenta().getSaldo_inicial();
       //     }
       boolean tipoMov=movimiento.getTipo_movimiento().contains("Retiro");
        if(saldoini<=0 && tipoMov){
            System.err.println("Saldo no disponible");
            realizado=false;
            
        }else{
            
            System.err.println("Saldo inicial "+saldoini);
        Date fecha=new Date();
        DateFormat datef= new SimpleDateFormat("yyyy-MM-dd");
        datef.format(fecha);
        movimiento.setFecha(fecha);
        Cuenta cue=new Cuenta();
        Movimientos mov=new Movimientos();
        valor=movimiento.getValor();
            System.err.println("El valor llegado es "+valor);
        if(movimiento.getTipo_movimiento().contains("Deposito")){
        saldo=saldoini+valor;
       
        }
        if(movimiento.getTipo_movimiento().contains("Retiro")){
        saldo=saldoini-valor;
        }
            System.err.println("El saldo es "+saldo);
        //movimiento.setSaldo(saldo);
            cue.setCuentaId(movimiento.getCuenta().getCuentaId());
            //cue.setSaldo_inicial(saldo);
            mov.setCuenta(cue);
            mov.setFecha(fecha);
            mov.setMovimientoId(movimiento.getMovimientoId());
            mov.setSaldo(saldo);
            mov.setTipo_movimiento(movimiento.getTipo_movimiento());
            mov.setValor(valor);
        movimientosRepositorio.save(mov);
        
        
         //Actualizo Saldo inicial
        Cuenta cu1=new Cuenta();
        for(Cuenta cu2 : ListaCuenta){
        Cliente cli=new Cliente();
        cli.setClienteId(cliente);
        cu1.setCliente(cli);
        cu1.setCuentaId(cu2.getCuentaId());
        cu1.setNumero_cuenta(cu2.getNumero_cuenta());
        cu1.setSaldo_inicial(saldo);
        cu1.setTipo_cuenta(cu2.getTipo_cuenta());
        cu1.setEstado(true);
        System.err.println("Parametros idCli "+cli.getClienteId()+" CuentaId "+cu2.getCuentaId());
        System.err.println("Parametros2 numCue "+cu2.getNumero_cuenta()+" saldoIni"+cu2.getSaldo_inicial());
      
         }
        try {
           cuentaServicio.guardarCuenta(cu1);  
        } catch (Exception e) {
            System.err.println("Error "+e.getMessage());
        }
        
        realizado=true;
        }
      
    return realizado;
    }
    
    public Movimientos ActualizarMovimientos(Movimientos movimiento){
        Movimientos up=new Movimientos();
        Cuenta cue=new Cuenta();
        up.setCuenta(cue);
        up.setMovimientoId(movimiento.getMovimientoId());
        up.setFecha(movimiento.getFecha());
        up.setSaldo(movimiento.getSaldo());
        up.setTipo_movimiento(movimiento.getTipo_movimiento());
        cue.setCuentaId(movimiento.getCuenta().getCuentaId());
        up.setCuenta(cue);
        
    return movimientosRepositorio.save(up);
    }
    
    public boolean EliminarMovimientos(Integer id){
    try {
            movimientosRepositorio.deleteById(id);
            return true;
        } catch (Exception e) {
        return false;
        }
    }  


public ArrayList<String> MovimientosPorFecha(Date fec1,Date fec2,int codCli){
    System.err.println("Parametros recibidos "+fec1+" fecha2 "+fec2+' '+codCli);
ArrayList<String> ListaMovimientos=new  ArrayList<>();
ListaMovimientos=movimientosRepositorio.findAllMovimientos(codCli,fec1,fec2);
return  ListaMovimientos;
}

}
