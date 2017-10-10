package com.example.ashish.mytabapplication;

/**
 * Created by ashish on 2/8/17.
 */

public class Item {
    String name,date,details;

    public Item(String name, String date, String details) {
        this.name = name;
        this.date = date;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
