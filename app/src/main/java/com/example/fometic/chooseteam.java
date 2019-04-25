package com.example.fometic;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class chooseteam extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseteam);
        getTeamData();

        Button button=findViewById(R.id.buttonstart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openrecordstat();
            }
        });

    }

    public void getTeamData(){
        MyDBHandler db = new MyDBHandler(this);
        Cursor loadDataTeam=db.loadHandler();
        List<String> spinnerArray=new ArrayList<String>();
        loadDataTeam.moveToFirst();
        while (!loadDataTeam.isAfterLast()) {
            spinnerArray.add(loadDataTeam.getString(1));
            Log.d("Data spinner ",loadDataTeam.getString(1));
            loadDataTeam.moveToNext();
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, spinnerArray);
        Spinner teamA= findViewById(R.id.spinnerteamA);
        teamA.setAdapter(arrayAdapter);

        Spinner teamB= findViewById(R.id.spinnerteamB);
        teamB.setAdapter(arrayAdapter);
    }

    public void openrecordstat() {
        Intent intent = new Intent(this, recordstat.class);
        startActivity(intent);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {}

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
