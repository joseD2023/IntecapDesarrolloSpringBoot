package org.example.biblioteca.Service;


import org.example.biblioteca.Exception.LibroNoEncontradoException;
import org.example.biblioteca.Model.Libro;
import org.example.biblioteca.Repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    //Lógica del Negocio de la Biblioteca

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository){

        this.libroRepository = libroRepository;
    }


    public List<Libro> getAllLibros(){

        return libroRepository.findAll();
    }


    public Libro getById(Long id){
        return libroRepository.findById(id).orElse(null);
    }


    public Libro createLibro(Libro nuevoLibro){

        if(libroRepository.findLibroByIsbn(nuevoLibro.getIsbn()) != null){
            throw new LibroNoEncontradoException("Libro ya Existente");

        }
        return libroRepository.save(nuevoLibro);
    }


    public Libro updateLibro(Long id, Libro actualizarLibro){
        Libro existLibro = libroRepository.findById(id).orElse(null);

        if(existLibro == null){
            throw new LibroNoEncontradoException("Libro No existente");
        }

        if(actualizarLibro.getAutor() != null){
            existLibro.setAutor(actualizarLibro.getAutor());
        }

        if(actualizarLibro.getTitulo() != null){
            existLibro.setTitulo(actualizarLibro.getTitulo());
        }

        if(actualizarLibro.getStock() != null){
            existLibro.setStock(actualizarLibro.getStock());
        }

        return libroRepository.save(existLibro);

    }



    public boolean deleteLibro(Long id){
        Libro existeLibro = libroRepository.findById(id).orElse(null);
        if(existeLibro != null){
            libroRepository.deleteById(id);
            return true;

        }
        return false;
    }



}
