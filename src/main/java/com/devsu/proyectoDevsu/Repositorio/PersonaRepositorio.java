/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.devsu.proyectoDevsu.Repositorio;

import com.devsu.proyectoDevsu.Modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jorge
 */
public interface PersonaRepositorio extends JpaRepository<Persona,Integer>{
    
}
