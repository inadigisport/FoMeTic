package com.example.fometic;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class MatchResult extends AppCompatActivity {

    String teamA;
    String teamB;
    TextView textviewteama;
    TextView textviewteamb;

    TextView textViewlistpemaingoalteama;
    TextView textViewlistpemaingoalteamb;
    TextView textViewvenue;
    TextView textViewevent;
    TextView textViewtanggal;
    TextView textViewbabak;
    TextView textViewgoalteama;
    TextView textViewgoalteamb;
    ArrayList<String > cetakgoalteama = new ArrayList<>();
    ArrayList<String > cetakgoalteamb = new ArrayList<>();



    String formationteama;
    String formationteamb;
    String venue;
    String event;
    String tanggal;
    String babakstring;


    int goalteama;
    int goalteamb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        teamA= getIntent().getStringExtra("teama");
        teamB= getIntent().getStringExtra("teamb");
        formationteama= getIntent().getStringExtra("formationteama");
        formationteamb= getIntent().getStringExtra("formationteamb");
        venue= getIntent().getStringExtra("venue");
        event= getIntent().getStringExtra("event");
        babakstring= getIntent().getStringExtra("babakstring");
        tanggal= getIntent().getStringExtra("tanggal");
        Log.d("venue", venue);
        textviewteama=findViewById(R.id.textViewteama);
        textviewteama.setText(teamA);
        textviewteamb=findViewById(R.id.textViewteamb);
        textviewteamb.setText(teamB);
        textViewvenue=findViewById(R.id.textViewvenue2);
        textViewvenue.setText(venue);
        textViewevent=findViewById(R.id.textViewevent2);
        textViewevent.setText(event);
        //getFormationData();
        // textviewformationa=findViewById(R.id.textViewformationA);
        //textviewformationb=findViewById(R.id.textViewformationB);
        //  textviewformationa.setText(formationteama);
        //  textviewformationb.setText(formationteamb);

        textViewtanggal = findViewById(R.id.textViewtanggal2);
        textViewtanggal.setText(tanggal);
        textViewbabak = findViewById(R.id.textViewbabak2);
        textViewbabak.setText(babakstring);




        goalteama= getIntent().getIntExtra("goalteama",goalteama);
        goalteamb= getIntent().getIntExtra("goalteamb",goalteamb);

        cetakgoalteama= getIntent().getExtras().getStringArrayList("cetakgoalteama");
        cetakgoalteamb= getIntent().getExtras().getStringArrayList("cetakgoalteamb");


        textViewgoalteama=findViewById(R.id.textViewgoalteama2);
        textViewgoalteamb=findViewById(R.id.textViewgoalteamb);
        textViewgoalteama.setText(Integer.toString(goalteama));
        textViewgoalteamb.setText(Integer.toString(goalteamb));


        textViewlistpemaingoalteama=findViewById(R.id.textViewlistpemaingoalteama);
        textViewlistpemaingoalteama.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder builder=new StringBuilder();
        for (String detail  : cetakgoalteama){
            builder.append(detail + "\n" );

        }
        textViewlistpemaingoalteama.setText(builder.toString());

        cetakgoalteama.clear();

        textViewlistpemaingoalteamb=findViewById(R.id.textViewlistpemaingoalteamb);
        textViewlistpemaingoalteamb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder builderteamb=new StringBuilder();
        for (String detail  : cetakgoalteamb){
            builderteamb.append(detail + "\n" );

        }
        textViewlistpemaingoalteamb.setText(builderteamb.toString());

        cetakgoalteamb.clear();

    }


}

