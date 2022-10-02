package com.example.kazimtaani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class postjob extends AppCompatActivity {
Button buttonsavewantohire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Post A job");
        setContentView(R.layout.activity_postjob);

         buttonsavewantohire=(Button) findViewById(R.id.buttonsavewantohire);
        buttonsavewantohire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(postjob.this,homepage.class);
                startActivity(intent);
            }
        });
    }
}