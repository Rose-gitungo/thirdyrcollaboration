package com.example.kazimtaani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class getjob extends AppCompatActivity {
    private Spinner jobindustry;
    private Spinner yrs;
    private Spinner gender;
    private Spinner city;
    Button savebutton;
    private int items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Hire me");
        setContentView(R.layout.activity_getjob);
        jobindustry=findViewById(R.id.jobindustry);
        jobindustry();
        yrs=findViewById(R.id.yrs);
        yrs();
        gender=findViewById(R.id.gender);
        gender();
        city=findViewById(R.id.city);
        city();

        savebutton=(Button) findViewById(R.id.savebutton);
        savebutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getjob.this,dashboardd.class);
                startActivity(intent);

            }
        });
    }
    private void jobindustry() {
        String []items=new String[]{
                "Automotive","Beauty","Food and beverages","Teaching","Home care","Gardening","Relationships"
        };
        ArrayAdapter<String>adapter=new  ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jobindustry.setAdapter(adapter);
        jobindustry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("Industry", (String) adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void city() {
        String []items=new String[]{
                "Nairobi","Mombasa","Kwale","Kilifi","Tana-River","Lamu","Taita-taveta","Garissa","Wajir","Wajir","Mandera","Marsabit","Isiolo"
                ,"Meru","Tharaka-Nithi","Embu","Kitui","Machakos","Makueni","Nyandarua","Nyeri","Kirinyaga","Murang'a","Kiambu","Turkana" ,"West-pokot","Samburu","Trans-Nzoia","Uasin-Gishu","Elgeyo-Marakwet","Nandi","Baringo","Laikipia","Nakuru","Narok","Kajiado","Kericho","Bomet","Kakamega","Vihiga","Bungoma","Busia","Siaya","Kisumu","Homa Bay","Migori","Kisii","Nyamira","Nairobi"
        };
        ArrayAdapter<String>adapter=new  ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      city.setAdapter(adapter);
       city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               Log.v("City", (String) adapterView.getItemAtPosition(i));
               ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });
    }

    private void gender() {
        String []items=new String[]{
                "Female","Male","Prefer not to say"
        };
        ArrayAdapter<String>adapter=new  ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
     gender.setAdapter(adapter);
       gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               Log.v("Gender", (String) adapterView.getItemAtPosition(i));
               ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);

           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });
    }

    private void yrs() {
        String []items=new String[]{
                "less than 1yr","2-5 years","more than 5 years"
        };
        ArrayAdapter<String>adapter=new  ArrayAdapter<String>(getApplication(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       yrs.setAdapter(adapter);
        yrs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("years", (String) adapterView.getItemAtPosition(i));
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
}
}
