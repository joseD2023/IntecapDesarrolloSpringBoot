package org.example.biblioteca.Handler;


import org.apache.catalina.LifecycleException;
import org.example.biblioteca.Exception.LibroNoEncontradoException;
import org.example.biblioteca.Exception.UsuarioNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<String> manejarUsuarioNoEncontrado(UsuarioNoEncontradoException ex){
        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        ); //devuelve el mensaje y codigo HTTP
    }


    @ExceptionHandler(LibroNoEncontradoException.class)
    public ResponseEntity<String> manejarLibrosNoEncontrado(LibroNoEncontradoException ex){
        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }
}
