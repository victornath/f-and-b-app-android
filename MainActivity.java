package com.example.binusezyfoody_2201808863;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    LinearLayout foodmenu, drinkmenu, snackmenu;
    Button topup, myorder;
    TextView showBalance;
    Balance balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodmenu = findViewById(R.id.food_menu);
        drinkmenu = findViewById(R.id.drink_menu);
        snackmenu = findViewById(R.id.snack_menu);
        topup = findViewById(R.id.btn_topUp);
        myorder = findViewById(R.id.btn_myOrder);
        showBalance = findViewById(R.id.balance);

        SharedPref sharedPref = new SharedPref(MainActivity.this);
        balance = sharedPref.load();

        NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
        showBalance.setText(nf.format(balance.ammount) + " IDR");


        foodmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent food = new Intent(MainActivity.this, Food.class);
                startActivity(food);
            }
        });

        drinkmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent drink = new Intent(MainActivity.this, Drink.class);
                startActivity(drink);
            }
        });

        snackmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent snack = new Intent(MainActivity.this, Snack.class);
                startActivity(snack);
            }
        });

        topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent topUp = new Intent(MainActivity.this, TopUp.class);
                startActivity(topUp);
            }
        });

        myorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myOrder = new Intent(MainActivity.this, TotalOrder.class);
                startActivity(myOrder);
            }
        });

    }


}