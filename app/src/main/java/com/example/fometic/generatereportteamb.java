package com.example.fometic;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class generatereportteamb extends AppCompatActivity {

    ArrayList<String> statistikpemainteamb = new ArrayList<>();
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

    TextView textViewnamapemainb;
    TextView textViewposisipemainb;
    TextView textViewnomorpunggungpemainb;
    TextView textViewgoalpemainb;
    TextView textViewshootontargetpemainb;
    TextView textViewshootofftargetpemainb;
    TextView textViewyellowcardpemainb;
    TextView textViewredcardpemainb;

    TextView namateamB;
    TextView textViewevent;
    TextView textViewvenue;
    TextView textViewtanggal;
    TextView textViewbabak;
    TextView textViewtacklingpemainb;
    TextView textViewinterceptpemainb;
    String teamB;
    String venue;
    String event;
    String tanggal;
    String babakstring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        statistikpemainteamb.clear();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_generatereportteam);


        teamB= getIntent().getStringExtra("teamb");
        venue= getIntent().getStringExtra("venue");
        event= getIntent().getStringExtra("event");
        tanggal= getIntent().getStringExtra("tanggal");
        babakstring= getIntent().getStringExtra("babak");
        statistikpemainteamb= getIntent().getExtras().getStringArrayList("datapertandinganpemainteamb");
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


        namateamB=findViewById(R.id.textViewteama);
        namateamB.setText(teamB);
        textViewevent=findViewById(R.id.textViewevent);
        textViewvenue=findViewById(R.id.textViewvenue);
        textViewevent.setText(event);
        textViewvenue.setText(venue);



        textViewtanggal = findViewById(R.id.textViewtanggal);
        textViewtanggal.setText(tanggal);
        textViewbabak = findViewById(R.id.textViewbabak);
        textViewbabak.setText(babakstring);




        textViewnamapemainb = findViewById(R.id.textViewnamapemain);

        StringBuilder buildernamapemainb=new StringBuilder();
        for (String detail  : namapemainb){
            buildernamapemainb.append(detail + "\n" );

        }
        textViewnamapemainb.setText(buildernamapemainb.toString());

        textViewposisipemainb = findViewById(R.id.textViewposisipemain);
        textViewposisipemainb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder builderposisipemainb=new StringBuilder();
        for (String detail  : posisipemainb){
        builderposisipemainb.append(detail + "\n" );

        }
        textViewposisipemainb.setText(builderposisipemainb.toString());

        textViewnomorpunggungpemainb = findViewById(R.id.textViewnomorpunggungpemain);
        textViewnomorpunggungpemainb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder buildernomorpunggungpemainb=new StringBuilder();
        for (String detail  : nomorpunggungpemainb){
            buildernomorpunggungpemainb.append(detail + "\n" );

        }
        textViewnomorpunggungpemainb.setText(buildernomorpunggungpemainb.toString());

        textViewgoalpemainb = findViewById(R.id.textViewgoalpemain);
        textViewgoalpemainb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder buildergoalpemainb=new StringBuilder();
        for (String detail  : goalpemainb){
            buildergoalpemainb.append(detail + "\n" );

        }
        textViewgoalpemainb.setText(buildergoalpemainb.toString());


        textViewshootontargetpemainb = findViewById(R.id.textViewshootontargetpemain);
        textViewshootontargetpemainb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder buildershootontargetpemainb=new StringBuilder();
        for (String detail  : shootontargetpemainb){
            buildershootontargetpemainb.append(detail + "\n" );

        }
        textViewshootontargetpemainb.setText(buildershootontargetpemainb.toString());


        textViewshootofftargetpemainb = findViewById(R.id.textViewshootofftargetpemain);
        textViewshootofftargetpemainb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder buildershootofftargetpemainb=new StringBuilder();
        for (String detail  : shootofftargetpemainb){
            buildershootofftargetpemainb.append(detail + "\n" );

        }
        textViewshootofftargetpemainb.setText(buildershootofftargetpemainb.toString());

        textViewyellowcardpemainb = findViewById(R.id.textViewyellowcardpemain);
        textViewyellowcardpemainb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder builderyellowcardpemainb=new StringBuilder();
        for (String detail  : yellowcardpemainb){
            builderyellowcardpemainb.append(detail + "\n" );

        }
        textViewyellowcardpemainb.setText(builderyellowcardpemainb.toString());


        textViewredcardpemainb = findViewById(R.id.textViewredcardpemain);
        textViewredcardpemainb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder builderredcardpemainb=new StringBuilder();
        for (String detail  : redcardpemainb){
            builderredcardpemainb.append(detail + "\n" );

        }
        textViewredcardpemainb.setText(builderredcardpemainb.toString());


        textViewtacklingpemainb = findViewById(R.id.textViewtacklingpemain);
        textViewtacklingpemainb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder buildertacklingpemainb=new StringBuilder();
        for (String detail  : tacklingpemainb){
            buildertacklingpemainb.append(detail + "\n" );

        }
        textViewtacklingpemainb.setText(buildertacklingpemainb.toString());




        textViewinterceptpemainb = findViewById(R.id.textViewinterceptpemain);
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
