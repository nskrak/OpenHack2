package com.example.nskra.openhack;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nskra on 2018-04-21.
 */

public class ParkingHandler {

    private Parkings parking;
    private Map<String, Parkings> parkings;
    private ArrayList<Parkings> parkeringar;

    public ParkingHandler(Map<String, Parkings> parkings){
        this.parkings = parkings;
        parkeringar = new ArrayList<>();
    }

    public void removeNonAvailable(double currentLong, double currentLat){


        for(String parking: parkings.keySet()){
            Parkings p = parkings.get(parking);
            if(!p.getStatus().equals("AKTIV"))continue;

            DateTime current = new DateTime();
            int currentMinute = current.getMinuteOfDay();
            int startMinute = Integer.MAX_VALUE;
            int endMinute = Integer.MIN_VALUE;
            double distance = 0;
            int cost = 0;
            String[] time = p.getPayTime().split("-");
            String[] firstTime = time[0].split(":");
            String[] secondtime = time[1].split(":");
            try {
                startMinute = Integer.parseInt(firstTime[0])*60 + Integer.parseInt(firstTime[1]);
                endMinute = Integer.parseInt(secondtime[0])*60 + Integer.parseInt(secondtime[1]);
            }catch(Exception e){
                System.out.println("Could not convert to int");
            }
            if(currentMinute < startMinute || currentMinute > endMinute){
                p.setCost(0);
            }

            cost = p.getCost();

            distance = Math.hypot(Math.abs(currentLat - p.getLatitude()), Math.abs(currentLong - p.getLongitude()));
            System.out.println(currentLong + " ... " + currentLat);
            System.out.println("Distance for " + p.getPlace() + ": " + distance);

        //Latitude:56.03857555, Longitude:12.6966509
        }
    }


}
