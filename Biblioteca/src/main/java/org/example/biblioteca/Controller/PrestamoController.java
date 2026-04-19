package org.example.biblioteca.Controller;


import jakarta.validation.Valid;
import org.example.biblioteca.Model.Prestamo;
import org.example.biblioteca.Service.PrestamoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/prestamo")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService){
        this.prestamoService = prestamoService;
    }


    @PostMapping()
    public ResponseEntity<?> crearPrestamos(@Valid @RequestBody Prestamo prestamoNuevo, BindingResult resultado){
        Map<String, String> errores = new HashMap<>();
        if(resultado.hasErrors()){
            resultado.getFieldErrors().forEach(e -> errores.put(e.getField(), e.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }

        return ResponseEntity.ok(prestamoService.crearPrestamo(prestamoNuevo));
    }


    /*Actualizar lo de los prestamos*/
    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> actualizarPrestamo(@PathVariable Long id){
        return ResponseEntity.ok(prestamoService.updatePrestamo(id));
    }
}
