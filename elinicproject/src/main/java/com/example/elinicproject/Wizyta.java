package com.example.elinicproject;

import java.time.LocalDateTime;

public class Wizyta {
    private int wizytaId;
    private int pacjentId;
    private int pracownikId;
    private LocalDateTime dataWizyty;
    private String opisWizyty;

    // Konstruktor
    public Wizyta(int wizytaId, int pacjentId, int pracownikId, LocalDateTime dataWizyty, String opisWizyty) {
        this.wizytaId = wizytaId;
        this.pacjentId = pacjentId;
        this.pracownikId = pracownikId;
        this.dataWizyty = dataWizyty;
        this.opisWizyty = opisWizyty;
    }

    public Wizyta() {

    }

    // Gettery
    public int getWizytaId() {
        return wizytaId;
    }

    public int getPacjentId() {
        return pacjentId;
    }

    public int getPracownikId() {
        return pracownikId;
    }

    public LocalDateTime getDataWizyty() {
        return dataWizyty;
    }

    public String getOpisWizyty() {
        return opisWizyty;
    }

    // Settery
    public void setWizytaId(int wizytaId) {
        this.wizytaId = wizytaId;
    }

    public void setPacjentId(int pacjentId) {
        this.pacjentId = pacjentId;
    }

    public void setPracownikId(int pracownikId) {
        this.pracownikId = pracownikId;
    }

    public void setDataWizyty(LocalDateTime dataWizyty) {
        this.dataWizyty = dataWizyty;
    }

    public void setOpisWizyty(String opisWizyty) {
        this.opisWizyty = opisWizyty;
    }
}