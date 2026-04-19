package org.example.biblioteca.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Libros")
@Setter
@Getter
@NoArgsConstructor
public class Libro {

    //primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    //colocamos los atributos para nuestra entidad


    @Size(min = 1 , max = 4, message = "Identificador ISBN ")
    private String isbn;

    @NotBlank()
    private String titulo;

    @NotBlank
    private String autor;


    @NotNull
    @Min(value = 0 , message = "Stock no puede ser Menor a 0 ")
    private Integer stock;


    //representacion de la relacion
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Prestamo> listaPrestamo = new ArrayList<>();


    public Libro(String isbn, String titulo, String autor, Integer stock){
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.stock = stock;
    }





}
