package com.example.individualproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.individualproject.Adapters.HomeItemsAdapter;
import com.example.individualproject.Models.Item;
import com.example.individualproject.R;

public class Home extends AppCompatActivity {
    RecyclerView recyclerView;
    HomeItemsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        BottomNavigationView BottomNavigationView =findViewById(R.id.bottomNavigationView);
        BottomNavigationView.setSelectedItemId(R.id.homepage);
        BottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homepage:
                        return true;
                    case R.id.cart:
                        startActivity(new Intent(getApplicationContext(), Cart.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        recyclerView = findViewById(R.id.sales_items);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        String[] itemNames=new String[Item.items.length];
        String[] itemRatings=new String[Item.items.length];
        double[] itemPrices=new double[Item.items.length];
        int[] itemImagesIDs=new int[Item.items.length];
        for (int i=0;i<itemNames.length;i++){
            itemNames[i]=Item.items[i].getName();
            itemPrices[i]=Item.items[i].getPrice();
            itemImagesIDs[i]=Item.items[i].getImageID();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new HomeItemsAdapter(getApplicationContext(),itemNames,itemPrices,itemImagesIDs);
        recyclerView.setAdapter(adapter);
    }

}