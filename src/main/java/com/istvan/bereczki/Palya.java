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

    public int getArrayLength() {
        return fipalya.length;
    }
/*
    public char[][] getFipalya(int i, int j) {
        return fipalya[i][j];
    }
    */
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


