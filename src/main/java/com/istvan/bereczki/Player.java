package com.istvan.bereczki;

public class Player {
    private String nev;
    private int arany;
    private int nyilak;

    public Player(String nev, int arany, int nyilak) {
        this.nev = nev;
        this.arany = arany;
        this.nyilak = nyilak;
    }

    // Getterek és setterek

    public void veszitNyilat() {
        if (this.nyilak > 0) {
            this.nyilak--;
        }
    }

    public String getNev() {
        return nev;
    }

    public int getArany() {
        return arany;
    }

    public int getNyilak() {
        return nyilak;
    }

    @Override
    public String toString() {
        return nev+" "+arany+" "+nyilak;
    }



}

