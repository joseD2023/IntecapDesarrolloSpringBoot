package org.example.biblioteca.Exception;


//convertimos una clase en una excepcion real personalizado
public class UsuarioNoEncontradoException extends RuntimeException{

    public UsuarioNoEncontradoException(String mensaje){
        super(mensaje);
    }




}
