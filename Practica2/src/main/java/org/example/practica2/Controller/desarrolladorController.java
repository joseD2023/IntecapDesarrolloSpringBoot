package org.example.practica2.Controller;


import jakarta.validation.Valid;
import org.example.practica2.Model.desarrolladorModel;
import org.example.practica2.Service.desarrolladorService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/desarrollador")
public class desarrolladorController {

    private final desarrolladorService service;

    public desarrolladorController(desarrolladorService service) {
        this.service = service;
    }


    @GetMapping()
    public List<desarrolladorModel> obtenerTodos(){
        return this.service.obtenerTodos();
    }

    @PostMapping()
    public ResponseEntity<?> crear(@Valid @RequestBody desarrolladorModel desarrollador, BindingResult result){
        if(result.hasErrors()){
            Map<String,String> errores = new HashMap<>();
            result.getFieldErrors().forEach(p->errores.put(p.getField(), p.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }
        this.service.guardar(desarrollador);
        return ResponseEntity.ok("Desarrollador Guardado");
    }
}
