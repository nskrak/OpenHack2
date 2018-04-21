package com.example.nskra.openhack;

import android.graphics.Color;
import android.graphics.Point;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * Created by nskra on 2018-04-21.
 */

public class CircleDrawer {
    private GoogleMap mMap;
    private LatLng point;
    private CykelpumpData cData;
    private Map<String, Bikepump> pumps;

    public CircleDrawer(GoogleMap mMap, LatLng point){
        this.mMap = mMap;
        this.point = point;

    }

    public CircleDrawer(Map<String, Bikepump> pumps, GoogleMap mMap){
        this.pumps = pumps;
        this.mMap = mMap;
    }

    public void drawCircle(double latitude, double longitude){
        CircleOptions circle = new CircleOptions();
        LatLng p = new LatLng(latitude, longitude);
        circle.center(p);
        circle.radius(10);
        circle.strokeColor(Color.BLACK);
        circle.fillColor(0x30ff0000);
        circle.strokeWidth(2);
        System.out.println("Mmap: " + mMap);
        mMap.addCircle(circle);
        mMap.addMarker(new MarkerOptions().position(p).title("Cykelpump"));
    }

    public void createCircles(){
        for(String pump: pumps.keySet()){
            Bikepump bp = pumps.get(pump);
            drawCircle(bp.getLatitude(), bp.getLongitude());
        }

    }

}
