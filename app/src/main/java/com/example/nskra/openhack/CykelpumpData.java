package com.example.nskra.openhack;

import android.os.AsyncTask;

import com.google.android.gms.maps.GoogleMap;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.*;
import java.util.Random;


/**
 * Created by nskra on 2018-04-21.
 */

public class CykelpumpData extends AsyncTask<URL, Integer, Integer> {

    private Map<String, Parkings> bikePumps;
    private CircleDrawer drawer;
    GoogleMap mMap;

    public CykelpumpData(GoogleMap mMap){
        this.mMap = mMap;
    }

    @Override
    protected Integer doInBackground(URL... urls) {
        try{
            bikePumps = new DataWeb().fetchParks(urls[0]);

        }catch(Exception e){
            System.out.println(e);
        }
        return 0;
    }

    public Map<String, Bikepump> getBikePumps(){
        return null;
    }



    protected void onPostExecute(Integer result) {
        System.out.println(mMap);
        drawer = new CircleDrawer(bikePumps, mMap, 1);
        System.out.println(bikePumps);
        System.out.println(drawer);
        new ParkingHandler(bikePumps).removeNonAvailable();
        drawer.createCirclesForParkings();
    }




}
