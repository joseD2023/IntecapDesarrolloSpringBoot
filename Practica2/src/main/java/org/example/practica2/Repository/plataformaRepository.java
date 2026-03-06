package org.example.practica2.Repository;
import org.example.practica2.Model.plataformaModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class plataformaRepository {

    private List<plataformaModel> listaPlataforma = new ArrayList<>();

    /*Vamos hacer como un tipo de funcion o metodo o caracteristica que tiene la plataforma*/

    public List<plataformaModel> findAll(){
        return listaPlataforma;
    }

    public void save (plataformaModel nuevaPlataforma){
        listaPlataforma.add(nuevaPlataforma);
    }


}
