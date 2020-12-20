package com.example.binusezyfoody_2201808863;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.ViewHolder> {

    ArrayList<Drinklist> dataMinuman;

    public DrinkAdapter(ArrayList<Drinklist> dataMinuman) {
        this.dataMinuman = dataMinuman;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drink, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkAdapter.ViewHolder holder, int position){
        Drinklist drinklist = dataMinuman.get(position);

        holder.drinkImage.setImageResource(drinklist.image);
        holder.drinkName.setText(drinklist.drinkName);
        holder.drinkPrice.setText(drinklist.drinkPrice + " IDR");

    }

    @Override
    public int getItemCount() {
        return dataMinuman.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView drinkImage;
        TextView drinkName;
        TextView drinkPrice;
        Button btn;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            drinkImage = itemView.findViewById(R.id.drink_image);
            drinkName =itemView.findViewById(R.id.drink_name);
            drinkPrice = itemView.findViewById(R.id.drink_price);
            drinkPrice.setText(drinkPrice + " IDR");
            btn = itemView.findViewById(R.id.btn_orderDrink);
            btn.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {

            int position =getAdapterPosition();
            Drinklist drinkpos = dataMinuman.get(position);
            Intent i = new Intent(view.getContext(), Order.class);

            i.putExtra("Image", drinkpos.image);
            i.putExtra("Name", drinkpos.drinkName);
            i.putExtra("Price", drinkpos.drinkPrice);

            view.getContext().startActivity(i);

        }
    }

}
