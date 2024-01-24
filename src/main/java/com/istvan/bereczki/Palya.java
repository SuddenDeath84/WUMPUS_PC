package com.istvan.bereczki;

public class Palya {
    private char[][] fipalya;

    public Palya() {
        this.fipalya = new char[][]{
                {'F', 'F', 'F', 'F', 'F', 'F', 'F'},
                {'F', 'W', 'U', 'U', 'G', 'U', 'F'},
                {'F', 'U', 'U', 'G', 'U', 'U', 'F'},
                {'F', 'W', 'U', 'E', 'U', 'W', 'F'},
                {'F', 'U', 'A', 'U', 'G', 'U', 'F'},
                {'F', 'U', 'U', 'G', 'U', 'U', 'F'},
                {'F', 'F', 'F', 'F', 'F', 'F', 'F'}
        };
    }

    public char[][] getFipalya() {
        return fipalya;
    }

    public void printPalya() {
        for (int i = 0; i < fipalya.length; i++) {
            for (int j = 0; j < fipalya[i].length; j++) {
                System.out.print(fipalya[i][j] + " | ");
            }
            System.out.println();
        }
    }
    public String ellenorizPoziciot(int x, int y, Player jatekos) {
        if (x < 0 || x >= fipalya.length || y < 0 || y >= fipalya[x].length) {
            return "Falba ütköztél!";
        } else if (fipalya[x][y] == 'F') {
            return "Falba ütköztél!";
        } else if (fipalya[x][y] == 'W') {
            return "Meghaltál, a Wumpus megevett!";
        } else if (fipalya[x][y] == 'G') {
            jatekos.veszitNyilat();
            return "Gödörbe estél, egy nyilat vesztettél!";
        }
        return "OK";
    }
}
