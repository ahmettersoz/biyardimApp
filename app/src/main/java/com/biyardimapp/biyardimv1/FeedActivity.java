package com.biyardimapp.biyardimv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
    }



    public void yardimAl(View view){
        Intent intent = new Intent(getApplicationContext(), YardimAlActivity.class);
        startActivity(intent);

    }

    public void yardimEt(View view){
        Intent intent = new Intent(getApplicationContext(), YardimlarActivity.class);
        startActivity(intent);


    }














}
