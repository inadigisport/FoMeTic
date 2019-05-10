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
    String formationA;
    String formationB;



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

        getTeamData();

    }

    public void getTeamData(){
        TeamDBHandler db = new TeamDBHandler(this);
        Cursor loadDataTeam=db.loaddatareport(teamA);
        //List<String> spinnerArray=new ArrayList<String>();
        loadDataTeam.moveToFirst();
        while (!loadDataTeam.isAfterLast()) {
        formationA = loadDataTeam.getString(2);
        //spinnerArray.add(loadDataTeam.getString(2));
        Log.d("formasi team A ",formationA);
            loadDataTeam.moveToNext();
        }
        //ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, spinnerArray);
       // teamA= findViewById(R.id.spinnerteamA);
        //teamA.setAdapter(arrayAdapter);

        //teamB= findViewById(R.id.spinnerteamB);
        //teamB.setAdapter(arrayAdapter);
    }


}
