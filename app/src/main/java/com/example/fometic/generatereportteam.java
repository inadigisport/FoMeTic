package com.example.fometic;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class generatereportteam extends AppCompatActivity {

    ArrayList<String> statistikpemainteama = new ArrayList<>();
    ArrayList<String> statistikpemainteamb = new ArrayList<>();
    TextView textViewlistdatapertandinganpemainteama;
    TextView textViewlistdatapertandinganpemainteamb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        statistikpemainteama.clear();
        statistikpemainteamb.clear();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_generatereportteam);

        statistikpemainteama= getIntent().getExtras().getStringArrayList("datapertandinganpemainteama");
        statistikpemainteamb= getIntent().getExtras().getStringArrayList("datapertandinganpemainteamb");

        textViewlistdatapertandinganpemainteama =findViewById(R.id.datapertandinganpemainteama);
        textViewlistdatapertandinganpemainteama.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder builder=new StringBuilder();
        for (String detail  : statistikpemainteama){
            builder.append(detail + "\n" );

        }
        textViewlistdatapertandinganpemainteama.setText(builder.toString());

        textViewlistdatapertandinganpemainteamb =findViewById(R.id.datapertandinganpemainteamb);
        textViewlistdatapertandinganpemainteamb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder builderteamb=new StringBuilder();
        for (String detail  : statistikpemainteamb){
            builderteamb.append(detail + "\n" );

        }
        textViewlistdatapertandinganpemainteamb.setText(builderteamb.toString());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

}
