package com.example.nskra.openhack;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.net.*;
import java.util.Map;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener, GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener {

    private GoogleMap mMap;
    private Map<String, Bikepump> pumps;
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    TextView txtLat;
    String lat;
    String provider;
    protected String latitude, longitude;
    protected boolean gps_enabled, network_enabled;
    double[] myCoor = new double[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        myCoor[0] = 0;
        myCoor[1] = 0;
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //txtLat = (TextView) findViewById(R.id.textview1);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        try {

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            System.out.println("hewjofinewaoideihopohfdwhjidsfhkhjdsf");
        } catch (SecurityException e) {
            System.out.println("Could not get permission");
        } catch (NullPointerException e2) {
            System.out.println("NullPointer omg epic fail");
        } finally {
            System.out.println("Nothing works!");
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
        try {
            CykelpumpData cpd = new CykelpumpData(mMap, myCoor);
            //cpd.execute(new URL("https://helsingborg.opendatasoft.com/api/records/1.0/search/?dataset=cykelpumpar"));
            cpd.execute(new URL("https://helsingborg.opendatasoft.com/api/records/1.0/search/?dataset=parkering_new&rows=-1"));
        } catch (Exception e) {
            System.out.println(e);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
        // Add a marker in Sydney and move the camera
        LatLng Helsingborg = new LatLng(56.0384836, 12.6966470);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Helsingborg));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Helsingborg, 14.0f));

/*
        new CircleDrawer(mMap, Helsingborg);
*/

//some random text

    }


    @Override
    public void onLocationChanged(Location location) {
        //txtLat = (TextView) findViewById(R.id.textview1);
        System.out.println("Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
        myCoor[0] = location.getLatitude();
        myCoor[1] = location.getLongitude();

    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude","disable");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude","status");
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

    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {

    }
}
