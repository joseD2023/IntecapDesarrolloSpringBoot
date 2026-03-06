package org.example.practica2.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class desarrolladorModel {
    @NotBlank(message = "La platafoma no puede estar vaci")
    @Size(min = 3, max = 20, message = "Plataforma debe ser entre 3 min y 20 max de caracteres")
    @Pattern(regexp = "[A-zA-Z0-9]+$", message = "Solo letras y Numeros")
    private String nitendo;
    @NotBlank(message = "La platafoma no puede estar vaci")
    @Size(min = 3, max = 20, message = "Plataforma debe ser entre 3 min y 20 max de caracteres")
    @Pattern(regexp = "[A-zA-Z0-9]+$", message = "Solo letras y Numeros")
    private String sega;
    @NotBlank(message = "La platafoma no puede estar vaci")
    @Size(min = 3, max = 20, message = "Plataforma debe ser entre 3 min y 20 max de caracteres")
    @Pattern(regexp = "[A-zA-Z0-9]+$", message = "Solo letras y Numeros")
    private String roblox;
    @NotBlank(message = "La platafoma no puede estar vaci")
    @Size(min = 3, max = 20, message = "Plataforma debe ser entre 3 min y 20 max de caracteres")
    @Pattern(regexp = "[A-zA-Z0-9]+$", message = "Solo letras y Numeros")
    private String konami;

    public desarrolladorModel(String konami, String nitendo, String roblox, String sega) {
        this.konami = konami;
        this.nitendo = nitendo;
        this.roblox = roblox;
        this.sega = sega;
    }

    public String getKonami() {
        return konami;
    }

    public void setKonami(String konami) {
        this.konami = konami;
    }

    public String getNitendo() {
        return nitendo;
    }

    public void setNitendo(String nitendo) {
        this.nitendo = nitendo;
    }

    public String getRoblox() {
        return roblox;
    }

    public void setRoblox(String roblox) {
        this.roblox = roblox;
    }

    public String getSega() {
        return sega;
    }

    public void setSega(String sega) {
        this.sega = sega;
    }
}
