package org.example.practica2.Model;

import jakarta.validation.constraints.*;

public class videoJuegoModel {
    @NotBlank(message = "El titulo es Obligatorio") /*Esta notacion se va a respetar sin usar if */
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String titulo;
    @NotBlank(message = "Genero es Obligatorio") /*No permite espacios en blanco*/
    private String genero;
    @Min(value = 1, message = "El año debe ser mayor a 0") //como minimo un año de el valor minimo permitido es 1
    private int anioLanzamiento;
    @DecimalMin(value = "0.0", message = "El precio no debe ser negativo")
    private double precio;
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe tomar un formato valido")
    @Size(max = 100, message = "El correo no puede exceder los 100 caracteres")
    private String correo;

    /*si tenemos un patron para validar un lexema es decir verificar si el token es valido
    * @Pattern entonces esto nos ayuda a verificar si un patron viene bien o sino que lance un error
    * */
    @Pattern(regexp = "[A-Z]{3}-\\d{4}", message = "Formato de placa invalido")
    private String placas;
    @Pattern(regexp = "\\d{13}", message = "El dpi debe tener 13 caracteres")
    private String dpi;
    @Pattern(regexp = "Activo|Inactivo", message = "Estado invalido")

    /*aqui es donde entra las validaciones: sistema de ventas de juegos
    * mandatorio que el titulo del juego no debe estar vacio que logicamente no deberi Ocurrir
    * En las validaciones en spring vamos a utilizar anotaciones
    * @NotBlank
    * @Not*/


    public videoJuegoModel(int anioLanzamiento, String correo, String genero, double precio, String titulo) {
        this.anioLanzamiento = anioLanzamiento;
        this.correo = correo;
        this.genero = genero;
        this.precio = precio;
        this.titulo = titulo;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
