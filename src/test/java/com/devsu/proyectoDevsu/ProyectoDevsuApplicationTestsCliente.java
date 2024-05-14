package com.devsu.proyectoDevsu;

import com.devsu.proyectoDevsu.Controlador.ClienteController;
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
class ProyectoDevsuApplicationTestsCliente {
    
    
    
    @BeforeEach
    void setUp(){
        Persona per=new Persona();
        per.setPersonaId(4);
        Cliente cli=new Cliente();
        cli.setClienteId(1);
        cli.setContrasena("54654");
        cli.setEstado("Verdadero");
        cli.setPersona(per);
        cliente.add(cli);
        
    
    }
    
    @Mock
    private ClienteRepositorio clienteRepositorio;
    
    @Mock
    private ClienteController clienteController;
   
    @InjectMocks
    private ClienteServicio clienteServicio;
    
    private ArrayList<Cliente> cliente=new ArrayList<>();
	@Test
	public void BuscarCliente() {
            System.err.println("Metodo Buscar Cliente");
      when(clienteController.ObtenerCliente()).thenReturn(cliente);
      for(Cliente c: cliente){
          System.err.println("ClienteId "+c.getClienteId());
          System.err.println("Contraseña "+c.getContrasena());
          System.err.println("Estado "+c.getEstado());
          System.err.println("PersonaId "+c.getPersona().getPersonaId());
      }
     }
      
        @Test
	public void ActualizarCliente() {
            System.err.println("Metodo Actualizar Cliente");
            Cliente clien=new Cliente();
            clien.setClienteId(3);
      when(clienteController.ActualizarCliente(clien)).thenReturn(clien);
            System.err.println("Actualizo Cliente"+clien.getClienteId());
        }
        
}
