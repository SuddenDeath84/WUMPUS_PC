package com.istvan.bereczki;

import java.util.Scanner;

public class Main {
    static int heroX = 0;
    static int heroY = 0;

    public static void main(String[] args) {
        System.out.println("----------------------------------------------");
        System.out.println("Üdvözöllek a Wumpus játékomban!");
        System.out.println("----------------------------------------------");

        Scanner szov = new Scanner(System.in);
        System.out.println("Add meg a felhasználóneved:");
        String jatekosNev = szov.nextLine();
        System.out.println("A felhasználóneved: " + jatekosNev);

        // Menü megjelenítése
        System.out.println("Szia " + jatekosNev + "! Kezdődjék a játék:");
        System.out.println("----------------------------------------------");
        System.out.println("Menü: ");
        System.out.println("(1) Új játék ");
        System.out.println("(2) Pályaszerkesztő: ");
        System.out.println("(3) Pálya betöltése külső állományból: ");
        System.out.println("(4) Kilépés a menüből: ");
        System.out.println("----------------------------------------------");

        // Pálya és játékos létrehozása
        Palya palya = new Palya();
        Player jatekos = new Player(jatekosNev, 0, 5); // Például 0 arannyal és 5 nyíllal
        char[][] fixpalya = palya.getFipalya();

        // Hős kezdeti helyzetének meghatározása
        for (int i = 0; i < fixpalya.length; i++) {
            for (int j = 0; j < fixpalya[i].length; j++) {
                if (fixpalya[i][j] == 'E') {
                    heroX = i;
                    heroY = j;
                }
            }
        }

        String valasz = "";
        while (!"0".equals(valasz)) {
            System.out.println("Add meg a lépésed! (E(előre) H(hátra) J(jobbra) B(balra) vagy nyomd meg a 0 gombot a játék befejezéséhez!)");
            valasz = szov.nextLine();

            switch (valasz) {
                case "e":
                    moveHero(palya, fixpalya, -1, 0, jatekos);
                    break;
                case "h":
                    moveHero(palya, fixpalya, 1, 0, jatekos);
                    break;
                case "j":
                    moveHero(palya, fixpalya, 0, 1, jatekos);
                    break;
                case "b":
                    moveHero(palya, fixpalya, 0, -1, jatekos);
                    break;
            }

            // Pálya újrarajzolása
            palya.printPalya();
            System.out.println("Nyilaid száma: " + jatekos.getNyilak());
        }

        System.out.println("Kiléptél! A játéknak vége! Játszunk máskor is " + jatekosNev + "!");
    }

    private static void moveHero(Palya palya, char[][] palyaTomb, int dx, int dy, Player jatekos) {
        int newX = heroX + dx;
        int newY = heroY + dy;

        String ellenorzes = palya.ellenorizPoziciot(newX, newY, jatekos);
        if ("OK".equals(ellenorzes)) {
            palyaTomb[heroX][heroY] = 'U';
            heroX = newX;
            heroY = newY;
            palyaTomb[heroX][heroY] = 'E';
        } else {
            System.out.println(ellenorzes);
            if (ellenorzes.contains("Meghaltál")) {
                System.exit(0); // Kilép a programból
            }
        }
    }
}
