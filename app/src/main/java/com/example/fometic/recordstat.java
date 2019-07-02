package com.example.fometic;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class recordstat extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {


    private Chronometer chronometer;
    private Chronometer chronometerteam;
    private TextView textViewpossesionteama;
    private TextView textViewpossesionteamb;
    private long pauseOffset;
    private long pauseOffsetteam;

    double possesionteama;
    double possesionteamb;
    TextView textviewteama;
    TextView textviewteamb;
    TextView textviewbabak;
    ListView listViewcetakgoalteama;


    String teamA;
    String teamB;
    String pemain;
    int listpemainint;
    String pemainb;
    String goalnoteb;
    String goalnotea;
    String passingstatusteama = "no";
    String passingstatusteamb = "no";
    String formationteama;
    String formationteamb;
    String babak;
    String statusgoal;


    ArrayList<String> cetakgoalteama = new ArrayList<>();
    ArrayAdapter<String> arrayAdaptercetakgoalteama;
    ArrayList<String> cetakgoalteamb = new ArrayList<>();
    ArrayAdapter<String> arrayAdaptercetakgoalteamb;

    int ballpossesionteama;
    int ballpossesionteamb;
    long elapsedchronometerteam;
    long elapsedchronometerteamb;
    double elapsedchronometerteamint;
    double elapsedchronometerteambint;
    int passingteama;
    int passingteamb;
    int tacklingteama;
    int tacklingteamb;
    int interceptteama;
    int interceptteamb;
    int savesteama;
    int savesteamb;
    int yellowcardteama;
    int yellowcardteamb;
    int redcardteama;
    int redcardteamb;
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
    int running;
    int babakint;
    int timematchint;
    String venue;
    String event;
    String timematch;

    Pertandingan tanding = new Pertandingan();
    PemainDBHandler dbpemain = new PemainDBHandler(this);
    PertandinganDBHandler dbpertandingan = new PertandinganDBHandler(this);
    PertandinganPemainDBHandler dbpertandinganpemain = new PertandinganPemainDBHandler(this);
    goalDBHandler dbgoal = new goalDBHandler(this);
    TeamDBHandler dbteam = new TeamDBHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_recordstat);
        running = 1;
        Bundle bundle = getIntent().getExtras();
        teamA = bundle.getString("teama");
        teamB = bundle.getString("teamb");
        formationteama = bundle.getString("formationteama");
        formationteamb = bundle.getString("formationteamb");
        venue = bundle.getString("venue");
        event = bundle.getString("event");
        timematch = bundle.getString("timematch");
        babak = bundle.getString("babak");
        tanding.setWaktupertandingan(Calendar.getInstance().getTime());


        chronometer = findViewById(R.id.chronometer);
        chronometerteam = findViewById(R.id.chronometerteam);
        textviewteama = findViewById(R.id.textViewteama);
        textviewteama.setText(teamA);
        textviewteamb = findViewById(R.id.textViewteamb);
        textviewteamb.setText(teamB);
        textviewbabak = findViewById(R.id.textViewbabak);
        textviewbabak.setText(babak);

        if (babak.equals("1sthalf")) {
            babakint = 1;
            timematchint = 0;
            statusgoal = "";
        }
        else if (babak.equals("2ndhalf")) {
            babakint = 2;
            timematchint = Integer.parseInt(timematch);
            statusgoal = "";
        }
        else if (babak.equals("Ex1sthalf")) {
            babakint = 3;
            timematchint = 0;
            statusgoal = "(Ex)";
        }
        else if (babak.equals("Ex2ndhalf")) {
            babakint = 4;
            timematchint = Integer.parseInt(timematch);
            statusgoal = "(Ex)";
        }
        tanding.setBabak(babakint);


        textViewpossesionteama = findViewById(R.id.textViewpossesionteama);
        textViewpossesionteamb = findViewById(R.id.textViewpossesionteamb);

        Button button = findViewById(R.id.buttonstop2ndhalf);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop1sthalf();
            }
        });


    }

    public void start1sthalf(View v) {
        if(running == 1) {
            chronometer.setBase(SystemClock.elapsedRealtime() - (timematchint * 60000) - pauseOffset);
            chronometer.start();
            chronometerteam.setBase(SystemClock.elapsedRealtime() - pauseOffsetteam);
            chronometerteam.start();
            Button button = findViewById(R.id.buttonteam);

            button.setText("Pause");

            running = 2;
        } else {

            chronometer.stop();
            chronometerteam.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            pauseOffsetteam = SystemClock.elapsedRealtime() - chronometerteam.getBase();

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("GAME PAUSED")
                    .setNeutralButton("RESUME", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                            chronometer.start();
                            chronometerteam.setBase(SystemClock.elapsedRealtime() - pauseOffsetteam);
                            chronometerteam.start();

                        }
                    }).show();


        }
    }

    public int getidpertandingan(){
        Cursor datapertandingan=dbpertandingan.loaddatapertandingan();
        int i=1;
        datapertandingan.moveToFirst();
            //Log.d("Enter if ", "input goal");

            while (!datapertandingan.isAfterLast()) {

                //Log.d("Enter while ", "input goal");

                if (datapertandingan.getInt(33)==1 && babakint==2){
                    i=datapertandingan.getInt(0);
                }else if (datapertandingan.getInt(33)==2 && babakint==3){
                    i=datapertandingan.getInt(0);
                }else if (datapertandingan.getInt(33)==3 && babakint==4){
                    i=datapertandingan.getInt(0);
                }else {
                    i = datapertandingan.getInt(0) + 1;
                }
                datapertandingan.moveToNext();
            }
        return i;
    }

    public void stop1sthalf() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("End Record Stat")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        tanding.setBabak(babakint);
                        tanding.setIdPertandingan(getidpertandingan());
                        tanding.setIdTeamA(dbteam.loaddataidteam(teamA));
                        tanding.setIdTeamB(dbteam.loaddataidteam(teamB));
                        tanding.setNamaTeamA(teamA);
                        tanding.setNamaTeamB(teamB);
                        tanding.setFormasiTeamA(formationteama);
                        tanding.setFormasiTeamB(formationteamb);
                        tanding.setVenue(venue);
                        tanding.setEvent(event);
                        tanding.setPosessionTeamA(ballpossesionteama);
                        tanding.setPosessionTeamB(ballpossesionteamb);
                        dbpertandingan.addHandler(tanding);
                        Log.d("Posession Team A", String.valueOf(tanding.getPosessionTeamA()));
                        Log.d("Posession Team B", String.valueOf(tanding.getPosessionTeamB()));
                        Log.d("ID Pertandingan Save", String.valueOf(getidpertandingan()));
                        backtomenu();
                    }

                })
                .setNegativeButton("CANCEL", null).show();


    }

    public void backtomenu() {
        chronometer.stop();
        chronometerteam.stop();

        Intent intent = new Intent(this, MainActivity.class);


        startActivity(intent);
        finish();


    }

    public void passingteama(View v) {

        if (passingstatusteama == "yes") {
            passingteama = passingteama + 1;
            Log.d("passing team a", Integer.toString((passingteama)));

            elapsedchronometerteam = SystemClock.elapsedRealtime() - chronometerteam.getBase();


            Log.d("mili chronometer a", Long.toString(elapsedchronometerteam));

            possesionteama = possesionteama + elapsedchronometerteam;

            Log.d("mili possesion a", Double.toString(possesionteama));
            chronometerteam.setBase(SystemClock.elapsedRealtime());
            chronometerteam.start();
            tanding.setPassingTeamA(tanding.getPassingTeamA() + 1);

            ballpossesionteama = (int) ((possesionteama / (possesionteama + possesionteamb)) * 100);
            ballpossesionteamb = (int) ((possesionteamb / (possesionteama + possesionteamb)) * 100);
            textViewpossesionteama.setText(Integer.toString(ballpossesionteama));
            textViewpossesionteamb.setText(Integer.toString(ballpossesionteamb));
            Log.d("ballpossesion team a", Integer.toString(ballpossesionteama));
            Log.d("ballpossesion team b", Integer.toString(ballpossesionteamb));
            tanding.setPosessionTeamA(ballpossesionteama);
            tanding.setPosessionTeamB(ballpossesionteamb);
        } else {
            chronometerteam.setBase(SystemClock.elapsedRealtime());
            chronometerteam.start();
            passingstatusteama = "yes";
            passingstatusteamb = "no";
        }


    }

    public void keepingballteama(View v) {

        if (passingstatusteama == "yes") {

            elapsedchronometerteam = SystemClock.elapsedRealtime() - chronometerteam.getBase();
            Log.d("mili chronometer", Long.toString(elapsedchronometerteam));

            possesionteama = possesionteama + elapsedchronometerteam;

            Log.d("mili possesion a", Double.toString(possesionteama));
            chronometerteam.setBase(SystemClock.elapsedRealtime());
            chronometerteam.start();
            //tanding.setPassingTeamA(tanding.getPassingTeamA() + 1);

            ballpossesionteama = (int) ((possesionteama / (possesionteama + possesionteamb)) * 100);
            ballpossesionteamb = (int) ((possesionteamb / (possesionteama + possesionteamb)) * 100);
            textViewpossesionteama.setText(Integer.toString(ballpossesionteama));
            textViewpossesionteamb.setText(Integer.toString(ballpossesionteamb));
            Log.d("ballpossesion team a", Integer.toString(ballpossesionteama));
            tanding.setPosessionTeamA(ballpossesionteama);
            tanding.setPosessionTeamB(ballpossesionteamb);
        } else {
            chronometerteam.setBase(SystemClock.elapsedRealtime());
            chronometerteam.start();
            passingstatusteama = "yes";
            passingstatusteamb = "no";
        }


    }


    public void passingteamb(View v) {
        if (passingstatusteamb == "yes") {
            //passingteamb = passingteamb + 1;
            Log.d("passing team b", Integer.toString((passingteamb)));

            elapsedchronometerteamb = SystemClock.elapsedRealtime() - chronometerteam.getBase();
            Log.d("mili chronometer b", Long.toString(elapsedchronometerteamb));

            possesionteamb = possesionteamb + elapsedchronometerteamb;
            Log.d("mili possesion b", Double.toString(possesionteamb));
            chronometerteam.setBase(SystemClock.elapsedRealtime());
            chronometerteam.start();
            tanding.setPassingTeamB(tanding.getPassingTeamB() + 1);


            ballpossesionteamb = (int) ((possesionteamb / (possesionteama + possesionteamb)) * 100);
            ballpossesionteama = (int) ((possesionteama / (possesionteama + possesionteamb)) * 100);

            Log.d("Cek possesion", Double.toString(ballpossesionteamb));
            textViewpossesionteama.setText(Integer.toString(ballpossesionteama));
            textViewpossesionteamb.setText(Integer.toString(ballpossesionteamb));
            tanding.setPosessionTeamA(ballpossesionteama);
            tanding.setPosessionTeamB(ballpossesionteamb);
        } else {
            chronometerteam.setBase(SystemClock.elapsedRealtime());
            chronometerteam.start();
            passingstatusteamb = "yes";
            passingstatusteama = "no";

        }
    }

    public void keepingballteamb(View v) {
        if (passingstatusteamb == "yes") {
            elapsedchronometerteamb = SystemClock.elapsedRealtime() - chronometerteam.getBase();
            Log.d("mili chronometer b", Long.toString(elapsedchronometerteamb));

            possesionteamb = possesionteamb + elapsedchronometerteamb;
            Log.d("mili possesion b", Double.toString(possesionteamb));
            chronometerteam.setBase(SystemClock.elapsedRealtime());
            chronometerteam.start();
            //tanding.setPassingTeamB(tanding.getPassingTeamB() + 1);


            ballpossesionteamb = (int) ((possesionteamb / (possesionteama + possesionteamb)) * 100);
            ballpossesionteama = (int) ((possesionteama / (possesionteama + possesionteamb)) * 100);

            Log.d("Cek possesion", Double.toString(ballpossesionteamb));
            textViewpossesionteama.setText(Integer.toString(ballpossesionteama));
            textViewpossesionteamb.setText(Integer.toString(ballpossesionteamb));
            tanding.setPosessionTeamA(ballpossesionteama);
            tanding.setPosessionTeamB(ballpossesionteamb);
        } else {
            chronometerteam.setBase(SystemClock.elapsedRealtime());
            chronometerteam.start();
            passingstatusteamb = "yes";
            passingstatusteama = "no";

        }
    }

    public void tacklingteama(View v) {
        tacklingteama = tacklingteama + 1;
        Log.d("tackling team a", Integer.toString((tacklingteama)));

        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();
        tanding.setTacklingTeamA(tanding.getTacklingTeamA() + 1);
        passingstatusteama = "yes";
        passingstatusteamb = "no";

    }

    public void tacklingteamb(View v) {
        tacklingteamb = tacklingteamb + 1;
        Log.d("tackling team b", Integer.toString((tacklingteamb)));

        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();
        tanding.setTacklingTeamB(tanding.getTacklingTeamB() + 1);
        passingstatusteama = "no";
        passingstatusteamb = "yes";

    }

    public void interceptteama(View v) {
        interceptteama = interceptteama + 1;
        Log.d("intercept team a", Integer.toString((interceptteama)));


        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();
        tanding.setInterceptTeamA(tanding.getInterceptTeamA() + 1);
        passingstatusteama = "yes";
        passingstatusteamb = "no";

    }

    public void interceptteamb(View v) {
        interceptteamb = interceptteamb + 1;
        Log.d("intercept team b", Integer.toString((interceptteamb)));


        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();
        tanding.setInterceptTeamB(tanding.getInterceptTeamB() + 1);
        passingstatusteama = "no";
        passingstatusteamb = "yes";
    }


    public void throwinteama(View v) {
        throwinteama = throwinteama + 1;
        Log.d("throw in team a", Integer.toString((throwinteama)));

        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setThrowinTeamA(tanding.getThrowinTeamA() + 1);
        passingstatusteama = "no";
        passingstatusteamb = "no";

    }

    public void throwinteamb(View v) {
        throwinteamb = throwinteamb + 1;
        Log.d("throw in team b", Integer.toString((throwinteamb)));

        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setThrowinTeamB(tanding.getThrowinTeamB() + 1);
        passingstatusteama = "no";
        passingstatusteamb = "no";
    }

    public void cornerkickteama(View v) {
        cornerkickteama = cornerkickteama + 1;
        Log.d("corner kick team a", Integer.toString((cornerkickteama)));


        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setCornerkickTeamA(tanding.getCornerkickTeamA() + 1);
        passingstatusteama = "no";
        passingstatusteamb = "no";
    }

    public void inputgoal(String nomor, String namateam, int i, int babak) {
        Log.d("Start ", "input goal");
        PertandinganPemain tandingpemain = new PertandinganPemain();
        int idpemain = dbpemain.loaddataidpemain(nomor, namateam);
        Cursor pertandinganpemain = dbpertandinganpemain.loaddatapertandinganpemain(idpemain, i, babak);
        pertandinganpemain.moveToFirst();
        Log.d("End of ", "input goal");
        if (pertandinganpemain.moveToFirst()) {
            dbpertandinganpemain.updategoal(i, idpemain, babakint);
            Log.d("id pertangingan exist", Integer.toString(i));
            Log.d("jumlah goal", Integer.toString(jumlahgoalpemain(i, idpemain)));
            //dbpertandinganpemain.loaddatapemain();
        } else {
            Log.d("id pertangingan", Integer.toString(i));
            Log.d("jumlah goal", Integer.toString(jumlahgoalpemain(i, idpemain)));
            tandingpemain.setIdpemain(idpemain);
            tandingpemain.setIdpertandingan(i);
            tandingpemain.setJumlahgoal(tandingpemain.getJumlahgoal() + 1);
            tandingpemain.setBabak(babakint);
            //Log.d("id pemain", Integer.toString(listpemainint));
            //Log.d("id pertangingan",Integer.toString(i));
            dbpertandinganpemain.addHandler(tandingpemain);

        }
    }

    public void inputyellow(String nomor, String namateam, int i) {
        Log.d("Start ", "input yellow");
        PertandinganPemain tandingpemain = new PertandinganPemain();
        int idpemain = dbpemain.loaddataidpemain(nomor, namateam);
        Cursor pertandinganpemain = dbpertandinganpemain.loaddatapertandinganpemain(idpemain, i, babakint);
        pertandinganpemain.moveToFirst();
        //Log.d("End of ", "input yellow");
        if (pertandinganpemain.moveToFirst()) {
            dbpertandinganpemain.updateyellow(i, idpemain, babakint);
            Log.d("id pertangingan exist", Integer.toString(i));
            Log.d("jumlah yellow", Integer.toString(jumlahyellowpemain(i, idpemain)));
            //dbpertandinganpemain.loaddatapemain();
        } else {
            Log.d("id pertangingan", Integer.toString(i));
            Log.d("jumlah yellow", Integer.toString(jumlahyellowpemain(i, idpemain)));
            tandingpemain.setIdpemain(idpemain);
            tandingpemain.setIdpertandingan(i);
            tandingpemain.setJumlahyellowcard(tandingpemain.getJumlahyellowcard() + 1);
            tandingpemain.setBabak(babakint);
            //Log.d("id pemain", Integer.toString(listpemainint));
            //Log.d("id pertangingan",Integer.toString(i));
            dbpertandinganpemain.addHandler(tandingpemain);

        }
    }

    public void inputred(String nomor, String namateam, int i) {
        Log.d("Start ", "input red");
        PertandinganPemain tandingpemain = new PertandinganPemain();
        int idpemain = dbpemain.loaddataidpemain(nomor, namateam);
        Cursor pertandinganpemain = dbpertandinganpemain.loaddatapertandinganpemain(idpemain, i, babakint);
        pertandinganpemain.moveToFirst();
        //Log.d("End of ", "input red");
        if (pertandinganpemain.moveToFirst()) {
            dbpertandinganpemain.updatered(i, idpemain,babakint);
            Log.d("id pertangingan exist", Integer.toString(i));
            Log.d("jumlah red", Integer.toString(jumlahredpemain(i, idpemain)));
            //dbpertandinganpemain.loaddatapemain();
        } else {
            Log.d("id pertangingan", Integer.toString(i));
            Log.d("jumlah red", Integer.toString(jumlahredpemain(i, idpemain)));
            tandingpemain.setIdpemain(idpemain);
            tandingpemain.setIdpertandingan(i);
            tandingpemain.setJumlahyellowcard(tandingpemain.getJumlahyellowcard() + 1);
            tandingpemain.setBabak(babakint);
            //Log.d("id pemain", Integer.toString(listpemainint));
            //Log.d("id pertangingan",Integer.toString(i));
            dbpertandinganpemain.addHandler(tandingpemain);

        }
    }

    public void inputshotongoal(String nomor, String namateam, int i) {
        Log.d("Start ", "on goal");
        PertandinganPemain tandingpemain = new PertandinganPemain();
        int idpemain = dbpemain.loaddataidpemain(nomor, namateam);
        Cursor pertandinganpemain = dbpertandinganpemain.loaddatapertandinganpemain(idpemain, i, babakint);
        pertandinganpemain.moveToFirst();
        //Log.d("End of ", "input on goal");
        if (pertandinganpemain.moveToFirst()) {
            dbpertandinganpemain.updateshotongoal(i, idpemain, babakint);
            Log.d("id pertangingan exist", Integer.toString(i));
            Log.d("jumlah on goal", Integer.toString(jumlahongoalpemain(i, idpemain)));
            //dbpertandinganpemain.loaddatapemain();
        } else {
            Log.d("id pertangingan", Integer.toString(i));
            Log.d("jumlah on goal", Integer.toString(jumlahongoalpemain(i, idpemain)));
            tandingpemain.setIdpemain(idpemain);
            tandingpemain.setIdpertandingan(i);
            tandingpemain.setJumlahshotontarget(tandingpemain.getJumlahshotontarget() + 1);
            tandingpemain.setBabak(babakint);
            //Log.d("id pemain", Integer.toString(listpemainint));
            //Log.d("id pertangingan",Integer.toString(i));
            dbpertandinganpemain.addHandler(tandingpemain);

        }
    }

    public void inputshotoffgoal(String nomor, String namateam, int i) {
        Log.d("Start ", "off goal");
        PertandinganPemain tandingpemain = new PertandinganPemain();
        int idpemain = dbpemain.loaddataidpemain(nomor, namateam);
        Cursor pertandinganpemain = dbpertandinganpemain.loaddatapertandinganpemain(idpemain, i, babakint);
        pertandinganpemain.moveToFirst();
        //Log.d("End of ", "input off goal");
        if (pertandinganpemain.moveToFirst()) {
            dbpertandinganpemain.updateshotoffgoal(i, idpemain, babakint);
            Log.d("id pertangingan exist", Integer.toString(i));
            Log.d("jumlah off goal", Integer.toString(jumlahoffgoalpemain(i, idpemain)));
            //dbpertandinganpemain.loaddatapemain();
        } else {
            Log.d("id pertangingan", Integer.toString(i));
            Log.d("jumlah off goal", Integer.toString(jumlahoffgoalpemain(i, idpemain)));
            tandingpemain.setIdpemain(idpemain);
            tandingpemain.setIdpertandingan(i);
            tandingpemain.setJumlahshotofftarget(tandingpemain.getJumlahshotofftarget() + 1);
            tandingpemain.setBabak(babakint);
            //Log.d("id pemain", Integer.toString(listpemainint));
            //Log.d("id pertangingan",Integer.toString(i));
            dbpertandinganpemain.addHandler(tandingpemain);

        }
    }

    public void inputdatagoal(String nomor, String namateam, int i, String waktu, String status) {
        Log.d("Start ", "off goal");
        goal datagoal = new goal();
        int idpemain = dbpemain.loaddataidpemain(nomor, namateam);
        int idteam = dbteam.loaddataidteam(namateam);
        //Log.d("End of ", "input off goal");
        datagoal.setIdpertandingan(i);
        datagoal.setIdpemain(idpemain);
        datagoal.setIdteam(idteam);
        datagoal.setMenit(waktu);
        datagoal.setStatusgoal(status);
        datagoal.setBabak(babakint);
        dbgoal.addHandler(datagoal);
    }

    public int jumlahgoalpemain(int idpertandingan, int idpemain) {
        int goal;
        Cursor jumlahgoal = dbpertandinganpemain.loaddatapertandinganpemain(idpemain, idpertandingan, babakint);
        if (jumlahgoal.moveToFirst()) {
            jumlahgoal.moveToFirst();
            goal = jumlahgoal.getInt(2);
        } else {
            goal = 0;
        }
        return goal;
    }


    public int jumlahongoalpemain(int idpertandingan, int idpemain) {
        int goal;
        Cursor jumlahgoal = dbpertandinganpemain.loaddatapertandinganpemain(idpemain, idpertandingan, babakint);
        if (jumlahgoal.moveToFirst()) {
            jumlahgoal.moveToFirst();
            goal = jumlahgoal.getInt(5);
        } else {
            goal = 0;
        }
        return goal;
    }

    public int jumlahoffgoalpemain(int idpertandingan, int idpemain) {
        int goal;
        Cursor jumlahgoal = dbpertandinganpemain.loaddatapertandinganpemain(idpemain, idpertandingan, babakint);
        if (jumlahgoal.moveToFirst()) {
            jumlahgoal.moveToFirst();
            goal = jumlahgoal.getInt(6);
        } else {
            goal = 0;
        }
        return goal;
    }


    public int jumlahyellowpemain(int idpertandingan, int idpemain) {
        int yellow;
        Cursor jumlahyellow = dbpertandinganpemain.loaddatapertandinganpemain(idpemain, idpertandingan, babakint);
        if (jumlahyellow.moveToFirst()) {
            jumlahyellow.moveToFirst();
            yellow = jumlahyellow.getInt(3);
        } else {
            yellow = 0;
        }
        return yellow;
    }

    public int jumlahredpemain(int idpertandingan, int idpemain) {
        int red;
        Cursor jumlahred = dbpertandinganpemain.loaddatapertandinganpemain(idpemain, idpertandingan, babakint);
        if (jumlahred.moveToFirst()) {
            jumlahred.moveToFirst();
            red = jumlahred.getInt(4);
        } else {
            red = 0;
        }
        return red;
    }


    public void cornerkickteamb(View v) {
        cornerkickteamb = cornerkickteamb + 1;
        Log.d("corner kick team b", Integer.toString((cornerkickteamb)));

        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setCornerkickTeamB(tanding.getCornerkickTeamB() + 1);
        passingstatusteama = "no";
        passingstatusteamb = "no";
    }

    public void pinaltyteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();

        Cursor datagoalteama = dbpemain.loaddatateam(teamA);
        List<String> listpemaingoalteama = new ArrayList<String>();
        datagoalteama.moveToFirst();
        while (!datagoalteama.isAfterLast()) {
            listpemaingoalteama.add(datagoalteama.getString(3));
            Log.d("list pemain goal team a", datagoalteama.getString(3));
            datagoalteama.moveToNext();
        }


        AlertDialog.Builder builder = new AlertDialog.Builder(recordstat.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
        final Spinner mSpinner = (Spinner) mView.findViewById(R.id.spinnerplayer);
        final EditText editTextinputplayer = (EditText) mView.findViewById(R.id.editTextinputplayer);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemaingoalteama);
        mSpinner.setAdapter(arrayAdapter);


        builder.setTitle("Pick Player");
        builder.setPositiveButton("GOAL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                goalteama = goalteama + 1;
                shootontargetteama = shootontargetteama + 1;
                tanding.setGoalTeamA(tanding.getGoalTeamA() + 1);
                tanding.setShootOnTargetTeamA(tanding.getShootOnTargetTeamA() + 1);
                tanding.setPinaltyTeamA(tanding.getPinaltyTeamA() + 1);
                String chronotext = chronometer.getText().toString();
                String array[] = chronotext.split(":");

                Log.d("time goal", array[0]);

                if (TextUtils.isEmpty(editTextinputplayer.getText().toString())) {
                    pemain = mSpinner.getSelectedItem().toString();
                } else {
                    pemain = editTextinputplayer.getText().toString();

                }

                goalnotea = pemain + " (P)'" + array[0];

                cetakgoalteama.add(goalnotea);
                arrayAdaptercetakgoalteama = new ArrayAdapter<>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, cetakgoalteama);


                Log.d("Pemain Goal Team A", pemain);
                //Log.d("Pemain Goal Team A", cetakgoalteama.get(0));
                //Log.d("Pemain Goal Team A", cetakgoalteama.get(1));
                int datagoalteama = dbpemain.loaddataidpemain(pemain, teamA);
                List<String> listpemaingoalteama = new ArrayList<String>();
                Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                if (datapertandingan.moveToFirst()) {
                    inputgoal(pemain, teamA, getidpertandingan(), babakint);
                    inputshotongoal(pemain, teamA, getidpertandingan());
                    inputdatagoal(pemain, teamA, getidpertandingan(), array[0], "Pinalty"+ statusgoal);
                } else {
                    Log.d("belum ada ", "data pertadingan");
                    inputgoal(pemain, teamA, getidpertandingan(), babakint);
                    inputshotongoal(pemain, teamA, getidpertandingan());
                    inputdatagoal(pemain, teamA, getidpertandingan(), array[0], "Pinalty"+ statusgoal);

                }
                dialog.dismiss();
            }

        });
        builder.setNegativeButton("MISSED", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                shootontargetteama = shootontargetteama + 1;
                savesteamb = savesteamb + 1;
                tanding.setShootOnTargetTeamA(tanding.getShootOnTargetTeamA() + 1);
                tanding.setSavesTeamB(tanding.getSavesTeamB() + 1);
                tanding.setPinaltyTeamA(tanding.getPinaltyTeamA() + 1);
                String chronotext = chronometer.getText().toString();
                String array[] = chronotext.split(":");

                Log.d("time goal", array[0]);
                if (TextUtils.isEmpty(editTextinputplayer.getText().toString())) {

                    pemain = mSpinner.getSelectedItem().toString();
                } else {
                    pemain = editTextinputplayer.getText().toString();

                }

                goalnotea = pemain + " (Missed)'" + array[0];

                cetakgoalteama.add(goalnotea);
                arrayAdaptercetakgoalteama = new ArrayAdapter<>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, cetakgoalteama);


                Log.d("Pemain Missed Team A", pemain);
                //Log.d("Pemain Goal Team A", cetakgoalteama.get(0));
                //Log.d("Pemain Goal Team A", cetakgoalteama.get(1));

                int datagoalteama = dbpemain.loaddataidpemain(pemain, teamA);

                dialog.dismiss();
            }
        });
        builder.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();

            }
        });
        builder.setView(mView);
        AlertDialog dialog = builder.create();
        dialog.show();
        passingstatusteama = "no";
        passingstatusteamb = "no";
    }

    public void pinaltyteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();

        TeamDBHandler dbgoalb = new TeamDBHandler(this);
        Cursor loadDataTeamgoalb = dbpemain.loaddatateam(teamB);
        List<String> spinnerArraygoalb = new ArrayList<String>();
        loadDataTeamgoalb.moveToFirst();
        while (!loadDataTeamgoalb.isAfterLast()) {
            spinnerArraygoalb.add(loadDataTeamgoalb.getString(3));
            Log.d("Data spinner ", loadDataTeamgoalb.getString(3));
            loadDataTeamgoalb.moveToNext();
        }
        Cursor datagoalteamb = dbpemain.loaddatateam(teamB);
        List<String> listpemaingoalteamb = new ArrayList<String>();
        datagoalteamb.moveToFirst();
        while (!datagoalteamb.isAfterLast()) {
            listpemaingoalteamb.add(datagoalteamb.getString(3));
            Log.d("Data spinner ", datagoalteamb.getString(3));
            datagoalteamb.moveToNext();
        }
        AlertDialog.Builder buildergoalb = new AlertDialog.Builder(recordstat.this);
        View mViewgoalb = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
        final Spinner mSpinnergoalb = (Spinner) mViewgoalb.findViewById(R.id.spinnerplayer);
        final EditText editTextinputplayerb = (EditText) mViewgoalb.findViewById(R.id.editTextinputplayer);
        ArrayAdapter<String> arrayAdaptergoalb = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemaingoalteamb);
        mSpinnergoalb.setAdapter(arrayAdaptergoalb);


        buildergoalb.setTitle("Pick Player");
        buildergoalb.setPositiveButton("GOAL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(recordstat.this, "Goal Team B", Toast.LENGTH_SHORT).show();
                goalteamb = goalteamb + 1;
                shootontargetteamb = shootontargetteamb + 1;
                tanding.setGoalTeamB(tanding.getGoalTeamB() + 1);
                tanding.setShootOnTargetTeamB(tanding.getShootOnTargetTeamB() + 1);
                tanding.setPinaltyTeamB(tanding.getPinaltyTeamB() + 1);
                String chronotext = chronometer.getText().toString();
                String array[] = chronotext.split(":");

                Log.d("time goal", array[0]);
                if (TextUtils.isEmpty(editTextinputplayerb.getText().toString())) {

                    pemainb = mSpinnergoalb.getSelectedItem().toString();
                } else {
                    pemainb = editTextinputplayerb.getText().toString();

                }
                goalnoteb = pemainb + " (P)'" + array[0];

                Log.d("pemain team b", goalnoteb);


                cetakgoalteamb.add(goalnoteb);
                arrayAdaptercetakgoalteamb = new ArrayAdapter<>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, cetakgoalteamb);
                Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                if (datapertandingan.moveToFirst()) {
                    Log.d("Enter if ", "input goal");
                    inputgoal(pemainb, teamB, getidpertandingan(), babakint);
                    inputshotongoal(pemainb, teamB, getidpertandingan());
                    inputdatagoal(pemainb, teamB, getidpertandingan(), array[0], "Pinalty"+ statusgoal);
                } else {
                    Log.d("belum ada ", "data pertadingan");
                    inputgoal(pemainb, teamB, getidpertandingan(), babakint);
                    inputshotongoal(pemainb, teamB, getidpertandingan());
                    inputdatagoal(pemainb, teamB, getidpertandingan(), array[0], "Pinalty"+ statusgoal);
                }


                dialog.dismiss();
            }

        });
        buildergoalb.setNegativeButton("MISSED", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shootontargetteamb = shootontargetteamb + 1;
                savesteama = savesteama + 1;
                tanding.setShootOnTargetTeamB(tanding.getShootOnTargetTeamB() + 1);
                tanding.setSavesTeamA(tanding.getSavesTeamA() + 1);
                tanding.setPinaltyTeamB(tanding.getPinaltyTeamB() + 1);
                String chronotext = chronometer.getText().toString();
                String array[] = chronotext.split(":");

                Log.d("time goal", array[0]);

                if (TextUtils.isEmpty(editTextinputplayerb.getText().toString())) {

                    pemainb = mSpinnergoalb.getSelectedItem().toString();
                } else {
                    pemainb = editTextinputplayerb.getText().toString();

                }

                goalnoteb = pemainb + " (Missed)'" + array[0];

                Log.d("pemain missed team b", goalnoteb);


                cetakgoalteamb.add(goalnoteb);
                arrayAdaptercetakgoalteamb = new ArrayAdapter<>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, cetakgoalteamb);


                dialog.dismiss();
            }
        });

        buildergoalb.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });


        buildergoalb.setView(mViewgoalb);
        AlertDialog dialoggoalb = buildergoalb.create();
        dialoggoalb.show();
        passingstatusteama = "no";
        passingstatusteamb = "no";
    }

    public void freekickteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        passingstatusteama = "no";
        passingstatusteamb = "no";
        tanding.setFreekickTeamA(tanding.getFreekickTeamA() + 1);
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_freekick);
        popup.show();

    }

    public void freekickteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        passingstatusteama = "no";
        passingstatusteamb = "no";
        tanding.setFreekickTeamB(tanding.getFreekickTeamB() + 1);
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_freekickb);
        popup.show();
    }

    public void goalkickteama(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        passingstatusteama = "no";
        passingstatusteamb = "no";
        tanding.setGoalkickTeamA(tanding.getGoalkickTeamA() + 1);
    }

    public void goalkickteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        passingstatusteama = "no";
        passingstatusteamb = "no";
        tanding.setGoalkickTeamB(tanding.getGoalkickTeamB() + 1);
    }


    public void showpopupshootinga(View v) {
        if (passingstatusteama == "yes") {
            elapsedchronometerteam = SystemClock.elapsedRealtime() - chronometerteam.getBase();
            Log.d("mili chronometer a", Long.toString(elapsedchronometerteam));
            possesionteama = possesionteama + elapsedchronometerteam;
            ballpossesionteama = (int) ((possesionteama / (possesionteama + possesionteamb)) * 100);
            ballpossesionteamb = (int) ((possesionteamb / (possesionteama + possesionteamb)) * 100);
            textViewpossesionteama.setText(Integer.toString(ballpossesionteama));
            textViewpossesionteamb.setText(Integer.toString(ballpossesionteamb));

            chronometerteam.stop();
            chronometerteam.setBase(SystemClock.elapsedRealtime());


            PopupMenu popup = new PopupMenu(this, v);
            popup.setOnMenuItemClickListener(this);
            popup.inflate(R.menu.popup_shooting);
            popup.show();
            passingstatusteama = "no";
            passingstatusteamb = "no";
        } else {
            chronometerteam.stop();
            chronometerteam.setBase(SystemClock.elapsedRealtime());


            PopupMenu popup = new PopupMenu(this, v);
            popup.setOnMenuItemClickListener(this);
            popup.inflate(R.menu.popup_shooting);
            popup.show();
            passingstatusteama = "no";
            passingstatusteamb = "no";

        }
    }

    public void showpopupshootingb(View v) {
        if (passingstatusteamb == "yes") {
            elapsedchronometerteamb = SystemClock.elapsedRealtime() - chronometerteam.getBase();
            Log.d("mili chronometer b", Long.toString(elapsedchronometerteamb));

            possesionteamb = possesionteamb + elapsedchronometerteamb;
            Log.d("mili possesion b", Double.toString(possesionteamb));


            ballpossesionteama = (int) ((possesionteama / (possesionteama + possesionteamb)) * 100);
            ballpossesionteamb = (int) ((possesionteamb / (possesionteama + possesionteamb)) * 100);
            textViewpossesionteama.setText(Integer.toString(ballpossesionteama));
            textViewpossesionteamb.setText(Integer.toString(ballpossesionteamb));

            chronometerteam.stop();
            chronometerteam.setBase(SystemClock.elapsedRealtime());

            PopupMenu popup = new PopupMenu(this, v);
            popup.setOnMenuItemClickListener(this);
            popup.inflate(R.menu.popup_shootingb);
            popup.show();
            passingstatusteama = "no";
            passingstatusteamb = "no";
        } else {
            chronometerteam.stop();
            chronometerteam.setBase(SystemClock.elapsedRealtime());

            PopupMenu popup = new PopupMenu(this, v);
            popup.setOnMenuItemClickListener(this);
            popup.inflate(R.menu.popup_shootingb);
            popup.show();
            passingstatusteama = "no";
            passingstatusteamb = "no";
        }
    }

    public void yellowcard(View v) {


        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.getMenu().add(1, R.id.yellowhome, 1, teamA);
        popup.getMenu().add(1, R.id.yellowaway, 2, teamB);
        popup.show();
        passingstatusteama = "no";
        passingstatusteamb = "no";

    }

    public void redcard(View v) {

        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.getMenu().add(1, R.id.redhome, 1, teamA);
        popup.getMenu().add(1, R.id.redaway, 2, teamB);
        popup.show();
        passingstatusteama = "no";
        passingstatusteamb = "no";
    }

    public void inputname() {
        Intent intent = new Intent(this, InputName.class);
        startActivity(intent);

    }


    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.goal:


                Cursor datagoalteama = dbpemain.loaddatateam(teamA);
                List<String> listpemaingoalteama = new ArrayList<String>();
                datagoalteama.moveToFirst();
                while (!datagoalteama.isAfterLast()) {
                    listpemaingoalteama.add(datagoalteama.getString(3));
                    Log.d("list pemain goal team a", datagoalteama.getString(3));
                    datagoalteama.moveToNext();
                }


                AlertDialog.Builder builder = new AlertDialog.Builder(recordstat.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                final Spinner mSpinner = (Spinner) mView.findViewById(R.id.spinnerplayer);
                final EditText editTextinputplayer = (EditText) mView.findViewById(R.id.editTextinputplayer);
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemaingoalteama);
                mSpinner.setAdapter(arrayAdapter);


                builder.setTitle("Pick Player");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(recordstat.this, "Goal Team A", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        String pemain = mSpinner.getSelectedItem().toString();
                        //List<String> cetakgoalteama = new ArrayList<>();
                        //cetakgoalteama.add(pemain);
                        goalteama = goalteama + 1;
                        shootontargetteama = shootontargetteama + 1;
                        tanding.setGoalTeamA(tanding.getGoalTeamA() + 1);
                        tanding.setShootOnTargetTeamA(tanding.getShootOnTargetTeamA() + 1);
                        String chronotext = chronometer.getText().toString();

                        String array[] = chronotext.split(":");


                        Log.d("time goal", array[0]);
                        if (TextUtils.isEmpty(editTextinputplayer.getText().toString())) {
                            pemain = mSpinner.getSelectedItem().toString();

                        } else {
                            pemain = editTextinputplayer.getText().toString();
                        }

                        goalnotea = pemain + " " + array[0] + "'";

                        cetakgoalteama.add(goalnotea);
                        arrayAdaptercetakgoalteama = new ArrayAdapter<>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, cetakgoalteama);


                        Log.d("Pemain Goal Team A", pemain);
                        //Log.d("Pemain Goal Team A", cetakgoalteama.get(1));
                        //Log.d("Pemain Goal Team A", cetakgoalteama.get(0));
                        //int datagoalteama=dbpemain.loaddataidpemain(pemain, teamA);
                        Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                        if (datapertandingan.moveToFirst()) {
                            Log.d("Enter if ", "input goal");
                            inputgoal(pemain, teamA, getidpertandingan(), babakint);
                            inputshotongoal(pemain, teamA, getidpertandingan());
                            inputdatagoal(pemain, teamA, getidpertandingan(), array[0], "On Play");
                        } else {
                            Log.d("belum ada ", "data pertadingan");
                            inputgoal(pemain, teamA, getidpertandingan(), babakint);
                            inputshotongoal(pemain, teamA, getidpertandingan());
                            inputdatagoal(pemain, teamA, getidpertandingan(), array[0], "On Play");
                        }
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

                return true;
            case R.id.shootontarget:
                shootontargetteama = shootontargetteama + 1;
                savesteamb = savesteamb + 1;
                tanding.setShootOnTargetTeamA(tanding.getShootOnTargetTeamA() + 1);
                tanding.setSavesTeamB(tanding.getSavesTeamB() + 1);
                //Toast.makeText(this, "Shoot On Target Team A", Toast.LENGTH_SHORT).show();
                Cursor datashootontargeta = dbpemain.loaddatateam(teamA);
                List<String> listpemainshootontargeta = new ArrayList<String>();
                datashootontargeta.moveToFirst();
                while (!datashootontargeta.isAfterLast()) {
                    listpemainshootontargeta.add(datashootontargeta.getString(3));
                    Log.d("Data spinner ", datashootontargeta.getString(3));
                    datashootontargeta.moveToNext();
                }
                AlertDialog.Builder buildershootontargeta = new AlertDialog.Builder(recordstat.this);
                View mViewshootontargeta = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                final Spinner mSpinnershootontargeta = (Spinner) mViewshootontargeta.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdaptershootontargeta = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemainshootontargeta);
                mSpinnershootontargeta.setAdapter(arrayAdaptershootontargeta);


                buildershootontargeta.setTitle("Pick Player");
                buildershootontargeta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(recordstat.this, "Shoot On Target Team A", Toast.LENGTH_SHORT).show();
                        pemain = mSpinnershootontargeta.getSelectedItem().toString();
                        Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                        if (datapertandingan.moveToFirst()) {
                            Log.d("Enter if ", "input goal");
                            inputshotongoal(pemain, teamA, getidpertandingan());
                        } else {
                            Log.d("belum ada ", "data pertadingan");
                            inputshotongoal(pemain, teamA, getidpertandingan());
                        }
                        dialog.dismiss();
                    }

                });
                buildershootontargeta.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                buildershootontargeta.setView(mViewshootontargeta);
                AlertDialog dialogshootontargeta = buildershootontargeta.create();
                dialogshootontargeta.show();


                return true;
            case R.id.shootofftarget:
                shootofftargetteama = shootofftargetteama + 1;
                tanding.setShootOffTargetTeamA(tanding.getShootOffTargetTeamA() + 1);
                //Toast.makeText(this, "Shoot Off Target Team A", Toast.LENGTH_SHORT).show();
                Cursor datashootofftargeta = dbpemain.loaddatateam(teamA);
                List<String> listpemainshootofftargeta = new ArrayList<String>();
                datashootofftargeta.moveToFirst();
                while (!datashootofftargeta.isAfterLast()) {
                    listpemainshootofftargeta.add(datashootofftargeta.getString(3));
                    Log.d("Data spinner ", datashootofftargeta.getString(3));
                    datashootofftargeta.moveToNext();
                }
                AlertDialog.Builder buildershootofftargeta = new AlertDialog.Builder(recordstat.this);
                View mViewshootofftargeta = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                final Spinner mSpinnershootofftargeta = (Spinner) mViewshootofftargeta.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdaptershootofftargeta = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemainshootofftargeta);
                mSpinnershootofftargeta.setAdapter(arrayAdaptershootofftargeta);


                buildershootofftargeta.setTitle("Pick Player");
                buildershootofftargeta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(recordstat.this, "Shoot Off Target Team A", Toast.LENGTH_SHORT).show();
                        pemain = mSpinnershootofftargeta.getSelectedItem().toString();
                        Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                        if (datapertandingan.moveToFirst()) {
                            Log.d("Enter if ", "input goal");
                            inputshotoffgoal(pemain, teamA, getidpertandingan());
                        } else {
                            Log.d("belum ada ", "data pertadingan");
                            inputshotoffgoal(pemain, teamA, getidpertandingan());
                        }
                        dialog.dismiss();
                    }

                });
                buildershootofftargeta.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                buildershootofftargeta.setView(mViewshootofftargeta);
                AlertDialog dialogshootofftargeta = buildershootofftargeta.create();
                dialogshootofftargeta.show();


                return true;
            case R.id.goalb:

                TeamDBHandler dbgoalb = new TeamDBHandler(this);
                Cursor loadDataTeamgoalb = dbgoalb.loaddatateam();
                List<String> spinnerArraygoalb = new ArrayList<String>();
                loadDataTeamgoalb.moveToFirst();
                while (!loadDataTeamgoalb.isAfterLast()) {
                    spinnerArraygoalb.add(loadDataTeamgoalb.getString(1));
                    Log.d("Data spinner ", loadDataTeamgoalb.getString(1));
                    loadDataTeamgoalb.moveToNext();
                }
                Cursor datagoalteamb = dbpemain.loaddatateam(teamB);
                List<String> listpemaingoalteamb = new ArrayList<String>();
                datagoalteamb.moveToFirst();
                while (!datagoalteamb.isAfterLast()) {
                    listpemaingoalteamb.add(datagoalteamb.getString(3));
                    Log.d("Data spinner ", datagoalteamb.getString(3));
                    datagoalteamb.moveToNext();
                }
                AlertDialog.Builder buildergoalb = new AlertDialog.Builder(recordstat.this);
                View mViewgoalb = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                final Spinner mSpinnergoalb = (Spinner) mViewgoalb.findViewById(R.id.spinnerplayer);
                final EditText editTextinputplayerb = (EditText) mViewgoalb.findViewById(R.id.editTextinputplayer);
                ArrayAdapter<String> arrayAdaptergoalb = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemaingoalteamb);
                mSpinnergoalb.setAdapter(arrayAdaptergoalb);


                buildergoalb.setTitle("Pick Player");
                buildergoalb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(recordstat.this, "Goal Team B", Toast.LENGTH_SHORT).show();
                        goalteamb = goalteamb + 1;
                        shootontargetteamb = shootontargetteamb + 1;
                        tanding.setGoalTeamB(tanding.getGoalTeamB() + 1);
                        tanding.setShootOnTargetTeamB(tanding.getShootOnTargetTeamB() + 1);

                        String chronotext = chronometer.getText().toString();
                        String array[] = chronotext.split(":");

                        Log.d("time goal", array[0]);
                        if (TextUtils.isEmpty(editTextinputplayerb.getText().toString())) {

                            pemainb = mSpinnergoalb.getSelectedItem().toString();
                        } else {
                            pemainb = editTextinputplayerb.getText().toString();

                        }

                        goalnoteb = pemainb + " '" + array[0];

                        Log.d("pemain team b", goalnoteb);


                        cetakgoalteamb.add(goalnoteb);
                        arrayAdaptercetakgoalteamb = new ArrayAdapter<>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, cetakgoalteamb);

                        Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                        if (datapertandingan.moveToFirst()) {
                            Log.d("Enter if ", "input goal");
                            inputgoal(pemainb, teamB, getidpertandingan(), babakint);
                            inputshotongoal(pemainb, teamB, getidpertandingan());
                            inputdatagoal(pemainb, teamB, getidpertandingan(), array[0], "On Play");
                        } else {
                            Log.d("belum ada ", "data pertadingan");
                            inputgoal(pemainb, teamB, getidpertandingan(), babakint);
                            inputshotongoal(pemainb, teamB, getidpertandingan());
                            inputdatagoal(pemainb, teamB, getidpertandingan(), array[0], "On Play");
                        }

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

                return true;
            case R.id.shootontargetb:
                shootontargetteamb = shootontargetteamb + 1;
                savesteama = savesteama + 1;
                tanding.setShootOnTargetTeamB(tanding.getShootOnTargetTeamB() + 1);
                tanding.setSavesTeamA(tanding.getSavesTeamA() + 1);
                //Toast.makeText(this, "Shoot On Target Team B", Toast.LENGTH_SHORT).show();
                Cursor datashootontargetb = dbpemain.loaddatateam(teamB);
                List<String> listpemainshootontargetb = new ArrayList<String>();
                datashootontargetb.moveToFirst();
                while (!datashootontargetb.isAfterLast()) {
                    listpemainshootontargetb.add(datashootontargetb.getString(3));
                    Log.d("Data spinner ", datashootontargetb.getString(3));
                    datashootontargetb.moveToNext();
                }
                AlertDialog.Builder buildershootontargetb = new AlertDialog.Builder(recordstat.this);
                View mViewshootontargetb = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                final Spinner mSpinnershootontargetb = (Spinner) mViewshootontargetb.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdaptershootontargetb = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemainshootontargetb);
                mSpinnershootontargetb.setAdapter(arrayAdaptershootontargetb);


                buildershootontargetb.setTitle("Pick Player");
                buildershootontargetb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(recordstat.this, "Shoot On Target Team B", Toast.LENGTH_SHORT).show();
                        pemain = mSpinnershootontargetb.getSelectedItem().toString();
                        Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                        if (datapertandingan.moveToFirst()) {
                            Log.d("Enter if ", "input goal");
                            inputshotongoal(pemain, teamB, getidpertandingan());
                        } else {
                            Log.d("belum ada ", "data pertadingan");
                            inputshotongoal(pemain, teamB, getidpertandingan());
                        }
                        dialog.dismiss();
                    }

                });
                buildershootontargetb.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                buildershootontargetb.setView(mViewshootontargetb);
                AlertDialog dialogshootontargetb = buildershootontargetb.create();
                dialogshootontargetb.show();

                chronometerteam.start();

                return true;
            case R.id.shootofftargetb:
                shootofftargetteamb = shootofftargetteamb + 1;
                tanding.setShootOffTargetTeamB(tanding.getShootOffTargetTeamB() + 1);
                //Toast.makeText(this, "Shoot Off Target Team B", Toast.LENGTH_SHORT).show();
                Cursor datashootofftargetb = dbpemain.loaddatateam(teamB);
                List<String> listpemainshootofftargetb = new ArrayList<String>();
                datashootofftargetb.moveToFirst();
                while (!datashootofftargetb.isAfterLast()) {
                    listpemainshootofftargetb.add(datashootofftargetb.getString(3));
                    Log.d("Data spinner ", datashootofftargetb.getString(3));
                    datashootofftargetb.moveToNext();
                }
                AlertDialog.Builder buildershootofftargetb = new AlertDialog.Builder(recordstat.this);
                View mViewshootofftargetb = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                final Spinner mSpinnershootofftargetb = (Spinner) mViewshootofftargetb.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdaptershootofftargetb = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemainshootofftargetb);
                mSpinnershootofftargetb.setAdapter(arrayAdaptershootofftargetb);


                buildershootofftargetb.setTitle("Pick Player");
                buildershootofftargetb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(recordstat.this, "Shoot Off Target Team B", Toast.LENGTH_SHORT).show();
                        pemain = mSpinnershootofftargetb.getSelectedItem().toString();
                        Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                        if (datapertandingan.moveToFirst()) {
                            Log.d("Enter if ", "input goal");
                            inputshotoffgoal(pemain, teamB, getidpertandingan());
                        } else {
                            Log.d("belum ada ", "data pertadingan");
                            inputshotoffgoal(pemain, teamB, getidpertandingan());
                        }
                        dialog.dismiss();
                    }

                });
                buildershootofftargetb.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                buildershootofftargetb.setNeutralButton("INPUT NAME", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        inputname();

                    }
                });
                buildershootofftargetb.setView(mViewshootofftargetb);
                AlertDialog dialogshootofftargetb = buildershootofftargetb.create();
                dialogshootofftargetb.show();


                return true;

            case R.id.yellowhome:
                chronometerteam.setBase(SystemClock.elapsedRealtime());
                chronometerteam.stop();
                Cursor datayellowhome = dbpemain.loaddatateam(teamA);
                List<String> listpemainyellowhome = new ArrayList<String>();
                datayellowhome.moveToFirst();
                while (!datayellowhome.isAfterLast()) {
                    listpemainyellowhome.add(datayellowhome.getString(3));
                    Log.d("Data spinner ", datayellowhome.getString(3));
                    datayellowhome.moveToNext();
                }

                AlertDialog.Builder builderyellowhome = new AlertDialog.Builder(recordstat.this);
                View mViewyellowhome = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                final Spinner mSpinneryellowhome = (Spinner) mViewyellowhome.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdapteryellowhome = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemainyellowhome);
                mSpinneryellowhome.setAdapter(arrayAdapteryellowhome);

                builderyellowhome.setTitle("Pick Player");
                builderyellowhome.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        yellowcardteama = yellowcardteama + 1;
                        tanding.setYellowcardTeamA(tanding.getYellowcardTeamA() + 1);
                        Toast.makeText(recordstat.this, "Yellow Team A", Toast.LENGTH_SHORT).show();
                        String pemain = mSpinneryellowhome.getSelectedItem().toString();
                        Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                        if (datapertandingan.moveToFirst()) {
                            Log.d("Enter if ", "input yellow");
                            inputyellow(pemain, teamA, getidpertandingan());
                            ;
                        } else {
                            Log.d("belum ada ", "data pertadingan");
                            inputyellow(pemain, teamA, getidpertandingan());
                        }
                        dialog.dismiss();
                    }

                });
                builderyellowhome.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


                builderyellowhome.setView(mViewyellowhome);
                AlertDialog dialogyellowhome = builderyellowhome.create();
                dialogyellowhome.show();
                return true;

            case R.id.yellowaway:
                chronometerteam.setBase(SystemClock.elapsedRealtime());
                chronometerteam.stop();
                Cursor datayellowaway = dbpemain.loaddatateam(teamB);
                List<String> listpemainyellowaway = new ArrayList<String>();
                datayellowaway.moveToFirst();
                while (!datayellowaway.isAfterLast()) {
                    listpemainyellowaway.add(datayellowaway.getString(3));
                    Log.d("Data spinner ", datayellowaway.getString(3));
                    datayellowaway.moveToNext();
                }

                AlertDialog.Builder builderyellowaway = new AlertDialog.Builder(recordstat.this);
                View mViewyellowaway = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                final Spinner mSpinneryellowaway = (Spinner) mViewyellowaway.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdapteryellowaway = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemainyellowaway);
                mSpinneryellowaway.setAdapter(arrayAdapteryellowaway);

                builderyellowaway.setTitle("Pick Player");
                builderyellowaway.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(recordstat.this, "Yellow Team B", Toast.LENGTH_SHORT).show();
                        yellowcardteamb = yellowcardteamb + 1;
                        tanding.setYellowcardTeamB(tanding.getYellowcardTeamB() + 1);
                        String pemain = mSpinneryellowaway.getSelectedItem().toString();
                        Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                        if (datapertandingan.moveToFirst()) {
                            Log.d("Enter if ", "input yellow");
                            inputyellow(pemain, teamB, getidpertandingan());
                            ;
                        } else {
                            Log.d("belum ada ", "data pertadingan");
                            inputyellow(pemain, teamB, getidpertandingan());
                        }
                        dialog.dismiss();
                    }

                });
                builderyellowaway.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


                builderyellowaway.setView(mViewyellowaway);
                AlertDialog dialogyellowaway = builderyellowaway.create();
                dialogyellowaway.show();
                return true;

            case R.id.redhome:
                chronometerteam.setBase(SystemClock.elapsedRealtime());
                chronometerteam.stop();
                Cursor dataredhome = dbpemain.loaddatateam(teamA);
                List<String> listpemainredhome = new ArrayList<String>();
                dataredhome.moveToFirst();
                while (!dataredhome.isAfterLast()) {
                    listpemainredhome.add(dataredhome.getString(3));
                    Log.d("Data spinner ", dataredhome.getString(3));
                    dataredhome.moveToNext();
                }

                AlertDialog.Builder builderredhome = new AlertDialog.Builder(recordstat.this);
                View mViewredhome = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                final Spinner mSpinnerredhome = (Spinner) mViewredhome.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdapterredhome = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemainredhome);
                mSpinnerredhome.setAdapter(arrayAdapterredhome);

                builderredhome.setTitle("Pick Player");
                builderredhome.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(recordstat.this, "RED CARD Team A", Toast.LENGTH_SHORT).show();
                        redcardteama = redcardteama + 1;
                        tanding.setRedcardTeamA(tanding.getRedcardTeamA() + 1);
                        String pemain = mSpinnerredhome.getSelectedItem().toString();
                        Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                        if (datapertandingan.moveToFirst()) {
                            Log.d("Enter if ", "input yellow");
                            inputred(pemain, teamA, getidpertandingan());
                            ;
                        } else {
                            Log.d("belum ada ", "data pertadingan");
                            inputred(pemain, teamA, getidpertandingan());
                        }
                        dialog.dismiss();
                    }

                });
                builderredhome.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


                builderredhome.setView(mViewredhome);
                AlertDialog dialogredhome = builderredhome.create();
                dialogredhome.show();
                return true;

            case R.id.redaway:
                chronometerteam.setBase(SystemClock.elapsedRealtime());
                chronometerteam.stop();
                Cursor dataredaway = dbpemain.loaddatateam(teamB);
                List<String> listpemainredaway = new ArrayList<String>();
                dataredaway.moveToFirst();
                while (!dataredaway.isAfterLast()) {
                    listpemainredaway.add(dataredaway.getString(3));
                    Log.d("Data spinner ", dataredaway.getString(3));
                    dataredaway.moveToNext();
                }

                AlertDialog.Builder builderredaway = new AlertDialog.Builder(recordstat.this);
                View mViewredaway = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                final Spinner mSpinnerredaway = (Spinner) mViewredaway.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdapterredaway = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemainredaway);
                mSpinnerredaway.setAdapter(arrayAdapterredaway);

                builderredaway.setTitle("Pick Player");
                builderredaway.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(recordstat.this, "RED CARD Team B", Toast.LENGTH_SHORT).show();
                        redcardteamb = redcardteamb + 1;
                        tanding.setRedcardTeamB(tanding.getRedcardTeamB() + 1);
                        String pemain = mSpinnerredaway.getSelectedItem().toString();
                        Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                        if (datapertandingan.moveToFirst()) {
                            Log.d("Enter if ", "input yellow");
                            inputred(pemain, teamB, getidpertandingan());
                            ;
                        } else {
                            Log.d("belum ada ", "data pertadingan");
                            inputred(pemain, teamB, getidpertandingan());
                        }
                        dialog.dismiss();
                    }

                });
                builderredaway.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


                builderredaway.setView(mViewredaway);
                AlertDialog dialogredaway = builderredaway.create();
                dialogredaway.show();
                return true;

            case R.id.foulhome:
                foulteama = foulteama + 1;
                tanding.setFoulTeamA(tanding.getFoulTeamA() + 1);
                Log.d("hitung foul team a", Integer.toString(foulteama));
                Toast.makeText(recordstat.this, "Foul Team A", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.offsidehome:
                offsideteama = offsideteama + 1;
                tanding.setOffsideTeamA(tanding.getOffsideTeamA() + 1);
                Log.d("hitung offside team a", Integer.toString(offsideteama));
                Toast.makeText(recordstat.this, "Offside Team A", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.foulaway:
                foulteamb = foulteamb + 1;
                tanding.setFoulTeamB(tanding.getFoulTeamB() + 1);
                Log.d("hitung foul team b", Integer.toString(foulteamb));
                Toast.makeText(recordstat.this, "Foul Team B", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.offsideaway:
                offsideteamb = offsideteamb + 1;
                tanding.setOffsideTeamB(tanding.getOffsideTeamB() + 1);
                Log.d("hitung offside team b", Integer.toString(offsideteamb));
                Toast.makeText(recordstat.this, "Offside Team A", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return false;


        }
    }
}
