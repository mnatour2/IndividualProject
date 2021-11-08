package com.example.individualproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.util.ArrayList;

import com.example.individualproject.Adapters.CheckoutItemsAdapter;
import com.example.individualproject.Models.Item;
import com.example.individualproject.R;

public class Checkout extends AppCompatActivity {
    Intent intent;
    String itemsString;
    RecyclerView recyclerView;
    ArrayList<Item> cartItemsList;
    CheckoutItemsAdapter adapter;
    Gson gson;
    Item item;
    Double totalPriceBeforeTax,totalPriceAfterTax,subtotal,tax;
    TextView totalBeforeTaxV,taxV,totalAfterTaxV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_layout);
        BottomNavigationView BottomNavigationView =findViewById(R.id.bottomNavigationView);
        BottomNavigationView.setSelectedItemId(R.id.cart);
        BottomNavigationView.setOnNavigationItemSelectedListener(item -> {
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
        });
        totalBeforeTaxV=findViewById(R.id.totalBtaxV);
        totalAfterTaxV=findViewById(R.id.totalAtaxV);
        taxV=findViewById(R.id.taxV);

        subtotal=0.0;
        recyclerView=findViewById(R.id.checkout_items);
        cartItemsList=new ArrayList<>();
        gson = new Gson();
        intent=getIntent();
        itemsString=intent.getStringExtra("itemsString");
        String[] itemsList=itemsString.split("#");
        Log.d("TAG", "onCreateasasdas: ");
        for (String s : itemsList) {
            item = gson.fromJson(s, Item.class);
            subtotal += item.getTotalBeforeTax();
            Log.d("TAG", "onCreate: " + subtotal);
            cartItemsList.add(item);
        }
        totalPriceBeforeTax=subtotal;
        totalBeforeTaxV.setText(String.valueOf(totalPriceBeforeTax));
        tax=totalPriceBeforeTax*0.14;
        taxV.setText(String.valueOf(tax));
        totalPriceAfterTax=totalPriceBeforeTax+tax;
        totalAfterTaxV.setText(String.valueOf(totalPriceAfterTax));

        if(cartItemsList.size()!=0){
            Log.d("TAG", "inside if: "+cartItemsList.size());
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter=new CheckoutItemsAdapter(getApplicationContext(),cartItemsList);
            recyclerView.setAdapter(adapter);
        }
    }
    public void placeOrder(View view) {
        intent=new Intent(this, com.example.individualproject.Activities.Confirmation.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }
}