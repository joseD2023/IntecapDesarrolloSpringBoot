package org.example.practica2.Repository;

import org.example.practica2.Model.UsuarioModel;
import org.example.practica2.Model.plataformaModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {
    private List<UsuarioModel> listaUsuarios = new ArrayList<>();

    /*Vamos hacer como un tipo de funcion o metodo o caracteristica que tiene la plataforma*/

    public List<UsuarioModel> findAll(){
        return listaUsuarios;
    }

    public void save (UsuarioModel nuevo){
        listaUsuarios.add(nuevo);
    }


}
