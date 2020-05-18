package com.emekachukwulobe.locator;

public class EventLocation extends UserLocation{

    private int distance;

    public EventLocation(){

    }

    public EventLocation(int longitude, int latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(UserLocation currentLocation) {
        this.distance = (int) Math.sqrt(square(currentLocation.getLongitude()) + square(currentLocation.getLatitude()));
    }

    private int square(int a){
       return (int) Math.pow(a, 2);
    }
}
