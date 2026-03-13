package org.example.relaciones.Controller;


import org.example.relaciones.Model.Articulo;
import org.example.relaciones.Model.Rubro;
import org.example.relaciones.Service.ArticuloService;
import org.example.relaciones.Service.RubroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RubroController {

    private final RubroService rubroService;
    private final ArticuloService articuloService;

    public RubroController(ArticuloService articuloService, RubroService rubroService) {
        this.articuloService = articuloService;
        this.rubroService = rubroService;
    }

    @GetMapping("/rubros")
    public List<Rubro> obtenerRubros(){
        return rubroService.getAllRubros();
    }

    @GetMapping("/rubros/{id}/articulos")
    public List<Articulo> obtenerArticulosRubros(@PathVariable Long id){
        return rubroService.obtenerArticulos(id);
    }


    @GetMapping("/rubros/{id}")
    public Rubro getRubroById(@PathVariable Long id){
        return rubroService.getRubroById(id);
    }

    @PostMapping("/rubros")
    public Rubro createRubro(@RequestBody Rubro nuevoRubro){
        return rubroService.saveRubro(nuevoRubro);
    }

    @DeleteMapping("/rubros/{id}")
    public void deleteRubro(@PathVariable Long id){
        rubroService.deleteRubro(id);
    }



}
