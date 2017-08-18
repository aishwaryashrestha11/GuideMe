package com.example.aadmin.guidemethree;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListItemActivity1 extends AppCompatActivity {
    Context context;
    Intent intent;
    ListView list;
    String[] Items;
    String[] titles;
  //  int[] images={R.drawable.right};
    String[] description;


    String name, area, type;
    JSONArray ja;
    ArrayList<String> spacecrafts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item1);

//        Bundle bundle = getIntent().getExtras();
//        String name = bundle.getString("name");
//



//        Resources res = getResources();
//        Items = res.getStringArray(R.array.titles);
        list = (ListView) findViewById(R.id.listView1);
//        VivzAdapter adapter = new VivzAdapter(this, Items, images, description);
//        list.setAdapter(adapter);
//
//
//
////        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                switch (position) {
////                    case 0:
////
////                        intent = new Intent(Semester.this, Notification.class);
////                        break;
////
////
////                    case 1:
////
////                        intent = new Intent(Semester.this, Syllabus.class);
////                        break;
////
////
////                    case 2:
////
////                        intent = new Intent(Semester.this, Oldques.class);
////                        break;
////
////
////                    case 3:
////
////                        intent = new Intent(Semester.this, Message.class);
////                        break;
////
////                }
////                startActivity(intent);
////            }
////        });
//
//
//    }
//
//    class VivzAdapter extends ArrayAdapter<String> {
//        Context context;
//        int[] images;
//        String[] titleArray;
//        String[] description;
//
//        VivzAdapter(Context c, String[] titles, int imgs[], String[] disc) {
//            super(c, R.layout.singlerow, R.id.textView, Items);
//            this.context = c;
//            this.images = imgs;
//            this.titleArray = titles;
//            this.description = disc;
//
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View row = inflater.inflate(R.layout.singlerow, parent, false);
//            ImageView myimage = (ImageView) row.findViewById(R.id.imageView);
//            TextView topic = (TextView) row.findViewById(R.id.textView);
//            TextView descr = (TextView) row.findViewById(R.id.txtdescritpion);
//            myimage.setImageResource(images[position]);
//            topic.setText(titleArray[position]);
//            descr.setText(description[position]);
//
//            return row;
//
//        }

        //ListView list = (ListView) findViewById(R.id.lv);
        Intent intent = getIntent();
        String data = intent.getStringExtra("jsonData");
        spacecrafts = new ArrayList<>();
        parseData(data);
//        for(String s : spacecrafts){
//            Log.e("Data",s);
//        }

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, spacecrafts);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), spacecrafts.get(position), Toast.LENGTH_SHORT).show();
                Intent i =new Intent(ListItemActivity1.this,Profile.class);
//                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View row = inflater.inflate(R.layout.singlerow, parent, false);
//            ImageView myimage = (ImageView) row.findViewById(R.id.imageView);
//                //int[] image = R.drawable.right;
//                myimage.setImageResource(images[position]);



                JSONObject selectedObject=null;
                try {
                    selectedObject=ja.getJSONObject(position);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Bundle bundle = new Bundle();

                try {
                    bundle.putString("area", selectedObject.getString("area"));
                    bundle.putString("name", selectedObject.getString("name"));

                    bundle.putString("type", selectedObject.getString("type"));
                    bundle.putString("username", selectedObject.getString("username"));
                    bundle.putString("phone", selectedObject.getString("phone"));
                    bundle.putString("latitude", selectedObject.getString("latitude"));
                    bundle.putString("longitude", selectedObject.getString("longitude"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                i.putExtras(bundle);
                startActivity(i);

            }
        });
    }

    public void parseData(String rawJson) {

        try {
            JSONObject rootObj = new JSONObject(rawJson);

            ja = rootObj.getJSONArray("server");
            JSONObject jo;
            spacecrafts.clear();
            for (int i = 0; i < ja.length(); i++) {
                jo = ja.getJSONObject(i);

                String id = jo.getString("id");
                name = jo.getString("name");
                area = jo.getString("area");
                type = jo.getString("type");

                //spacecrafts.add(id);
                spacecrafts.add(name + System.getProperty("line.separator") + area);

                //spacecrafts.add(area);
                //spacecrafts.add(type);

                //new Shops(name,address,type);
            }
            //return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //return false;
    }
}