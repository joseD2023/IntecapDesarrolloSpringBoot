package org.example.biblioteca.Controller;


import jakarta.validation.Valid;
import org.example.biblioteca.Model.Usuario;
import org.example.biblioteca.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }


    /*Parte CRUD de lo que es Usuario*/

    @GetMapping()
    public List<Usuario> listaUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> usuarioPorId(@PathVariable Long id){
        Usuario usuarioExist = usuarioService.getById(id);
        //operador ternario
        return (usuarioExist != null ) ? ResponseEntity.ok(usuarioExist) : ResponseEntity.notFound().build();

    }


    @PostMapping()
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody Usuario usuarioNuevo, BindingResult resultado){
        Map<String, String> errores  = new HashMap<>();
        if(resultado.hasErrors()){
            resultado.getFieldErrors().forEach(e -> errores.put(e.getField(), e.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }

        return ResponseEntity.ok(usuarioService.createUsuario(usuarioNuevo));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> usuarioActualizado(@PathVariable Long id, @RequestBody Usuario usuarioActualizado){
        return ResponseEntity.ok(usuarioService.updateUsuario(id, usuarioActualizado));

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id){
        if(usuarioService.deleteUsuario(id)){
            return ResponseEntity.notFound().build(); //204
        }
        return ResponseEntity.noContent().build(); //204
    }



}
