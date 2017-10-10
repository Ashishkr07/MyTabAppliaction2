package com.example.ashish.mytabapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by ashish on 2/9/17.
 */

public class NotesActivity extends AppCompatActivity {

    Button b1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notelayout);

        b1 = (Button) findViewById(R.id.notebtn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),NotesfragActivity.class);
                startActivity(i);
            }
        });

    }
}
