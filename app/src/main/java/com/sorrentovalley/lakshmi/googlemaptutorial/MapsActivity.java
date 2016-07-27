package com.sorrentovalley.lakshmi.googlemaptutorial;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    double latitude;
    double longitude;
    double longitude_map;
    double  latitude_map;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);mapFragment.getMapAsync(this);
         Intent intent = getIntent();
         longitude_map = intent.getDoubleExtra("Longitude",longitude);
        latitude_map = intent.getDoubleExtra("Latitude",latitude);


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
       //LatLng place = new LatLng(32.9057114, -117.1665014);

        LatLng place = new LatLng(latitude_map, longitude_map);
        mMap.addMarker(new MarkerOptions().position(place).title("Your current location is here"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(place));
    }
}
