package com.example.nskra.openhack;

import android.graphics.Color;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by nskra on 2018-04-21.
 */

public class CircleDrawer {
    private GoogleMap mMap;
    private LatLng point;
    private CykelpumpData cData;

    public CircleDrawer(GoogleMap mMap, LatLng point){
        this.mMap = mMap;
        this.point = point;
        try {
            cData = new CykelpumpData();
            cData.execute(new URL("https://helsingborg.opendatasoft.com/api/records/1.0/search/?dataset=cykelpumpar"));
        }catch (MalformedURLException e){
            System.out.print(e);
        }


    }

    public void drawCircle(){
        CircleOptions circle = new CircleOptions();
        circle.center(point);
        circle.radius(10);
        circle.strokeColor(Color.BLACK);
        circle.fillColor(0x30ff0000);
        circle.strokeWidth(2);
        mMap.addCircle(circle);
    }

}
