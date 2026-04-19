package org.example.biblioteca.Controller;


import jakarta.validation.Valid;
import org.example.biblioteca.Model.Libro;
import org.example.biblioteca.Service.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService){
        this.libroService = libroService;
    }

    @GetMapping()
    public List<Libro> listaLibros(){
        return libroService.getAllLibros();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Libro> LibroPorId(@PathVariable Long id){
        Libro libroExiste = libroService.getById(id);
        return (libroExiste != null) ? ResponseEntity.ok(libroExiste) : ResponseEntity.notFound().build();
    }


    @PostMapping()
    public ResponseEntity<?> crearLibro(@Valid @RequestBody Libro nuevoLibro, BindingResult resultado){
        Map<String, String> errores = new HashMap<>();
        if(resultado.hasErrors()){
            resultado.getFieldErrors().forEach(e -> errores.put(e.getField(), e.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }

        return ResponseEntity.ok(libroService.createLibro(nuevoLibro));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Libro> libroActualizado(@PathVariable Long id, @RequestBody Libro libroActualizado){
        return ResponseEntity.ok(libroService.updateLibro(id, libroActualizado));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id){
        if(libroService.deleteLibro(id)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }






}
