package com.example.ashish.mytabapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ashish on 1/8/17.
 */

public class ShowPrevActivity extends AppCompatActivity{

    DatabaseHelper databaseHelper;
    TextView textName;
    EditText deletenum;

    Button button;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showprevlayout);
        databaseHelper = new DatabaseHelper(this);

        textName = (TextView) findViewById(R.id.textviewPrevName);
        button = (Button) findViewById(R.id.deletebtn);

        Cursor res = databaseHelper.getallData();
        if(res.getCount() == 0){
            Toast.makeText(getBaseContext(),"No Event Created",Toast.LENGTH_SHORT).show();
        }
        else{
            StringBuffer stringBuffer = new StringBuffer();
            while(res.moveToNext()){
                stringBuffer.append(res.getString(1) + "\n");
                stringBuffer.append(res.getString(2) + "\n");
                stringBuffer.append(res.getString(3) + "\n");
                stringBuffer.append("\n");
                stringBuffer.append("\n");
            }
            textName.setText(stringBuffer.toString());
        }



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mbuider = new AlertDialog.Builder(ShowPrevActivity.this).setTitle("Enter The Name");
                View mview = getLayoutInflater().inflate(R.layout.customlayout,null);
                final EditText editTextno =(EditText) mview.findViewById(R.id.editTextno);
                Button deletenum =(Button) mview.findViewById(R.id.deletenum);

                deletenum.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!editTextno.getText().toString().isEmpty()){
                            int isDeleted = databaseHelper.deleteData(editTextno.getText().toString());
                            if(isDeleted > 0){
                                Toast.makeText(getBaseContext(),"Event deleted",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getBaseContext(),MainActivity.class));
                            }else {
                                Toast.makeText(getBaseContext(), "Enter the name correctly", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getBaseContext(),"Enter The Name",Toast.LENGTH_SHORT).show();
                            editTextno.setText("");
                        }

                    }
                });


                mbuider.setView(mview);
                AlertDialog alertDialog = mbuider.create();
                alertDialog.show();


            }
        });
   }
}
