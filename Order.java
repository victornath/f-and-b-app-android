package com.example.binusezyfoody_2201808863;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Order extends AppCompatActivity {

    ImageView imageView;
    TextView nameView;
    TextView priceView;
    EditText jumlah;
    int quantity;
    Button btnAdd, btnCancel;
    int image,price;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        imageView = findViewById(R.id.order_image);
        nameView = findViewById(R.id.order_name);
        priceView = findViewById(R.id.order_price);
        jumlah = findViewById(R.id.orderQuantity);
        btnAdd = findViewById(R.id.btn_addToMyorder);
        btnCancel = findViewById(R.id.btn_cancelOrder);

        image = getIntent().getIntExtra("Image",0);
        name = getIntent().getStringExtra("Name");
        price = getIntent().getIntExtra("Price",0);

        imageView.setImageResource(image);
        nameView.setText(name);
        priceView.setText(price + " IDR");


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity = Integer.parseInt(jumlah.getText().toString());
                if(quantity < 1){
                    Toast.makeText(getApplicationContext(), "Quantity must be at least 1 pcs.", Toast.LENGTH_SHORT).show();
                }

                else if(quantity > 10){
                    Toast.makeText(getApplicationContext(), "Sorry, you can only order maximum 10 pcs.", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(getApplicationContext(), "Item succesfully added to My Order", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(v.getContext(), TotalOrder.class);

                    i.putExtra("Image",image);
                    i.putExtra("Name", name);
                    i.putExtra("Price", price);
                    i.putExtra("Quantity", quantity);

                    v.getContext().startActivity(i);
                }
            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Order Cancelled. Back to Main Menu.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(v.getContext(), MainActivity.class);

                v.getContext().startActivity(i);
            }
        });

    }

}