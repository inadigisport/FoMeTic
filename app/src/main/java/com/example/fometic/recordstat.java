package com.example.fometic;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class recordstat extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {


    private Chronometer chronometer;
    private Chronometer chronometerteam;
    private boolean running;
    Pertandingan tanding = new Pertandingan();
    //Button buttonshootingteama;
    //Button buttonshootingteamb;
    //Button buttonpassingteama;
    //Button buttonpassingteamb;
    //Button buttontacklingteama;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordstat);

        chronometer = findViewById(R.id.chronometer);
        chronometerteam = findViewById(R.id.chronometerteam);

        Button button=findViewById(R.id.buttonhalftime);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop1sthalf();
            }
        });





    }

    public void start1sthalf(View v) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            chronometerteam.setBase(SystemClock.elapsedRealtime());
            chronometerteam.start();
            running = true;
        }
    }

    public void stop1sthalf() {
       AlertDialog.Builder builder = new AlertDialog.Builder(this);
       builder.setTitle("End of 1st Half")
               .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       chronometer.stop();
                       chronometerteam.stop();
                       start2ndhalf();

                   }

               })
               .setNegativeButton("CANCEL", null).show();





    }

    public void start2ndhalf () {
        Intent intent = new Intent(this, recordstatsecond.class);
        startActivity(intent);
    }

    public void passingteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();
        tanding.setPassingTeamA(tanding.getPassingTeamA()+1);

    }

    public void passingteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();
        tanding.setPassingTeamB(tanding.getPassingTeamB()+1);

    }

    public void tacklingteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();
        tanding.setTacklingTeamA(tanding.getTacklingTeamA()+1);

    }

    public void tacklingteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();
        tanding.setTacklingTeamB(tanding.getTacklingTeamB()+1);

    }

    public void interceptteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();
        tanding.setInterceptTeamA(tanding.getInterceptTeamA()+1);

    }

    public void interceptteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();
        tanding.setInterceptTeamB(tanding.getInterceptTeamB()+1);

    }

    public void savesteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();
        tanding.setSavesTeamA(tanding.getSavesTeamA()+1);

    }

    public void savesteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();
        tanding.setSavesTeamB(tanding.getSavesTeamB()+1);

    }

    public void throwinteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setThrowinTeamA(tanding.getThrowinTeamA()+1);

    }

    public void throwinteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setThrowinTeamB(tanding.getThrowinTeamB()+1);
    }

    public void cornerkickteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setCornerkickTeamA(tanding.getCornerkickTeamA()+1);
    }
    public void cornerkickteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setCornerkickTeamB(tanding.getCornerkickTeamB()+1);

    }
    public void pinaltyteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setPinaltyTeamA(tanding.getPassingTeamA()+1);
    }
    public void pinaltyteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setPinaltyTeamB(tanding.getPassingTeamB()+1);
    }

    public void freekickteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setFreekickTeamA(tanding.getFreekickTeamA()+1);
    }

    public void freekickteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setFreekickTeamB(tanding.getFreekickTeamB()+1);
    }

    public void goalkickteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setGoalkickTeamA(tanding.getGoalkickTeamA()+1);
    }
    public void goalkickteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setGoalkickTeamB(tanding.getGoalkickTeamB()+1);
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
                TeamDBHandler db = new TeamDBHandler(this);
                Cursor loadDataTeam=db.loadHandler();
                List<String> spinnerArray=new ArrayList<String>();
                loadDataTeam.moveToFirst();
                while (!loadDataTeam.isAfterLast()) {
                    spinnerArray.add(loadDataTeam.getString(1));
                    Log.d("Data spinner ",loadDataTeam.getString(1));
                    loadDataTeam.moveToNext();
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(recordstat.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                Spinner mSpinner = (Spinner) mView.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, spinnerArray );
                mSpinner.setAdapter(arrayAdapter);

                builder.setTitle("Pick Player");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(recordstat.this, "Goal Team A", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    }

                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setView(mView);
                AlertDialog dialog = builder.create();
                dialog.show();
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
                TeamDBHandler dbgoalb = new TeamDBHandler(this);
                Cursor loadDataTeamgoalb=dbgoalb.loadHandler();
                List<String> spinnerArraygoalb=new ArrayList<String>();
                loadDataTeamgoalb.moveToFirst();
                while (!loadDataTeamgoalb.isAfterLast()) {
                    spinnerArraygoalb.add(loadDataTeamgoalb.getString(1));
                    Log.d("Data spinner ",loadDataTeamgoalb.getString(1));
                    loadDataTeamgoalb.moveToNext();
                }
                AlertDialog.Builder buildergoalb = new AlertDialog.Builder(recordstat.this);
                View mViewgoalb = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                Spinner mSpinnergoalb = (Spinner) mViewgoalb.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdaptergoalb = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, spinnerArraygoalb );
                mSpinnergoalb.setAdapter(arrayAdaptergoalb);

                buildergoalb.setTitle("Pick Player");
                buildergoalb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(recordstat.this, "Goal Team B", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }

                });
                buildergoalb.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                buildergoalb.setView(mViewgoalb);
                AlertDialog dialoggoalb = buildergoalb.create();
                dialoggoalb.show();
                //Toast.makeText(this, "Goal Team B", Toast.LENGTH_SHORT).show();
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
