package com.example.phrapp;

import static com.example.phrapp.login2.alluserslist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        ImageView signupbutton = (ImageView) findViewById(R.id.signup_button);
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputLayout name = findViewById(R.id.register_name);
                String nameEntered = name.getEditText().getText().toString();

                TextInputLayout mobile=  findViewById(R.id.register_mobile);
                String mobileEntered = mobile.getEditText().getText().toString();

                TextInputLayout email=  findViewById(R.id.register_email);
                String emailEntered = email.getEditText().getText().toString();

                TextInputLayout password=  findViewById(R.id.register_password);
                String passwordEntered = password.getEditText().getText().toString();

                System.out.println("Entered Details " +nameEntered +mobileEntered +emailEntered + passwordEntered);

                userdetails newuser = new userdetails();
                newuser.setName(nameEntered);
                newuser.setMobile(mobileEntered);
                newuser.setEmail(emailEntered);
                newuser.setPassword(passwordEntered);

                alluserslist.add(newuser);

                Toast.makeText(register.this, "User Registered Successful !!!", Toast.LENGTH_SHORT).show();

                Intent myIntent;
                myIntent = new Intent(view.getContext(), login2.class);
                startActivity(myIntent);
            }
        });
    }
}