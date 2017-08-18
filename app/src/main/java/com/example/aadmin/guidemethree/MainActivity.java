package com.example.aadmin.guidemethree;

import android.*;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private LocationManager locationManager;
    private LocationListener listener;
    Button offer;
    public TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        offer = (Button) findViewById(R.id.offerbtn);
//        offer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,Direction.class);
//                startActivity(intent);
//            }
//        });


//nav start
        super.onStart();
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        //dialog.setTitle(" 'Guide To Local Business'");

        Button buttonDont = (Button) dialog.findViewById(R.id.Button01);
        buttonDont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        Button buttonOk = (Button) dialog.findViewById(R.id.buttonAllow);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // t=(TextView) findViewById(R.id.textView);
                //noinspection MissingPermission
                locationManager.requestLocationUpdates("gps", 5000, 0, listener);
                dialog.dismiss();
            }
        });

        dialog.show();




        t=(TextView)findViewById(R.id.cordinates);
        //btnOk = (Button) findViewById(R.id.btnOk);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                TextView cleartext;
                cleartext = ((TextView) findViewById(R.id.cordinates));
                cleartext.setText("");
                t.append("\n " + location.getLatitude() + "," + +location.getLongitude());
                String currentLocation = t.getText().toString();
                TextView current = (TextView) findViewById(R.id.current);
                current.setText(""+currentLocation);
                //Toast.makeText(MainActivity.this, "Fetching your location...", Toast.LENGTH_SHORT).show();
                //Toast.makeText(MainActivity.this, currentLocation, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {
            }

            @Override
            public void onProviderEnabled(String s) {
            }

            @Override
            public void onProviderDisabled(String s) {
                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
        };
        configure_button();




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            drawer.setDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10:
                configure_button();
                break;
            default:
                break;
        }
    }
    void configure_button() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.INTERNET}
                        , 10);
            }
            return;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Ownerlogin)
        {
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
            // Handle the camera action
        }
        else if (id == R.id.nav_Customerlogin)
        {
            startActivity(new Intent(MainActivity.this,CustomerLoginActivity.class));
            // Handle the camera action
        }

        else if(id == R.id.nav_Subscribe){
            startActivity(new Intent(MainActivity.this,Subscribe.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void Nearby(View view)
    {
        startActivity(new Intent(MainActivity.this,Myaddress.class));
    }

        public void ViewAllServices(View view)
        {
            startActivity(new Intent(MainActivity.this,TakeTourCategories.class));
        }
        public void SearchService(View view)
            {
                startActivity(new Intent(MainActivity.this,SearchBoxActivity.class));
            }
        public void GetDirection(View view)
        {
            startActivity(new Intent(MainActivity.this,indi.class));
        }
    public void OptionSearch(View view)
    {
        startActivity(new Intent(MainActivity.this,OptionSearch.class));
    }


}
