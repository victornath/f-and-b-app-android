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

public class TotalOrderAdapter extends RecyclerView.Adapter<TotalOrderAdapter.ViewHolder> {

    ArrayList<TotalOrderlist> dataPesanan;


    public TotalOrderAdapter(ArrayList<TotalOrderlist> dataPesanan) {
        this.dataPesanan = dataPesanan;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_totalorder, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TotalOrderAdapter.ViewHolder holder, int position){
        TotalOrderlist totalOrderlist = dataPesanan.get(position);

        holder.totalorderImage.setImageResource(totalOrderlist.image);
        holder.totalorderName.setText(totalOrderlist.name);
        holder.totalorderQuantityAndPrice.setText(totalOrderlist.quantity + " x " + totalOrderlist.price);

    }


    @Override
    public int getItemCount() {
        return dataPesanan.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView totalorderImage;
        TextView totalorderName;
        TextView totalorderQuantityAndPrice;
        Button delete;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            totalorderImage = itemView.findViewById(R.id.totalorder_image);
            totalorderName =itemView.findViewById(R.id.totalorder_name);
            totalorderQuantityAndPrice = itemView.findViewById(R.id.totalorder_quantityxprice);
            delete = itemView.findViewById(R.id.btn_deleteOrder);
            delete.setOnClickListener(this);

        }
        @Override
        public void onClick(View view) {

            int position =getAdapterPosition();
            dataPesanan.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, dataPesanan.size());

        }
    }

}
