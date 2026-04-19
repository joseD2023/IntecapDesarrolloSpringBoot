package org.example.biblioteca.Repository;

import org.example.biblioteca.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    Libro findLibroByIsbn(String isbn);
}
