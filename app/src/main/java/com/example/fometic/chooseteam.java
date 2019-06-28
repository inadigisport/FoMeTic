package com.example.fometic;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class chooseteam extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner teamA;
    Spinner teamB;
    Spinner formationteama;
    Spinner formationteamb;
    Spinner babak;
    EditText editTextvenue;
    EditText editTextevent;
    EditText editTexttimematch;

    PertandinganDBHandler dbpertandingan=new PertandinganDBHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_chooseteam);
        getTeamData();

        formationteama = findViewById(R.id.spinnerformationteama);
        formationteamb = findViewById(R.id.spinnerformationteamb);
        babak = findViewById(R.id.spinnerbabak);
        editTextvenue = findViewById(R.id.editTextvenue);
        editTextevent = findViewById(R.id.editTextevent);
        editTexttimematch = findViewById(R.id.editTexttimematch);


        Button button = findViewById(R.id.buttonstart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openrecordstat();
            }
        });

    }

    public void getTeamData() {
        TeamDBHandler db = new TeamDBHandler(this);
        Cursor loadDataTeam = db.loaddatateam();
        List<String> spinnerArray = new ArrayList<String>();
        loadDataTeam.moveToFirst();
        while (!loadDataTeam.isAfterLast()) {
            spinnerArray.add(loadDataTeam.getString(1));
            Log.d("Data spinner ", loadDataTeam.getString(1));
            loadDataTeam.moveToNext();
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, spinnerArray);
        teamA = findViewById(R.id.spinnerteamA);
        teamA.setAdapter(arrayAdapter);

        teamB = findViewById(R.id.spinnerteamB);
        teamB.setAdapter(arrayAdapter);
    }

    public void openrecordstat() {
        String namateama="";
        String namateamb="";
        int babakpertandingan=0;
        int babakdata=0;
        Cursor datapertandigan=dbpertandingan.loaddatapertandingan();
        if (babak.getSelectedItem().toString().equals("1sthalf")) {
            babakpertandingan = 1;
        }
        else if (babak.getSelectedItem().toString().equals("2ndhalf")) {
            babakpertandingan = 2;
        }
        else if (babak.getSelectedItem().toString().equals("Ex1sthalf")) {
            babakpertandingan = 3;
        }
        else if (babak.getSelectedItem().toString().equals("Ex2ndhalf")) {
            babakpertandingan = 4;
        }
        if (datapertandigan.moveToFirst()){
            datapertandigan.moveToFirst();
            while (!datapertandigan.isAfterLast()){
                namateama=datapertandigan.getString(1);
                namateamb=datapertandigan.getString(17);
                babakdata=datapertandigan.getInt(33);
                datapertandigan.moveToNext();
            }
            Log.d("babak data=",Integer.toString(babakdata));
            Log.d("babak selected=",Integer.toString(babakpertandingan));
            if (babakpertandingan==1){
                Intent intent = new Intent(this, recordstat.class);
                intent.putExtra("teama", teamA.getSelectedItem().toString());
                Log.d("team A choosen", teamA.getSelectedItem().toString());
                intent.putExtra("teamb", teamB.getSelectedItem().toString());
                Log.d("team B choosen", teamB.getSelectedItem().toString());
                intent.putExtra("formationteama", formationteama.getSelectedItem().toString());
                Log.d("formation team A", formationteama.getSelectedItem().toString());
                intent.putExtra("formationteamb", formationteamb.getSelectedItem().toString());
                Log.d("formation team B", formationteamb.getSelectedItem().toString());
                intent.putExtra("venue", editTextvenue.getText().toString());
                Log.d("venue ", editTextvenue.getText().toString());
                intent.putExtra("event", editTextevent.getText().toString());
                Log.d("venue ", editTextevent.getText().toString());
                intent.putExtra("timematch", editTexttimematch.getText().toString());
                Log.d("timematch ", editTexttimematch.getText().toString());
                intent.putExtra("babak", babak.getSelectedItem().toString());
                Log.d("babak ", babak.getSelectedItem().toString());


                startActivity(intent);
            }
            else if (namateama.equals(teamA.getSelectedItem().toString()) && namateamb.equals(teamB.getSelectedItem().toString()) && babakpertandingan-1==babakdata){
                Intent intent = new Intent(this, recordstat.class);
                intent.putExtra("teama", teamA.getSelectedItem().toString());
                Log.d("team A choosen", teamA.getSelectedItem().toString());
                intent.putExtra("teamb", teamB.getSelectedItem().toString());
                Log.d("team B choosen", teamB.getSelectedItem().toString());
                intent.putExtra("formationteama", formationteama.getSelectedItem().toString());
                Log.d("formation team A", formationteama.getSelectedItem().toString());
                intent.putExtra("formationteamb", formationteamb.getSelectedItem().toString());
                Log.d("formation team B", formationteamb.getSelectedItem().toString());
                intent.putExtra("venue", editTextvenue.getText().toString());
                Log.d("venue ", editTextvenue.getText().toString());
                intent.putExtra("event", editTextevent.getText().toString());
                Log.d("venue ", editTextevent.getText().toString());
                intent.putExtra("timematch", editTexttimematch.getText().toString());
                Log.d("timematch ", editTexttimematch.getText().toString());
                intent.putExtra("babak", babak.getSelectedItem().toString());
                Log.d("babak ", babak.getSelectedItem().toString());


                startActivity(intent);
            } else if (namateamb.equals(teamA.getSelectedItem().toString()) && namateama.equals(teamB.getSelectedItem().toString()) && babakpertandingan-1==babakdata){
                Intent intent = new Intent(this, recordstat.class);
                intent.putExtra("teama", teamA.getSelectedItem().toString());
                Log.d("team A choosen", teamA.getSelectedItem().toString());
                intent.putExtra("teamb", teamB.getSelectedItem().toString());
                Log.d("team B choosen", teamB.getSelectedItem().toString());
                intent.putExtra("formationteama", formationteama.getSelectedItem().toString());
                Log.d("formation team A", formationteama.getSelectedItem().toString());
                intent.putExtra("formationteamb", formationteamb.getSelectedItem().toString());
                Log.d("formation team B", formationteamb.getSelectedItem().toString());
                intent.putExtra("venue", editTextvenue.getText().toString());
                Log.d("venue ", editTextvenue.getText().toString());
                intent.putExtra("event", editTextevent.getText().toString());
                Log.d("venue ", editTextevent.getText().toString());
                intent.putExtra("timematch", editTexttimematch.getText().toString());
                Log.d("timematch ", editTexttimematch.getText().toString());
                intent.putExtra("babak", babak.getSelectedItem().toString());
                Log.d("babak ", babak.getSelectedItem().toString());


                startActivity(intent);
            }else {
                Toast.makeText(chooseteam.this, "Belum ada data babak-"+Integer.valueOf(babakpertandingan-1), Toast.LENGTH_SHORT).show();
            }
        }else{
            if (babakpertandingan==1) {
                Intent intent = new Intent(this, recordstat.class);
                intent.putExtra("teama", teamA.getSelectedItem().toString());
                Log.d("team A choosen", teamA.getSelectedItem().toString());
                intent.putExtra("teamb", teamB.getSelectedItem().toString());
                Log.d("team B choosen", teamB.getSelectedItem().toString());
                intent.putExtra("formationteama", formationteama.getSelectedItem().toString());
                Log.d("formation team A", formationteama.getSelectedItem().toString());
                intent.putExtra("formationteamb", formationteamb.getSelectedItem().toString());
                Log.d("formation team B", formationteamb.getSelectedItem().toString());
                intent.putExtra("venue", editTextvenue.getText().toString());
                Log.d("venue ", editTextvenue.getText().toString());
                intent.putExtra("event", editTextevent.getText().toString());
                Log.d("venue ", editTextevent.getText().toString());
                intent.putExtra("timematch", editTexttimematch.getText().toString());
                Log.d("timematch ", editTexttimematch.getText().toString());
                intent.putExtra("babak", babak.getSelectedItem().toString());
                Log.d("babak ", babak.getSelectedItem().toString());


                startActivity(intent);
            }else{
                Toast.makeText(chooseteam.this, "Belum ada data babak-1", Toast.LENGTH_SHORT).show();
            }
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
