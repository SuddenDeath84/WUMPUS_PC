package com.istvan.bereczki;
import java.util.Arrays;
public class Palya {

    char [][] fipalya;

    public Palya(char [][] fipalya)
    {
        this.fipalya=new char[][]{
                {'F', 'F', 'F', 'F', 'F', 'F', 'F'},
                {'F', 'W', 'U', 'U', 'G', 'U', 'F'},
                {'F', 'U', 'U', 'G', 'U', 'U', 'F'},
                {'F', 'W', 'U', 'E', 'U', 'W', 'F'},
                {'F', 'U', 'A', 'U', 'G', 'U', 'F'},
                {'F', 'U', 'U', 'G', 'U', 'U', 'F'},
                {'F', 'F', 'F', 'F', 'F', 'F', 'F'},
        };
    }

    public char[][] getFipalya() {
        return fipalya;
    }

    @Override
    public String toString() {
        return "Palya{" +
                "fipalya=" + Arrays.toString(fipalya) +
                '}';
    }

}
