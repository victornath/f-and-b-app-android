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

public class SnackAdapter extends RecyclerView.Adapter<SnackAdapter.ViewHolder> {

    ArrayList<Snacklist> dataSnack;

    public SnackAdapter(ArrayList<Snacklist> dataSnack) {
        this.dataSnack = dataSnack;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_snack, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SnackAdapter.ViewHolder holder, int position){
        Snacklist snacklist = dataSnack.get(position);

        holder.snackImage.setImageResource(snacklist.image);
        holder.snackName.setText(snacklist.snackName);
        holder.snackPrice.setText(snacklist.snackPrice + " IDR");

    }

    @Override
    public int getItemCount() {
        return dataSnack.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView snackImage;
        TextView snackName;
        TextView snackPrice;
        Button btn;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            snackImage = itemView.findViewById(R.id.snack_image);
            snackName =itemView.findViewById(R.id.snack_name);
            snackPrice = itemView.findViewById(R.id.snack_price);
            snackPrice.setText(snackPrice + " IDR");
            btn = itemView.findViewById(R.id.btn_orderSnack);
            btn.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {

            int position =getAdapterPosition();
            Snacklist snackpos = dataSnack.get(position);

            Intent i = new Intent(view.getContext(), Order.class);

            i.putExtra("Image", snackpos.image);
            i.putExtra("Name", snackpos.snackName);
            i.putExtra("Price", snackpos.snackPrice);

            view.getContext().startActivity(i);

        }
    }

}
