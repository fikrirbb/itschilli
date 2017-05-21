package com.example.fikid.itschilliv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

<<<<<<< HEAD
        if (id == android.R.id.home) {
=======
        if (id == android.R.id.home){
>>>>>>> origin/master
            //end the activity
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}