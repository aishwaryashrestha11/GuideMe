package com.example.aadmin.guidemethree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OptionSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_search);
    }
    public void EasySearch(View view)
    {
        startActivity(new Intent(OptionSearch.this,TakeTourCategories.class));
    }
    public void ManualSearch(View view)
    {
        startActivity(new Intent(OptionSearch.this,SearchBoxActivity.class));
    }

}
