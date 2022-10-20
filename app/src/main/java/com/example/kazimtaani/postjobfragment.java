package com.example.kazimtaani;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class postjobfragment extends Fragment {
    private Spinner spinner2;
    private Spinner hours;
    private Spinner pay;
    private Spinner location;
    Spinner spinner;
    Button topayout;
    private int items;

    public postjobfragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Spinner spinner =(Spinner) findViewById(R.id.spinner);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootview= inflater.inflate(R.layout.fragment_postjobfragment, container, false);
        spinner2=rootview.findViewById(R.id.spinner2);
        initspinnerfooter();

        hours=rootview.findViewById(R.id.hours);
        initspinnerfooter2();

        topayout=rootview.findViewById(R.id.topayout);
        initbutton();

        location=rootview.findViewById(R.id.location);
        initlocation();

        pay=rootview.findViewById(R.id.pay);
        initpay();


  return rootview;
    }
    private void initpay() {
        String []items=new String[]{
               "Less than KSH 5000","KSH 5k-24 k","KSH 20k -50k","KSH 50k -100k"
        };
        ArrayAdapter<String>adapter=new  ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       pay.setAdapter(adapter);
        pay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initlocation() {
        String []items=new String[]{
                "Nairobi","Mombasa","Kwale","Kilifi","Tana-River","Lamu","Taita-taveta","Garissa","Wajir","Wajir","Mandera","Marsabit","Isiolo"
                ,"Meru","Tharaka-Nithi","Embu","Kitui","Machakos","Makueni","Nyandarua","Nyeri","Kirinyaga","Murang'a","Kiambu","Turkana" ,"West-pokot","Samburu","Trans-Nzoia","Uasin-Gishu","Elgeyo-Marakwet","Nandi","Baringo","Laikipia","Nakuru","Narok","Kajiado","Kericho","Bomet","Kakamega","Vihiga","Bungoma","Busia","Siaya","Kisumu","Homa Bay","Migori","Kisii","Nyamira","Nairobi"
        };
        ArrayAdapter<String>adapter=new  ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        location.setAdapter(adapter);
        location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("Location", (String) adapterView.getItemAtPosition(i));
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    private void initbutton() {
        topayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),payout.class);
                startActivity(intent);
            }
        });
    }

    private void initspinnerfooter2() {
        String []items=new String[]{
                "less than 1 hour","2-3 hours","5-10 hours","24 hours","48 hours","Overnight"
        };
        ArrayAdapter<String>adapter=new  ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hours.setAdapter(adapter);
        hours.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("Approx No of hours", (String) adapterView.getItemAtPosition(i));
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void initspinnerfooter() {
        String []items=new String[]{
                "Beauty","Home and living","House Keeping","Transporter","Catering","Plumbing","Office errands","Gardening","Health and Wellness","Security","School work","Childcare"
        };
        ArrayAdapter<String>adapter=new  ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
       spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               Log.v("Industry", (String) adapterView.getItemAtPosition(i));
              ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });
    }

}