package com.devsu.proyectoDevsu;

import com.devsu.proyectoDevsu.Controlador.PersonaController;
import com.devsu.proyectoDevsu.Modelo.Cliente;
import com.devsu.proyectoDevsu.Modelo.Persona;
import com.devsu.proyectoDevsu.Repositorio.ClienteRepositorio;
import com.devsu.proyectoDevsu.Repositorio.PersonaRepositorio;
import com.devsu.proyectoDevsu.Servicio.ClienteServicio;
import com.devsu.proyectoDevsu.Servicio.PersonaServicio;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProyectoDevsuApplicationTests {
    
    
    
    @BeforeEach
    void setUp(){
        Persona per=new Persona();
        per.setDireccion("dir");
        per.setEdad(20);
        per.setGenero("Masculino");
        per.setIdentificacion("1776253535");
        per.setNombre("Jorge");
        per.setPersonaId(4);
        per.setTelefono(374747373);
        persona.add(per);
        
    
    }
    
    @Mock
    private PersonaRepositorio personaRepositorio;
    
    @Mock
    private PersonaController PersonaController;
   
    @InjectMocks
    private PersonaServicio personaServicio;
    
    private ArrayList<Persona> persona=new ArrayList<>();
	@Test
	public void BuscarPersona() {
            System.err.println("Metodo Buscar Persona");
      when(PersonaController.ObtenerPersona()).thenReturn(persona);
      for(Persona p: persona){
          System.err.println("Persona"+p.getNombre());
      }
     }

        
}
