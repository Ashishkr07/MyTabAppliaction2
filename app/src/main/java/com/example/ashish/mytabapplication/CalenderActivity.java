package com.example.ashish.mytabapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CalendarView;

/**
 * Created by ashish on 1/8/17.
 */

public class CalenderActivity extends AppCompatActivity {


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calenderlayout);
        CalendarView calendarView = (CalendarView) findViewById(R.id.calender);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = (i2 + "/" + (i1+1) + "/" + i);
                Log.d("Date - ",date);
                Intent intent = new Intent(CalenderActivity.this,CreateEventActivity.class);
                intent.putExtra("date",date);
                startActivity(intent);
            }
        });
    }
}
