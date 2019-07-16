package com.example.fometic;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class choosegeneratereport extends AppCompatActivity {
    String teamA;
    String teamB;
    ArrayList<String > cetakgoalteama = new ArrayList<>();
    ArrayList<String > cetakgoalteamb = new ArrayList<>();
    ArrayList<String > pertandinganpemainteama = new ArrayList<>();
    ArrayList<String > pertandinganpemainteamb = new ArrayList<>();
    ArrayList<String> namapemain = new ArrayList<>();
    ArrayList<String> nomorpunggungpemain = new ArrayList<>();
    ArrayList<String> posisipemain = new ArrayList<>();
    ArrayList<String> goalpemain = new ArrayList<>();
    ArrayList<String> shootontargetpemain = new ArrayList<>();
    ArrayList<String> shootofftargetpemain = new ArrayList<>();
    ArrayList<String> yellowcardpemain = new ArrayList<>();
    ArrayList<String> redcardpemain = new ArrayList<>();
    ArrayList<String> namapemainb = new ArrayList<>();
    ArrayList<String> nomorpunggungpemainb = new ArrayList<>();
    ArrayList<String> posisipemainb = new ArrayList<>();
    ArrayList<String> goalpemainb = new ArrayList<>();
    ArrayList<String> shootontargetpemainb = new ArrayList<>();
    ArrayList<String> shootofftargetpemainb = new ArrayList<>();
    ArrayList<String> yellowcardpemainb = new ArrayList<>();
    ArrayList<String> redcardpemainb = new ArrayList<>();
    String formationteama;
    String formationteamb;
    String venue;
    String event;
    String tanggal;
    String babakstring;
    int ballpossesionteama;
    int ballpossesionteamb;
    int passingteama;
    int passingteamb;
    int tacklingteama;
    int tacklingteamb;
    int interceptteama;
    int interceptteamb;
    int savesteama;
    int savesteamb;
    int throwinteama;
    int throwinteamb;
    int cornerkickteama;
    int cornerkickteamb;
    int foulteama;
    int foulteamb;
    int offsideteama;
    int offsideteamb;
    int goalteama;
    int goalteamb;
    int shootontargetteama;
    int shootontargetteamb;
    int shootofftargetteama;
    int shootofftargetteamb;
    int yellowcardteama;
    int yellowcardteamb;
    int redcardteama;
    int redcardteamb;
    int babak;
    int idpertandingan;
    ConstraintLayout layout;

    Button buttonteam;
    Button buttonmatch;

    PertandinganDBHandler dbpertandingan=new PertandinganDBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosegeneratereport);
        Button b = null;
        final LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        idpertandingan=getIntent().getIntExtra("idpertandingan",idpertandingan);
        teamA= getIntent().getStringExtra("teama");
        teamB= getIntent().getStringExtra("teamb");
        formationteama= getIntent().getStringExtra("formationteama");
        formationteamb= getIntent().getStringExtra("formationteamb");
        venue= getIntent().getStringExtra("venue");
        event= getIntent().getStringExtra("event");
        tanggal= getIntent().getStringExtra("tanggal");
        babakstring= getIntent().getStringExtra("babakstring");
        ballpossesionteama= getIntent().getIntExtra("ballpossesionteama",ballpossesionteama);
        ballpossesionteamb= getIntent().getIntExtra("ballpossesionteamb",ballpossesionteamb);
        passingteama= getIntent().getIntExtra("passingteama",passingteama);
        passingteamb= getIntent().getIntExtra("passingteamb",passingteamb);
        tacklingteama= getIntent().getIntExtra("tacklingteama",tacklingteama);
        tacklingteamb= getIntent().getIntExtra("tacklingteamb",tacklingteamb);
        interceptteama= getIntent().getIntExtra("interceptteama",interceptteama);
        interceptteamb= getIntent().getIntExtra("interceptteamb",interceptteamb);
        savesteama= getIntent().getIntExtra("savesteama",savesteama);
        savesteamb= getIntent().getIntExtra("savesteamb",savesteamb);
        throwinteama= getIntent().getIntExtra("throwinteama",throwinteama);
        throwinteamb= getIntent().getIntExtra("throwinteamb",throwinteamb);
        cornerkickteama= getIntent().getIntExtra("cornerkickteama",cornerkickteama);
        cornerkickteamb= getIntent().getIntExtra("cornerkickteamb",cornerkickteamb);
        foulteama= getIntent().getIntExtra("foulteama",foulteama);
        foulteamb= getIntent().getIntExtra("foulteamb",foulteamb);
        offsideteama= getIntent().getIntExtra("offsideteama",offsideteama);
        offsideteamb= getIntent().getIntExtra("offsideteamb",offsideteamb);
        goalteama= getIntent().getIntExtra("goalteama",goalteama);
        goalteamb= getIntent().getIntExtra("goalteamb",goalteamb);
        shootontargetteama= getIntent().getIntExtra("shootontargetteama",shootontargetteama);
        shootontargetteamb= getIntent().getIntExtra("shootontargetteamb",shootontargetteamb);
        shootofftargetteama= getIntent().getIntExtra("shootofftargetteama",shootofftargetteama);
        shootofftargetteamb= getIntent().getIntExtra("shootofftargetteamb",shootofftargetteamb);
        yellowcardteama= getIntent().getIntExtra("yellowcardteama",yellowcardteama);
        yellowcardteamb= getIntent().getIntExtra("yellowcardteamb",yellowcardteamb);
        redcardteama= getIntent().getIntExtra("redcardteama",redcardteama);
        redcardteamb= getIntent().getIntExtra("redcardteamb",redcardteamb);
        cetakgoalteama= getIntent().getExtras().getStringArrayList("cetakgoalteama");
        cetakgoalteamb= getIntent().getExtras().getStringArrayList("cetakgoalteamb");
        pertandinganpemainteama= getIntent().getExtras().getStringArrayList("datapertandinganpemainteama");
        pertandinganpemainteamb= getIntent().getExtras().getStringArrayList("datapertandinganpemainteamb");
        namapemain= getIntent().getExtras().getStringArrayList("namapemain");
        posisipemain= getIntent().getExtras().getStringArrayList("posisipemain");
        nomorpunggungpemain= getIntent().getExtras().getStringArrayList("nomorpunggungpemain");
        goalpemain= getIntent().getExtras().getStringArrayList("goalpemain");
        shootontargetpemain= getIntent().getExtras().getStringArrayList("shootontargetpemain");
        shootofftargetpemain= getIntent().getExtras().getStringArrayList("shootofftargetpemain");
        yellowcardpemain= getIntent().getExtras().getStringArrayList("yellowcardpemain");
        redcardpemain= getIntent().getExtras().getStringArrayList("redcardpemain");
        namapemainb= getIntent().getExtras().getStringArrayList("namapemainb");
        posisipemainb= getIntent().getExtras().getStringArrayList("posisipemainb");
        nomorpunggungpemainb= getIntent().getExtras().getStringArrayList("nomorpunggungpemainb");
        goalpemainb= getIntent().getExtras().getStringArrayList("goalpemainb");
        shootontargetpemainb= getIntent().getExtras().getStringArrayList("shootontargetpemainb");
        shootofftargetpemainb= getIntent().getExtras().getStringArrayList("shootofftargetpemainb");
        yellowcardpemainb= getIntent().getExtras().getStringArrayList("yellowcardpemainb");
        redcardpemainb= getIntent().getExtras().getStringArrayList("redcardpemainb");
        babak=getIntent().getIntExtra("babak",babak);
        if (babak==2 || babak ==4){
            View v = inflater.inflate(R.layout.activity_choosegeneratereport, null);
            b = v.findViewById(R.id.buttonfullmatch);
            b.setTag("Fullmatch");
            if(b.getParent()!=null){
                ((ViewGroup)b.getParent()).removeView(b);
            }
            layout=(ConstraintLayout) findViewById(R.id.layoutchoose);
            layout.addView(b);

            b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(choosegeneratereport.this, generatereportfullmatch.class);
                    intent.putExtra("idpertandingan",idpertandingan);
                    intent.putExtra("babak",babak);
                    String babakstringfull = "FullTime";
                    intent.putExtra("babakstring",babakstringfull);
                    intent.putExtra("tanggal", tanggal);

                    startActivity(intent);
                }
            });
        }


        buttonmatch = findViewById(R.id.buttonmatch);
        buttonmatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choosegeneratereport.this, generatereport.class);
                intent.putExtra("teama", teamA);
                intent.putExtra("teamb", teamB);
                intent.putExtra("formationteamb", formationteamb);
                intent.putExtra("formationteama", formationteama);
                intent.putExtra("formationteamb", formationteamb);
                intent.putExtra("venue", venue);
                intent.putExtra("event", event);
                intent.putExtra("babakstring", babakstring);
                intent.putExtra("tanggal", tanggal);
                intent.putExtra("passingteama", passingteama);
                intent.putExtra("passingteamb", passingteamb);
                intent.putExtra("tacklingteama", tacklingteama);
                intent.putExtra("tacklingteamb", tacklingteamb);
                intent.putExtra("interceptteama", interceptteama);
                intent.putExtra("interceptteamb", interceptteamb);
                intent.putExtra("savesteama", savesteama);
                intent.putExtra("savesteamb", savesteamb);
                intent.putExtra("throwinteama", throwinteama);
                intent.putExtra("throwinteamb", throwinteamb);
                intent.putExtra("cornerkickteama", cornerkickteama);
                intent.putExtra("cornerkickteamb", cornerkickteamb);
                intent.putExtra("ballpossesionteama", ballpossesionteama);
                intent.putExtra("ballpossesionteamb", ballpossesionteamb);
                intent.putExtra("foulteama", foulteama);
                intent.putExtra("foulteamb", foulteamb);
                intent.putExtra("offsideteama", offsideteama);
                intent.putExtra("offsideteamb", offsideteamb);
                intent.putExtra("goalteama", goalteama);
                intent.putExtra("goalteamb", goalteamb);
                intent.putExtra("shootontargetteama", shootontargetteama);
                intent.putExtra("shootontargetteamb", shootontargetteamb);
                intent.putExtra("shootofftargetteama", shootofftargetteama);
                intent.putExtra("shootofftargetteamb", shootofftargetteamb);
                intent.putExtra("yellowcardteama", yellowcardteama);
                intent.putExtra("yellowcardteamb", yellowcardteamb);
                intent.putExtra("redcardteama", redcardteama);
                intent.putExtra("redcardteamb", redcardteamb);
                intent.putExtra("ballpossesionteama", ballpossesionteama);
                intent.putExtra("ballpossesionteamb", ballpossesionteamb);
                intent.putStringArrayListExtra("cetakgoalteama", cetakgoalteama);
                intent.putStringArrayListExtra("cetakgoalteamb", cetakgoalteamb);
                startActivity(intent);
            }
        });

        buttonteam = findViewById(R.id.buttonteam);
        buttonteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choosegeneratereport.this, generatereportteam.class);
                intent.putExtra("teama", teamA);
                intent.putExtra("teamb", teamB);
                intent.putExtra("venue", venue);
                intent.putExtra("event", event);
                intent.putExtra("babak", babakstring);
                intent.putExtra("tanggal", tanggal);
                intent.putStringArrayListExtra("datapertandinganpemainteama", pertandinganpemainteama);
                intent.putStringArrayListExtra("datapertandinganpemainteamb", pertandinganpemainteamb);
                intent.putStringArrayListExtra("namapemain", namapemain);
                intent.putStringArrayListExtra("posisipemain", posisipemain);
                intent.putStringArrayListExtra("nomorpunggungpemain", nomorpunggungpemain);
                intent.putStringArrayListExtra("goalpemain", goalpemain);
                intent.putStringArrayListExtra("shootontargetpemain", shootontargetpemain);
                intent.putStringArrayListExtra("shootofftargetpemain", shootofftargetpemain);
                intent.putStringArrayListExtra("yellowcardpemain", yellowcardpemain);
                intent.putStringArrayListExtra("redcardpemain", redcardpemain);
                intent.putStringArrayListExtra("namapemainb", namapemainb);
                intent.putStringArrayListExtra("posisipemainb", posisipemainb);
                intent.putStringArrayListExtra("nomorpunggungpemainb", nomorpunggungpemainb);
                intent.putStringArrayListExtra("goalpemainb", goalpemainb);
                intent.putStringArrayListExtra("shootontargetpemainb", shootontargetpemainb);
                intent.putStringArrayListExtra("shootofftargetpemainb", shootofftargetpemainb);
                intent.putStringArrayListExtra("yellowcardpemainb", yellowcardpemainb);
                intent.putStringArrayListExtra("redcardpemainb", redcardpemainb);
                startActivity(intent);
            }
        });


    }
}
