package org.example.biblioteca.Repository;

import org.example.biblioteca.Model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    boolean existsByLibroIdAndEstadoFalse(Long libroId);
}
