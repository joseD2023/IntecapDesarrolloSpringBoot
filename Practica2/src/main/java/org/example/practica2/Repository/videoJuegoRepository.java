package org.example.practica2.Repository;
import java.util.List;
import java.util.ArrayList;

import org.example.practica2.Model.videoJuegoModel;
import org.springframework.stereotype.Repository;

@Repository
public class videoJuegoRepository {

    private List<videoJuegoModel> listaVideojuegos = new ArrayList<>();

    public List<videoJuegoModel> findAll(){
        return listaVideojuegos;
    }

    public void save (videoJuegoModel videoJuego){
        listaVideojuegos.add(videoJuego);
    }


}
