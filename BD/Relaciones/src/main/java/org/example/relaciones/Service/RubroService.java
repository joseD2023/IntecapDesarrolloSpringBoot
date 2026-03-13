package org.example.relaciones.Service;


import org.example.relaciones.Model.Articulo;
import org.example.relaciones.Model.Rubro;
import org.example.relaciones.Repository.ArticuloRepository;
import org.example.relaciones.Repository.RubroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RubroService {

    private final RubroRepository rubroRepository;
    private final ArticuloRepository articuloRepository;

    public RubroService(ArticuloRepository articuloRepository, RubroRepository rubroRepository) {
        this.articuloRepository = articuloRepository;
        this.rubroRepository = rubroRepository;
    }



    public List<Rubro> getAllRubros(){
        return rubroRepository.findAll();
    }

    public List<Articulo> obtenerArticulos(Long id ){
        List<Articulo> lista = new ArrayList<>();
        for(Articulo a : articuloRepository.findAll()){
            if(id.equals(a.getRubro().getId())){
                lista.add(a);
            }
        }
        return lista;
    }

    public Rubro getRubroById(Long id){
        return rubroRepository.findById(id).orElse(null); //devuelve null si el rubro no se encuentra
    }

    public Rubro saveRubro(Rubro rubro){
        return rubroRepository.save(rubro);
    }


    public void deleteRubro(Long id){
        rubroRepository.deleteById(id);
    }
}


