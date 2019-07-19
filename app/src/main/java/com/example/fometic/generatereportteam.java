package com.example.fometic;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class generatereportteam extends AppCompatActivity {

    ArrayList<String> statistikpemainteama = new ArrayList<>();
    ArrayList<String> statistikpemainteamb = new ArrayList<>();
    ArrayList<String> namapemain = new ArrayList<>();
    ArrayList<String> nomorpunggungpemain = new ArrayList<>();
    ArrayList<String> posisipemain = new ArrayList<>();
    ArrayList<String> goalpemain = new ArrayList<>();
    ArrayList<String> shootontargetpemain = new ArrayList<>();
    ArrayList<String> shootofftargetpemain = new ArrayList<>();
    ArrayList<String> yellowcardpemain = new ArrayList<>();
    ArrayList<String> redcardpemain = new ArrayList<>();
    ArrayList<String> tacklingpemain = new ArrayList<>();
    ArrayList<String> interceptpemain = new ArrayList<>();
    ArrayList<String> namapemainb = new ArrayList<>();
    ArrayList<String> nomorpunggungpemainb = new ArrayList<>();
    ArrayList<String> posisipemainb = new ArrayList<>();
    ArrayList<String> goalpemainb = new ArrayList<>();
    ArrayList<String> shootontargetpemainb = new ArrayList<>();
    ArrayList<String> shootofftargetpemainb = new ArrayList<>();
    ArrayList<String> yellowcardpemainb = new ArrayList<>();
    ArrayList<String> redcardpemainb = new ArrayList<>();
    ArrayList<String> tacklingpemainb = new ArrayList<>();
    ArrayList<String> interceptpemainb = new ArrayList<>();
    TextView textViewnamapemain;
    TextView textViewposisipemain;
    TextView textViewnomorpunggungpemain;
    TextView textViewgoalpemain;
    TextView textViewshootontargetpemain;
    TextView textViewshootofftargetpemain;
    TextView textViewyellowcardpemain;
    TextView textViewredcardpemain;
    TextView textViewnamapemainb;
    TextView textViewposisipemainb;
    TextView textViewnomorpunggungpemainb;
    TextView textViewgoalpemainb;
    TextView textViewshootontargetpemainb;
    TextView textViewshootofftargetpemainb;
    TextView textViewyellowcardpemainb;
    TextView textViewredcardpemainb;
    TextView textViewlistdatapertandinganpemainteama;
    TextView textViewlistdatapertandinganpemainteamb;
    TextView namateamA;
    TextView namateamB;
    TextView textViewevent;
    TextView textViewvenue;
    TextView textViewtanggal;
    TextView textViewbabak;
    TextView textViewtacklingpemain;
    TextView textViewtacklingpemainb;
    TextView textViewinterceptpemain;
    TextView textViewinterceptpemainb;
    String teamA;
    String teamB;
    String venue;
    String event;
    String tanggal;
    String babakstring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        statistikpemainteama.clear();
        statistikpemainteamb.clear();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_generatereportteam);

        teamA= getIntent().getStringExtra("teama");
        teamB= getIntent().getStringExtra("teamb");
        venue= getIntent().getStringExtra("venue");
        event= getIntent().getStringExtra("event");
        tanggal= getIntent().getStringExtra("tanggal");
        babakstring= getIntent().getStringExtra("babak");
        statistikpemainteama= getIntent().getExtras().getStringArrayList("datapertandinganpemainteama");
        statistikpemainteamb= getIntent().getExtras().getStringArrayList("datapertandinganpemainteamb");
        namapemain= getIntent().getExtras().getStringArrayList("namapemain");
        posisipemain= getIntent().getExtras().getStringArrayList("posisipemain");
        nomorpunggungpemain= getIntent().getExtras().getStringArrayList("nomorpunggungpemain");
        goalpemain= getIntent().getExtras().getStringArrayList("goalpemain");
        shootontargetpemain= getIntent().getExtras().getStringArrayList("shootontargetpemain");
        shootofftargetpemain= getIntent().getExtras().getStringArrayList("shootofftargetpemain");
        yellowcardpemain= getIntent().getExtras().getStringArrayList("yellowcardpemain");
        redcardpemain= getIntent().getExtras().getStringArrayList("redcardpemain");
        tacklingpemain= getIntent().getExtras().getStringArrayList("tacklingpemain");
        interceptpemain= getIntent().getExtras().getStringArrayList("interceptpemain");
        namapemainb= getIntent().getExtras().getStringArrayList("namapemainb");
        posisipemainb= getIntent().getExtras().getStringArrayList("posisipemainb");
        nomorpunggungpemainb= getIntent().getExtras().getStringArrayList("nomorpunggungpemainb");
        goalpemainb= getIntent().getExtras().getStringArrayList("goalpemainb");
        shootontargetpemainb= getIntent().getExtras().getStringArrayList("shootontargetpemainb");
        shootofftargetpemainb= getIntent().getExtras().getStringArrayList("shootofftargetpemainb");
        yellowcardpemainb= getIntent().getExtras().getStringArrayList("yellowcardpemainb");
        redcardpemainb= getIntent().getExtras().getStringArrayList("redcardpemainb");
        tacklingpemainb= getIntent().getExtras().getStringArrayList("tacklingpemainb");
        interceptpemainb= getIntent().getExtras().getStringArrayList("interceptpemainb");

        namateamA=findViewById(R.id.textViewteama);
        namateamB=findViewById(R.id.textViewteamb);
        namateamA.setText(teamA);
        namateamB.setText(teamB);
        textViewevent=findViewById(R.id.textViewevent);
        textViewvenue=findViewById(R.id.textViewvenue);
        textViewevent.setText(event);
        textViewvenue.setText(venue);



        textViewtanggal = findViewById(R.id.textViewtanggal);
        textViewtanggal.setText(tanggal);
        textViewbabak = findViewById(R.id.textViewbabak);
        textViewbabak.setText(babakstring);


        //textViewlistdatapertandinganpemainteama =findViewById(R.id.datapertandinganpemainteama);
        //textViewlistdatapertandinganpemainteama.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textViewnamapemain = findViewById(R.id.textViewnamapemain);

        StringBuilder buildernamapemain=new StringBuilder();
        for (String detail  : namapemain){
            buildernamapemain.append(detail + "\n" );

        }
        textViewnamapemain.setText(buildernamapemain.toString());

        textViewposisipemain = findViewById(R.id.textViewposisipemain);
        textViewposisipemain.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder builderposisipemain=new StringBuilder();
        for (String detail  : posisipemain){
            builderposisipemain.append(detail + "\n" );

        }
        textViewposisipemain.setText(builderposisipemain.toString());

        textViewnomorpunggungpemain = findViewById(R.id.textViewnomorpunggungpemain);
        textViewnomorpunggungpemain.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder buildernomorpunggungpemain=new StringBuilder();
        for (String detail  : nomorpunggungpemain){
            buildernomorpunggungpemain.append(detail + "\n" );

        }
        textViewnomorpunggungpemain.setText(buildernomorpunggungpemain.toString());

        textViewgoalpemain = findViewById(R.id.textViewgoalpemain);
        textViewgoalpemain.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder buildergoalpemain=new StringBuilder();
        for (String detail  : goalpemain){
            buildergoalpemain.append(detail + "\n" );

        }
        textViewgoalpemain.setText(buildergoalpemain.toString());


        textViewshootontargetpemain = findViewById(R.id.textViewshootontargetpemain);
        textViewshootontargetpemain.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder buildershootontargetpemain=new StringBuilder();
        for (String detail  : shootontargetpemain){
            buildershootontargetpemain.append(detail + "\n" );

        }
        textViewshootontargetpemain.setText(buildershootontargetpemain.toString());


        textViewshootofftargetpemain = findViewById(R.id.textViewshootofftargetpemain);
        textViewshootofftargetpemain.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder buildershootofftargetpemain=new StringBuilder();
        for (String detail  : shootofftargetpemain){
            buildershootofftargetpemain.append(detail + "\n" );

        }
        textViewshootofftargetpemain.setText(buildershootofftargetpemain.toString());

        textViewyellowcardpemain = findViewById(R.id.textViewyellowcardpemain);
        textViewyellowcardpemain.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder builderyellowcardpemain=new StringBuilder();
        for (String detail  : yellowcardpemain){
            builderyellowcardpemain.append(detail + "\n" );

        }
        textViewyellowcardpemain.setText(builderyellowcardpemain.toString());


        textViewredcardpemain = findViewById(R.id.textViewredcardpemain);
        textViewredcardpemain.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder builderredcardpemain=new StringBuilder();
        for (String detail  : redcardpemain){
            builderredcardpemain.append(detail + "\n" );

        }
        textViewredcardpemain.setText(builderredcardpemain.toString());

        textViewnamapemainb = findViewById(R.id.textViewnamapemainb);

        StringBuilder buildernamapemainb=new StringBuilder();
        for (String detail  : namapemainb){
            buildernamapemainb.append(detail + "\n" );

        }
        textViewnamapemainb.setText(buildernamapemainb.toString());

        textViewposisipemainb = findViewById(R.id.textViewposisipemainb);
        textViewposisipemainb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder builderposisipemainb=new StringBuilder();
        for (String detail  : posisipemainb){
        builderposisipemainb.append(detail + "\n" );

        }
        textViewposisipemainb.setText(builderposisipemainb.toString());

        textViewnomorpunggungpemainb = findViewById(R.id.textViewnomorpunggungpemainb);
        textViewnomorpunggungpemainb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder buildernomorpunggungpemainb=new StringBuilder();
        for (String detail  : nomorpunggungpemainb){
            buildernomorpunggungpemainb.append(detail + "\n" );

        }
        textViewnomorpunggungpemainb.setText(buildernomorpunggungpemainb.toString());

        textViewgoalpemainb = findViewById(R.id.textViewgoalpemainb);
        textViewgoalpemainb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder buildergoalpemainb=new StringBuilder();
        for (String detail  : goalpemainb){
            buildergoalpemainb.append(detail + "\n" );

        }
        textViewgoalpemainb.setText(buildergoalpemainb.toString());


        textViewshootontargetpemainb = findViewById(R.id.textViewshootontargetpemainb);
        textViewshootontargetpemainb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder buildershootontargetpemainb=new StringBuilder();
        for (String detail  : shootontargetpemainb){
            buildershootontargetpemainb.append(detail + "\n" );

        }
        textViewshootontargetpemainb.setText(buildershootontargetpemainb.toString());


        textViewshootofftargetpemainb = findViewById(R.id.textViewshootofftargetpemainb);
        textViewshootofftargetpemainb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder buildershootofftargetpemainb=new StringBuilder();
        for (String detail  : shootofftargetpemainb){
            buildershootofftargetpemainb.append(detail + "\n" );

        }
        textViewshootofftargetpemainb.setText(buildershootofftargetpemainb.toString());

        textViewyellowcardpemainb = findViewById(R.id.textViewyellowcardpemainb);
        textViewyellowcardpemainb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder builderyellowcardpemainb=new StringBuilder();
        for (String detail  : yellowcardpemainb){
            builderyellowcardpemainb.append(detail + "\n" );

        }
        textViewyellowcardpemainb.setText(builderyellowcardpemainb.toString());


        textViewredcardpemainb = findViewById(R.id.textViewredcardpemainb);
        textViewredcardpemainb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder builderredcardpemainb=new StringBuilder();
        for (String detail  : redcardpemainb){
            builderredcardpemainb.append(detail + "\n" );

        }
        textViewredcardpemainb.setText(builderredcardpemainb.toString());


        textViewtacklingpemain = findViewById(R.id.textViewtacklingpemain);
        textViewtacklingpemain.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder buildertacklingpemain=new StringBuilder();
        for (String detail  : tacklingpemain){
            buildertacklingpemain.append(detail + "\n" );

        }
        textViewtacklingpemain.setText(buildertacklingpemain.toString());

        textViewtacklingpemainb = findViewById(R.id.textViewtacklingpemainb);
        textViewtacklingpemainb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder buildertacklingpemainb=new StringBuilder();
        for (String detail  : tacklingpemainb){
            buildertacklingpemainb.append(detail + "\n" );

        }
        textViewtacklingpemainb.setText(buildertacklingpemainb.toString());


        textViewinterceptpemain = findViewById(R.id.textViewinterceptpemain);
        textViewinterceptpemain.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder builderinterceptpemain=new StringBuilder();
        for (String detail  : interceptpemain){
            builderinterceptpemain.append(detail + "\n" );

        }
        textViewinterceptpemain.setText(builderinterceptpemain.toString());


        textViewinterceptpemainb = findViewById(R.id.textViewinterceptpemainb);
        textViewinterceptpemainb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder builderinterceptpemainb=new StringBuilder();
        for (String detail  : interceptpemainb){
            builderinterceptpemainb.append(detail + "\n" );

        }
        textViewinterceptpemainb.setText(builderinterceptpemainb.toString());




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

}
