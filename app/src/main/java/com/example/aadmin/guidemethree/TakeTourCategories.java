package com.example.aadmin.guidemethree;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class TakeTourCategories extends AppCompatActivity {
    String rawJson = null;
    public String getvalue;
    ListView lst;
    public String[] values = new String[]{"Barber Shop", "beauty parlour",
            "Automobile", "dry cleaners","tailors",
            " carpenter", "bike rental", " tution center", "language institution",
            "jewellery shop", "advertising agency","Tutoring",
            " photograph studio",
    };

    Integer[] imgid = {R.drawable.barber_shop, R.drawable.automobile_workshop, R.drawable.photo_studio,
            R.drawable.bike_rental, R.drawable.carpenter, R.drawable.tailor,
            R.drawable.dry_cleaner, R.drawable.language_institution, R.drawable.jewelers, R.drawable.parlor,
            };

    Integer[] color = new Integer[] {Color.rgb(255,138,103),Color.rgb(75,182,172),Color.rgb(255,183,76),
            Color.rgb(29,154,174),Color.rgb(108,122,71),Color.rgb(212,235,171),Color.rgb(106,3,4),Color.rgb(78,208,226),
            Color.rgb(203,44,40), Color.rgb(54,52,53)};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_tour_categories);
        lst = (ListView) findViewById(R.id.CategoryList);
        TakeTour takeTour = new TakeTour(this,values,imgid,color);
        lst.setAdapter(takeTour);
        getSupportActionBar().hide();

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position == 0) {
//                    Intent myIntent = new Intent(view.getContext(), ListItemActivity1.class);
//                    startActivityForResult(myIntent, 0);
//                }
//
//                if (position == 1) {
//                    Intent myIntent = new Intent(view.getContext(), ListItemActivity2.class);
//                    startActivityForResult(myIntent, 0);
//                }

                getvalue = values[position];

                TakeTourCategories.BackgroundWorker bw = new BackgroundWorker();
                bw.execute();
                }
        });
    }
    public class BackgroundWorker extends AsyncTask<String,Void,String> {

        String result;
        String login_url = "https://vivid-realinement.000webhostapp.com/Catego.php";


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //String item = getvalue;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Intent i =new Intent(TakeTourCategories.this,ListItemActivity1.class);
            i.putExtra("jsonData",rawJson);
            startActivity(i);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String postdata = URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(getvalue, "UTF-8");
                bufferedWriter.write(postdata);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                result = "";
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                //res = result;
                rawJson = result;
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
        public void SearchService(View view)
        {
            startActivity(new Intent(TakeTourCategories.this,SearchBoxActivity.class));
        }
    }
}
