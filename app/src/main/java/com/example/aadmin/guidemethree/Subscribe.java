package com.example.aadmin.guidemethree;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Subscribe extends AppCompatActivity {
    ArrayList<String> spacecrafts;
    SharedPreferences preferences=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);

        spacecrafts = new ArrayList<>();
        ListView lv= (ListView) findViewById(R.id.listView);
        preferences=getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        final String name=preferences.getString("name",null);
        final String area=preferences.getString("area",null);
        final String phone=preferences.getString("phone",null);
        int flag = preferences.getInt("flag",0);
        if(flag ==1) {
            spacecrafts.add(name);
            ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, spacecrafts);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i =new Intent(Subscribe.this,Profile.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", name);
                    bundle.putString("area", area);
                    bundle.putString("phone", phone);
                    i.putExtras(bundle);
                    startActivity(i);
                }
            });
        }
        else {
            Toast.makeText(Subscribe.this, "No Bookmarks!",
                    Toast.LENGTH_LONG).show();
        }
    }
}
