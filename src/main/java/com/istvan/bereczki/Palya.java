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
                {'F', 'F', 'F', 'F', 'F', 'F', 'F'},
        };
    }

    public void movePlayer(int newX, int newY) {
        for (int i = 0; i < fipalya.length; i++) {
            for (int j = 0; j < fipalya[i].length; j++) {
                if (fipalya[i][j] == 'E') {
                    if (newX >= 0 && newX < fipalya.length && newY >= 0 && newY < fipalya[newX].length && fipalya[newX][newY] != 'F') {
                        fipalya[i][j] = 'U';
                        fipalya[newX][newY] = 'E';
                    }
                    return;
                }
            }
        }
    }

    public char[][] getFipalya() {
        return fipalya;
    }

    public void setFipalya(char[][] fipalya) {
        this.fipalya = fipalya;
    }

    public void move2Player(int newX, int newY) {
        // Ellenőrizze, hogy az új pozíció a pályán belül van-e
        if (newX >= 0 && newX < fipalya.length && newY >= 0 && newY < fipalya[0].length) {
            for (int i = 0; i < fipalya.length; i++) {
                for (int j = 0; j < fipalya[i].length; j++) {
                    if (fipalya[i][j] == 'E') {
                        fipalya[i][j] = 'U'; // Az előző pozíciót üres területté alakítja
                        fipalya[newX][newY] = 'E'; // A játékos új pozícióját beállítja
                        return;
                    }
                }
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : fipalya) {
            for (char c : row) {
                sb.append(c).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}