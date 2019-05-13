package com.example.fometic;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

public class recordstatsecond extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private Chronometer chronometer;
    private Chronometer chronometerteam;
    private boolean running;
    String teamA;
    String teamB;
    TextView textviewteama;
    TextView textviewteamb;
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









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordstatsecond);
        teamA= getIntent().getStringExtra("teama");
        teamB= getIntent().getStringExtra("teamb");
        Log.d("home",teamA);
        Log.d("away",teamB);
        ballpossesionteama= getIntent().getIntExtra("ballpossesionteama",ballpossesionteama);
        Log.d("ballpossesionteama", Integer.toString(ballpossesionteama));
        ballpossesionteamb= getIntent().getIntExtra("ballpossesionteamb",ballpossesionteamb);
        Log.d("ballpossesionteamb", Integer.toString(ballpossesionteamb));
        passingteama= getIntent().getIntExtra("passingteama",passingteama);
        passingteamb= getIntent().getIntExtra("passingteamb",passingteamb);
        Log.d("passing team a", Integer.toString(passingteama));
        Log.d("passing team b", Integer.toString(passingteamb));
        tacklingteama= getIntent().getIntExtra("tacklingteama",tacklingteama);
        tacklingteamb= getIntent().getIntExtra("tacklingteamb",tacklingteamb);
        Log.d("tackling team a", Integer.toString(tacklingteama));
        Log.d("tackling team b", Integer.toString(tacklingteamb));
        interceptteama= getIntent().getIntExtra("interceptteama",interceptteama);
        interceptteamb= getIntent().getIntExtra("interceptteamb",interceptteamb);
        Log.d("intercept team a", Integer.toString(interceptteama));
        Log.d("intercept team b", Integer.toString(interceptteamb));
        savesteama= getIntent().getIntExtra("savesteama",savesteama);
        savesteamb= getIntent().getIntExtra("savesteamb",savesteamb);
        Log.d("saves team a", Integer.toString(savesteama));
        Log.d("saves team b", Integer.toString(savesteamb));
        throwinteama= getIntent().getIntExtra("throwinteama",throwinteama);
        throwinteamb= getIntent().getIntExtra("throwinteamb",throwinteamb);
        Log.d("throw in team a", Integer.toString(throwinteama));
        Log.d("throw in team b", Integer.toString(throwinteamb));
        cornerkickteama= getIntent().getIntExtra("cornerkickteama",cornerkickteama);
        cornerkickteamb= getIntent().getIntExtra("cornerkickteamb",cornerkickteamb);
        Log.d("corner kick team a", Integer.toString(cornerkickteama));
        Log.d("corner kick team b", Integer.toString(cornerkickteamb));
        foulteama= getIntent().getIntExtra("foulteama",foulteama);
        foulteamb= getIntent().getIntExtra("foulteamb",foulteamb);
        Log.d("foul team a", Integer.toString(foulteama));
        Log.d("foul team b", Integer.toString(foulteamb));
        offsideteama= getIntent().getIntExtra("offsideteama",offsideteama);
        offsideteamb= getIntent().getIntExtra("offsideteamb",offsideteamb);
        Log.d("offside team a", Integer.toString(offsideteama));
        Log.d("offside team b", Integer.toString(offsideteamb));
        goalteama= getIntent().getIntExtra("goalteama",goalteama);
        goalteamb= getIntent().getIntExtra("goalteamb",goalteamb);
        Log.d("goal team a", Integer.toString(goalteama));
        Log.d("goal team b", Integer.toString(goalteamb));
        shootontargetteama= getIntent().getIntExtra("shootontargetteama",shootontargetteama);
        shootontargetteamb= getIntent().getIntExtra("shootontargetteamb",shootontargetteamb);
        Log.d("shoot on target team a", Integer.toString(shootontargetteama));
        Log.d("shoot on target team b", Integer.toString(shootontargetteamb));
        shootofftargetteama= getIntent().getIntExtra("shootofftargetteama",shootofftargetteama);
        shootofftargetteamb= getIntent().getIntExtra("shootofftargetteamb",shootofftargetteamb);
        Log.d("shoot off target team a", Integer.toString(shootofftargetteama));
        Log.d("shoot off target team b", Integer.toString(shootofftargetteamb));
        yellowcardteama= getIntent().getIntExtra("yellowcardteama",yellowcardteama);
        yellowcardteamb= getIntent().getIntExtra("yellowcardteamb",yellowcardteamb);
        Log.d("yellow card team a", Integer.toString(yellowcardteama));
        Log.d("yellow card team b", Integer.toString(yellowcardteamb));
        redcardteama= getIntent().getIntExtra("redcardteama",redcardteama);
        redcardteamb= getIntent().getIntExtra("redcardteamb",redcardteamb);
        Log.d("red card team a", Integer.toString(redcardteama));
        Log.d("red card team b", Integer.toString(redcardteamb));

        textviewteama=findViewById(R.id.textViewteama);
        textviewteama.setText(teamA);
        textviewteamb=findViewById(R.id.textViewteamb);
        textviewteamb.setText(teamB);
        chronometer = findViewById(R.id.chronometer);
        chronometerteam = findViewById(R.id.chronometerteam);

        Button button=findViewById(R.id.buttonstop2ndhalf);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop2ndhalf();
            }
        });


    }

    public void startChronometer(View v) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            chronometerteam.setBase(SystemClock.elapsedRealtime());
            chronometerteam.start();
            running = true;
        }
    }

    public void stop2ndhalf() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("End of Full Time")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        chronometer.stop();
                        chronometerteam.stop();
                        viewgeneratereport();

                    }

                })
                .setNegativeButton("CANCEL", null).show();





    }

    public void viewgeneratereport () {
        Intent intent = new Intent(this, generatereport.class);
        intent.putExtra("teama",teamA);
        Log.d("Home",teamA);
        intent.putExtra("teamb",teamB);
        Log.d("Away",teamB);
        intent.putExtra("passingteama",passingteama);
        intent.putExtra("passingteamb",passingteamb);
        intent.putExtra("tacklingteama",tacklingteama);
        intent.putExtra("tacklingteamb",tacklingteamb);
        intent.putExtra("interceptteama",interceptteama);
        intent.putExtra("interceptteamb",interceptteamb);
        intent.putExtra("savesteama",savesteama);
        intent.putExtra("savesteamb",savesteamb);
        intent.putExtra("throwinteama",throwinteama);
        intent.putExtra("throwinteamb",throwinteamb);
        intent.putExtra("cornerkickteama",cornerkickteama);
        intent.putExtra("cornerkickteamb",cornerkickteamb);
        intent.putExtra("ballpossesionteama",ballpossesionteama);
        intent.putExtra("ballpossesionteamb",ballpossesionteamb);
        intent.putExtra("foulteama",foulteama);
        intent.putExtra("foulteamb",foulteamb);
        intent.putExtra("offsideteama",offsideteama);
        intent.putExtra("offsideteamb",offsideteamb);
        intent.putExtra("goalteama",goalteama);
        intent.putExtra("goalteamb",goalteamb);
        intent.putExtra("shootontargetteama",shootontargetteama);
        intent.putExtra("shootontargetteamb",shootontargetteamb);
        intent.putExtra("shootofftargetteama",shootofftargetteama);
        intent.putExtra("shootofftargetteamb",shootofftargetteamb);
        intent.putExtra("yellowcardteama",yellowcardteama);
        intent.putExtra("yellowcardteamb",yellowcardteamb);
        intent.putExtra("redcardteama",redcardteama);
        intent.putExtra("redcardteamb",redcardteamb);


        startActivity(intent);
    }

    public void passingteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();


    }

    public void passingteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();


    }

    public void tacklingteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();


    }

    public void tacklingteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();


    }

    public void interceptteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();


    }

    public void interceptteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();


    }

    public void savesteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();


    }

    public void savesteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();


    }

    public void throwinteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();


    }

    public void throwinteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();


    }

    public void cornerkickteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();


    }
    public void cornerkickteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();


    }
    public void pinaltyteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();


    }
    public void pinaltyteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();


    }

    public void freekickteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();


    }

    public void freekickteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();


    }

    public void goalkickteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();


    }
    public void goalkickteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();


    }


    public void showpopupshootinga(View v) {

        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_shooting);
        popup.show();
    }

    public void showpopupshootingb(View v) {

        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_shootingb);
        popup.show();
    }

    public void yellowcard(View v) {

        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_yellow);
        popup.show();
    }

    public void redcard(View v) {

        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_red);
        popup.show();
    }
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.goal:
                Toast.makeText(this, "Goal Team A", Toast.LENGTH_SHORT).show();
                chronometerteam.setBase(SystemClock.elapsedRealtime());
                chronometerteam.stop();
                return true;
            case R.id.shootontarget:
                Toast.makeText(this, "Shoot On Target Team A", Toast.LENGTH_SHORT).show();
                chronometerteam.setBase(SystemClock.elapsedRealtime());
                chronometerteam.start();
                return true;
            case R.id.shootofftarget:
                Toast.makeText(this, "Shoot Off Target Team A", Toast.LENGTH_SHORT).show();
                chronometerteam.setBase(SystemClock.elapsedRealtime());
                chronometerteam.stop();
                return true;
            case R.id.goalb:
                Toast.makeText(this, "Goal Team B", Toast.LENGTH_SHORT).show();
                chronometerteam.setBase(SystemClock.elapsedRealtime());
                chronometerteam.stop();
                return true;
            case R.id.shootontargetb:
                Toast.makeText(this, "Shoot On Target Team B", Toast.LENGTH_SHORT).show();
                chronometerteam.setBase(SystemClock.elapsedRealtime());
                chronometerteam.start();
                return true;
            case R.id.shootofftargetb:
                Toast.makeText(this, "Shoot Off Target Team B", Toast.LENGTH_SHORT).show();
                chronometerteam.setBase(SystemClock.elapsedRealtime());
                chronometerteam.stop();
                return true;

            case R.id.yellowhome:
                Toast.makeText(this, "Yellow Card Team Home", Toast.LENGTH_SHORT).show();
                chronometerteam.setBase(SystemClock.elapsedRealtime());
                chronometerteam.stop();
                return true;

            case R.id.yellowaway:
                Toast.makeText(this, "Yellow Card Team Away", Toast.LENGTH_SHORT).show();
                chronometerteam.setBase(SystemClock.elapsedRealtime());
                chronometerteam.stop();
                return true;

            case R.id.redhome:
                Toast.makeText(this, "Red Card Team Home", Toast.LENGTH_SHORT).show();
                chronometerteam.setBase(SystemClock.elapsedRealtime());
                chronometerteam.stop();
                return true;

            case R.id.redaway:
                Toast.makeText(this, "Red Card Team Away", Toast.LENGTH_SHORT).show();
                chronometerteam.setBase(SystemClock.elapsedRealtime());
                chronometerteam.stop();
                return true;

            default:
                return false;


        }
    }
}
