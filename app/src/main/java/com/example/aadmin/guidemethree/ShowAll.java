package com.example.aadmin.guidemethree;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ShowAll extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    InputStream inputStream;
    String[] data;
    List<LatLng> latLngList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.showmap);
        mapFragment.getMapAsync(this);
//
////        InputStreamReader csvStreamReader = new InputStreamReader(
////                    ParseMap.this.getResources().openRawResource(R.raw.dataset));
////
////            CSVReader reader = new CSVReader(csvStreamReader);
////        InputStream instream = null;
////            try {
////                instream = new FileInputStream("dataset.csv");
////            }
////            catch (FileNotFoundException e) {
////                e.printStackTrace();
////            }
        inputStream = getResources().openRawResource(R.raw.dataset);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) // Read until end of file
            {
                //double lat = Double.parseDouble(line.split(",")[0]);
                //double lon = Double.parseDouble(line.split(",")[1]);
                data = csvLine.split(",");
                try{
                    Log.e("Data",""+data[0]);
                }
                catch (Exception e)
                {
                    Log.e("Problem",e.toString());
                }
//                latLngList.add(new LatLng(lat, lon));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//        for (LatLng pos : data) {
//            mMap.addMarker(new MarkerOptions()
//                    .position(pos)
//                    .title("Title!"))
//                    ; // Don't necessarily need title
//        }
        LatLng demo = new LatLng(27.56475,80.234567);
        mMap.addMarker(new MarkerOptions().position(demo).title("Marker in demo place"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(demo,20));
    }
}
