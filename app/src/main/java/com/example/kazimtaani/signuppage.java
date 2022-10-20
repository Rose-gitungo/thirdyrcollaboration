package com.example.kazimtaani;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signuppage extends AppCompatActivity {
private FirebaseAuth mAuth;
    Button register;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
     private EditText email, pass, password,mobile,location;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setTitle("Sign Up page");
            setContentView(R.layout.activity_signuppage);

            mAuth=FirebaseAuth.getInstance();
            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference("CustomerInfo");

            register=(Button) findViewById(R.id.register);//identify button by id

            email=findViewById(R.id.email);//identify email by id
            String Email= email.getText().toString();//convert email from text to string

            pass=findViewById(R.id.pass);//identify password by id
            String Password= pass.getText().toString();//convert pass from text to string

            password=findViewById(R.id.password);//identify confirm password by id
            String ConfirmPassword= password.getText().toString();//convert password to string from text

           mobile=findViewById(R.id.mobile);//identify mobile by id
            String Mobile= mobile.getText().toString();

         // location=findViewById(R.id.location);//identify location by id
           // String Location= location.getText().toString();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Email.isEmpty()||Password.isEmpty()||ConfirmPassword.isEmpty()||Mobile.isEmpty()) {
                    Toast.makeText(signuppage.this,"please fill all the fields",Toast.LENGTH_LONG).show();
                }else {
                    if (Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
                        setError("Entered Email format is wrong ");
                    }else{
                    if (ConfirmPassword!=Password){
                        Toast.makeText(signuppage.this,"Passwords must match",Toast.LENGTH_SHORT).show();
                    }else{
                        mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(signuppage.this,"Account Created Successful",Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(signuppage.this,homepage.class);
                                    startActivity(intent);
                                    FirebaseUser user= mAuth.getCurrentUser();
                                    updateUI(user);
                                    finish();
                                } else{
                                Toast.makeText(signuppage.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            UpdateUI(null);
                                }
                            }

                            
                        });
                    }}
                }

            }

            private void updateUI(FirebaseUser user) {
            }
        });

        }

    private void UpdateUI(Object o) {
    }

    private void setError(String entered_email_format_is_wrong_) {
    }

    public void writeNewUser(String userId, String Email, String Password, String ConfirmPassword, String Username, String Mobile, String Location) {
       CustomerInfo user = new CustomerInfo();
       databaseReference.child("users").child(userId).setValue(user);
    }

    public void login(View view) {
        Intent intent = new Intent(signuppage.this, login.class);
        startActivity(intent);
    }
}