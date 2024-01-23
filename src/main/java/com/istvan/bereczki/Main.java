package com.istvan.bereczki;
import java.util.Scanner;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------");
        System.out.println("Üdvözöllek a Wumpus játékomban! ");
        System.out.println("----------------------------------------------");


        Scanner szov = new Scanner(System.in);


        System.out.println("Add meg a felhasználóneved:");

        String jatekosNev = szov.nextLine();
        System.out.println("A fehasználóneved: " + jatekosNev);

        System.out.println("Szia "+jatekosNev+"! Kezdődjék a játék: ");
        System.out.println("----------------------------------------------");
        System.out.println("Menü: ");
        System.out.println("(1) Új játék ");
        System.out.println("(2) Pályaszerkesztő: ");
        System.out.println("(3) Pálya betöltése külső állományból: ");
        System.out.println("(4) Kilépés a menüből: ");


        System.out.println("----------------------------------------------");

        System.out.println("Jelölések:");
        System.out.print("E: A játékos, tehát Te!  ");
        System.out.print("F: Fal  ");
        System.out.print("U: Üres terület  ");
        System.out.print("W: Wumpus  ");
        System.out.print("A: Arany  ");
        System.out.println("G: Gödör  ");

        System.out.println("----------------------------------------------");

        System.out.println("Mit választasz a menüpontok közül?");
        String menuValasz = szov.nextLine();

        int golddb=0;
        int nyildb=2;

        Player jatekos=new Player(jatekosNev,golddb,nyildb);
        System.out.println(jatekos.getNev()+" "+jatekos.getArany()+" "+jatekos.getNyilak());

        char[][] fixpalya = {
        };


        Palya palya=new Palya(fixpalya);
        System.out.println(palya);


        for (int i = 0; i < fixpalya.length; ++i)
        {
            for (int j = 0; j < fixpalya[i].length; ++j) {
                System.out.print(fixpalya[i][j]+" | ");
            }
            System.out.println(' ');

        }
        String nyilirany="0";
        String valasz="Q";
        String kilep="0";
        int killwumpus=0;
        int godorkill=0;
        int wumpuskill=0;


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
                    //System.out.println("Megölt a wumpus!");
                    wumpuskill++;
                    break;
                }
                if (fixpalya[x-1][y] == 'A') {
                    System.out.println("Aranyat találtál!");
                    golddb++;
                }
                if (fixpalya[x-1][y] == 'U') {
                    System.out.println("Üres mezőn vagy, nincs veszély!");
                }
                if (fixpalya[x-1][y] == 'G') {
                    // System.out.println("Gödörbe estél! Vége a játéknak!");
                    godorkill++;

                    break;
                }

                if (fixpalya[y][x - 1] == 'W') {
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
                if (fixpalya[y-1][x] == 'W') {
                    System.out.println("Közel a wumpus");
                    System.out.print(x);
                    System.out.print(" ");
                    System.out.println(y);
                }
                if (fixpalya[y][x+1] == 'W') {
                    System.out.println("Közel a wumpus");
                    System.out.print(x);
                    System.out.print(" ");
                    System.out.println(y);
                }

                fixpalya[x][y] = 'U';
                y = y;
                x = x - 1;
                fixpalya[x][y] = 'E';
                System.out.print(fixpalya[x][y]);
                System.out.print(x);
                System.out.print(" ");
                System.out.println(y);

                for (int i = 0; i < fixpalya.length; ++i) {
                    for (int j = 0; j < fixpalya[i].length; ++j) {
                        System.out.print(fixpalya[i][j]+" | ");
                    }
                    System.out.println(' ');
                }


            }
            if ("H".equals(valasz)) {
                if (fixpalya[x+1][y] == 'W') {
                    //System.out.println("Megölt a wumpus!");
                    wumpuskill++;
                    break;
                }
                if (fixpalya[x+1][y] == 'A') {
                    System.out.println("Aranyat találtál!");
                    golddb++;
                }
                if (fixpalya[x+1][y] == 'U') {
                    System.out.println("Üres mezőn vagy, nincs veszély!");
                }
                if (fixpalya[x+1][y] == 'G') {
                    //System.out.println("Gödörbe estél! Vége a játéknak!");
                    godorkill++;
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
                if (fixpalya[y][x - 1] == 'W') {
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
                for (int i = 0; i < fixpalya.length; ++i) {
                    for (int j = 0; j < fixpalya[i].length; ++j) {
                        System.out.print(fixpalya[i][j]+" | ");
                    }
                    System.out.println(' ');
                }


            }
            if ("J".equals(valasz)) {
                if (fixpalya[x][y+1] == 'W') {
                    //System.out.println("Megölt a wumpus!");
                    wumpuskill++;
                    break;
                }
                if (fixpalya[x][y+1] == 'A') {
                    System.out.println("Aranyat találtál!");
                    golddb++;
                }
                if (fixpalya[x][y+1] == 'U') {
                    System.out.println("Üres mezőn vagy, nincs veszély!");
                }
                if (fixpalya[x][y+1] == 'G') {
                    //System.out.println("Gödörbe estél! Vége a játéknak!");
                    godorkill++;
                    break;
                }
                fixpalya[x][y] = 'U';
                y = y+1;
                x = x;
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
                if (fixpalya[y + 1][x] == 'W') {
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
                    //System.out.println("Megölt a wumpus!");
                    wumpuskill++;
                    break;

                }
                if (fixpalya[x][y-1] == 'A') {
                    System.out.println("Aranyat találtál!");
                    golddb++;
                }
                if (fixpalya[x][y-1] == 'U') {
                    System.out.println("Üres mezőn vagy, nincs veszély!");
                }
                if (fixpalya[x][y-1] == 'G') {
                    //System.out.println("Gödörbe estél! Vége a játéknak!");
                    godorkill++;
                    break;
                }
                fixpalya[x][y] = 'U';
                y = y-1;
                x = x;
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
                if (fixpalya[y + 1][x] == 'W') {
                    System.out.println("Közel a wumpus");
                    System.out.print(x);
                    System.out.print(" ");
                    System.out.println(y);
                }
                if (fixpalya[y-1][x] == 'W') {
                    System.out.println("Közel a wumpus");
                    System.out.print(x);
                    System.out.print(" ");
                    System.out.println(y);
                }
                if (fixpalya[y][x+1] == 'W') {
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
                System.out.println("Válassz nyilazási irányt! (L-E, L-J, L-B, L-H)");
                nyilirany = szov.nextLine();

                if (nyildb>0) {
                    nyildb--;
                    System.out.println("Ilyadat megfeszíted és lősz!");

                    if ("L-E".equals(nyilirany)) {
                        if (fixpalya[x - 1][y] == 'W') {
                            System.out.println("Megölted a wumpust!");
                            killwumpus++;
                            break;
                        }
                        if (fixpalya[x - 1][y] == 'A') {
                            System.out.println("Nem találtál el semmit!");
                        }
                        if (fixpalya[x - 1][y] == 'U') {
                            System.out.println("Nem találtál el semmit!");
                        }
                        if (fixpalya[x - 1][y] == 'G') {
                            System.out.println("Nem találtál el semmit!");
                        }
                    }

                    if ("L-H".equals(nyilirany)) {
                        if (fixpalya[x + 1][y] == 'W') {
                            System.out.println("Megölted a wumpust!");
                            killwumpus++;
                            break;
                        }
                        if (fixpalya[x + 1][y] == 'A') {
                            System.out.println("Nem találtál el semmit!");
                        }
                        if (fixpalya[x + 1][y] == 'U') {
                            System.out.println("Nem találtál el semmit!");
                        }
                        if (fixpalya[x + 1][y] == 'G') {
                            System.out.println("Nem találtál el semmit!");
                        }
                    }

                    if ("L-J".equals(nyilirany)) {
                        if (fixpalya[x][y+1] == 'W') {
                            System.out.println("Megölted a wumpust!");
                            killwumpus++;
                            break;
                        }
                        if (fixpalya[x][y+1] == 'A') {
                            System.out.println("Nem találtál el semmit!");
                        }
                        if (fixpalya[x][y+1] == 'U') {
                            System.out.println("Nem találtál el semmit!");
                        }
                        if (fixpalya[x][y+1] == 'G') {
                            System.out.println("Nem találtál el semmit!");
                        }
                    }

                    if ("L-B".equals(nyilirany)) {
                        if (fixpalya[x][y-1] == 'W') {
                            System.out.println("Megölted a wumpust!");
                            killwumpus++;
                            break;
                        }
                        if (fixpalya[x][y-1] == 'A') {
                            System.out.println("Nem találtál el semmit!");
                        }
                        if (fixpalya[x][y-1] == 'U') {
                            System.out.println("Nem találtál el semmit!");
                        }
                        if (fixpalya[x][y-1] == 'G') {
                            System.out.println("Nem találtál el semmit!");
                        }
                    }




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
        if (killwumpus>0)
        {
            System.out.println("Ügyes vagy! a wumpus halott");
            System.out.println("Aranyaid száma: "+golddb);


        }
        else if (wumpuskill>0)
        {
            System.out.println("A wumpus megölt! Kalandod itt véget ért!");
            System.out.println("Aranyaid száma: "+golddb);

        }
        else if (godorkill>0)
        {
            System.out.println("Gödörbe estél! Kalandod itt véget ért!");
            System.out.println("Aranyaid száma: "+golddb);

        }
        System.out.println("Kiléptél! A játéknak vége!  Játszunk máskor is "+jatekosNev+ "!");



    }
}