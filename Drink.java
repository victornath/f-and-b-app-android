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

public class Drink extends AppCompatActivity {

    ArrayList<Drinklist> dataMinuman;
    DrinkAdapter adapter;
    RecyclerView viewDrink;
    Button topup, myorder;
    TextView showBalance;
    Balance balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        topup = findViewById(R.id.btn_topUp);
        myorder = findViewById(R.id.btn_myOrder);
        showBalance = findViewById(R.id.balance);

        viewDrink = findViewById(R.id.list_of_drink);
        viewDrink.setLayoutManager(new LinearLayoutManager(this));

        SharedPref sharedPref = new SharedPref(Drink.this);
        balance = sharedPref.load();

        NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
        showBalance.setText(nf.format(balance.ammount) + " IDR");

        dataMinuman = new ArrayList<>();

        Drinklist drink1 = new Drinklist("Coca Cola", 12000, R.drawable.cocacola);
        Drinklist drink2 = new Drinklist("Orange Juice", 16000, R.drawable.orangejuice);
        Drinklist drink3 = new Drinklist("Strawberry Juice", 16000, R.drawable.strawberryjuice);
        Drinklist drink4 = new Drinklist("Avocado Juice", 16000, R.drawable.avocadojuice);
        Drinklist drink5 = new Drinklist("Coffee", 18000, R.drawable.coffee);
        Drinklist drink6 = new Drinklist("Lemon Tea", 14000, R.drawable.lemontea);
        Drinklist drink7 = new Drinklist("Thai Tea", 14000, R.drawable.thaitea);
        Drinklist drink8 = new Drinklist("Pearl Milk Tea", 20000, R.drawable.pearlmilktea);
        Drinklist drink9 = new Drinklist("Milo", 12000, R.drawable.milo);
        Drinklist drink10 = new Drinklist("Mineral Water", 10000, R.drawable.mineralwater);

        dataMinuman.add(drink1);
        dataMinuman.add(drink2);
        dataMinuman.add(drink3);
        dataMinuman.add(drink4);
        dataMinuman.add(drink5);
        dataMinuman.add(drink6);
        dataMinuman.add(drink7);
        dataMinuman.add(drink8);
        dataMinuman.add(drink9);
        dataMinuman.add(drink10);


        adapter = new DrinkAdapter(dataMinuman);
        viewDrink.setAdapter(adapter);

        topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent topUp = new Intent(Drink.this, TopUp.class);
                startActivity(topUp);
            }
        });

        myorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myOrder = new Intent(Drink.this, TotalOrder.class);
                startActivity(myOrder);
            }
        });

    }
}