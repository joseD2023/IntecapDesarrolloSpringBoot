package org.example.biblioteca.Service;


import org.example.biblioteca.Exception.UsuarioNoEncontradoException;
import org.example.biblioteca.Model.Usuario;
import org.example.biblioteca.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }


    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario getById(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }



    public Usuario createUsuario(Usuario nuevoUsuario){

        if(usuarioRepository.findByEmail(nuevoUsuario.getEmail()) != null){
            throw new UsuarioNoEncontradoException("Usuario Existente");
        }
        return usuarioRepository.save(nuevoUsuario);
    }




    public Usuario updateUsuario(Long id, Usuario actualizarUsuario){
        Usuario existeUsuario = usuarioRepository.findById(id).orElse(null);

        if(existeUsuario == null){
            throw new UsuarioNoEncontradoException("Usuario No existente");
        }

        //vamos a poder utilizar la manera en que pueden actualizar cualquier de los do s

        if(actualizarUsuario.getEmail() != null){
            existeUsuario.setEmail(actualizarUsuario.getEmail());
        }

        if(actualizarUsuario.getNombre() != null){
            existeUsuario.setNombre(actualizarUsuario.getNombre());
        }

        return usuarioRepository.save(existeUsuario);
    }



    public boolean deleteUsuario(Long id){
        Usuario usuarioExiste = usuarioRepository.findById(id).orElse(null);
        if(usuarioExiste != null){
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }



}
