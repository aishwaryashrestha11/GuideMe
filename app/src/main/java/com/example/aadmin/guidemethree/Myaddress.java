package com.example.aadmin.guidemethree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Myaddress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myaddress);

//        ImageButton ibDillibazar = (ImageButton)findViewById(R.id.ibDillibazar);
//        ibDillibazar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
////                Log.v("ImageButton", "Clicked!");
//                Intent anything =  new Intent(Myaddress.this,ShowIndividualMap.class);
//                Log.v("hy","hello");
//                startActivity(anything);
//            }
//        });
        ImageButton  ibDillibazar =(ImageButton)findViewById(R.id.ibDillibazar);
        ibDillibazar.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {
                try {

                    Intent anything =  new Intent(Myaddress.this,tryLast.class);
                    Log.v("hy","hello");
                    startActivity(anything);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



//        ImageButton ibPutalisadak = (ImageButton)findViewById(R.id.ibPutalisadak);
//        ibPutalisadak.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
////                Log.v("ImageButton", "Clicked!");
//                Intent anything =  new Intent(Myaddress.this,ShowIndividualMap.class);
//                startActivity(anything);
//            }
//        });
//        ImageButton ibCharkhal = (ImageButton)findViewById(R.id.ibCharkhal);
//        ibCharkhal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
////                Log.v("ImageButton", "Clicked!");
//                Intent anything =  new Intent(Myaddress.this,ShowIndividualMap.class);
//                startActivity(anything);
//            }
//        });

    }
}
