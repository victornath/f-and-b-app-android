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

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    ArrayList<Foodlist> dataMakanan;

    public FoodAdapter(ArrayList<Foodlist> dataMakanan) {
        this.dataMakanan = dataMakanan;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position){
        Foodlist foodlist = dataMakanan.get(position);

        holder.foodImage.setImageResource(foodlist.image);
        holder.foodName.setText(foodlist.foodName);
        holder.foodOrigin.setText(foodlist.foodOrigin);
        holder.foodPrice.setText(foodlist.foodPrice + " IDR");

    }


    @Override
    public int getItemCount() {
        return dataMakanan.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView foodImage;
        TextView foodName;
        TextView foodOrigin;
        TextView foodPrice;
        Button btn;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            foodImage = itemView.findViewById(R.id.food_image);
            foodName =itemView.findViewById(R.id.food_name);
            foodOrigin = itemView.findViewById(R.id.food_origin);
            foodPrice = itemView.findViewById(R.id.food_price);
            foodPrice.setText(foodPrice + " IDR");
            btn = itemView.findViewById(R.id.btn_orderFood);
            btn.setOnClickListener(this);

        }
        @Override
        public void onClick(View view) {

            int position =getAdapterPosition();
            Foodlist foodpos = dataMakanan.get(position);
            Intent i = new Intent(view.getContext(), Order.class);

            i.putExtra("Image", foodpos.image);
            i.putExtra("Name", foodpos.foodName);
            i.putExtra("Price", foodpos.foodPrice);

            view.getContext().startActivity(i);
        }
    }

}
