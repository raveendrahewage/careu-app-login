package com.example.careu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class policeEcomplain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_ecomplain);
    }

    public void cancecl_req(View view) {
        Intent i = new Intent(this,homePageDuplicate.class);
        startActivity(i);
    }
}