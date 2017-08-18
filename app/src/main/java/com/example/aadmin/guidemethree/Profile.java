package com.example.aadmin.guidemethree;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import rjsv.floatingmenu.animation.enumerators.AnimationType;
import rjsv.floatingmenu.floatingmenubutton.FloatingMenuButton;
import rjsv.floatingmenu.floatingmenubutton.subbutton.FloatingSubButton;

public class Profile extends AppCompatActivity {


    public Profile() {
    }

    private Button callbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        FloatingMenuButton floatingButton = (FloatingMenuButton) findViewById(R.id.my_floating_button);
        floatingButton.setStartAngle(0)
                .setEndAngle(360)
                .setAnimationType(AnimationType.RADIAL)
                .setAnchored(false)
                .setRadius(200)
        ;
        floatingButton.getAnimationHandler()
                .setOpeningAnimationDuration(500)
                .setClosingAnimationDuration(200)
                .setLagBetweenItems(0)
                .setOpeningInterpolator(new FastOutSlowInInterpolator())
                .setClosingInterpolator(new FastOutLinearInInterpolator())
                .shouldFade(true)
                .shouldScale(true)
                .shouldRotate(false)
        ;



        Button btnMap = (Button) findViewById(R.id.bMap);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);


        TextView txtaddress = (TextView) findViewById(R.id.pAddress);
        TextView txtphone = (TextView) findViewById(R.id.pPhone);
        //TextView txttype = (TextView) findViewById(R.id.pMobile);
        // TextView txttime = (TextView) findViewById(R.id.pTime);

        Intent it = getIntent();
        final Bundle bundle = it.getExtras();
        final String name = bundle.getString("name");
        final String area = bundle.getString("area");
        final String type = bundle.getString("type");
        final String phone = bundle.getString("phone");
        String time = bundle.getString("username");
        final String latitude = bundle.getString("latitude");
        final String longitude = bundle.getString("longitude");


        txtaddress.setText(area);
        txtphone.setText(phone);
        // txttype.setText(type);
        //txttype.setText(time);
        collapsingToolbarLayout.setTitle(name);

        FloatingSubButton cal = (FloatingSubButton) findViewById(R.id.call);
        // Button cal = (Button) findViewById(R.id.call);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phone.isEmpty()) {
                    Toast.makeText(Profile.this, "No number found",
                            Toast.LENGTH_LONG).show();

                }

                else
                {
                    dialContactPhone(phone);
                }
            }
        });

       // final FloatingSubButton bookmark= (FloatingSubButton) findViewById(R.id.sub_button_1);
        final ToggleButton bookmark = (ToggleButton) findViewById(R.id.toggleButton);
        bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(bookmark.isEnabled()){
                        int flag=1;
                        SharedPreferences.Editor editor = (SharedPreferences.Editor) getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE).edit();
                        editor.putInt("flag",flag);
                        editor.putString("name", name);
                        editor.putString("area", area);
                        editor.putString("phone", phone);
                        editor.commit();
                    }
                    else{
                        int flag=0;
                        SharedPreferences.Editor editor = (SharedPreferences.Editor) getSharedPreferences("MyPREFERENCES",Context.MODE_PRIVATE).edit();
                        editor.putInt("flag",flag);
                        editor.commit();
                    }

            }
        });


        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profile.this, MapsActivity.class);
                //Create the bundle
                Bundle sendCordinates = new Bundle();

//Add your data to bundle
                sendCordinates.putString("latitude", latitude);
                sendCordinates.putString("longitude", longitude);

//Add the bundle to the intent
                i.putExtras(sendCordinates);

//Fire that second activity
                // startActivity(i);
                startActivity(i);
            }
        });



    }
    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
//    public void callShop(View view){
//        FloatingSubButton call = (FloatingSubButton) findViewById(R.id.call);
//        call.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent callIntent = new Intent(Intent.ACTION_CALL);
//                callIntent.setData(Uri.parse("9849305333"));
//                if (ActivityCompat.checkSelfPermission(Profile.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                    // TODO: Consider calling
//                    //    ActivityCompat#requestPermissions
//                    // here to request the missing permissions, and then overriding
//                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                    //                                          int[] grantResults)
//                    // to handle the case where the user grants the permission. See the documentation
//                    // for ActivityCompat#requestPermissions for more details.
//                    return;
//                }
//                startActivity(callIntent);
//
//            }
//        });


       // }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
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

//    public void addListenerOnButtonClick() {
//        callbtn = (Button) findViewById(R.id.call);
//        callbtn.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent callIntent = new Intent(Intent.ACTION_CALL);
//                        callIntent.setData(Uri.parse("9849305333"));
//                        if (ActivityCompat.checkSelfPermission(Profile.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                            // TODO: Consider calling
//                            //    ActivityCompat#requestPermissions
//                            // here to request the missing permissions, and then overriding
//                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                            //                                          int[] grantResults)
//                            // to handle the case where the user grants the permission. See the documentation
//                            // for ActivityCompat#requestPermissions for more details.
//                            return;
//                        }
//                        startActivity(callIntent);
//                    }
//                }
//        );
//    }
}

