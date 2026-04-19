package org.example.biblioteca.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Usuarios")
@Setter
@Getter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Nombres Vacios no son validos")
    private String nombre;

    @Email(message = "Ingrese Un Correo Valido")
    private String email;

    //activo si esta permitido como su ingreso o tipo asi
    private boolean activo = false;

    //vamos a tener como la representación de la relacion
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Prestamo> listaPrestamos = new ArrayList<>();





    public Usuario(String nombre, String email){
        this.nombre = nombre;
        this.email = email;
    }




}
