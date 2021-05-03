package co.mycompany.restaurant.server.infra;

import co.mycompany.restaurant.commons.domain.Componente;
import co.unicauca.serversocket.serversockettemplate.infra.ServerSocketTemplate;
import com.google.gson.Gson;
import co.mycompany.restaurant.commons.domain.TipoComponente;
import co.mycompany.restaurant.commons.infra.Protocol;
import co.mycompany.restaurant.commons.infra.Utilities;
import co.mycompany.restaurant.server.access.Factory;
import co.mycompany.restaurant.server.access.IRestauranteRepository;
import co.mycompany.restaurant.server.domain.services.RestauranteService;

/**
 * @author Kevith Bastidas
 * 
 * Esta clase envia o recibe las peticiones entre cliente y servidor, además de extender de la clase
 * serverdsockettemplate y sus metodos reescritos
 */
public class ServerSocketRestaurant extends ServerSocketTemplate{
    
//    private PlatoService service;
    private RestauranteService service;
    /**
     * Inicialización del serversockettemplate y la inyección de la dependencia
     * 
     * @return este mismo objeto
     */
    @Override
    protected ServerSocketTemplate init() {
        PORT = Integer.parseInt(Utilities.loadProperty("server.port"));
        
        IRestauranteRepository repository = Factory.getInstance().getRepository();
        service = new RestauranteService(repository);
        
        return this;
    }
    
    /**
     * este metodo procesa la peticion que proviene del cliente
     *
     * @param requestJson de tipo json la cual contiene la petición
     */
    @Override
    protected void processRequest(String requestJson) {
        Gson gson = new Gson();
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);
        switch (protocolRequest.getResource()) {
            case "componente":
                processSetComponente(protocolRequest);
                break;
        }
    }
    
    /**
     * Procesa la solicitud de agregar un Componente
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processSetComponente(Protocol protocolRequest) {
        //Protocol{resource=componente, action=set, 
        //parameters=[Parameter{name=Id, value=12}, Parameter{name=Nombre, value=jugo de lulo}, Parameter{name=Tipo, value=BEBIDA}]}
        Componente componente = new Componente();
        int cont = 0;
        componente.setId(Integer.parseInt(protocolRequest.getParameters().get(cont).getValue()));
        cont++;
        componente.setNombre(protocolRequest.getParameters().get(cont).getValue());
        cont++;
        componente.setTipo(TipoComponente.valueOf(protocolRequest.getParameters().get(cont).getValue()));
        String response = service.addComponente(componente);   
        respond(response);
    }    
    
}
