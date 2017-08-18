package com.example.aadmin.guidemethree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_content);

        TextView txtaddress = (TextView) findViewById(R.id.pAddress);
        TextView txtphone = (TextView) findViewById(R.id.pPhone);
        //TextView txttype = (TextView) findViewById(R.id.pMobile);
        TextView txttime = (TextView) findViewById(R.id.pTime);


        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String address = bundle.getString("city_name");
        String type = bundle.getString("type");
        String phone = bundle.getString("phone");
        String time = bundle.getString("username");

        txtaddress.setText(address);
        txtphone.setText(phone);
      //  txttype.setText(type);
      //  txttype.setText(time);



    }
}
