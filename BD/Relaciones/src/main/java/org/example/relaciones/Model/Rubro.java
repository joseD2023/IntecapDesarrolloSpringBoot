package org.example.relaciones.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Rubro {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descripcion;

    @OneToMany(mappedBy = "rubro", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Articulo> articulos;


}
