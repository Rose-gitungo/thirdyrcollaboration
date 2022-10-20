package com.example.kazimtaani;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class summary extends Fragment {


    public summary() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     View rootview= inflater.inflate(R.layout.fragment_summary, container, false);
     rootview.findViewById(R.id.order).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent=new Intent(getContext(),homefragment.class);
             startActivity(intent);
         }
     });
     return rootview;
    }
    @Override
    public String toString() {
        return "Summary";
    }

}