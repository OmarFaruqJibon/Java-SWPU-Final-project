package com.example.swpufinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewCommodity extends AppCompatActivity {

    RecyclerView View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_commodity);

        View = findViewById(R.id.viewId);
        View.setLayoutManager(new LinearLayoutManager(this));
        View.setHasFixedSize(true);

        MyHelper2 myHelper2 = new MyHelper2(this);
        List<CommodityHelper> commodityHelpers = myHelper2.getEmployeeList();

        if (commodityHelpers.size() > 0){
            commodityAdapter commodityAdapter = new commodityAdapter(commodityHelpers,ViewCommodity.this);
            View.setAdapter(commodityAdapter);
        }else {
            Toast.makeText(this, "There is no employee in the database", Toast.LENGTH_SHORT).show();
        }




    }
}
