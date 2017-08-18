package com.example.aadmin.guidemethree;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class tryLast extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_last);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng trinity = new LatLng(27.704105,85.326068);
        mMap.addMarker(new MarkerOptions()
                .position(trinity)
                .title("Amrit Bhog Palace"));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(trinity, 22));

//        mMap.addMarker(new MarkerOptions()
//                .position(new LatLng(27.704105,85.326068))
//                .title("Amrit bhog event venue"))
//                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.7042, 85.3262))
                .title("Hari Carwash"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.703571,85.326068))
                .title("New barber store"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));


        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.703485,85.325414
                ))
                .title("Mobile Locksmith"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.703077,85.325929))
                .title("Home Tution"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.703827,85.326594))
                .title("Barber Shop"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));


        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.703973,85.326799
                ))
                .title("Kalika Bakery"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.7037301, 85.325047))
                .title("Cloth stiching"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.704074,85.326248
                ))
                .title("Mobile locksmith"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.70395,85.326084
                ))
                .title("Ramu carpenter"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));

//        mMap.addMarker(new MarkerOptions()
//                .position(new LatLng(27.708, 85.329))
//                .title("Trinity International College"));
////                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
//        mMap.addMarker(new MarkerOptions()
//                .position(new LatLng(27.709, 85.330))
//                .title("Trinity International College"));
////                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
//        mMap.addMarker(new MarkerOptions()
//                .position(new LatLng(27.710, 85.331))
//                .title("Trinity International College"));
////                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
//        mMap.addMarker(new MarkerOptions()
//                .position(new LatLng(27.711, 85.332))
//                .title("Trinity International College"));
////                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
//
//        mMap.addMarker(new MarkerOptions()
//                .position(new LatLng(27.706084, 85.323728))
//                .title("Trinity International College"));
////                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
//        mMap.addMarker(new MarkerOptions()
//                .position(new LatLng(27.705077, 85.325015))
//                .title("Trinity International College"));
////                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
//        mMap.addMarker(new MarkerOptions()
//                .position(new LatLng(27.705077, 85.325015))
//                .title("Trinity International College"));
////                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
//        mMap.addMarker(new MarkerOptions()
//                .position(new LatLng(27.705039, 85.326957))
//                .title("Trinity International College"));
////                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
//        mMap.addMarker(new MarkerOptions()
//                .position(new LatLng(27.703510, 85.327204))
//                .title("Trinity International College"));
////                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));
//        mMap.addMarker(new MarkerOptions()
//                .position(new LatLng(27.701262, 85.325105))
//                .title("Trinity International College"));
////                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon));


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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
