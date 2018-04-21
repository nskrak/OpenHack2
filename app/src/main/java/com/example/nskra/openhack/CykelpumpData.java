package com.example.nskra.openhack;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.*;
import java.util.Random;


/**
 * Created by nskra on 2018-04-21.
 */

public class CykelpumpData extends AsyncTask<URL, Integer, Long> {

    private Map<String, Bikepump> bikePumps;

    @Override
    protected Long doInBackground(URL... urls) {
        try{
            bikePumps = new DataWeb().fetchPumps(new URL("https://helsingborg.opendatasoft.com/api/records/1.0/search/?dataset=cykelpumpar"));
        }catch(IOException e){
            System.out.println(e);
        }
        return null;
    }

    public Map<String, Bikepump> getBikePumps(){
        return bikePumps;
    }




}
