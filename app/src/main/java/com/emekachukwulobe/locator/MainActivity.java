package com.emekachukwulobe.locator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList <EventLocation> locations = new ArrayList<>();

        locations.add(new EventLocation(30, 20));
        locations.add(new EventLocation(40, 40));
        locations.add(new EventLocation(50, 80));

        UserLocation myLocation = new UserLocation();

        myLocation.setLongitude(85);
        myLocation.setLatitude(85);

        for (int i = 0; i < locations.size(); i++){
            locations.get(i).setDistance(myLocation);
        }

        // Later, browse on how to sort objects by one of their properties

        HashSet<Integer> distances = new HashSet<>();

        for (int i = 0; i < locations.size(); i++){
            distances.add(locations.get(i).getDistance());
        }


        ArrayList<Integer> sortedDistances = new ArrayList<>(distances);
        Collections.sort(sortedDistances);

        ArrayList<EventLocation> closestEvents = new ArrayList<>();

        for (int i = 0; i < sortedDistances.size(); i ++){
            for (int j = 0; j < locations.size(); j++){

                if (sortedDistances.get(i) == locations.get(j).getDistance()){
                    closestEvents.add(locations.get(j));
                }

            }
        }


    }
}
