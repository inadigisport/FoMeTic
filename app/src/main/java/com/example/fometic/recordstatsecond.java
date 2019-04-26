package com.example.fometic;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

public class recordstatsecond extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private Chronometer chronometer;
    private Chronometer chronometerteam;
    private boolean running;
    //Button buttonshootingteama;
    //Button buttonshootingteamb;
    //Button buttonpassingteama;
    //Button buttonpassingteamb;
    //Button buttontacklingteama;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordstatsecond);

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
                        backtomenu();

                    }

                })
                .setNegativeButton("CANCEL", null).show();





    }

    public void backtomenu () {
        Intent intent = new Intent(this, MainActivity.class);
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
