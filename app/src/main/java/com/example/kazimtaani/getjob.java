package com.example.kazimtaani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class getjob extends AppCompatActivity {

    Button savebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Hire me");
        setContentView(R.layout.activity_getjob);

        savebutton=(Button) findViewById(R.id.savebutton);
        savebutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getjob.this,homepage.class);
                startActivity(intent);

            }
        });
    }
}
