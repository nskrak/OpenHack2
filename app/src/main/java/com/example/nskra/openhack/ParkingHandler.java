package com.example.nskra.openhack;

import org.joda.time.DateTime;

import java.util.ArrayList;
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

    public void removeNonAvailable(){

        for(String parking: parkings.keySet()){
            Parkings p = parkings.get(parking);
            if(p.getStatus().equals("ACTIVE"))continue;

            DateTime current = new DateTime();
            int currentMinute = current.getMinuteOfDay();
            String[] splitTime = p.getTime().split(":");

            try {
                int minuteOfParking = Integer.parseInt()
            }catch(Exception e){
                System.out.println("Could not convert to int");
            }
            if(currentTime){

            }
        }
    }


}
