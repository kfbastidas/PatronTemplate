package co.mycompany.restaurant.server.access;

import co.mycompany.restaurant.commons.infra.Utilities;

/**
 * @author Kevith Bastidas
 * 
 * Esta clase instancia el repositorio 
 */
public class Factory {

    /**
     * atributos
     */
    
    private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Metodo que crea una instancia del repositorio
     *
     * @return una instancia segun sea el repositorio
     */
    public IRestauranteRepository getRepository() {
        String type = Utilities.loadProperty("restaurant.repository");
        if (type.isEmpty()) {
            type = "default";
        }
        IRestauranteRepository result = null;

        switch (type) {
            case "default":
                result = new RestauranteRepositoryImplArrays();
                break;
        }
        return result;

    }
}
