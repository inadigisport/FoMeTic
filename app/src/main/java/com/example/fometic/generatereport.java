package com.example.fometic;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class generatereport extends AppCompatActivity {

    String teamA;
    String teamB;
    TextView textviewteama;
    TextView textviewteamb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generatereport);
        teamA= getIntent().getStringExtra("teama");
        teamB= getIntent().getStringExtra("teamb");
        textviewteama=findViewById(R.id.textViewteama);
        textviewteama.setText(teamA);
        textviewteamb=findViewById(R.id.textViewteamb);
        textviewteamb.setText(teamB);

    }

}
