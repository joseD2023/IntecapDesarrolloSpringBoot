package org.example.biblioteca.Model;
import jakarta.persistence.*;
import  org.example.biblioteca.Model.Libro;
import  org.example.biblioteca.Model.Usuario;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Prestamos")
@NoArgsConstructor
@Setter
@Getter
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private LocalDate fecha = LocalDate.now();

    private boolean estado = false;



}
