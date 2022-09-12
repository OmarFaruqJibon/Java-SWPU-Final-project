package com.example.swpufinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    EditText productName,price,location;
    Button addCommodity,viewCommodity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        productName=(EditText)findViewById(R.id.productNameId);
        price=(EditText)findViewById(R.id.priceId);
        location=(EditText)findViewById(R.id.locationId);

        addCommodity=(Button)findViewById(R.id.addCommodityId);
        viewCommodity=(Button)findViewById(R.id.viewCommodityId);

        addCommodity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pName = productName.getText().toString();
                String pPrice=price.getText().toString();
                String pLocation=location.getText().toString();

        if (pName.length() <=0 || pPrice.length()<=0 || pLocation.length()<=0){
            Toast.makeText(Home.this, "Fill Up All The Text Filed", Toast.LENGTH_SHORT).show();
        }else {
            MyHelper2 myHelper2 = new MyHelper2(Home.this);
            CommodityHelper commodityHelper = new CommodityHelper(pName,pPrice,pLocation);
            myHelper2.addCommodity(commodityHelper);
            Toast.makeText(Home.this, "New Commodity Successfully Added", Toast.LENGTH_SHORT).show();
            finish();
            startActivity(getIntent());
        }
    }
});


        viewCommodity.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent intent = new Intent(Home.this,ViewCommodity.class);
        startActivity(intent);
        }
        });


        }
        }
