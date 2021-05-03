/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import co.mycompany.restaurant.commons.domain.Componente;
import co.mycompany.restaurant.commons.domain.TipoComponente;
import co.mycompany.restaurant.server.access.RestauranteRepositoryImplArrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kevit
 */
public class RestauranteRepositoryImplArraysIT {
    
    public RestauranteRepositoryImplArraysIT() {
    }
    

    /**
     * Test of addComponente method, of class RestauranteRepositoryImplArrays.
     */
    @Test
    public void testAddComponente() {
        System.out.println("addComponente");
        //componente no existente
        Componente componente = new Componente(8, "oyucos", TipoComponente.PRINCIPIO);
        
        RestauranteRepositoryImplArrays instance = new RestauranteRepositoryImplArrays();
        
        String expResult = "Componente añadido correctamente";
        String result = instance.addComponente(componente);
        assertEquals(expResult, result);
        
        //componente existente que seria el mismo
        Componente componente2 = componente;
        expResult = "Error, el componente con ese id y nombre ya existe";
        result = instance.addComponente(componente2);
        assertEquals(expResult, result);
    }

   
    
}
