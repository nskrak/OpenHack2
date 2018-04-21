package com.example.nskra.openhack;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.net.*;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        try{
            new CykelpumpData().execute(new URL("https://helsingborg.opendatasoft.com/api/records/1.0/search/?dataset=cykelpumpar"));
        }catch (Exception e){
            System.out.println(e);
        }

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Helsingborg = new LatLng(56.0384836, 12.6966470);
        mMap.addMarker(new MarkerOptions().position(Helsingborg).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Helsingborg));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Helsingborg, 14.0f));

/*
        new CircleDrawer(mMap, Helsingborg);
*/

//some random text

    }

    private void createCircle(LatLng point){
        CircleOptions circle = new CircleOptions();
        circle.center(point);
        circle.radius(10);
        circle.strokeColor(Color.BLACK);
        circle.fillColor(0x30ff0000);
        circle.strokeWidth(2);
        mMap.addCircle(circle);
    }
}
