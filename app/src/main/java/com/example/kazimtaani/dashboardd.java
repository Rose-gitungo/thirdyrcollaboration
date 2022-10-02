package com.example.kazimtaani;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class dashboardd extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
BottomNavigationView bottomNav;
    private Object postjobfragment;
Fragment homefragment;
Fragment profilefragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardd);
        bottomNav=findViewById(R.id.bottom_nav);
        bottomNav.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment= null;
        switch(item.getItemId()){
            case R.id.nav_add:
              selectedFragment=new postjobfragment();
                  FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelay, (Fragment) postjobfragment).commit();
                break;
            case R.id.nav_home:
               selectedFragment=new homefragment();
                FragmentTransaction transaction2= getSupportFragmentManager().beginTransaction();
                transaction2.replace(R.id.framelay,homefragment).commit();
                break;
            case R.id.nav_profile:
               selectedFragment=new profilefragment();
               FragmentTransaction transaction3= getSupportFragmentManager().beginTransaction();
                transaction3.replace(R.id.framelay,profilefragment).commit();
                break;

        }
        return false;
    }
}