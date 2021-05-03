package co.mycompany.restaurant.server.access;

import co.mycompany.restaurant.commons.domain.Componente;

/**
 * Interface del respositorio de clientes
 * @author Kevith Felipe Bastidas
 */
public interface IRestauranteRepository {

    /**
     * Adiciona un componenete a la base de datos
     * @param componente
     * @return
     */
    public String addComponente(Componente componente);
    
}
