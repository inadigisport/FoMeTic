package com.example.fometic;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.HashMap;

public class generatereportfullmatch extends AppCompatActivity {

    TextView textviewteama;
    TextView textviewteamb;
    TextView textviewformationa;
    TextView textviewformationb;
    TextView textViewballpossesionteama;
    TextView textViewballpossesionteamb;
    TextView textViewpassingteama;
    TextView textViewpassingteamb;
    TextView textViewtacklingteama;
    TextView textViewtacklingteamb;
    TextView textViewinterceptteama;
    TextView textViewinterceptteamb;
    TextView textViewsavesteama;
    TextView textViewsavesteamb;
    TextView textViewthrowinteama;
    TextView textViewthrowinteamb;
    TextView textViewcornerkickteama;
    TextView textViewcornerkickteamb;
    TextView textViewfoulteama;
    TextView textViewfoulteamb;
    TextView textViewoffsideteama;
    TextView textViewoffsideteamb;
    TextView textViewgoalteama;
    TextView textViewgoalteamb;
    TextView textViewshootontargetteama;
    TextView textViewshootontargetteamb;
    TextView textViewshootofftargetteama;
    TextView textViewshootofftargetteamb;
    TextView textViewyellowcardteama;
    TextView textViewyellowcardteamb;
    TextView textViewredcardteama;
    TextView textViewredcardteamb;
    TextView textViewlistpemaingoalteama;
    TextView textViewlistpemaingoalteamb;
    TextView textViewvenue;
    TextView textViewevent;
    TextView textViewtanggal;
    TextView textViewbabak;

