package com.example.individualproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import com.example.individualproject.Models.Item;
import com.example.individualproject.R;

public class Information extends AppCompatActivity {
    Intent intent;
    ArrayList<Item> cartItemsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_information_layout);
        BottomNavigationView BottomNavigationView =findViewById(R.id.bottomNavigationView);
        BottomNavigationView.setSelectedItemId(R.id.cart);
        BottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homepage:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.cart:
                        startActivity(new Intent(getApplicationContext(), Cart.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
       // cartItemsList=new ArrayList<>();
        intent=getIntent();

    }
}