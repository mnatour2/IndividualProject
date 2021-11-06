package com.example.individualproject.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.individualproject.R;

public class Confirmation extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public static final String CARTPREFS = "cartPrefs" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation_layout);
        BottomNavigationView BottomNavigationView =findViewById(R.id.bottomNavigationView);
        BottomNavigationView.setSelectedItemId(R.id.cart);
        BottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homepage:
                        startActivity(new Intent(getApplicationContext(), com.example.individualproject.Activities.Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.cart:
                        startActivity(new Intent(getApplicationContext(), com.example.individualproject.Activities.Cart.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        setUpSharedPrefs();
        editor.clear();
        editor.commit();
    }
    private void setUpSharedPrefs(){
        sharedPreferences= getSharedPreferences(CARTPREFS, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
}