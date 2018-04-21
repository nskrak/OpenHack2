package com.example.nskra.openhack;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.net.*;

public class Taker {

    private double[][] data;

    public void takeData(URL url) throws IOException {
        Object[][] xy = DataWeb.coords(url);
       data = new double[xy.length][xy[0].length];
        String s;
        double d;
        for (int i = 0; i < xy.length; i++) {
            for (int j = 0; j < xy[0].length; j++) {
                s = xy[i][j].toString();
                d = Double.parseDouble(s);
                data[i][j] = d;
            }
        }

        for (int i = 0; i < xy.length; i++) {
            System.out.println("");
            for (int j = 0; j < xy[0].length; j++) {
                System.out.print(data[i][j] + " ");

            }
        }
        System.out.println("####");
    }

    public double[][] getData(){
        return data;
    }

    }