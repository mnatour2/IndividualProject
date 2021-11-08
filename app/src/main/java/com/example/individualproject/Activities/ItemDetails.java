package com.example.individualproject.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import com.example.individualproject.R;
import com.example.individualproject.Models.Item;
import com.example.individualproject.Models.CartModel;

public class ItemDetails extends AppCompatActivity {
    Intent intent;
    ImageView nis_symbol2;
    TextView item_title_preview, item_price_preview;
    Spinner quantity_spinner;
    int itemImage;
    double itemPrice;
    String itemName, itemRating, itemQuantity, items = "";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    Gson gson;
    CartModel cartObject = new CartModel();
    public static final String CARTPREFS = "cartPrefs";
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details_layout);
        BottomNavigationView BottomNavigationView = findViewById(R.id.bottomNavigationView);
        BottomNavigationView.setSelectedItemId(R.id.homepage);
        BottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.homepage:
                        startActivity(new Intent(getApplicationContext(), com.example.individualproject.Activities.Home.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.cart:
                        startActivity(new Intent(getApplicationContext(), com.example.individualproject.Activities.Cart.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        intent = getIntent();
        itemImage = (int) intent.getExtras().get("itemImageToItemDetails");
        itemPrice = (double) intent.getExtras().get("itemPriceToItemDetails");
        itemName = intent.getExtras().getString("itemNameToItemDetails");
        itemRating = intent.getExtras().getString("itemRatingToItemDetails");
        nis_symbol2 = findViewById(R.id.nis_symbol2);
        item_title_preview = findViewById(R.id.item_title_preview);
        item_price_preview = findViewById(R.id.item_price_preview);
        quantity_spinner = findViewById(R.id.quantity_spinner);
        item_title_preview.setText(itemName);
        item_price_preview.setText(String.valueOf(itemPrice));
        nis_symbol2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.nis_symbol));
        populateSpinner();
        setUpSharedPrefs();

    }

    private void setUpSharedPrefs() {
        sharedPreferences = getSharedPreferences(CARTPREFS, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    private void populateSpinner() {
        String[] qty = {"1", "2", "3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, qty);
        quantity_spinner.setAdapter(adapter);
    }

    public void addToCartOnClick(View view) {
        itemQuantity = quantity_spinner.getSelectedItem().toString();
        editor.putInt("itemImageToItemAdded2", itemImage);
        editor.putFloat("itemPriceToItemAdded2", (float) itemPrice);
        editor.putString("itemNameToItemAdded2", itemName);
        editor.putString("itemQtyToItemAdded2", itemQuantity);
        Log.d("TAG", "itemQuantity: " + itemQuantity);
        item = new Item(itemName, itemPrice, Integer.parseInt(itemQuantity), itemImage);
        gson = new Gson();
        String previousItem = sharedPreferences.getString(CARTPREFS, "");
        items = previousItem + gson.toJson(item) + "#";
        editor.putString(CARTPREFS, items);
        editor.commit();
        intent = new Intent(this, com.example.individualproject.Activities.ItemAdded.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("itemImageToItemAdded", itemImage);
        intent.putExtra("itemNameToItemAdded", itemName);
        intent.putExtra("itemPriceToItemAdded", itemPrice);
        intent.putExtra("itemQtyToItemAdded", itemQuantity);
        this.startActivity(intent);
    }

}