package org.example.practica2.Service;

import org.example.practica2.Model.UsuarioModel;
import org.example.practica2.Model.plataformaModel;
import org.example.practica2.Repository.UsuarioRepository;
import org.example.practica2.Repository.plataformaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }


    public List<UsuarioModel> obtenerTodosUsuarios(){
        return this.repository.findAll();
    }

    public void guardar(UsuarioModel nueva){
        this.repository.save(nueva);
    }
}
