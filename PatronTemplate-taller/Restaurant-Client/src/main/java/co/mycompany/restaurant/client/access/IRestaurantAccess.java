package co.mycompany.restaurant.client.access;

import co.mycompany.restaurant.commons.domain.Componente;

/**
 *
 * @author Kevith Bastidas
 */
public interface IRestaurantAccess {
    
    
    /**
     * Adiciona un componenete a la base de datos
     * @param componente
     * @return
     */
    public String addComponente(Componente componente);
}
