package com.example.fometic;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class generatereportteam extends AppCompatActivity {

    ArrayList<String> statistikpemainteama = new ArrayList<>();
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

    TextView textViewnamapemain;
    TextView textViewposisipemain;
    TextView textViewnomorpunggungpemain;
    TextView textViewgoalpemain;
    TextView textViewshootontargetpemain;
    TextView textViewshootofftargetpemain;
    TextView textViewyellowcardpemain;
    TextView textViewredcardpemain;
    TextView namateamA;
    TextView textViewevent;
    TextView textViewvenue;
    TextView textViewtanggal;
    TextView textViewbabak;
    TextView textViewtacklingpemain;
    TextView textViewinterceptpemain;
    String teamA;
    String venue;
    String event;
    String tanggal;
    String babakstring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        statistikpemainteama.clear();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_generatereportteam);

        teamA= getIntent().getStringExtra("teama");
        venue= getIntent().getStringExtra("venue");
        event= getIntent().getStringExtra("event");
        tanggal= getIntent().getStringExtra("tanggal");
        babakstring= getIntent().getStringExtra("babak");
        statistikpemainteama= getIntent().getExtras().getStringArrayList("datapertandinganpemainteama");
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

        namateamA=findViewById(R.id.textViewteama);
        namateamA.setText(teamA);
        textViewevent=findViewById(R.id.textViewevent);
        textViewvenue=findViewById(R.id.textViewvenue);
        textViewevent.setText(event);
        textViewvenue.setText(venue);



        textViewtanggal = findViewById(R.id.textViewtanggal);
        textViewtanggal.setText(tanggal);
        textViewbabak = findViewById(R.id.textViewbabak);
        textViewbabak.setText(babakstring);



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



        textViewtacklingpemain = findViewById(R.id.textViewtacklingpemain);
        textViewtacklingpemain.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder buildertacklingpemain=new StringBuilder();
        for (String detail  : tacklingpemain){
            buildertacklingpemain.append(detail + "\n" );

        }
        textViewtacklingpemain.setText(buildertacklingpemain.toString());



        textViewinterceptpemain = findViewById(R.id.textViewinterceptpemain);
        textViewinterceptpemain.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder builderinterceptpemain=new StringBuilder();
        for (String detail  : interceptpemain){
            builderinterceptpemain.append(detail + "\n" );

        }
        textViewinterceptpemain.setText(builderinterceptpemain.toString());






    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

}
