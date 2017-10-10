package com.example.ashish.mytabapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ashish on 2/8/17.
 */

public class RecyclerFragment extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private DatabaseHelper databaseHelper;
    private ArrayList<Item> arrayList = new ArrayList<>();




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerlayout);
        databaseHelper = new DatabaseHelper(this);



        Cursor res = databaseHelper.getallData();
        if (res.getCount() == 0) {
            Toast.makeText(getBaseContext(), "No Event Created", Toast.LENGTH_SHORT).show();
        } else {
            while (res.moveToNext()) {
                arrayList.add(new Item(res.getString(1), res.getString(2), res.getString(3)));
            }

        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new RecyclerAdapter(arrayList,this);
        recyclerView.setAdapter(recyclerAdapter);




    }
}



