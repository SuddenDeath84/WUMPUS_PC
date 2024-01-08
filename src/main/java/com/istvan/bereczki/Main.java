package com.istvan.bereczki;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------");
        System.out.println("Üdvözöllek a Wumpus játékomban! ");
        System.out.println("----------------------------------------------");


        Scanner szov = new Scanner(System.in);


        System.out.println("Add meg a felasználóneved:");

        String jatekosNev = szov.nextLine();
        System.out.println("A fehasználóneved: " + jatekosNev);

        System.out.println("Szia "+jatekosNev+"! Kezdődjék a játék: ");
        System.out.println("----------------------------------------------");
        System.out.println("Menü: ");
        System.out.println("(1) Új játék ");
        System.out.println("(2) Pályaszerkesztő: ");
        System.out.println("(3) Pálya betöltése külső állományból: ");
        System.out.println("(4) Kiléps a menüből: ");


        System.out.println("----------------------------------------------");

        System.out.println("Jelölések:");
        System.out.print("F: Fal  ");
        System.out.print("U: Üres terület  ");
        System.out.print("W: Wumpus  ");
        System.out.print("A: Arany  ");
        System.out.println("G: Gödör  ");

        System.out.println("----------------------------------------------");

        System.out.println("Mit választasz a menüpontok közül?");
        String menuValasz = szov.nextLine();


        char[][] fixpalya = {
                {'F','F','F','F','F','F','F'},
                {'F','W','U','U','G','U','F'},
                {'F','U','U','G','U','U','F'},
                {'F','W','U','U','U','W','F'},
                {'F','U','A','U','G','U','F'},
                {'F','E','U','G','U','U','F'},
                {'F','F','F','F','F','F','F'},

        };


        for (int i = 0; i < fixpalya.length; ++i)
        {
            for (int j = 0; j < fixpalya[i].length; ++j) {
                System.out.print(fixpalya[i][j]+" | ");
            }
            System.out.println(' ');

        }

        String valasz="Q";
        String kilep="0";
        int nyildb=2;

        System.out.println("Add meg a lépésed (E(előre) H(hátra) J(jobbra) B(balra) L(lővés)  vagy nyomd meg a 0 gombot a játék befejezéséhez!)");

        valasz = szov.nextLine();




        while (!kilep.equals(valasz))
        {

            System.out.println("A lépésed: " + valasz);
            System.out.println("A nyilak száma: " + nyildb);


            int x = 0;
            int y = 0;
            System.out.print("Poziciód a pályán:");
            for (int i = 0; i < fixpalya.length; ++i) {
                for (int j = 0; j < fixpalya[i].length; ++j) {
                    if (fixpalya[i][j] == 'E') {
                        System.out.print(i);
                        System.out.print(" ");
                        System.out.println(j);
                        x = i;
                        y = j;
                    }
                }
            }

            if ("E".equals(valasz)) {
                if (fixpalya[x-1][y] == 'W') {
                    System.out.println("Megölt a wumpus!");
                    break;
                }
                if (fixpalya[x-1][y] == 'A') {
                    System.out.println("Aranyat találtál!");
                }
                if (fixpalya[x-1][y] == 'U') {
                    System.out.println("Üres mezőn vagy, nincs veszély!");
                }
                if (fixpalya[x-1][y] == 'G') {
                    System.out.println("Gödörbe estél! Vége a játéknak!");
                    break;
                }
                fixpalya[x][y] = 'U';
                y = y;
                x = x - 1;
                fixpalya[x][y] = 'E';
                System.out.print(fixpalya[x][y]);
                System.out.print(x);
                System.out.print(" ");
                System.out.println(y);
                if (fixpalya[y][x - 1] == 'W') {
                    System.out.println("Közel a wumpus");
                    System.out.print(x);
                    System.out.print(" ");
                    System.out.println(y);
                }
                if (fixpalya[y][x + 1] == 'W') {
                        System.out.println("Közel a wumpus");
                        System.out.print(x);
                        System.out.print(" ");
                        System.out.println(y);
                }
                if (fixpalya[y + 1][x] == 'W') {
                    System.out.println("Közel a wumpus");
                    System.out.print(x);
                    System.out.print(" ");
                    System.out.println(y);
                }
                if (fixpalya[y - 1][x] == 'W') {
                    System.out.println("Közel a wumpus");
                    System.out.print(x);
                    System.out.print(" ");
                    System.out.println(y);
                }
                for (int i = 0; i < fixpalya.length; ++i) {
                    for (int j = 0; j < fixpalya[i].length; ++j) {
                        System.out.print(fixpalya[i][j]+" | ");
                    }
                    System.out.println(' ');
                }


            }
            if ("H".equals(valasz)) {
                if (fixpalya[x+1][y] == 'W') {
                    System.out.println("Megölt a wumpus!");
                    break;
                }
                if (fixpalya[x+1][y] == 'A') {
                    System.out.println("Aranyat találtál!");
                }
                if (fixpalya[x+1][y] == 'U') {
                    System.out.println("Üres mezőn vagy, nincs veszély!");
                }
                if (fixpalya[x+1][y] == 'G') {
                    System.out.println("Gödörbe estél! Vége a játéknak!");
                    break;
                }
                fixpalya[x][y] = 'U';
                y = y;
                x = x+1;
                fixpalya[x][y] = 'E';
                System.out.print(fixpalya[x][y]);
                System.out.print(x);
                System.out.print(" ");
                System.out.print(y);
                if (fixpalya[y][x - 1] == 'U') {
                    System.out.println("Közel a wumpus");
                    System.out.print(x);
                    System.out.print(" ");
                    System.out.println(y);
                }
                if (fixpalya[y + 1][x] == 'U') {
                    System.out.println("Közel a wumpus");
                    System.out.print(x);
                    System.out.print(" ");
                    System.out.println(y);
                }
                for (int i = 0; i < fixpalya.length; ++i) {
                    for (int j = 0; j < fixpalya[i].length; ++j) {
                        System.out.print(fixpalya[i][j]+" | ");
                    }
                    System.out.println(' ');
                }


            }
            if ("J".equals(valasz)) {
                if (fixpalya[x][y+1] == 'W') {
                    System.out.println("Megölt a wumpus!");
                    break;
                }
                if (fixpalya[x][y+1] == 'A') {
                    System.out.println("Aranyat találtál!");
                }
                if (fixpalya[x][y+1] == 'U') {
                    System.out.println("Üres mezőn vagy, nincs veszély!");
                }
                if (fixpalya[x][y+1] == 'G') {
                    System.out.println("Gödörbe estél! Vége a játéknak!");
                    break;
                }
                fixpalya[x][y] = 'U';
                y = y+1;
                x = x;
                fixpalya[x][y] = 'E';
                System.out.print(fixpalya[x][y]);
                System.out.print(x);
                System.out.print(" ");
                System.out.print(y);
                if (fixpalya[y][x - 1] == 'U') {
                    System.out.println("Közel a wumpus");
                    System.out.print(x);
                    System.out.print(" ");
                    System.out.println(y);
                }
                if (fixpalya[y + 1][x] == 'U') {
                    System.out.println("Közel a wumpus");
                    System.out.print(x);
                    System.out.print(" ");
                    System.out.println(y);
                }
                for (int i = 0; i < fixpalya.length; ++i) {
                    for (int j = 0; j < fixpalya[i].length; ++j) {
                        System.out.print(fixpalya[i][j]+" | ");
                    }
                    System.out.println(' ');
                }


            }
            if ("B".equals(valasz)) {
                if (fixpalya[x][y-1] == 'W') {
                    System.out.println("Megölt a wumpus!");
                    break;
                }
                if (fixpalya[x][y-1] == 'A') {
                    System.out.println("Aranyat találtál!");
                }
                if (fixpalya[x][y-1] == 'U') {
                    System.out.println("Üres mezőn vagy, nincs veszély!");
                }
                if (fixpalya[x][y-1] == 'G') {
                    System.out.println("Gödörbe estél! Vége a játéknak!");
                    break;
                }
                fixpalya[x][y] = 'U';
                y = y-1;
                x = x;
                fixpalya[x][y] = 'E';
                System.out.print(fixpalya[x][y]);
                System.out.print(x);
                System.out.print(" ");
                System.out.print(y);
                if (fixpalya[y][x - 1] == 'U') {
                    System.out.println("Közel a wumpus");
                    System.out.print(x);
                    System.out.print(" ");
                    System.out.println(y);
                }
                if (fixpalya[y + 1][x] == 'U') {
                    System.out.println("Közel a wumpus");
                    System.out.print(x);
                    System.out.print(" ");
                    System.out.println(y);
                }
                for (int i = 0; i < fixpalya.length; ++i) {
                    for (int j = 0; j < fixpalya[i].length; ++j) {
                        System.out.print(fixpalya[i][j]+" | ");
                    }
                    System.out.println(' ');
                }


            }
            if ("L".equals(valasz)) {
                if (nyildb>0) {
                    nyildb--;
                    System.out.println("Ilyadat megfeszíted és lősz!");
                }
                else
                    System.out.println("Nincs több nyilad!");



                System.out.println("jelenlei nyilaid száma: "+nyildb);

                for (int i = 0; i < fixpalya.length; ++i) {
                    for (int j = 0; j < fixpalya[i].length; ++j) {
                        System.out.print(fixpalya[i][j]+" | ");
                    }
                    System.out.println(' ');
                }


            }



            System.out.println("Add meg a lépésed! (E(előre) H(hátra) J(jobbra) B(balra) L(lővés)  vagy nyomd meg a 0 gombot a játék befejezéséhez!)");

            valasz = szov.nextLine();

        }
        System.out.println("Kiléptél! Játszunk máskor is "+jatekosNev+ "!");








    }
}