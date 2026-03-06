package org.example.practica2.Service;

import org.example.practica2.Model.plataformaModel;
import org.example.practica2.Repository.plataformaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class plataformaService {

    private final plataformaRepository repository;

    public plataformaService(plataformaRepository repository) {
        this.repository = repository;
    }

    /*crear la logica del sistema para que cuando el controller necesite algo el service se lo
    * pueda proporcionar*/

    public List<plataformaModel> obtenerTodasPlataformas(){
        return this.repository.findAll();
    }

    public void guardar(plataformaModel nuevaPlataforma){
        this.repository.save(nuevaPlataforma);
    }
}
