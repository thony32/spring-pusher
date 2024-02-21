package com.mademo.pusher1;

public class InsertionRequest {
    private int numero;
    private String nom;
    private String adresse;
    private double bourse;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getBourse() {
        return bourse;
    }

    public void setBourse(double bourse) {
        this.bourse = bourse;
    }
}
