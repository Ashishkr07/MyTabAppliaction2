package com.example.ashish.mytabapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ashish on 1/8/17.
 */

public class CreateEventActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText editName,editDate,editDetails;
    Button button;
    Animation back;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createeventlayout);
        databaseHelper = new DatabaseHelper(this);

        editDate = (EditText) findViewById(R.id.editDate);
        editName = (EditText) findViewById(R.id.editName);
        editDetails = (EditText) findViewById(R.id.editDetails);
        button = (Button) findViewById(R.id.createButton);


        Intent incomingIntent = getIntent();
        String date = incomingIntent.getStringExtra("date");
        editDate.setText(date);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = databaseHelper.insertData(editName.getText().toString(),editDate.getText().toString(),editDetails.getText().toString());

                if(isInserted == true){
                    Toast.makeText(getBaseContext(),"Event Created",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getBaseContext(),"Please try again",Toast.LENGTH_SHORT).show();
                }
            }});






    }

}
