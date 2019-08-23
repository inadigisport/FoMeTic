package com.example.fometic;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class generatereportfullresult extends AppCompatActivity {

    TextView textviewteama;
    TextView textviewteamb;

    TextView textViewgoalteama;
    TextView textViewgoalteamb;

    TextView textViewlistpemaingoalteama;
    TextView textViewlistpemaingoalteamb;
    TextView textViewvenue;
    TextView textViewevent;
    TextView textViewtanggal;
    TextView textViewbabak;


    String goalteama;
    String goalteamb;

    String namateama;
    String namateamb;

    String venue;
    String event;
    String tanggal;
    String babakstring;
    int idpertandingan;
    int babakint;
    String listgoalpemainteama="";
    String listgoalpemainteamb="";

    PertandinganDBHandler dbpertandingan=new PertandinganDBHandler(this);
    TeamDBHandler dbteam=new TeamDBHandler(this);
    goalDBHandler dbgoal=new goalDBHandler(this);
    PemainDBHandler dbpemain=new PemainDBHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        idpertandingan = getIntent().getIntExtra("idpertandingan", idpertandingan);
        babakint = getIntent().getIntExtra("babak", babakint);
        babakstring= getIntent().getStringExtra("babakstring");
        tanggal= getIntent().getStringExtra("tanggal");
        HashMap<String, String> data = dbpertandingan.loaddatafullmatch(idpertandingan, babakint);
        namateama = data.get("namateama");
        namateamb = data.get("namateamb");
        venue = data.get("venue");
        event = data.get("event");
        //tanggal = data.get("tanggal");


        goalteama = data.get("goalteama");
        goalteamb = data.get("goalteamb");

        Cursor goalpemainteama = dbgoal.loaddatagoalbabakdua(String.valueOf(idpertandingan), String.valueOf(dbteam.loaddataidteam(String.valueOf(namateama))));
        goalpemainteama.moveToFirst();
        while (!goalpemainteama.isAfterLast()) {
          if (!goalpemainteama.getString(4).equals("(OG)")) {
            listgoalpemainteama += dbpemain.loadnamapemain(goalpemainteama.getInt(2)) + " '" + goalpemainteama.getString(3) + goalpemainteama.getString(4) + System.getProperty("line.separator");
         }
        goalpemainteama.moveToNext();
        }

        Cursor goalpemainteamb = dbgoal.loaddatagoalbabakdua(String.valueOf(idpertandingan), String.valueOf(dbteam.loaddataidteam(String.valueOf(namateamb))));
        goalpemainteamb.moveToFirst();
        while (!goalpemainteamb.isAfterLast()) {
          if (!goalpemainteamb.getString(4).equals("(OG)")) {
            listgoalpemainteamb += dbpemain.loadnamapemain(goalpemainteamb.getInt(2)) + " '" + goalpemainteamb.getString(3) + goalpemainteamb.getString(4) + System.getProperty("line.separator");
        }
        goalpemainteamb.moveToNext();
        }

        goalpemainteamb.moveToFirst();
        while (!goalpemainteamb.isAfterLast()) {
            if (goalpemainteamb.getString(4).equals("(OG)")) {
                listgoalpemainteama += dbpemain.loadnamapemain(goalpemainteamb.getInt(2)) + " '" + goalpemainteamb.getString(3) + goalpemainteamb.getString(4) + System.getProperty("line.separator");
            }
            goalpemainteamb.moveToNext();
        }

        goalpemainteama.moveToFirst();
        while (!goalpemainteama.isAfterLast()) {
          if (goalpemainteama.getString(4).equals("(OG)")) {
            listgoalpemainteamb += dbpemain.loadnamapemain(goalpemainteama.getInt(2)) + " '" + goalpemainteama.getString(3) + goalpemainteama.getString(4) + System.getProperty("line.separator");
        }
        goalpemainteama.moveToNext();
        }



        textViewgoalteama=findViewById(R.id.textViewgoalteama2);
        textViewgoalteamb=findViewById(R.id.textViewgoalteamb);
        textViewgoalteama.setText(goalteama);
        textViewgoalteamb.setText(goalteamb);

        textViewlistpemaingoalteama=findViewById(R.id.textViewlistpemaingoalteama);
        textViewlistpemaingoalteama.setText(listgoalpemainteama);
        textViewlistpemaingoalteamb=findViewById(R.id.textViewlistpemaingoalteamb);
        textViewlistpemaingoalteamb.setText(listgoalpemainteamb);
        textViewtanggal = findViewById(R.id.textViewtanggal2);
        textViewtanggal.setText(tanggal);
        textViewbabak = findViewById(R.id.textViewbabak2);
        textViewbabak.setText(babakstring);
        textViewvenue=findViewById(R.id.textViewvenue2);
        textViewvenue.setText(venue);
        textViewevent=findViewById(R.id.textViewevent2);
        textViewevent.setText(event);
        // textviewformationa=findViewById(R.id.textViewformationA);
        // textviewformationb=findViewById(R.id.textViewformationB);
        // textviewformationa.setText(formationteama);
        //textviewformationb.setText(formationteamb);
        textviewteama=findViewById(R.id.textViewteama);
        textviewteama.setText(namateama);
        textviewteamb=findViewById(R.id.textViewteamb);
        textviewteamb.setText(namateamb);

    }
}



