package com.example.kazimtaani;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
private FirebaseAuth mAuth;
FirebaseAuth.AuthStateListener mAuthListener;
EditText emaillogin;
 EditText passwordlogin;
    Button loginbutton;//initialize button
    Button buttonforgotpassword;

    public void onStart(){
        login.super.onStart();
        //check whether user is signed in and update UI accordingly
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Log in page");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

       mAuth =FirebaseAuth.getInstance();//initializing firebase auth
        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                if (user!=null){
                    //user is logged in
                    Intent intent=new Intent(login.this,dashboardd.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(login.this, "Please login to access your account", Toast.LENGTH_SHORT).show();
                }
            }
        };
        emaillogin=findViewById(R.id.emaillogin);
        passwordlogin=findViewById(R.id.passwordlogin);
       loginbutton=(Button) findViewById(R.id.loginbutton);//refers to button by id

        loginbutton.setOnClickListener(new OnClickListener() {
         @Override
         public void onClick(View v) {
           String  Email=emaillogin.getText().toString();
             String Password=passwordlogin.getText().toString();

             if (TextUtils.isEmpty(Email)){
                  Toast.makeText(login.this,"Email field cannot be empty",Toast.LENGTH_SHORT).show();

             }else {
                 if (Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
                     Toast.makeText(login.this, "Email Address format is wrong", Toast.LENGTH_SHORT).show();
                      return;              
                 }else{
                     if (TextUtils.isEmpty(Password)){
                     Toast.makeText(login.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                 }else {
                         mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                             @Override
                             public void onComplete(@NonNull Task<AuthResult> task) {
                                 if (task.isSuccessful()){
                                     FirebaseUser user= mAuth.getCurrentUser();
                                     UpdateUI(user);
                                 }else{
                                     Toast.makeText(login.this, "User account not found", Toast.LENGTH_SHORT).show();
                                     UpdateUI(null);
                                 }

                     }
                         });
                 }

             }

         }}

     });

    }

    private void UpdateUI(FirebaseUser user) {
        if(user!=null){
            Toast.makeText(this,"You Signed In successfully",Toast.LENGTH_LONG).show();
            startActivity(new Intent(login.this,dashboardd.class));
        }else{
            Toast.makeText(this,"You Did not signed in",Toast.LENGTH_LONG).show();
        }
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