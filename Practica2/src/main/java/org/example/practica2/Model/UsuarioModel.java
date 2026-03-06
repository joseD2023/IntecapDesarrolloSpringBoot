package org.example.practica2.Model;

import jakarta.validation.constraints.*;

public class UsuarioModel {
    private Long id;
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 30, message = "El nombre debe tener entre 3 y 30 caracteres")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "El nombre solo puede contener letras")
    private String nombre;
    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 3, max = 30, message = "El apellido debe tener entre 3 y 30 caracteres")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "El apellido solo puede contener letras")
    private String apellido;
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, max = 20, message = "La contraseña debe tener entre 8 y 20 caracteres")
    private String password;
    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "Debe ingresar un correo válido")
    @Size(max = 50, message = "El correo no debe superar los 50 caracteres")
    private String email;

    public UsuarioModel(String apellido, String email, Long id, String nombre, String password) {
        this.apellido = apellido;
        this.email = email;
        this.id = id;
        this.nombre = nombre;
        this.password = password;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
