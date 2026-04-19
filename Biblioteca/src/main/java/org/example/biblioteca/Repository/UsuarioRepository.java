package org.example.biblioteca.Repository;

import org.example.biblioteca.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //necesitamos que nos retorne el Usuario si es que existe
    Usuario findByEmail(String email); //buscar usuarios por correo

}
