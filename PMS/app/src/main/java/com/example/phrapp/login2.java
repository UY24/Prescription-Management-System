
package com.example.phrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Locale;

public class login2 extends AppCompatActivity {


    static ArrayList<userdetails> alluserslist = new ArrayList<userdetails>();
    static String CurrentLoginUser="Utsav Baghela";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        userdetails tempuser = new userdetails();
        tempuser.setName("Utsav Baghela");
        tempuser.setEmail("utsav");
        tempuser.setMobile("9999988888");
        tempuser.setPassword("utsav");

        alluserslist.add(tempuser);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        ImageView signinbutton = (ImageView) findViewById(R.id.signinbutton);
        signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // check for login
                TextInputLayout email= (TextInputLayout)findViewById(R.id.emailLayout) ;
                String emailEntered = email.getEditText().getText().toString();

                TextInputLayout password= (TextInputLayout)findViewById(R.id.passLayout) ;
                String passwordEntered = password.getEditText().getText().toString();

                System.out.println("Entered Password is : "+emailEntered +" "+ passwordEntered);
                System.out.println("Required is         : "+tempuser.getEmail() +" "+ tempuser.getPassword());


                for(userdetails tempuser:alluserslist) {
                    if (emailEntered.equals(tempuser.getEmail()) && passwordEntered.equals(tempuser.getPassword())) {
                        CurrentLoginUser=tempuser.getName();
                        Toast.makeText(login2.this, "Login Successfull !!!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(login2.this, "Welcome " + tempuser.getName().toUpperCase(Locale.ROOT), Toast.LENGTH_SHORT).show();
                        Intent myIntent;
                        myIntent = new Intent(view.getContext(), dashboard.class);
                        startActivity(myIntent);
                    }
                }
                //Toast.makeText(login2.this, "Incorrect Username and Password.... :( Try Again ", Toast.LENGTH_SHORT).show();





            }
        });

        TextView signup = (TextView) findViewById(R.id.signuplink1);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent;
                myIntent = new Intent(view.getContext(),register.class);
                startActivity(myIntent);
            }
        });
    }


}