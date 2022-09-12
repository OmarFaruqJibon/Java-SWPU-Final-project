package com.example.swpufinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,mobile,password, conPassword;
    Button signup, signin;
    MyDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText) findViewById(R.id.userNameId);
        password=(EditText) findViewById(R.id.userPasswordId);
        conPassword=(EditText) findViewById(R.id.userConfirmPassId);
        signup=(Button)findViewById(R.id.registerButtonId);
        signin=(Button)findViewById(R.id.moveToSignInId);
        mobile=(EditText) findViewById(R.id.userMobileId);
        DB=new MyDBHelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = conPassword.getText().toString();
                String mobl= mobile.getText().toString();

                if (user.equals("")||pass.equals("")||repass.equals("")||mobl.equals(""))
                    Toast.makeText(MainActivity.this,"Please Fill Up All The Text Field",Toast.LENGTH_SHORT).show();
                else {
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkUserNameValidity(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,pass,mobl);
                            if(insert==true){
                                Toast.makeText(MainActivity.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent (getApplicationContext(),Home.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(MainActivity.this,"Registration Failed",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this,"This User Name Already Exist",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this,"Password Not Matching",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),SignIn.class);
                startActivity(intent);


            }
        });

    }
}


