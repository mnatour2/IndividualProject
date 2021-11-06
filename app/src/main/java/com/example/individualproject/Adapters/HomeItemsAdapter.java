package com.example.individualproject.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.individualproject.Activities.ItemDetails;
import com.example.individualproject.R;


public class HomeItemsAdapter extends RecyclerView.Adapter<HomeItemsAdapter.ViewHolder> {

    LayoutInflater inflater;
    Context context;
    private String[] itemNames,itemRatings;
    private double[] itemPrices;
    private int[] itemImagesIDs;


    public HomeItemsAdapter( Context context, String[] itemNames, String[] itemRatings, double[] itemPrices,int[] itemImagesIDs) {
        this.inflater=LayoutInflater.from(context);
        this.context = context;
        this.itemNames = itemNames;
        this.itemRatings = itemRatings;
        this.itemPrices = itemPrices;
        this.itemImagesIDs=itemImagesIDs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.item_card_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.item_title.setText(itemNames[position]);
        holder.item_price.setText(String.valueOf(itemPrices[position]));
        Drawable dr= ContextCompat.getDrawable(context,itemImagesIDs[position]);
        holder.item_image.setImageDrawable(dr);
        holder.nis_symbol.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.nis_symbol));
        if(itemRatings[position].equals("1")){
            holder.star1.setVisibility(View.VISIBLE);
            holder.star1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_star_24));
        }else if (itemRatings[position].equals("2")){
            holder.star1.setVisibility(View.VISIBLE);
            holder.star1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_star_24));
            holder.star2.setVisibility(View.VISIBLE);
            holder.star2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_star_24));
        }
        else if (itemRatings[position].equals("3")){
            holder.star1.setVisibility(View.VISIBLE);
            holder.star1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_star_24));
            holder.star2.setVisibility(View.VISIBLE);
            holder.star2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_star_24));
            holder.star3.setVisibility(View.VISIBLE);
            holder.star3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_star_24));
        }
        else if (itemRatings[position].equals("4")){
            holder.star1.setVisibility(View.VISIBLE);
            holder.star1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_star_24));
            holder.star2.setVisibility(View.VISIBLE);
            holder.star2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_star_24));
            holder.star3.setVisibility(View.VISIBLE);
            holder.star3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_star_24));
            holder.star4.setVisibility(View.VISIBLE);
            holder.star4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_star_24));
        }else if (itemRatings[position].equals("5")){
            holder.star1.setVisibility(View.VISIBLE);
            holder.star1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_star_24));
            holder.star2.setVisibility(View.VISIBLE);
            holder.star2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_star_24));
            holder.star3.setVisibility(View.VISIBLE);
            holder.star3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_star_24));
            holder.star4.setVisibility(View.VISIBLE);
            holder.star4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_star_24));
            holder.star5.setVisibility(View.VISIBLE);
            holder.star5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_star_24));
        }

        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(context, ItemDetails.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("itemImageToItemDetails", itemImagesIDs[position]);
                intent.putExtra("itemNameToItemDetails",itemNames[position]);
                intent.putExtra("itemPriceToItemDetails",itemPrices[position]);
                intent.putExtra("itemRatingToItemDetails",itemRatings[position]);
                context.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return itemNames.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView item_title,item_price;
        ImageView item_image,star1,star2,star3,star4,star5,nis_symbol;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_title=itemView.findViewById(R.id.item_title);
            item_price=itemView.findViewById(R.id.item_price);
            item_image=itemView.findViewById(R.id.item_image);
            star1=itemView.findViewById(R.id.star1);
            star2=itemView.findViewById(R.id.star2);
            star3=itemView.findViewById(R.id.star3);
            star4=itemView.findViewById(R.id.star4);
            star5=itemView.findViewById(R.id.star5);
            nis_symbol=itemView.findViewById(R.id.nis_symbol);
            cardView = itemView.findViewById(R.id.item_card);

        }
    }
}
