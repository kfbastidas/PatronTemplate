package co.mycompany.restaurant.client.presentation;

import co.mycompany.restaurant.client.access.IRestaurantAccess;
import co.mycompany.restaurant.client.access.RestauranteAccessImplSockets;
import co.mycompany.restaurant.commons.domain.Componente;

/**
 *
 * @author Kevith Bastidas
 * 
 * Esta clase representa el patrón fachada con el fin de que el cliente no manipule
 * directamente las clases del sistema.
 */
public class RestaurantFacade {
    
    private static RestaurantFacade instance;
    
    /**
     * servicio de acceso para conexion y envio de solicitudes al server
     */
    IRestaurantAccess service = new RestauranteAccessImplSockets();
    
    /**
     * Metodo de Singleton que se encarga de instanciar una vez la clase
     * @return la instancia restaurantFacade
     */
    public static RestaurantFacade getInstance() {
        if (instance == null) {
            instance = new RestaurantFacade();
        }
        return instance;
    }
    
     
    /**
     * Adiciona un componenete a la base de datos
     * @param componente
     * @return
     */
    public String addComponente(Componente componente){
        return service.addComponente(componente);
    }
}