    String ballpossesionteama;
    String ballpossesionteamb;
    String passingteama;
    String passingteamb;
    String tacklingteama;
    String tacklingteamb;
    String interceptteama;
    String interceptteamb;
    String savesteama;
    String savesteamb;
    String throwinteama;
    String throwinteamb;
    String cornerkickteama;
    String cornerkickteamb;
    String foulteama;
    String foulteamb;
    String offsideteama;
    String offsideteamb;
    String goalteama;
    String goalteamb;
    String shootontargetteama;
    String shootontargetteamb;
    String shootofftargetteama;
    String shootofftargetteamb;
    String yellowcardteama;
    String yellowcardteamb;
    String redcardteama;
    String redcardteamb;
    String timematch;
    String namateama;
    String namateamb;
    String formationteama;
    String formationteamb;
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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_generatereport);
        idpertandingan = getIntent().getIntExtra("idpertandingan", idpertandingan);
        babakint = getIntent().getIntExtra("babak", babakint);
        babakstring= getIntent().getStringExtra("babakstring");
        tanggal= getIntent().getStringExtra("tanggal");
        HashMap<String, String> data = dbpertandingan.loaddatafullmatch(idpertandingan, babakint);
        namateama = data.get("namateama");
        namateamb = data.get("namateamb");
        formationteama = data.get("formasiteama");
        formationteamb = data.get("formasiteamb");
        venue = data.get("venue");
        event = data.get("event");
        //tanggal = data.get("tanggal");
        formationteama = data.get("formasiteama");
        formationteamb = data.get("formasiteamb");
        ballpossesionteama = data.get("ballposessionteama");
        ballpossesionteamb = data.get("ballposessionteamb");
        passingteama = data.get("passingteama");
        passingteamb = data.get("passingteamb");
        tacklingteama = data.get("tacklingteama");
        tacklingteamb = data.get("tacklingteamb");
        interceptteama = data.get("interceptteama");
        interceptteamb = data.get("interceptteamb");
        savesteama = data.get("savesteama");
        savesteamb = data.get("savesteamb");
        throwinteama = data.get("throwinteama");
        throwinteamb = data.get("throwinteamb");
        cornerkickteama = data.get("cornerkickteama");
        cornerkickteamb = data.get("cornerkickteamb");
        foulteama = data.get("foulteama");
        foulteamb = data.get("foulteamb");
        offsideteama = data.get("offsideteama");
        offsideteamb = data.get("offsideteamb");
        goalteama = data.get("goalteama");
        goalteamb = data.get("goalteamb");
        shootontargetteama = data.get("shotontargetteama");
        shootontargetteamb = data.get("shotontargetteamb");
        shootofftargetteama = data.get("shotofftargetteama");
        shootofftargetteamb = data.get("shotofftargetteamb");
        yellowcardteama = data.get("yellowcardteama");
        yellowcardteamb = data.get("yellowcardteamb");
        redcardteama = data.get("redcardteama");
        redcardteamb = data.get("redcardteamb");
        //Cursor goalpemainteama = dbgoal.loaddatagoalbabakdua(String.valueOf(idpertandingan), String.valueOf(dbteam.loaddataidteam(String.valueOf(namateama))));
        //goalpemainteama.moveToFirst();
        //while (!goalpemainteama.isAfterLast()) {
          //  if (!goalpemainteama.getString(4).equals("(OG)")) {
            //    listgoalpemainteama += dbpemain.loadnamapemain(goalpemainteama.getInt(2)) + " '" + goalpemainteama.getString(3) + goalpemainteama.getString(4) + System.getProperty("line.separator");
           // }
            //goalpemainteama.moveToNext();
        //}

          //  Cursor goalpemainteamb = dbgoal.loaddatagoalbabakdua(String.valueOf(idpertandingan), String.valueOf(dbteam.loaddataidteam(String.valueOf(namateamb))));
        //goalpemainteamb.moveToFirst();
        //while (!goalpemainteamb.isAfterLast()) {
          //  if (!goalpemainteamb.getString(4).equals("(OG)")) {
            //    listgoalpemainteamb += dbpemain.loadnamapemain(goalpemainteamb.getInt(2)) + " '" + goalpemainteamb.getString(3) + goalpemainteamb.getString(4) + System.getProperty("line.separator");
            //}
            //goalpemainteamb.moveToNext();
        //}

        //goalpemainteamb.moveToFirst();
        //while (!goalpemainteamb.isAfterLast()) {
        //    if (goalpemainteamb.getString(4).equals("(OG)")) {
        //        listgoalpemainteama += dbpemain.loadnamapemain(goalpemainteamb.getInt(2)) + " '" + goalpemainteamb.getString(3) + goalpemainteamb.getString(4) + System.getProperty("line.separator");
        //    }
        //    goalpemainteamb.moveToNext();
        //}

        //goalpemainteama.moveToFirst();
        //while (!goalpemainteama.isAfterLast()) {
          //  if (goalpemainteama.getString(4).equals("(OG)")) {
            //    listgoalpemainteamb += dbpemain.loadnamapemain(goalpemainteama.getInt(2)) + " '" + goalpemainteama.getString(3) + goalpemainteama.getString(4) + System.getProperty("line.separator");
            //}
            //goalpemainteama.moveToNext();
        //}


        textViewballpossesionteama=findViewById(R.id.textViewballpossesionteama);
        textViewballpossesionteamb=findViewById(R.id.textViewballpossesionteamb);
        textViewballpossesionteama.setText(ballpossesionteama);
        textViewballpossesionteamb.setText(ballpossesionteamb);
        textViewpassingteama=findViewById(R.id.textViewpassingteama);
        textViewpassingteamb=findViewById(R.id.textViewpassingteamb);
        textViewpassingteama.setText(passingteama);
        textViewpassingteamb.setText(passingteamb);
        textViewtacklingteama=findViewById(R.id.textViewtacklingteama);
        textViewtacklingteamb=findViewById(R.id.textViewtacklingteamb);
        textViewtacklingteama.setText(tacklingteama);
        textViewtacklingteamb.setText(tacklingteamb);
        textViewinterceptteama=findViewById(R.id.textViewinterceptteama);
        textViewinterceptteamb=findViewById(R.id.textViewinterceptteamb);
        textViewinterceptteama.setText(interceptteama);
        textViewinterceptteamb.setText(interceptteamb);
        textViewsavesteama=findViewById(R.id.textViewsavesteama);
        textViewsavesteamb=findViewById(R.id.textViewsavesteamb);
        textViewsavesteama.setText(savesteama);
        textViewsavesteamb.setText(savesteamb);
        textViewcornerkickteama=findViewById(R.id.textViewcornerkickteama);
        textViewcornerkickteamb=findViewById(R.id.textViewcornerkickteamb);
        textViewcornerkickteama.setText(cornerkickteama);
        textViewcornerkickteamb.setText(cornerkickteamb);
        textViewfoulteama=findViewById(R.id.textViewfoulteama);
        textViewfoulteamb=findViewById(R.id.textViewfoulteamb);
        textViewfoulteama.setText(foulteama);
        textViewfoulteamb.setText(foulteamb);
        textViewoffsideteama=findViewById(R.id.textViewoffsideteama);
        textViewoffsideteamb=findViewById(R.id.textViewoffsideteamb);
        textViewoffsideteama.setText(offsideteama);
        textViewoffsideteamb.setText(offsideteamb);
        textViewgoalteama=findViewById(R.id.textViewgoalteama2);
        textViewgoalteamb=findViewById(R.id.textViewgoalteamb);
        textViewgoalteama.setText(goalteama);
        textViewgoalteamb.setText(goalteamb);
        textViewshootontargetteama=findViewById(R.id.textViewshootontargetteama);
        textViewshootontargetteamb=findViewById(R.id.textViewshootontargetteamb);
        textViewshootontargetteama.setText(shootontargetteama);
        textViewshootontargetteamb.setText(shootontargetteamb);
        textViewshootofftargetteama=findViewById(R.id.textViewshootofftargetteama);
        textViewshootofftargetteamb=findViewById(R.id.textViewshootofftargetteamb);
        textViewshootofftargetteama.setText(shootofftargetteama);
        textViewshootofftargetteamb.setText(shootofftargetteamb);
        textViewyellowcardteama=findViewById(R.id.textViewyellowcardteama);
        textViewyellowcardteamb=findViewById(R.id.textViewyellowcardteamb);
        textViewyellowcardteama.setText(yellowcardteama);
        textViewyellowcardteamb.setText(yellowcardteamb);
        textViewredcardteama=findViewById(R.id.textViewredcardteama);
        textViewredcardteamb=findViewById(R.id.textViewredcardteamb);
        textViewredcardteama.setText(redcardteama);
        textViewredcardteamb.setText(redcardteamb);
        //textViewlistpemaingoalteama=findViewById(R.id.textViewlistpemaingoalteama);
        //textViewlistpemaingoalteama.setText(listgoalpemainteama);
        //textViewlistpemaingoalteamb=findViewById(R.id.textViewlistpemaingoalteamb);
        //textViewlistpemaingoalteamb.setText(listgoalpemainteamb);
        textViewtanggal = findViewById(R.id.textViewtanggal);
        textViewtanggal.setText(tanggal);
        textViewbabak = findViewById(R.id.textViewbabak);
        textViewbabak.setText(babakstring);
        textViewvenue=findViewById(R.id.textViewvenue);
        textViewvenue.setText(venue);
        textViewevent=findViewById(R.id.textViewevent);
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
