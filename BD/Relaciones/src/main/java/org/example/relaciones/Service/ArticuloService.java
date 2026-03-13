package org.example.relaciones.Service;


import org.example.relaciones.Model.Articulo;
import org.example.relaciones.Repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloService {

    private final ArticuloRepository articuloRepository;

    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }


    public List<Articulo> getAllArticulos(){
        return articuloRepository.findAll();
    }

    public Articulo getArticuloById(Long id){
        return articuloRepository.findById(id).orElse(null);
    }

    public Articulo saveArticulo(Articulo nuevoArticulo){
        return articuloRepository.save(nuevoArticulo);
    }

    public void deleteArticulo(Long id){
        articuloRepository.deleteById(id);
    }
}
