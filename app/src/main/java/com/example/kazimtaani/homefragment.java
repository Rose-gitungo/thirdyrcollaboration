package com.example.kazimtaani;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class homefragment extends Fragment {

    public homefragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homefragment, container, false);
        view.findViewById(R.id.pa).setOnClickListener(mlistener);
        view.findViewById(R.id.chef).setOnClickListener(mlistener);
        view.findViewById(R.id.friend).setOnClickListener(mlistener);
        view.findViewById(R.id.tutor).setOnClickListener(mlistener);

        view.findViewById(R.id.five).setOnClickListener(mlistener);
        view.findViewById(R.id.twofour).setOnClickListener(mlistener);
        view.findViewById(R.id.fifty).setOnClickListener(mlistener);
        view.findViewById(R.id.hundred).setOnClickListener(mlistener);

        view.findViewById(R.id.driver).setOnClickListener(mlistener);
        view.findViewById(R.id.nanny).setOnClickListener(mlistener);
        view.findViewById(R.id.gatekeeper).setOnClickListener(mlistener);
        view.findViewById(R.id.gardener).setOnClickListener(mlistener);
        view.findViewById(R.id.painter).setOnClickListener(mlistener);
        return view;
    }
   private final View.OnClickListener mlistener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(getContext(),getjob.class);
            startActivity(intent);

 /*switch (view.getId()){
    case R.id.pa:
        break;
    case R.id.chef:
        break;
    case R.id.friend:
        break;
    case R.id.tutor:
        break;
    case R.id.trainer:
        break;
    case R.id.five:
        break;
    case R.id.twofour:
        break;
    case R.id.fifty:
        break;
    case R.id.hundred:
        break;
    case R.id.nanny:
        break;
    case R.id.driver:
        break;
    case R.id.gatekeeper:
        break;
    case R.id.gardener:
        break;
    case R.id.painter:
        break;

}*/
        }
    };


}