package co.mycompany.restaurant.server.domain.services;

import co.mycompany.restaurant.commons.domain.Componente;
import co.mycompany.restaurant.server.access.IRestauranteRepository;

/**
 * Servicio de clientes. Da acceso a la lógica de negocio
 *
 * @author Kevith Felipe Bastidas
 */
public class RestauranteService {

    /**
     * Repositorio de clientes
     */
    IRestauranteRepository repo;

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio de tipo IRestauranteRepository
     */
    public RestauranteService(IRestauranteRepository repo) {
        this.repo = repo;
    }
    
    public String addComponente(Componente componente){
        return repo.addComponente(componente);
    }
    
}
