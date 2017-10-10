package com.example.ashish.mytabapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ashish on 2/8/17.
 */

public  class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{


    List<Item> arrayList = Collections.emptyList();
    Activity activity;


    public RecyclerAdapter(List<Item> arrayList, Activity activity) {
        this.arrayList = arrayList;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        LayoutInflater l = LayoutInflater.from(activity);
        v = l.inflate(R.layout.single_text_input, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Item i = arrayList.get(position);
        holder.name.setText(i.getName());
        holder.date.setText(i.getDate());
        holder.details.setText(i.getDetails());

        holder.date.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                final AlertDialog.Builder nbuiler = new AlertDialog.Builder(activity).setTitle("Are you sure you wat to delete it?");
                View mview = View.inflate(activity,R.layout.onlondclicklayout,null);
                Button yesbtn = mview.findViewById(R.id.yesbtn);
                Button nobtn = mview.findViewById(R.id.nobtn);

                nbuiler.setView(mview);
                final AlertDialog alertDialog = nbuiler.create();
                alertDialog.show();

                yesbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatabaseHelper databaseHelper = new DatabaseHelper(activity);
                        int isDeleted = databaseHelper.deleteData(i.getName());
                        if(isDeleted >0){
                            Toast.makeText(activity,"Event Deleted",Toast.LENGTH_SHORT).show();
                            alertDialog.dismiss();
                            activity.startActivity(new Intent(activity,MainActivity.class));

                        }
                    }
                });

                nobtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                         alertDialog.dismiss();
                    }
                });


                return true;
            }
        });

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public  class ViewHolder extends RecyclerView.ViewHolder  {
        TextView name,date,details;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textname);
            date = (TextView) itemView.findViewById(R.id.textviewdate);
            details = (TextView) itemView.findViewById(R.id.textviewdetails);


        }



    }



}

