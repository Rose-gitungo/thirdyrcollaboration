package com.example.kazimtaani;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;


public class postjobfragment extends Fragment {
   private EditText Industry,Hours,Pay,Location;
    private Button topayout;
    private int items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootview= inflater.inflate(R.layout.fragment_postjobfragment, container, false);
                Industry=rootview.findViewById(R.id.industry);
        Hours=rootview.findViewById(R.id.hours);
        Location=rootview.findViewById(R.id.location);
        Pay=rootview.findViewById(R.id.pay);
        Button topayout=rootview.findViewById(R.id.topayout);
            topayout.setOnClickListener(mClicker);


        return rootview;
    }

    View.OnClickListener mClicker=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String mindustry = Industry.getText().toString();
            String mlocation=Location.getText().toString();
            String mpay=Pay.getText().toString();

          FragmentTransaction transaction= getFragmentManager().beginTransaction();
          homefragment homefrag=new homefragment();

                Bundle bundle1 = new Bundle();
                bundle1.putString("Industry2",mindustry );
                bundle1.putString("Pay2", mpay);
                bundle1.putString("Location2", mlocation);
                homefrag.setArguments(bundle1);
                transaction.replace(R.id.framelay, homefrag);
                transaction.commit();


            }
        };


}