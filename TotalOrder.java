package com.example.binusezyfoody_2201808863;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class TotalOrder extends AppCompatActivity {

    int totalorderprice, remain;
    ArrayList<TotalOrderlist> dataPayment;
    TotalOrderAdapter adapter;
    RecyclerView viewTotalOrder;
    Button topup, payNow;
    TextView totalPrice, currentBalance, remainingBalance;
    Balance balance;
    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_order);

        topup = findViewById(R.id.btn_topUp);
        payNow = findViewById(R.id.btn_payNow);

        totalPrice = findViewById(R.id.totalorderprice);
        currentBalance = findViewById(R.id.currentbalance);
        remainingBalance = findViewById(R.id.remainingbalance);

        viewTotalOrder = findViewById(R.id.list_of_myorder);
        viewTotalOrder.setLayoutManager(new LinearLayoutManager(this));

        sharedPref = new SharedPref(TotalOrder.this);
        balance = sharedPref.load();

        NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
        currentBalance.setText("Balance : " + nf.format(balance.ammount) + " IDR");

        dataPayment = SharedPref.readListFromPref(this);

        if(dataPayment == null){ dataPayment = new ArrayList<>();}

        adapter = new TotalOrderAdapter(dataPayment);
        viewTotalOrder.setAdapter(adapter);

        int image = getIntent().getIntExtra("Image",0);
        String name = getIntent().getStringExtra("Name");
        int price = getIntent().getIntExtra("Price",0);
        int quantity = getIntent().getIntExtra("Quantity",0);

        dataPayment.add(new TotalOrderlist(name,price,quantity,image));

        SharedPref.writeListInPref(this, dataPayment);

        totalorderprice = 0;

        remain = 0;

        for(int i=0; i<dataPayment.size(); i++){
            totalorderprice = totalorderprice + (price * quantity);
        }

        remain = balance.ammount - totalorderprice;

        totalPrice.setText("Total : " + nf.format(totalorderprice) + " IDR");
        remainingBalance.setText("Remaining  : " + nf.format(remain) + " IDR");


        if(remain < 0){
            payNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "You Need To Top Up Your Balance.", Toast.LENGTH_SHORT).show();
                }
            });
        }

        else{
            payNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    balance.ammount = remain;
                    sharedPref.save(balance);
                    Intent i = new Intent(TotalOrder.this, MainActivity.class);
                    startActivity(i);

                }
            });
        }

        topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent topUp = new Intent(TotalOrder.this, TopUp.class);
                startActivity(topUp);
            }
        });


    }
}