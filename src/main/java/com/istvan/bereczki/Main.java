package com.istvan.bereczki;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner szov = new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.println("Üdvözöllek a Wumpus játékomban!");
        System.out.println("----------------------------------------------");

        System.out.println("Add meg a felhasználóneved:");
        String jatekosNev = szov.nextLine();
        System.out.println("A fehasználóneved: " + jatekosNev);

        System.out.println("Szia " + jatekosNev + "! Kezdődjék a játék:");
        System.out.println("----------------------------------------------");

        // Kezdeti értékek arany es nyilak szama
        int golddb = 0;
        int nyildb = 2;
        Player jatekos = new Player(jatekosNev, golddb, nyildb);

        // Pálya létrehozása
        Palya palya = new Palya();
        System.out.println(palya);

        int x = 3; // Játékos kezdeti X pozíciója
        int y = 3; // Játékos kezdeti Y pozíciója

        String valasz = "Q";
        boolean vege = false;
        while (!valasz.equals("0") && !vege) {
            System.out.println(jatekos.getNev() + " " + jatekos.getArany() + " " + jatekos.getNyilak());
            System.out.println("Add meg a lépésed (E(előre) H(hátra) J(jobbra) B(balra) L(lővés) vagy nyomd meg a 0 gombot a játék befejezéséhez!):");
            valasz = szov.nextLine();

            switch (valasz) {
                case "E":
                    x--;
                    break;
                case "H":
                    x++;
                    break;
                case "J":
                    y++;
                    break;
                case "B":
                    y--;
                    break;
                case "0":
                    break;
            }

           if (!valasz.equals("0") && !valasz.equals("Q")) {
                palya.move2Player(x, y);
                char aktualisMezo = palya.getFipalya()[x][y];
                switch (aktualisMezo) {
                    case 'W':
                        System.out.println("Megölt a Wumpus! Vége a játéknak.");
                        vege = true;
                        break;
                    case 'G':
                        System.out.println("Gödörbe estél! Elvesztettél egy nyilat.");
                        nyildb = Math.max(0, nyildb - 1);
                        break;
                    case 'A':
                        System.out.println("Aranyat találtál!");
                        golddb++;
                        break;
                    case 'U':
                        System.out.println("Biztonságos terület.");
                        break;
                }
            }

            System.out.println(palya); // Frissített pálya megjelenítése
        }

        System.out.println("Kiléptél! A játéknak vége! Játszunk máskor is " + jatekosNev + "!");
        szov.close();
    }
}