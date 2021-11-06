package com.example.individualproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.individualproject.R;

public class ItemAdded extends AppCompatActivity {
    Intent intent,intent2;
    int itemImage;
    double itemPrice;
    String itemName,itemQty;
    ImageView imageAdded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_added_layout);
        BottomNavigationView BottomNavigationView =findViewById(R.id.bottomNavigationView);
        BottomNavigationView.setSelectedItemId(R.id.homepage);
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
        intent=getIntent();
        itemImage=(int)intent.getExtras().get("itemImageToItemAdded");
        itemPrice=(double)intent.getExtras().get("itemPriceToItemAdded");
        itemName=intent.getExtras().getString("itemNameToItemAdded");
        itemQty=intent.getExtras().getString("itemQtyToItemAdded");
        imageAdded=findViewById(R.id.image_cart);
        imageAdded.setImageDrawable(ContextCompat.getDrawable(this,itemImage));
    }

    public void continueBtnOnClick(View view) {
        intent2=new Intent(this, com.example.individualproject.Activities.Home.class);
        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent2);
    }

    public void checkOutBtnOnClick(View view) {
        intent=new Intent(this, com.example.individualproject.Activities.Cart.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }
}