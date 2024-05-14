/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.devsu.proyectoDevsu.Repositorio;

import com.devsu.proyectoDevsu.Modelo.Movimientos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 *
 * @author Jorge
 */
public interface MovimientosRepositorio extends JpaRepository<Movimientos,Integer>{
     Date f1=new Date();
     Date f2=new Date();
    @Query(
  value = "SELECT m.fecha as fecha,p.nombre as nombre,cu.numero_cuenta as cuenta,cu.tipo_cuenta as tipo_cuenta,cu.saldo_inicial as saldo_inicial,cu.estado as estado,m.saldo as saldo,m.valor as valor FROM movimientos m,cliente c,cuenta cu,persona p WHERE c.cliente_id=cu.cliente_cliente_id and m.cuenta_cuenta_id=cu.cuenta_id and p.persona_id=c.persona_persona_id and c.cliente_id=:id and m.fecha>=:fec1 and m.fecha<=:fec2", 
  nativeQuery = true)
       
ArrayList<String>  findAllMovimientos(@Param("id") int id,@Param("fec1") Date fec1,@Param("fec2") Date fec2);
    /*
    @Query("SELECT m.fecha,p.nombre,cu.numero_cuenta,cu.tipo_cuenta,\"\n" +
"        + \"cu.saldo_inicial,cu.estado,m.saldo,m.valor FROM movimientos m,\"\n" +
"        + \"cliente c,cuenta cu,persona p WHERE c.cliente_id=cu.cliente_cliente_id and \"\n" +
"        + \"m.cuenta_cuenta_id=cu.cuenta_id and p.persona_id=c.persona_persona_id and m.fecha>: fecha and "
          + "m.fecha<:fecha2 and c.cliente_id=:id");
*/
}
