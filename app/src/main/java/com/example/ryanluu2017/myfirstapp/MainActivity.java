package com.example.ryanluu2017.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements Serializable {

    private ArrayList foodItems;
    private TextView itemTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Method called when the addItem button is clicked
    public void onAddItem(View v){


    }

    // Method called when the viewList button is clicked
    public void onViewListClick(View v){


    }



}
