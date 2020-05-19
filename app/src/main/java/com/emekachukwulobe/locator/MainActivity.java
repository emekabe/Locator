package com.emekachukwulobe.locator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationClient;

    private TextView coordinatesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ArrayList <EventLocation> locations = new ArrayList<>();
//
//        locations.add(new EventLocation(30, 20));
//        locations.add(new EventLocation(40, 40));
//        locations.add(new EventLocation(50, 80));
//
//        UserLocation myLocation = new UserLocation();
//
//        myLocation.setLongitude(85);
//        myLocation.setLatitude(85);
//
//        for (int i = 0; i < locations.size(); i++){
//            locations.get(i).setDistance(myLocation);
//        }
//
//        // Later, browse on how to sort objects by one of their properties
//
//        HashSet<Integer> distances = new HashSet<>();
//
//        for (int i = 0; i < locations.size(); i++){
//            distances.add(locations.get(i).getDistance());
//        }
//
//
//        ArrayList<Integer> sortedDistances = new ArrayList<>(distances);
//        Collections.sort(sortedDistances);
//
//        ArrayList<EventLocation> closestEvents = new ArrayList<>();
//
//        for (int i = 0; i < sortedDistances.size(); i ++){
//            for (int j = 0; j < locations.size(); j++){
//
//                if (sortedDistances.get(i) == locations.get(j).getDistance()){
//                    closestEvents.add(locations.get(j));
//                }
//
//            }
//        }

        coordinatesText = findViewById(R.id.coordinates);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        Toast.makeText(MainActivity.this, "It works!!!!!!!\n!!!!!!!!!!\n!!!!!!!!!", Toast.LENGTH_SHORT).show();
                        if (location != null) {
                            // Logic to handle location object
                            coordinatesText.setText(location.getLongitude() + ", " + location.getLatitude());
                        } else {
                            Toast.makeText(MainActivity.this, "Try to turn on your location!\nThank you", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "E no work o", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
