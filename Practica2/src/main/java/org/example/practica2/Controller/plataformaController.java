package org.example.practica2.Controller;


import jakarta.validation.Valid;
import org.example.practica2.Model.plataformaModel;
import org.example.practica2.Service.plataformaService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/plataforma")
public class plataformaController {
    private final plataformaService service;

    public plataformaController(plataformaService service) {
        this.service = service;
    }

    @GetMapping
    public List<plataformaModel> obtenerTodos(){
        return this.service.obtenerTodasPlataformas();
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody plataformaModel nueva, BindingResult resultado){
        if(resultado.hasErrors()){
            Map <String, String> errores = new HashMap<>();
            resultado.getFieldErrors().forEach(e-> errores.put(e.getField(), e.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }
        service.guardar(nueva);
        return ResponseEntity.ok("Plataforma Guardada");
    }
}
