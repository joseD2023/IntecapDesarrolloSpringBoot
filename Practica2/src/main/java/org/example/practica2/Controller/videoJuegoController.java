package org.example.practica2.Controller;

import jakarta.validation.Valid;
import org.example.practica2.Model.videoJuegoModel;
import org.example.practica2.Service.videoJuegoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/videoJuegos")
public class videoJuegoController {

    private final videoJuegoService service;

    public videoJuegoController(videoJuegoService service) {
        this.service = service;
    }

    /*metodos*/

    @GetMapping()
    public List<videoJuegoModel> lsitarTodos(){
        return this.service.obtenerTodos();
    }

    /*@Valid es el encargado de verificar los datos en lo que hicimos en model*/

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody videoJuegoModel nuevo, BindingResult resultado){
        Map<String, String> errores = new HashMap<>();
        if(resultado.hasErrors()){
            resultado.getFieldErrors().forEach(e-> errores.put(e.getField(), e.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);

        }
        service.guardar(nuevo);
        return ResponseEntity.ok("Guardado con exito");
    }

    /*BindingResult no valida nada.
Solo guarda los errores que Spring encontró al validar el modelo.*/

    /*getFieldErrors() devuelve una lista de errores (una colección de objetos FieldError).
    * getField() Nombre del campo que fallo
    * getDefaultMessage() mensaje de validacion */
}
