package com.istvan.bereczki;

public class Player {

    private String nev;
    public int arany;
    public int nyilak;


    public Player(String nev,int arany,int nyilak) {
        this.nev=nev;
        this.arany=arany;
        this.nyilak=nyilak;

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
