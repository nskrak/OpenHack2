package com.example.nskra.openhack;

public class Parkings { // kanske kan implementa ett interace som alla objekten Ã¤rver frÃ¥n

    double longitude;
    double latitude;
    String place;
    int cost;
    String status;
    String payTime;
    String time;

    public Parkings(double longitude, double latitude, String place, int cost, String status, String payTime, String time) { //Kanske borde ta in en map idk

        this.longitude = longitude;
        this.latitude = latitude;
        this.place = place;
        this.cost = cost;
        this.status = status;
        this.payTime = payTime;
        this.time = time;

    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getPlace() {
        return place;
    }
    public String getStatus() {
        return status;
    }
    public String getPayTime() {
        return payTime;
    }
    public int getCost() {
        return cost;
    }
    public String getTime(){
        return time;
    }
    public void setCost(int newCost){
        this.cost = newCost;
    }
    public String toString(){
        return place + " " + status + " \nAvgift: " + payTime + ", kostar: " + cost + "\nDu får stå: " + time;
    }

}