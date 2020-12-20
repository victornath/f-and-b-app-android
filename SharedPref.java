package com.example.binusezyfoody_2201808863;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharedPref {

    private SharedPreferences sharedPref;

    public SharedPref(Context context){
        sharedPref = context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
    }

    public void save(Balance balance){
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putInt("Current Balance", balance.ammount);

        editor.apply();
    }

    public Balance load(){
        Balance balance = new Balance();

        balance.ammount = sharedPref.getInt("Current Balance", 0);

        return balance;
    }


    public static void writeListInPref(Context context, ArrayList<TotalOrderlist> dataPayment){
        Gson gson = new Gson();
        String jsonString = gson.toJson(dataPayment);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("List Key", jsonString);
        editor.apply();

    }

    public static ArrayList<TotalOrderlist> readListFromPref (Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString("List Key", "");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<TotalOrderlist>>() {}.getType();
        ArrayList<TotalOrderlist> list = gson.fromJson(jsonString, type);
        return list;
    }


}
