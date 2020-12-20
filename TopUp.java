package com.example.binusezyfoody_2201808863;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class TopUp extends AppCompatActivity {

    int addBalance;
    Button btnCancel, btnAdd;
    TextView showBalance;
    EditText inputBalance;
    Balance balance;
    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        btnCancel = findViewById(R.id.btn_cancelTopUp);
        btnAdd = findViewById(R.id.btn_addBalance);
        showBalance = findViewById(R.id.balance);
        inputBalance = findViewById(R.id.addBalance);

        sharedPref = new SharedPref(TopUp.this);
        balance = sharedPref.load();

        NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
        showBalance.setText(nf.format(balance.ammount) + " IDR");

        addBalance = 0;


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(i);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBalance = Integer.parseInt(inputBalance.getText().toString());

                if(addBalance < 100000){
                    Toast.makeText(getApplicationContext(), "You need to top up at least 100.000 IDR.", Toast.LENGTH_SHORT).show();
                }

                else if(addBalance > 1000000){
                    Toast.makeText(getApplicationContext(), "You need to top up smaller than 1.000.000 IDR.", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(getApplicationContext(), "Top Up Successful.", Toast.LENGTH_SHORT).show();
                    balance.ammount += addBalance;
                    sharedPref.save(balance);
                    Intent i = new Intent(v.getContext(), MainActivity.class);

                    v.getContext().startActivity(i);
                }

            }
        });
    }
}