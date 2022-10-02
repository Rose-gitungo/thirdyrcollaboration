package com.example.kazimtaani;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class forgotpassword extends AppCompatActivity {
TextInputEditText emailforgot;
FirebaseAuth mAuth;
Button button2submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Forgot Password");
        setContentView(R.layout.activity_forgotpassword);

        emailforgot=findViewById(R.id.emailforgot);
      String  Email=emailforgot.getText().toString();

        mAuth=FirebaseAuth.getInstance();
      button2submit=findViewById(R.id.button2submit);

      button2submit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if (Email.isEmpty()) {
                  Toast.makeText(forgotpassword.this, "Email field cannot be empty", Toast.LENGTH_SHORT).show();
              }else{
                  if (Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
                      Toast.makeText(forgotpassword.this,"Enter valid email address",Toast.LENGTH_SHORT).show();
                  }else{
                      mAuth.sendPasswordResetEmail(Email).addOnCompleteListener(new OnCompleteListener<Void>() {
                          @Override
                          public void onComplete(@NonNull Task<Void> task) {
                              if (task.isSuccessful()){
                                  Toast.makeText(forgotpassword.this,"Email has been reset",Toast.LENGTH_SHORT).show();
                              }else{
                                  Toast.makeText(forgotpassword.this, "Email ACcount not found", Toast.LENGTH_SHORT).show();
                              }
                          }
                      });
                  }
              }
          }
      });


    }
}