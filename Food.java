package com.example.binusezyfoody_2201808863;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Food extends AppCompatActivity {

    ArrayList<Foodlist> dataMakanan;
    FoodAdapter adapter;
    RecyclerView viewFood;
    Button topup, myorder;
    TextView showBalance;
    Balance balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        topup = findViewById(R.id.btn_topUp);
        myorder = findViewById(R.id.btn_myOrder);
        showBalance = findViewById(R.id.balance);

        viewFood = findViewById(R.id.list_of_food);
        viewFood.setLayoutManager(new LinearLayoutManager(this));

        SharedPref sharedPref = new SharedPref(Food.this);
        balance = sharedPref.load();

        NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
        showBalance.setText(nf.format(balance.ammount) + " IDR");

        dataMakanan = new ArrayList<>();

        Foodlist food1 = new Foodlist("Hamburger","Origin : USA", 60000, R.drawable.hamburger);
        Foodlist food2 = new Foodlist("Sushi Roll","Origin : Japan", 50000, R.drawable.sushi);
        Foodlist food3 = new Foodlist("Rendang", "Origin : Indonesia", 40000, R.drawable.rendang);
        Foodlist food4 = new Foodlist("Pizza", "Origin : Italy" , 60000, R.drawable.pizza);
        Foodlist food5 = new Foodlist("Swedish Meatball", "Origin : Sweden", 55000, R.drawable.swedishmeatball);
        Foodlist food6 = new Foodlist("Tom Yum", "Origin : Thailand", 70000, R.drawable.tomyum);
        Foodlist food7 = new Foodlist("Fish and Chips", "Origin : UK", 80000, R.drawable.fishandchips);
        Foodlist food8 = new Foodlist("Dim Sum", "Origin : China", 65000, R.drawable.dimsum);
        Foodlist food9 = new Foodlist("Tteokbokki", "Origin : South Korea", 45000, R.drawable.tteokbokki);
        Foodlist food10 = new Foodlist("Pho", "Origin : Vietnam", 40000, R.drawable.swedishmeatball);


        dataMakanan.add(food1);
        dataMakanan.add(food2);
        dataMakanan.add(food3);
        dataMakanan.add(food4);
        dataMakanan.add(food5);
        dataMakanan.add(food6);
        dataMakanan.add(food7);
        dataMakanan.add(food8);
        dataMakanan.add(food9);
        dataMakanan.add(food10);

        adapter = new FoodAdapter(dataMakanan);
        viewFood.setAdapter(adapter);

        topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent topUp = new Intent(Food.this, TopUp.class);
                startActivity(topUp);
            }
        });

        myorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myOrder = new Intent(Food.this, TotalOrder.class);
                startActivity(myOrder);
            }
        });

    }
}