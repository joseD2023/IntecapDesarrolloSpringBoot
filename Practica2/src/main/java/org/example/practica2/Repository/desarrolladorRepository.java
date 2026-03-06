package org.example.practica2.Repository;

import org.example.practica2.Model.desarrolladorModel;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;

@Repository
public class desarrolladorRepository {

    private List<desarrolladorModel> listaDesarrollador = new ArrayList<>();

    /*Que podemos hacer en nuestra lista pues obtener desarrolladores y guaralos*/

    public List<desarrolladorModel> findAll(){
        return listaDesarrollador;
    }

    public void save(desarrolladorModel nuevoDesarrollador){
        listaDesarrollador.add(nuevoDesarrollador);
    }
}
