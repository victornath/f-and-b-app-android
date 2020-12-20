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

public class Snack extends AppCompatActivity {

    ArrayList<Snacklist> dataSnack;
    SnackAdapter adapter;
    RecyclerView viewSnack;
    Button topup, myorder;
    TextView showBalance;
    Balance balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);

        topup = findViewById(R.id.btn_topUp);
        myorder = findViewById(R.id.btn_myOrder);
        showBalance = findViewById(R.id.balance);

        viewSnack = findViewById(R.id.list_of_snack);
        viewSnack.setLayoutManager(new LinearLayoutManager(this));

        SharedPref sharedPref = new SharedPref(Snack.this);
        balance = sharedPref.load();

        NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
        showBalance.setText(nf.format(balance.ammount) + " IDR");

        dataSnack = new ArrayList<>();

        Snacklist snack1 = new Snacklist("Croquette", 14000, R.drawable.croquette);
        Snacklist snack2 = new Snacklist("French Fries", 16000, R.drawable.frenchfries);
        Snacklist snack3 = new Snacklist("Marshmallow", 12000, R.drawable.marshmallow);
        Snacklist snack4 = new Snacklist("Pancake", 24000, R.drawable.pancake);
        Snacklist snack5 = new Snacklist("Potato Chips", 12000, R.drawable.potatochips);
        Snacklist snack6 = new Snacklist("Pudding", 18000, R.drawable.pudding);
        Snacklist snack7 = new Snacklist("Waffle", 26000, R.drawable.waffle);


        dataSnack.add(snack1);
        dataSnack.add(snack2);
        dataSnack.add(snack3);
        dataSnack.add(snack4);
        dataSnack.add(snack5);
        dataSnack.add(snack6);
        dataSnack.add(snack7);


        adapter = new SnackAdapter(dataSnack);
        viewSnack.setAdapter(adapter);

        topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent topUp = new Intent(Snack.this, TopUp.class);
                startActivity(topUp);
            }
        });

        myorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myOrder = new Intent(Snack.this, TotalOrder.class);
                startActivity(myOrder);
            }
        });

    }
}