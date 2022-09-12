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

public class SignIn extends AppCompatActivity {
    EditText username,password;
    Button login,mregister;
    MyDBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        username=(EditText) findViewById(R.id.signInNameId);
        password=(EditText)findViewById(R.id.signInPasswordId);
        login=(Button)findViewById(R.id.logInButtonId);
        mregister=(Button)findViewById(R.id.moveToRegisterId);
        DB = new MyDBHelper(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass =password.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(SignIn.this,"Please Fill Up All The Text Field",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkValidity = DB.checkUserNameAndPasswordValidity(user,pass);
                    if(checkValidity==true){
                        Toast.makeText(SignIn.this,"Sing in Successful",Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(getApplicationContext(),Home.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(SignIn.this,"Invalid User Name or Password",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        mregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
