package com.example.nskra.openhack;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by nskra on 2018-04-21.
 */

public class CykelpumpData extends AsyncTask<URL, Integer, Long> {

    private Taker taker = new Taker();

    @Override
    protected Long doInBackground(URL... urls) {
        /*try{
            taker.takeData(urls[0]);
        }catch(IOException e){
            System.out.println(e);
        }
        */return null;
    }




}
