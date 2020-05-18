package com.emekachukwulobe.locator;

public class UserLocation {
    int longitude;
    int latitude;

    public UserLocation(){

    }

    public UserLocation(int longitude, int latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }
}
