package org.example.relaciones.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "articulos")
@Setter
@Getter
public class Articulo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autocrementa el id
    private Long codigo;
    private String descripcion;
    private double precio;


    /*aqui es donde existe la relacion entre Rubro y Articulo*/
    @ManyToOne
    @JoinColumn(name = "rubro_id")
    private Rubro rubro;




}
