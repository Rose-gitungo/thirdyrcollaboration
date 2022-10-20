package com.example.kazimtaani;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class profilefragment extends Fragment implements View.OnClickListener {
    Button towallet;

    public profilefragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_profilefragment, container, false);

       Button towallet=(Button) view.findViewById(R.id.towallet);
       Button buttonlogout=(Button)view.findViewById(R.id.buttonlogout);
        towallet.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                 Intent intent=new Intent(getContext(),api.class);
                                                 startActivity(intent);
                                                }
                                            });
        buttonlogout.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        FirebaseAuth.getInstance().signOut();
                                                        Toast.makeText(getContext(), "you have logged out successfully", Toast.LENGTH_SHORT).show();
                                                    }
                                                });
        return view;
    }

    @Override
    public void onClick(View view) {

    }
}

