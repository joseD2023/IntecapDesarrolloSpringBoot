package org.example.practica2.Service;

import org.example.practica2.Model.desarrolladorModel;
import org.example.practica2.Repository.desarrolladorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class desarrolladorService {
    private final desarrolladorRepository repository;

    public desarrolladorService(desarrolladorRepository repository) {
        this.repository = repository;
    }

    /*La logica de obtener los datos y de guardar*/

    public List<desarrolladorModel> obtenerTodos(){
        return this.repository.findAll();
    }


    public void guardar(desarrolladorModel nuevo){
        this.repository.save(nuevo);
    }
}
