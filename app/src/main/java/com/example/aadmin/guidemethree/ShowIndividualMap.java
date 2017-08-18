package com.example.aadmin.guidemethree;

import android.*;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ShowIndividualMap extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_individual_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng trinity = new LatLng(27.703730, 85.325047);
        mMap.addMarker(new MarkerOptions()
                .position(trinity)
                .title("Trinity International College"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(trinity, 16));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.7041, 85.3261))
                .title("Amrit bhog event venue"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.7042, 85.3262))
                .title("Subod event venue"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.7043, 85.3263))
                .title("Ram Carpenter Homee"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.7044, 85.3262))
                .title("New barber store"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.7043, 85.3266))
                .title("Mobile Locksmith"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.7022, 85.3262))
                .title("Home Tution"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.702230, 85.326047))
                .title("Barber Shop"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.702231, 85.326947))
                .title("Salina Beauty Palour"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.702229, 85.316947))
                .title("New style kennel house"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.70373002, 85.325047))
                .title("Sarita Cloth stiching"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.7037301, 85.325047))
                .title("Cloth stiching"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.7037305, 85.325047))
                .title("Mobile locksmith"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.7037307, 85.325047))
                .title("Kennel house"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.7037308, 85.325047))
                .title("Ram Carpenter Home"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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

    }
}