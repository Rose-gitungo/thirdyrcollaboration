package com.example.kazimtaani;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class dashboardd extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
BottomNavigationView bottomNav;
    Fragment homefragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardd);
        bottomNav=findViewById(R.id.bottom_nav);
        bottomNav.setOnItemSelectedListener(this::onNavigationItemSelected);
       bottomNav.setSelectedItemId(R.id.nav_home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.nav_add:
              Fragment postjobfragment1=new postjobfragment();
                  FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelay,postjobfragment1).commit();
                break;

            case R.id.nav_home:
                Fragment homefragment1=new homefragment();
                FragmentTransaction transaction2= getSupportFragmentManager().beginTransaction();
                transaction2.replace(R.id.framelay,homefragment1).commit();
                break;
            case R.id.nav_profile:
                Fragment profilefragment1=new profilefragment();
               FragmentTransaction transaction3= getSupportFragmentManager().beginTransaction();
                transaction3.replace(R.id.framelay,profilefragment1).commit();
                break;

        }
        return false;
    }
    public void insertIntoDb(View v){

    }
}