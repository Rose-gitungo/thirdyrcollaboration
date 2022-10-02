package com.example.kazimtaani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
private FirebaseAuth mAuth;
 TextInputEditText emaillogin;
 TextInputEditText passwordlogin;
    Button loginbutton;//initialize button
    Button buttonforgotpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Log in page");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

       mAuth =FirebaseAuth.getInstance();//initializing firebase auth
        emaillogin=findViewById(R.id.emaillogin);
        passwordlogin=findViewById(R.id.passwordlogin);
       loginbutton=(Button) findViewById(R.id.loginbutton);//refers to button by id

        loginbutton.setOnClickListener(new OnClickListener() {
         @Override
         public void onClick(View v) {
           String  Email=emaillogin.getText().toString();
             String Password=passwordlogin.getText().toString();

             if (Email.isEmpty()){
                 new Error("Email cannot be empty");
             }else {
                 if (Patterns.EMAIL_ADDRESS.matcher(Email).matches()){

                 }else{
                     Toast.makeText(login.this, "Email Address format", Toast.LENGTH_SHORT).show();
                 }
             }

         }
         public void onStart(){
             login.super.onStart();
             //check whether user is signed in and update UI accordingly
             FirebaseUser currentUser = mAuth.getCurrentUser();
             if(currentUser!=null){
          recreate();
             }
         }
     });

    }
    public void up(View view) {
        Intent intent=new Intent(login.this,signuppage.class);
        startActivity(intent);
    }

    public void forgotpassword(View view) {
        Intent intent=new Intent(login.this,forgotpassword.class);
        startActivity(intent);
    }
}