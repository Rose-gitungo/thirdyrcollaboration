package com.example.kazimtaani;

import static android.os.Build.USER;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signuppage extends AppCompatActivity {
 FirebaseAuth mAuth;
    Button register;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
     private EditText email, pass, password,mobile;
     CustomerInfo customerInfo;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setTitle("Sign Up page");
            setContentView(R.layout.activity_signuppage);


            register=findViewById(R.id.register);
            email=findViewById(R.id.email);
            pass=findViewById(R.id.pass);
            password=findViewById(R.id.password);
            mobile=findViewById(R.id.mobile);

          //  mAuth=FirebaseAuth.getInstance();
            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference(USER);

            CustomerInfo customerInfo = new CustomerInfo();

            register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = email.getText().toString();
                String Password = pass.getText().toString();
                String ConfirmPassword = password.getText().toString();
                String Mobile = mobile.getText().toString();

                if (TextUtils.isEmpty(Email)) {
                    Toast.makeText(signuppage.this, "Enter Email", Toast.LENGTH_SHORT).show();
                } else {
                    if (TextUtils.isEmpty(Password)) {
                        Toast.makeText(signuppage.this, "Enter password", Toast.LENGTH_SHORT).show();
                    } else {
                        if (TextUtils.isEmpty(ConfirmPassword)) {
                            Toast.makeText(signuppage.this, "Enter password again to confirm password", Toast.LENGTH_SHORT).show();
                        } else {
                            if (!ConfirmPassword.equals(Password)) {
                                Toast.makeText(signuppage.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                            } else {
                                if (TextUtils.isEmpty(Mobile)) {
                                    Toast.makeText(signuppage.this, "Input Mobile number", Toast.LENGTH_SHORT).show();
                                } else {
                                    mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful()){
                                                FirebaseAuth.getInstance();
                                                Toast.makeText(signuppage.this, "User created and signed in successfully", Toast.LENGTH_SHORT).show();
                                                Intent intent=new Intent(signuppage.this,dashboardd.class);
                                                startActivity(intent);

                                            }else{
                                                Toast.makeText(signuppage.this, "user account creation failed", Toast.LENGTH_SHORT).show();

                                            }

                                        }
                                    });
                                }
                            }
                        }
                    }
                }

            }
});

        }

    private void addDatatoFirebase() {
        String Email = email.getText().toString();
        String Password = pass.getText().toString();
        String ConfirmPassword = password.getText().toString();
        String Mobile = mobile.getText().toString();


        customerInfo.setEmail(Email);
        customerInfo.setPassword(Password);
        customerInfo.setConfirmPassword(ConfirmPassword);
        customerInfo.setMobile(Mobile);

    }

    private void UpdateUI(FirebaseUser user) {
        FirebaseUser currentuser =mAuth.getCurrentUser();
        if (currentuser!=null){
            Toast.makeText(signuppage.this, "you signed in successully", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(signuppage.this, "You did not Sign in", Toast.LENGTH_SHORT).show();
        }
    }

    public void login(View view) {
        Intent intent = new Intent(signuppage.this, login.class);
        startActivity(intent);
    }
}