package org.example.practica2.Service;

import org.example.practica2.Model.videoJuegoModel;
import org.example.practica2.Repository.videoJuegoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class videoJuegoService {

    private final videoJuegoRepository repository;

    public videoJuegoService(videoJuegoRepository repository) {
        this.repository = repository;
    }

    public List<videoJuegoModel> obtenerTodos(){
        return this.repository.findAll();
    }

    public void guardar(videoJuegoModel videoJuego){
        this.repository.save(videoJuego);
    }


}
