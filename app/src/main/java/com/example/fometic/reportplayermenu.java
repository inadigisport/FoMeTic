package com.example.fometic;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class reportplayermenu extends AppCompatActivity {

    Spinner spinnerteamstat;
    Spinner spinnerplayerstat;
    Button buttonsubmitplayerstat;

    PemainBola datapemain= new PemainBola();
    PemainDBHandler dbpemain=new PemainDBHandler(this);
    TeamDBHandler dbteam = new TeamDBHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportplayermenu);
        spinnerteamstat=findViewById(R.id.spinnerTeamstat);
        spinnerplayerstat=findViewById(R.id.spinnerPlayerstat);
        buttonsubmitplayerstat=findViewById(R.id.buttonSubmitplayerstat);

        buttonsubmitplayerstat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                


                Intent intent = new Intent( reportplayermenu.this, reportplayer.class);
                startActivity(intent);
            }
        });

        getTeamData();

        spinnerteamstat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getPlayerData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }

    public void getTeamData(){
        TeamDBHandler db = new TeamDBHandler(this);
        Cursor loadDataTeam=db.loaddatateam();
        List<String> spinnerArray=new ArrayList<String>();
        loadDataTeam.moveToFirst();
        while (!loadDataTeam.isAfterLast()) {
            spinnerArray.add(loadDataTeam.getString(1));
            Log.d("Data spinner ",loadDataTeam.getString(1));
            loadDataTeam.moveToNext();
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, spinnerArray);
        spinnerteamstat.setAdapter(arrayAdapter);
    }

    public void getPlayerData(){
        Cursor datapemain = dbpemain.loaddatateam(spinnerteamstat.getSelectedItem().toString());
        List<String> listpemain = new ArrayList<String>();
        datapemain.moveToFirst();
        while (!datapemain.isAfterLast()) {
            listpemain.add(datapemain.getString(1)+", "+datapemain.getString(4)+" : "+datapemain.getString(3) );
            datapemain.moveToNext();
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, listpemain);
        spinnerplayerstat.setAdapter(arrayAdapter);
    }
}
