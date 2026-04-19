package org.example.biblioteca.Service;


import org.example.biblioteca.Exception.LibroNoEncontradoException;
import org.example.biblioteca.Exception.UsuarioNoEncontradoException;
import org.example.biblioteca.Model.Libro;
import org.example.biblioteca.Model.Prestamo;
import org.example.biblioteca.Model.Usuario;
import org.example.biblioteca.Repository.LibroRepository;
import org.example.biblioteca.Repository.PrestamoRepository;
import org.example.biblioteca.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class PrestamoService {

    /*Vamos a trabajar con lo que es los prestamos de libros relacionando Libros y Usuarios
    Debemos registrar los prestamos*/

    private final PrestamoRepository prestamoRepository;
    private final LibroRepository libroRepository;
    private final UsuarioRepository usuarioRepository;

    public PrestamoService(PrestamoRepository prestamoRepository, LibroRepository libroRepository, UsuarioRepository usuarioRepository){
        this.libroRepository = libroRepository;
        this.usuarioRepository = usuarioRepository;
        this.prestamoRepository = prestamoRepository;
    }


    public Prestamo crearPrestamo(Prestamo nuevoPrestamo){
         /*Debemos conocer si el usuario y el libro exista para hacer el prestamo*/

        Libro existeLibro = libroRepository.findById(nuevoPrestamo.getLibro().getId()).orElse(null);
        Usuario existeUsuario = usuarioRepository.findById(nuevoPrestamo.getUsuario().getId()).orElse(null);

        if(existeLibro == null){ throw  new LibroNoEncontradoException("Libro No encontrado"); }
        if(existeUsuario == null){ throw  new UsuarioNoEncontradoException("Usuario No encontrado"); }

        //devemos verificar que el libro no este prestado

        boolean prestado = prestamoRepository.existsByLibroIdAndEstadoFalse(existeLibro.getId());

        if(prestado){
            throw new RuntimeException("Libro ya se encuentra Prestado");
        }

        //ahora vamos a usar las relaciones para poder trabajar

        nuevoPrestamo.setUsuario(existeUsuario);
        nuevoPrestamo.setLibro(existeLibro);

        nuevoPrestamo.setEstado(false);

        return prestamoRepository.save(nuevoPrestamo);
    }


    public Prestamo updatePrestamo(Long id){
        Prestamo existe = prestamoRepository.findById(id).orElse(null);

        if(existe == null){
            throw  new RuntimeException("No existe Ningun Prestamo");
        }

        existe.setEstado(true);
        return prestamoRepository.save(existe);
    }
}
