package org.example.relaciones.Controller;


import org.example.relaciones.Model.Articulo;
import org.example.relaciones.Service.ArticuloService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticuloController {
    private final ArticuloService articuloService;

    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("/articulos")
    public List<Articulo> obtenerArticulos(){
        return articuloService.getAllArticulos();
    }


    @GetMapping("/articulos/{id}")
    public Articulo getArticuloById(@PathVariable Long id){
        return articuloService.getArticuloById(id);
    }

    @PostMapping("/articulos")
    public Articulo createArticulo(@RequestBody Articulo nuevoArticulo){
        return articuloService.saveArticulo(nuevoArticulo);
    }

    @DeleteMapping("/articulos/{id}")
    public void deleteArticulos(@PathVariable Long id){
        articuloService.deleteArticulo(id);
    }



}
