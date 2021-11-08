package com.example.individualproject.Models;

import com.example.individualproject.R;

public class Item  {
    private String name;
    private Double price;
    private int quantity;
    private int imageID;
    public static final Item[] items={
            new Item("Franklin Sports Grip-Rite 100 Rubber Junior Football",4.88, R.drawable.football),
            new Item("FC Barcelona Home Jersey 2020/21 (Nike)",64.96, R.drawable.barcelona_kit),
            new Item("F.C. Barcelona 2020/21 Stadium Goalkeeper Shorts",28.47, R.drawable.barcelona_shorts),
            new Item("METIS NEOPRENE HEX DUMBBELLS X2 [1LB-22LBS] - PAIR",29.99, R.drawable.dumbells),
            new Item("Adidas Running Shoes (Black)",61.9, R.drawable.shoes),
    };
    public Item(String name, Double price, int imageID) {
        this.name = name;
        this.price = price;
        this.imageID = imageID;
    }

    public Item(String name, Double price, int quantity, int imageID) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
    public double getTotalBeforeTax(){
        return price*quantity;

    }
    public double getTotalAfterTax(){
        return  (getTotalBeforeTax()*0.14)+getTotalBeforeTax();
    }
    @Override
    public String toString() {
        return "Item{" +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", imageID=" + imageID +
                '}';
    }
}