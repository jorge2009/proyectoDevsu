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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest
@AutoConfigureMockMvc
class ProyectoDevsuApplicationPerfomanceTests {
    
     @Autowired
    protected WebApplicationContext webApplicationContext;
 
    private MockMvc mockMvc;
    
	@BeforeEach
	public void setUp() throws  Exception{
            mockMvc = MockMvcBuilders
                .webAppContextSetup(this.webApplicationContext)
                .build();
        
           
     }
        @Test
        public void Aplication() throws Exception{
            System.err.println("Prueba Integracion");
           mockMvc.perform(MockMvcRequestBuilders.get("/clientes")
                   .contentType(MediaType.APPLICATION_JSON))
                   .andExpect(MockMvcResultMatchers.status().isOk())
                   .andExpect(MockMvcResultMatchers.content()
                    .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        }
        
        

        
}
