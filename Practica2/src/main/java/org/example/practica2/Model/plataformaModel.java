package org.example.practica2.Model;

import jakarta.validation.constraints.*;

public class plataformaModel {
    @NotBlank(message = "La platafoma no puede estar vaci")
    @Size(min = 3, max = 20, message = "Plataforma debe ser entre 3 min y 20 max de caracteres")
    @Pattern(regexp = "[A-zA-Z0-9]+$", message = "Solo letras y Numeros")
    private String pc;
    @NotBlank(message = "La platafoma no puede estar vaci")
    @Size(min = 3, max = 20, message = "Plataforma debe ser entre 3 min y 20 max de caracteres")
    @Pattern(regexp = "[A-zA-Z0-9]+$", message = "Solo letras y Numeros")
    private String playStation;
    @NotBlank(message = "La platafoma no puede estar vaci")
    @Size(min = 3, max = 20, message = "Plataforma debe ser entre 3 min y 20 max de caracteres")
    @Pattern(regexp = "[A-zA-Z0-9]+$", message = "Solo letras y Numeros")
    private String xbox;
    @NotBlank(message = "La platafoma no puede estar vaci")
    @Size(min = 3, max = 20, message = "Plataforma debe ser entre 3 min y 20 max de caracteres")
    @Pattern(regexp = "[A-zA-Z0-9]+$", message = "Solo letras y Numeros")
    private String nintendoSwitch;

    public plataformaModel(String nintendoSwitch, String pc, String playStation, String xbox) {
        this.nintendoSwitch = nintendoSwitch;
        this.pc = pc;
        this.playStation = playStation;
        this.xbox = xbox;
    }

    public String getNintendoSwitch() {
        return nintendoSwitch;
    }

    public void setNintendoSwitch(String nintendoSwitch) {
        this.nintendoSwitch = nintendoSwitch;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getPlayStation() {
        return playStation;
    }

    public void setPlayStation(String playStation) {
        this.playStation = playStation;
    }

    public String getXbox() {
        return xbox;
    }

    public void setXbox(String xbox) {
        this.xbox = xbox;
    }
}
