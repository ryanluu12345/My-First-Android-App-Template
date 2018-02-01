package com.example.ryanluu2017.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ViewListActivity extends AppCompatActivity {

    private ArrayList<String> groceryList;
    private ArrayAdapter<String> groceryListAdapter;
    private ListView groceryListLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        Intent getMainIntent = getIntent();
        this.groceryList = getMainIntent.getStringArrayListExtra("groceryList");

        //Call method to set list view
        setGroceryListView();
    }

    // Method that adds the grocery list to the main page
    private void setGroceryListView(){

        //Creates the array adapter and populates with the ArrayList
        groceryListAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,this.groceryList);

        //Obtain the list view
        groceryListLv=(ListView) findViewById(R.id.groceryListView);

        //Connect the list view to the array adapter
        groceryListLv.setAdapter(groceryListAdapter);


    }

    public void onSendMessage(View v){

        //Joins the items in an easy to read list for the person we will be sending it to
        String message="Hello, we will need these items from the store: \n";
        for (String item:this.groceryList){
            message=message+item+"\n";
        }

        //Starts an intent to the short messaging system of your phone (similar to other intents)
        Intent messageIntent=new Intent(Intent.ACTION_VIEW);
        messageIntent.putExtra("sms_body",message);
        messageIntent.setType("vnd.android-dir/mms-sms");
        startActivity(messageIntent);


    }

}
