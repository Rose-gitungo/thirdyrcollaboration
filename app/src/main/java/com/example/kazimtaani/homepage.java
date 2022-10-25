package com.example.kazimtaani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class homepage extends AppCompatActivity {

private FirebaseAuth mAuth;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //setTitle("HomePage");
        setContentView(R.layout.activity_homepage);
       mAuth=FirebaseAuth.getInstance();

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser =mAuth.getCurrentUser();
        if(currentUser!=null){
            recreate();
        }else {

        }
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
    }
}