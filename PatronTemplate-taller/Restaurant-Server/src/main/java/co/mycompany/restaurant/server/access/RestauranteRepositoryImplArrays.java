package co.mycompany.restaurant.server.access;

import co.mycompany.restaurant.commons.domain.Componente;
import co.mycompany.restaurant.commons.domain.TipoComponente;
import java.util.ArrayList;

/**
 * Implementación de IRestauranteRepository. Utilliza arreglos en memoria
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public final class RestauranteRepositoryImplArrays implements IRestauranteRepository {

    /**
     * Array List de Componentes
     */
    private ArrayList<Componente> componentes;
    public RestauranteRepositoryImplArrays() {
        if (componentes==null) {
            componentes = new ArrayList<>();
        }
        inicializarComponentes();        
    }
    private void inicializarComponentes(){
        //COMPONENTEES TIPO PRINCIPIO
        Componente componente1 = new Componente(1,"lentejas", TipoComponente.PRINCIPIO);
        Componente componente2 = new Componente(2,"frijoles", TipoComponente.PRINCIPIO);
        Componente componente3 = new Componente(3,"guiso de habichuela", TipoComponente.PRINCIPIO);
        Componente componente4 = new Componente(4,"garbanzos horneados", TipoComponente.PRINCIPIO);
        
        //COMPONENTES TIPO ENTRADA
        Componente componente5 = new Componente(1,"sopa de verduras", TipoComponente.ENTRADA);
        Componente componente6 = new Componente(2,"sancocho de gallina", TipoComponente.ENTRADA);
        Componente componente7 = new Componente(3,"sopa de costilla", TipoComponente.ENTRADA);
        Componente componente8 = new Componente(4,"masamorra", TipoComponente.ENTRADA);
        Componente componente9 = new Componente(5,"ensala de frutas", TipoComponente.ENTRADA);
        
        //COMPONENTES TIPO PROTEINA
        Componente componente10 = new Componente(1,"chuleta de pollo", TipoComponente.PROTEINA);
        Componente componente11 = new Componente(2,"chuleta de cerdo", TipoComponente.PROTEINA);
        Componente componente12 = new Componente(3,"carne frita", TipoComponente.PROTEINA);
        Componente componente13 = new Componente(4,"arroz con pollo con adicion de carne", TipoComponente.PROTEINA);
        
        //COCMPONENTES TIPO BEBIDA
        Componente componente14 = new Componente(1,"jugo de lulo", TipoComponente.BEBIDA);
        Componente componente15 = new Componente(2,"limonada", TipoComponente.BEBIDA);
        Componente componente16 = new Componente(3,"jugo de tomate", TipoComponente.BEBIDA);
        Componente componente17 = new Componente(3,"gaseosa de manzana", TipoComponente.BEBIDA);
        componentes.add(componente1);
        componentes.add(componente2);
        componentes.add(componente3);
        componentes.add(componente4);
        componentes.add(componente5);
        componentes.add(componente6);
        componentes.add(componente7);
        componentes.add(componente8);
        componentes.add(componente9);
        componentes.add(componente10);
        componentes.add(componente11);
        componentes.add(componente12);
        componentes.add(componente13);
        componentes.add(componente14);
        componentes.add(componente15);
        componentes.add(componente16);
        componentes.add(componente17);
    }


    @Override
    public String addComponente(Componente componente) {
        for (Componente componente1 : componentes) {
            
            if (componente1.getId()==componente.getId() && componente1.getNombre().equals(componente.getNombre())) {
                return "Error, el componente con ese id y nombre ya existe";
            }else if(componente1.getId()==componente.getId() && componente1.getTipo().name().equals(componente.getTipo().name())){
                return "Error el componente con ese id y tipo de componente ya existe";
            }
        }
        componentes.add(componente);
        return "Componente añadido correctamente";
    }  
}
