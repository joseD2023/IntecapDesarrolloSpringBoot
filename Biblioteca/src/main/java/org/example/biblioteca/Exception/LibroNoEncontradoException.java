package org.example.biblioteca.Exception;


public class LibroNoEncontradoException extends RuntimeException{
    public LibroNoEncontradoException(String mensaje){
        super(mensaje);
    }
}
