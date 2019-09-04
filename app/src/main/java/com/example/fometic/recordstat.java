package com.example.fometic;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.media.MediaPlayer;
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


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    MediaPlayer cornerkick;
    MediaPlayer freekick;
    MediaPlayer goalkick;
    MediaPlayer intercept;
    MediaPlayer keepingball;
    MediaPlayer passing;
    MediaPlayer pinalty;
    MediaPlayer red;
    MediaPlayer yellow;
    MediaPlayer shooting;
    MediaPlayer tackling;
    MediaPlayer throwin;


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

    PemainBola datapemain = new PemainBola();
    Pertandingan tanding = new Pertandingan();
    PemainDBHandler dbpemain = new PemainDBHandler(this);
    PertandinganDBHandler dbpertandingan = new PertandinganDBHandler(this);
    PertandinganPemainDBHandler dbpertandinganpemain = new PertandinganPemainDBHandler(this);
    goalDBHandler dbgoal = new goalDBHandler(this);
    TeamDBHandler dbteam = new TeamDBHandler(this);


    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }
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
        tanding.setTimematch(Integer.valueOf(timematch));
        tanding.setWaktupertandingan(Calendar.getInstance().getTime());

        cornerkick = MediaPlayer.create(this, R.raw.cornerkick);
        freekick = MediaPlayer.create(this, R.raw.freekick);
        goalkick = MediaPlayer.create(this, R.raw.goalkick);
        intercept = MediaPlayer.create(this, R.raw.intercept);
        keepingball = MediaPlayer.create(this, R.raw.keepingball);
        passing = MediaPlayer.create(this, R.raw.passing);
        pinalty = MediaPlayer.create(this, R.raw.pinalty);
        red = MediaPlayer.create(this, R.raw.red);
        shooting = MediaPlayer.create(this, R.raw.shooting);
        tackling = MediaPlayer.create(this, R.raw.tackling);
        throwin = MediaPlayer.create(this, R.raw.throwin);
        yellow = MediaPlayer.create(this, R.raw.yellow);


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
        } else if (babak.equals("2ndhalf")) {
            babakint = 2;
            Cursor datapertandingan = dbpertandingan.loaddatapertandinganshow(getidpertandingan()
                    , 1);
            datapertandingan.moveToFirst();
            timematchint = datapertandingan.getInt(45);
            statusgoal = "";
        } else if (babak.equals("Ex1sthalf")) {
            babakint = 3;
            Cursor datapertandingan = dbpertandingan.loaddatapertandinganshow(getidpertandingan()
                    , 1);
            datapertandingan.moveToFirst();
            Integer timematchintbabak1 = datapertandingan.getInt(45);
            Cursor datapertandingan2 =
                    dbpertandingan.loaddatapertandinganshow(getidpertandingan(), 2);
            datapertandingan2.moveToFirst();
            Integer timematchintbabak2 = datapertandingan2.getInt(45);
            timematchint = timematchintbabak1 + timematchintbabak2;
            statusgoal = "(Ex)";
        } else if (babak.equals("Ex2ndhalf")) {
            babakint = 4;
            Cursor datapertandingan = dbpertandingan.loaddatapertandinganshow(getidpertandingan()
                    , 1);
            datapertandingan.moveToFirst();
            Integer timematchintbabak1 = datapertandingan.getInt(45);
            Cursor datapertandingan2 =
                    dbpertandingan.loaddatapertandinganshow(getidpertandingan(), 2);
            datapertandingan2.moveToFirst();
            Integer timematchintbabak2 = datapertandingan2.getInt(45);
            Cursor datapertandingan3 =
                    dbpertandingan.loaddatapertandinganshow(getidpertandingan(), 3);
            datapertandingan3.moveToFirst();
            Integer timematchintbabak3 = datapertandingan3.getInt(45);
            timematchint = timematchintbabak1 + timematchintbabak2 + timematchintbabak3;
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
        if (running == 1) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
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

    public void setDataPemain(String namatim, String namapemain, String posisipemain,
                              Integer nomorpunggungpemain) {
        datapemain.setNamaPemain(namapemain);
        datapemain.setPosisi(posisipemain);
        datapemain.setNomorPunggung(nomorpunggungpemain);
        datapemain.setTeam(namatim);
        dbteam.loaddatateam();
        dbpemain.addHandler(datapemain, dbteam.loaddataidteam(namatim));
    }

    public int getidpertandingan() {
        Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
        int i = 1;
        datapertandingan.moveToFirst();
        //Log.d("Enter if ", "input goal");

        while (!datapertandingan.isAfterLast()) {

            //Log.d("Enter while ", "input goal");

            if (datapertandingan.getInt(33) == 1 && babakint == 2) {
                i = datapertandingan.getInt(0);
            } else if (datapertandingan.getInt(33) == 2 && babakint == 3) {
                i = datapertandingan.getInt(0);
            } else if (datapertandingan.getInt(33) == 3 && babakint == 4) {
                i = datapertandingan.getInt(0);
            } else {
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
        passing.start();

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

            ballpossesionteama = (int) Math.round((possesionteama / (possesionteama + possesionteamb)) * 100);
            ballpossesionteamb = (int) Math.round((possesionteamb / (possesionteama + possesionteamb)) * 100);
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
        keepingball.start();
        if (passingstatusteama == "yes") {

            elapsedchronometerteam = SystemClock.elapsedRealtime() - chronometerteam.getBase();
            Log.d("mili chronometer", Long.toString(elapsedchronometerteam));

            possesionteama = possesionteama + elapsedchronometerteam;

            Log.d("mili possesion a", Double.toString(possesionteama));
            chronometerteam.setBase(SystemClock.elapsedRealtime());
            chronometerteam.start();
            //tanding.setPassingTeamA(tanding.getPassingTeamA() + 1);

            ballpossesionteama = (int) Math.round((possesionteama / (possesionteama + possesionteamb)) * 100);
            ballpossesionteamb = (int) Math.round((possesionteamb / (possesionteama + possesionteamb)) * 100);
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
        passing.start();
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


            ballpossesionteamb = (int) Math.round((possesionteamb / (possesionteama + possesionteamb)) * 100);
            ballpossesionteama = (int) Math.round((possesionteama / (possesionteama + possesionteamb)) * 100);

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
        keepingball.start();
        if (passingstatusteamb == "yes") {
            elapsedchronometerteamb = SystemClock.elapsedRealtime() - chronometerteam.getBase();
            Log.d("mili chronometer b", Long.toString(elapsedchronometerteamb));

            possesionteamb = possesionteamb + elapsedchronometerteamb;
            Log.d("mili possesion b", Double.toString(possesionteamb));
            chronometerteam.setBase(SystemClock.elapsedRealtime());
            chronometerteam.start();
            //tanding.setPassingTeamB(tanding.getPassingTeamB() + 1);


            ballpossesionteamb = (int) Math.round((possesionteamb / (possesionteama + possesionteamb)) * 100);
            ballpossesionteama = (int) Math.round((possesionteama / (possesionteama + possesionteamb)) * 100);

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
        tackling.start();
        Log.d("tackling team a", Integer.toString((tacklingteama)));
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
        final EditText editTextinputplayer =
                (EditText) mView.findViewById(R.id.editTextinputplayer);
        final Spinner posisispinner = (Spinner) mView.findViewById(R.id.spinnerposisi3);
        final EditText editTextinputnomorpunggung =
                (EditText) mView.findViewById(R.id.textNomorPunggung2);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(recordstat.this,
                R.layout.support_simple_spinner_dropdown_item, listpemaingoalteama);
        mSpinner.setAdapter(arrayAdapter);


        builder.setTitle("Pick Player");

        builder.setPositiveButton("OK", null);
        builder.setNegativeButton("CANCEL", null);
        builder.setView(mView);
        final AlertDialog dialog = builder.create();
        dialog.show();
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextinputplayer.getText().toString().isEmpty() && editTextinputnomorpunggung.getText().toString().isEmpty()) {
                    Toast.makeText(recordstat.this, "Tackling Team A", Toast.LENGTH_SHORT).show();
                    String pemain = mSpinner.getSelectedItem().toString();
                    //List<String> cetakgoalteama = new ArrayList<>();
                    //cetakgoalteama.add(pemain);
                    tacklingteama = tacklingteama + 1;
                    tanding.setTacklingTeamA(tanding.getTacklingTeamA() + 1);
                    arrayAdaptercetakgoalteama = new ArrayAdapter<>(recordstat.this,
                            R.layout.support_simple_spinner_dropdown_item, cetakgoalteama);


                    Log.d("Pemain Tackling Team A", pemain);
                    chronometerteam.setBase(SystemClock.elapsedRealtime());
                    chronometerteam.start();
                    //Log.d("Pemain Goal Team A", cetakgoalteama.get(1));
                    //Log.d("Pemain Goal Team A", cetakgoalteama.get(0));
                    //int datagoalteama=dbpemain.loaddataidpemain(pemain, teamA);
                    Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                    if (datapertandingan.moveToFirst()) {
                        Log.d("Enter if ", "input tackling");
                        inputtackling(pemain, teamA, getidpertandingan(), babakint);
                    } else {
                        Log.d("belum ada ", "data pertadingan");
                        inputtackling(pemain, teamA, getidpertandingan(), babakint);
                    }
                    dialog.dismiss();
                } else if (editTextinputplayer.getText().toString().isEmpty() || editTextinputnomorpunggung.getText().toString().isEmpty()) {
                    Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak Boleh " +
                            "Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    String namapemain = editTextinputplayer.getText().toString();
                    String posisipemain = posisispinner.getSelectedItem().toString();
                    int nomorpunggungpemain =
                            Integer.parseInt(editTextinputnomorpunggung.getText().toString());
                    setDataPemain(teamA, namapemain, posisipemain, nomorpunggungpemain);
                    Toast.makeText(recordstat.this, "Input Data Pemain", Toast.LENGTH_SHORT).show();


                    tacklingteama = tacklingteama + 1;
                    tanding.setTacklingTeamA(tanding.getTacklingTeamA() + 1);
                    //arrayAdaptercetakgoalteama = new ArrayAdapter<>(recordstat.this, R.layout
                    // .support_simple_spinner_dropdown_item, cetakgoalteama);


                    //Log.d("Pemain Tackling Team A", pemain);
                    chronometerteam.setBase(SystemClock.elapsedRealtime());
                    chronometerteam.start();
                    //Log.d("Pemain Goal Team A", cetakgoalteama.get(1));
                    //Log.d("Pemain Goal Team A", cetakgoalteama.get(0));
                    //int datagoalteama=dbpemain.loaddataidpemain(pemain, teamA);
                    Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                    if (datapertandingan.moveToFirst()) {
                        Log.d("Enter if ", "input tackling");
                        inputtackling(editTextinputnomorpunggung.getText().toString(), teamA,
                                getidpertandingan(), babakint);
                    } else {
                        Log.d("belum ada ", "data pertadingan");
                        inputtackling(editTextinputnomorpunggung.getText().toString(), teamA,
                                getidpertandingan(), babakint);
                    }

                    dialog.dismiss();

                }

            }
        });


        passingstatusteama = "yes";
        passingstatusteamb = "no";

    }

    public void tacklingteamb(View v) {
        tackling.start();
        Log.d("tackling team b", Integer.toString((tacklingteamb)));
        Cursor datagoalteamb = dbpemain.loaddatateam(teamB);
        List<String> listpemaingoalteamb = new ArrayList<String>();
        datagoalteamb.moveToFirst();
        while (!datagoalteamb.isAfterLast()) {
            listpemaingoalteamb.add(datagoalteamb.getString(3));
            Log.d("list pemain goal team a", datagoalteamb.getString(3));
            datagoalteamb.moveToNext();
        }


        AlertDialog.Builder builder = new AlertDialog.Builder(recordstat.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
        final Spinner mSpinner = (Spinner) mView.findViewById(R.id.spinnerplayer);
        final EditText editTextinputplayer =
                (EditText) mView.findViewById(R.id.editTextinputplayer);
        final Spinner posisispinner = (Spinner) mView.findViewById(R.id.spinnerposisi3);
        final EditText editTextinputnomorpunggung =
                (EditText) mView.findViewById(R.id.textNomorPunggung2);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(recordstat.this,
                R.layout.support_simple_spinner_dropdown_item, listpemaingoalteamb);
        mSpinner.setAdapter(arrayAdapter);


        builder.setTitle("Pick Player");

        builder.setPositiveButton("OK", null);
        builder.setNegativeButton("CANCEL", null);
        builder.setView(mView);
        final AlertDialog dialog = builder.create();
        dialog.show();
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextinputplayer.getText().toString().isEmpty() && editTextinputnomorpunggung.getText().toString().isEmpty()) {
                    String pemain = mSpinner.getSelectedItem().toString();

                    tacklingteamb = tacklingteamb + 1;
                    tanding.setTacklingTeamB(tanding.getTacklingTeamB() + 1);
                    arrayAdaptercetakgoalteama = new ArrayAdapter<>(recordstat.this,
                            R.layout.support_simple_spinner_dropdown_item, cetakgoalteamb);


                    Log.d("Pemain Tackling Team B", pemain);
                    chronometerteam.setBase(SystemClock.elapsedRealtime());
                    chronometerteam.start();
                    Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                    if (datapertandingan.moveToFirst()) {
                        Log.d("Enter if ", "input tackling");
                        inputtackling(pemain, teamB, getidpertandingan(), babakint);
                    } else {
                        Log.d("belum ada ", "data pertadingan");
                        inputtackling(pemain, teamB, getidpertandingan(), babakint);
                    }
                    dialog.dismiss();
                } else if (editTextinputplayer.getText().toString().isEmpty() || editTextinputnomorpunggung.getText().toString().isEmpty()) {
                    Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak Boleh " +
                            "Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    String namapemain = editTextinputplayer.getText().toString();
                    String posisipemain = posisispinner.getSelectedItem().toString();
                    int nomorpunggungpemain =
                            Integer.parseInt(editTextinputnomorpunggung.getText().toString());
                    setDataPemain(teamB, namapemain, posisipemain, nomorpunggungpemain);
                    Toast.makeText(recordstat.this, "Input Data Pemain", Toast.LENGTH_SHORT).show();


                    tacklingteamb = tacklingteamb + 1;
                    tanding.setTacklingTeamB(tanding.getTacklingTeamB() + 1);
                    //arrayAdaptercetakgoalteama = new ArrayAdapter<>(recordstat.this, R.layout
                    // .support_simple_spinner_dropdown_item, cetakgoalteama);


                    //Log.d("Pemain Tackling Team A", pemain);
                    chronometerteam.setBase(SystemClock.elapsedRealtime());
                    chronometerteam.start();
                    //Log.d("Pemain Goal Team A", cetakgoalteama.get(1));
                    //Log.d("Pemain Goal Team A", cetakgoalteama.get(0));
                    //int datagoalteama=dbpemain.loaddataidpemain(pemain, teamA);
                    Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                    if (datapertandingan.moveToFirst()) {
                        Log.d("Enter if ", "input tackling");
                        inputtackling(editTextinputnomorpunggung.getText().toString(), teamB,
                                getidpertandingan(), babakint);
                    } else {
                        Log.d("belum ada ", "data pertadingan");
                        inputtackling(editTextinputnomorpunggung.getText().toString(), teamB,
                                getidpertandingan(), babakint);
                    }

                    dialog.dismiss();

                }

            }

        });


        passingstatusteama = "no";
        passingstatusteamb = "yes";

    }

    public void interceptteama(View v) {
        intercept.start();
        Log.d("intercept team a", Integer.toString((interceptteama)));

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
        final EditText editTextinputplayer =
                (EditText) mView.findViewById(R.id.editTextinputplayer);
        final Spinner posisispinner = (Spinner) mView.findViewById(R.id.spinnerposisi3);
        final EditText editTextinputnomorpunggung =
                (EditText) mView.findViewById(R.id.textNomorPunggung2);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(recordstat.this,
                R.layout.support_simple_spinner_dropdown_item, listpemaingoalteama);
        mSpinner.setAdapter(arrayAdapter);


        builder.setTitle("Pick Player");

        builder.setPositiveButton("OK", null);
        builder.setNegativeButton("CANCEL", null);
        builder.setView(mView);
        final AlertDialog dialog = builder.create();
        dialog.show();
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextinputplayer.getText().toString().isEmpty() && editTextinputnomorpunggung.getText().toString().isEmpty()) {


                    Toast.makeText(recordstat.this, "Intercept Team A", Toast.LENGTH_SHORT).show();
                    String pemain = mSpinner.getSelectedItem().toString();
                    //interceptteama = interceptteama + 1;
                    tanding.setInterceptTeamA(tanding.getInterceptTeamA() + 1);


                    Log.d("Intercept Team A", pemain);
                    chronometerteam.setBase(SystemClock.elapsedRealtime());
                    chronometerteam.start();
                    Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                    if (datapertandingan.moveToFirst()) {
                        Log.d("Enter if ", "input tackling");
                        inputintercept(pemain, teamA, getidpertandingan(), babakint);
                    } else {
                        Log.d("belum ada ", "data pertadingan");
                        inputintercept(pemain, teamA, getidpertandingan(), babakint);
                    }
                    dialog.dismiss();
                } else if (editTextinputplayer.getText().toString().isEmpty() || editTextinputnomorpunggung.getText().toString().isEmpty()) {
                    Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak Boleh " +
                            "Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    String namapemain = editTextinputplayer.getText().toString();
                    String posisipemain = posisispinner.getSelectedItem().toString();
                    int nomorpunggungpemain =
                            Integer.parseInt(editTextinputnomorpunggung.getText().toString());
                    setDataPemain(teamA, namapemain, posisipemain, nomorpunggungpemain);
                    Toast.makeText(recordstat.this, "Input Data Pemain", Toast.LENGTH_SHORT).show();


                    //tacklingteama = tacklingteama + 1;
                    tanding.setInterceptTeamA(tanding.getInterceptTeamA() + 1);
                    //arrayAdaptercetakgoalteama = new ArrayAdapter<>(recordstat.this, R.layout
                    // .support_simple_spinner_dropdown_item, cetakgoalteama);


                    //Log.d("Pemain Tackling Team A", pemain);
                    chronometerteam.setBase(SystemClock.elapsedRealtime());
                    chronometerteam.start();
                    //Log.d("Pemain Goal Team A", cetakgoalteama.get(1));
                    //Log.d("Pemain Goal Team A", cetakgoalteama.get(0));
                    //int datagoalteama=dbpemain.loaddataidpemain(pemain, teamA);
                    Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                    if (datapertandingan.moveToFirst()) {
                        Log.d("Enter if ", "input tackling");
                        inputintercept(editTextinputnomorpunggung.getText().toString(), teamA,
                                getidpertandingan(), babakint);
                    } else {
                        Log.d("belum ada ", "data pertadingan");
                        inputintercept(editTextinputnomorpunggung.getText().toString(), teamA,
                                getidpertandingan(), babakint);
                    }

                    dialog.dismiss();

                }


            }

        });


        passingstatusteama = "yes";
        passingstatusteamb = "no";

    }

    public void interceptteamb(View v) {
        intercept.start();
        Log.d("intercept team b", Integer.toString((interceptteamb)));

        Cursor datagoalteamb = dbpemain.loaddatateam(teamB);
        List<String> listpemaingoalteamb = new ArrayList<String>();
        datagoalteamb.moveToFirst();
        while (!datagoalteamb.isAfterLast()) {
            listpemaingoalteamb.add(datagoalteamb.getString(3));
            Log.d("list pemain goal team a", datagoalteamb.getString(3));
            datagoalteamb.moveToNext();
        }


        AlertDialog.Builder builder = new AlertDialog.Builder(recordstat.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
        final Spinner mSpinner = (Spinner) mView.findViewById(R.id.spinnerplayer);
        final EditText editTextinputplayer =
                (EditText) mView.findViewById(R.id.editTextinputplayer);
        final Spinner posisispinner = (Spinner) mView.findViewById(R.id.spinnerposisi3);
        final EditText editTextinputnomorpunggung =
                (EditText) mView.findViewById(R.id.textNomorPunggung2);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(recordstat.this,
                R.layout.support_simple_spinner_dropdown_item, listpemaingoalteamb);
        mSpinner.setAdapter(arrayAdapter);


        builder.setTitle("Pick Player");

        builder.setPositiveButton("OK", null);
        builder.setNegativeButton("CANCEL", null);
        builder.setView(mView);
        final AlertDialog dialog = builder.create();
        dialog.show();
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextinputplayer.getText().toString().isEmpty() && editTextinputnomorpunggung.getText().toString().isEmpty()) {


                    Toast.makeText(recordstat.this, "Intercept Team A", Toast.LENGTH_SHORT).show();
                    String pemain = mSpinner.getSelectedItem().toString();
                    //interceptteama = interceptteama + 1;
                    tanding.setInterceptTeamB(tanding.getInterceptTeamB() + 1);


                    Log.d("Intercept Team A", pemain);
                    chronometerteam.setBase(SystemClock.elapsedRealtime());
                    chronometerteam.start();
                    Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                    if (datapertandingan.moveToFirst()) {
                        Log.d("Enter if ", "input tackling");
                        inputintercept(pemain, teamB, getidpertandingan(), babakint);
                    } else {
                        Log.d("belum ada ", "data pertadingan");
                        inputintercept(pemain, teamB, getidpertandingan(), babakint);
                    }
                    dialog.dismiss();
                } else if (editTextinputplayer.getText().toString().isEmpty() || editTextinputnomorpunggung.getText().toString().isEmpty()) {
                    Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak Boleh " +
                            "Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    String namapemain = editTextinputplayer.getText().toString();
                    String posisipemain = posisispinner.getSelectedItem().toString();
                    int nomorpunggungpemain =
                            Integer.parseInt(editTextinputnomorpunggung.getText().toString());
                    setDataPemain(teamB, namapemain, posisipemain, nomorpunggungpemain);
                    Toast.makeText(recordstat.this, "Input Data Pemain", Toast.LENGTH_SHORT).show();


                    //tacklingteama = tacklingteama + 1;
                    tanding.setInterceptTeamB(tanding.getInterceptTeamB() + 1);
                    //arrayAdaptercetakgoalteama = new ArrayAdapter<>(recordstat.this, R.layout
                    // .support_simple_spinner_dropdown_item, cetakgoalteama);


                    //Log.d("Pemain Tackling Team A", pemain);
                    chronometerteam.setBase(SystemClock.elapsedRealtime());
                    chronometerteam.start();
                    //Log.d("Pemain Goal Team A", cetakgoalteama.get(1));
                    //Log.d("Pemain Goal Team A", cetakgoalteama.get(0));
                    //int datagoalteama=dbpemain.loaddataidpemain(pemain, teamA);
                    Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                    if (datapertandingan.moveToFirst()) {
                        Log.d("Enter if ", "input tackling");
                        inputintercept(editTextinputnomorpunggung.getText().toString(), teamB,
                                getidpertandingan(), babakint);
                    } else {
                        Log.d("belum ada ", "data pertadingan");
                        inputintercept(editTextinputnomorpunggung.getText().toString(), teamB,
                                getidpertandingan(), babakint);
                    }

                    dialog.dismiss();

                }


            }

        });

        passingstatusteama = "no";
        passingstatusteamb = "yes";
    }


    public void throwinteama(View v) {
        throwin.start();
        throwinteama = throwinteama + 1;
        Log.d("throw in team a", Integer.toString((throwinteama)));

        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setThrowinTeamA(tanding.getThrowinTeamA() + 1);
        passingstatusteama = "no";
        passingstatusteamb = "no";

    }

    public void throwinteamb(View v) {
        throwin.start();
        throwinteamb = throwinteamb + 1;
        Log.d("throw in team b", Integer.toString((throwinteamb)));

        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setThrowinTeamB(tanding.getThrowinTeamB() + 1);
        passingstatusteama = "no";
        passingstatusteamb = "no";
    }

    public void cornerkickteama(View v) {
        cornerkick.start();
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
        Cursor pertandinganpemain = dbpertandinganpemain.loaddatapertandinganpemain(idpemain, i,
                babak);
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

    public void inputintercept(String nomor, String namateam, int i, int babak) {
        Log.d("Start ", "input goal");
        PertandinganPemain tandingpemain = new PertandinganPemain();
        int idpemain = dbpemain.loaddataidpemain(nomor, namateam);
        Cursor pertandinganpemain = dbpertandinganpemain.loaddatapertandinganpemain(idpemain, i,
                babak);
        pertandinganpemain.moveToFirst();
        Log.d("End of ", "input goal");
        if (pertandinganpemain.moveToFirst()) {
            dbpertandinganpemain.updateintercept(i, idpemain, babakint);
            Log.d("id pertangingan exist", Integer.toString(i));
            Log.d("jumlah goal", Integer.toString(jumlahinterceptpemain(i, idpemain)));
            //dbpertandinganpemain.loaddatapemain();
        } else {
            Log.d("id pertangingan", Integer.toString(i));
            Log.d("jumlah goal", Integer.toString(jumlahinterceptpemain(i, idpemain)));
            tandingpemain.setIdpemain(idpemain);
            tandingpemain.setIdpertandingan(i);
            tandingpemain.setJumlahintercept(tandingpemain.getJumlahintercept() + 1);
            tandingpemain.setBabak(babakint);
            //Log.d("id pemain", Integer.toString(listpemainint));
            //Log.d("id pertangingan",Integer.toString(i));
            dbpertandinganpemain.addHandler(tandingpemain);

        }
    }

    public void inputsaves(String namateam, int i, int babak) {
        Log.d("Start ", "input goal");
        String nomor = "";
        PemainDBHandler dbteam = new PemainDBHandler(this);
        Cursor kiper = dbteam.loaddataposisi("Goalkeeper", namateam);
        kiper.moveToFirst();
        if (!kiper.isAfterLast()) {
            nomor = kiper.getString(3);
            kiper.moveToNext();
        }
        PertandinganPemain tandingpemain = new PertandinganPemain();
        int idpemain = dbpemain.loaddataidpemain(nomor, namateam);
        Cursor pertandinganpemain = dbpertandinganpemain.loaddatapertandinganpemain(idpemain, i,
                babak);
        pertandinganpemain.moveToFirst();
        Log.d("End of ", "input goal");
        if (pertandinganpemain.moveToFirst()) {
            dbpertandinganpemain.updatesaves(i, idpemain, babakint);
            Log.d("id pertangingan exist", Integer.toString(i));
            Log.d("jumlah goal", Integer.toString(jumlahsavespemain(i, idpemain)));
            //dbpertandinganpemain.loaddatapemain();
        } else {
            Log.d("id pertangingan", Integer.toString(i));
            Log.d("jumlah goal", Integer.toString(jumlahsavespemain(i, idpemain)));
            tandingpemain.setIdpemain(idpemain);
            tandingpemain.setIdpertandingan(i);
            tandingpemain.setJumlahsaves(tandingpemain.getJumlahsaves() + 1);
            tandingpemain.setBabak(babakint);
            //Log.d("id pemain", Integer.toString(listpemainint));
            //Log.d("id pertangingan",Integer.toString(i));
            dbpertandinganpemain.addHandler(tandingpemain);

        }
    }

    public void inputtackling(String nomor, String namateam, int i, int babak) {
        Log.d("Start ", "input goal");
        PertandinganPemain tandingpemain = new PertandinganPemain();
        int idpemain = dbpemain.loaddataidpemain(nomor, namateam);
        Cursor pertandinganpemain = dbpertandinganpemain.loaddatapertandinganpemain(idpemain, i,
                babak);
        pertandinganpemain.moveToFirst();
        Log.d("End of ", "input goal");
        if (pertandinganpemain.moveToFirst()) {
            dbpertandinganpemain.updatetackling(i, idpemain, babakint);
            Log.d("id pertangingan exist", Integer.toString(i));
            Log.d("jumlah goal", Integer.toString(jumlahtacklingpemain(i, idpemain)));
            //dbpertandinganpemain.loaddatapemain();
        } else {
            Log.d("id pertangingan", Integer.toString(i));
            Log.d("jumlah goal", Integer.toString(jumlahtacklingpemain(i, idpemain)));
            tandingpemain.setIdpemain(idpemain);
            tandingpemain.setIdpertandingan(i);
            tandingpemain.setJumlahtackling(tandingpemain.getJumlahtackling() + 1);
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
        Cursor pertandinganpemain = dbpertandinganpemain.loaddatapertandinganpemain(idpemain, i,
                babakint);
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
        Cursor pertandinganpemain = dbpertandinganpemain.loaddatapertandinganpemain(idpemain, i,
                babakint);
        pertandinganpemain.moveToFirst();
        //Log.d("End of ", "input red");
        if (pertandinganpemain.moveToFirst()) {
            dbpertandinganpemain.updatered(i, idpemain, babakint);
            Log.d("id pertangingan exist", Integer.toString(i));
            Log.d("jumlah red", Integer.toString(jumlahredpemain(i, idpemain)));
            //dbpertandinganpemain.loaddatapemain();
        } else {
            Log.d("id pertangingan", Integer.toString(i));
            Log.d("jumlah red", Integer.toString(jumlahredpemain(i, idpemain)));
            tandingpemain.setIdpemain(idpemain);
            tandingpemain.setIdpertandingan(i);
            tandingpemain.setJumlahredcard(tandingpemain.getJumlahredcard() + 1);
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
        Cursor pertandinganpemain = dbpertandinganpemain.loaddatapertandinganpemain(idpemain, i,
                babakint);
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
        Cursor pertandinganpemain = dbpertandinganpemain.loaddatapertandinganpemain(idpemain, i,
                babakint);
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
        Cursor jumlahgoal = dbpertandinganpemain.loaddatapertandinganpemain(idpemain,
                idpertandingan, babakint);
        if (jumlahgoal.moveToFirst()) {
            jumlahgoal.moveToFirst();
            goal = jumlahgoal.getInt(2);
        } else {
            goal = 0;
        }
        return goal;
    }

    public int jumlahinterceptpemain(int idpertandingan, int idpemain) {
        int goal;
        Cursor jumlahgoal = dbpertandinganpemain.loaddatapertandinganpemain(idpemain,
                idpertandingan, babakint);
        if (jumlahgoal.moveToFirst()) {
            jumlahgoal.moveToFirst();
            goal = jumlahgoal.getInt(9);
        } else {
            goal = 0;
        }
        return goal;
    }


    public int jumlahtacklingpemain(int idpertandingan, int idpemain) {
        int goal;
        Cursor jumlahgoal = dbpertandinganpemain.loaddatapertandinganpemain(idpemain,
                idpertandingan, babakint);
        if (jumlahgoal.moveToFirst()) {
            jumlahgoal.moveToFirst();
            goal = jumlahgoal.getInt(8);
        } else {
            goal = 0;
        }
        return goal;
    }

    public int jumlahsavespemain(int idpertandingan, int idpemain) {
        int goal;
        Cursor jumlahgoal = dbpertandinganpemain.loaddatapertandinganpemain(idpemain,
                idpertandingan, babakint);
        if (jumlahgoal.moveToFirst()) {
            jumlahgoal.moveToFirst();
            goal = jumlahgoal.getInt(10);
        } else {
            goal = 0;
        }
        return goal;
    }


    public int jumlahongoalpemain(int idpertandingan, int idpemain) {
        int goal;
        Cursor jumlahgoal = dbpertandinganpemain.loaddatapertandinganpemain(idpemain,
                idpertandingan, babakint);
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
        Cursor jumlahgoal = dbpertandinganpemain.loaddatapertandinganpemain(idpemain,
                idpertandingan, babakint);
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
        Cursor jumlahyellow = dbpertandinganpemain.loaddatapertandinganpemain(idpemain,
                idpertandingan, babakint);
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
        Cursor jumlahred = dbpertandinganpemain.loaddatapertandinganpemain(idpemain,
                idpertandingan, babakint);
        if (jumlahred.moveToFirst()) {
            jumlahred.moveToFirst();
            red = jumlahred.getInt(4);
        } else {
            red = 0;
        }
        return red;
    }


    public void cornerkickteamb(View v) {
        cornerkick.start();
        cornerkickteamb = cornerkickteamb + 1;
        Log.d("corner kick team b", Integer.toString((cornerkickteamb)));

        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setCornerkickTeamB(tanding.getCornerkickTeamB() + 1);
        passingstatusteama = "no";
        passingstatusteamb = "no";
    }

    public void pinaltyteama(View v) {
        pinalty.start();
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
        final EditText editTextinputplayer =
                (EditText) mView.findViewById(R.id.editTextinputplayer);
        final Spinner posisispinner = (Spinner) mView.findViewById(R.id.spinnerposisi3);
        final EditText editTextinputnomorpunggung =
                (EditText) mView.findViewById(R.id.textNomorPunggung2);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(recordstat.this,
                R.layout.support_simple_spinner_dropdown_item, listpemaingoalteama);
        mSpinner.setAdapter(arrayAdapter);

        builder.setTitle("Pick Player");

        builder.setPositiveButton("GOAL", null);
        builder.setNegativeButton("MISSED", null);
        builder.setNeutralButton("CANCEL", null);
        builder.setView(mView);
        final AlertDialog dialog = builder.create();
        dialog.show();
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextinputplayer.getText().toString().isEmpty() && editTextinputnomorpunggung.getText().toString().isEmpty()) {

                    tanding.setGoalTeamA(tanding.getGoalTeamA() + 1);
                    tanding.setShootOnTargetTeamA(tanding.getShootOnTargetTeamA() + 1);
                    tanding.setPinaltyTeamA(tanding.getPinaltyTeamA() + 1);
                    tanding.setFoulTeamB(tanding.getFoulTeamB() + 1);
                    String chronotext = chronometer.getText().toString();
                    String array[] = chronotext.split(":");
                    Integer arrayint = Integer.parseInt(array[0]) + timematchint;
                    array[0] = String.valueOf(arrayint);
                    Log.d("time goal edited", array[0]);


                    //if (TextUtils.isEmpty(editTextinputplayer.getText().toString())) {
                    pemain = mSpinner.getSelectedItem().toString();
                    //} else {
                    //  pemain = editTextinputplayer.getText().toString();

                    //}

                    //goalnotea = pemain + " (P)'" + array[0];

                    //cetakgoalteama.add(goalnotea);
                    //arrayAdaptercetakgoalteama = new ArrayAdapter<>(recordstat.this, R.layout
                    // .support_simple_spinner_dropdown_item, cetakgoalteama);


                    Log.d("Pemain Goal Team A", pemain);
                    //Log.d("Pemain Goal Team A", cetakgoalteama.get(0));
                    //Log.d("Pemain Goal Team A", cetakgoalteama.get(1));
                    //int datagoalteama = dbpemain.loaddataidpemain(pemain, teamA);
                    //List<String> listpemaingoalteama = new ArrayList<String>();
                    Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                    if (datapertandingan.moveToFirst()) {
                        inputgoal(pemain, teamA, getidpertandingan(), babakint);
                        inputshotongoal(pemain, teamA, getidpertandingan());
                        inputdatagoal(pemain, teamA, getidpertandingan(), array[0],
                                "Pinalty" + statusgoal);
                    } else {
                        Log.d("belum ada ", "data pertadingan");
                        inputgoal(pemain, teamA, getidpertandingan(), babakint);
                        inputshotongoal(pemain, teamA, getidpertandingan());
                        inputdatagoal(pemain, teamA, getidpertandingan(), array[0],
                                "Pinalty" + statusgoal);

                    }
                    dialog.dismiss();
                } else if (editTextinputplayer.getText().toString().isEmpty() || editTextinputnomorpunggung.getText().toString().isEmpty()) {
                    Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak Boleh " +
                            "Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    String namapemain = editTextinputplayer.getText().toString();
                    String posisipemain = posisispinner.getSelectedItem().toString();
                    int nomorpunggungpemain =
                            Integer.parseInt(editTextinputnomorpunggung.getText().toString());
                    setDataPemain(teamA, namapemain, posisipemain, nomorpunggungpemain);
                    Toast.makeText(recordstat.this, "Input Data Pemain", Toast.LENGTH_SHORT).show();

                    tanding.setGoalTeamA(tanding.getGoalTeamA() + 1);
                    tanding.setShootOnTargetTeamA(tanding.getShootOnTargetTeamA() + 1);
                    tanding.setPinaltyTeamA(tanding.getPinaltyTeamA() + 1);
                    tanding.setFoulTeamB(tanding.getFoulTeamB() + 1);
                    String chronotext = chronometer.getText().toString();
                    String array[] = chronotext.split(":");
                    Integer arrayint = Integer.parseInt(array[0]) + timematchint;
                    array[0] = String.valueOf(arrayint);
                    Log.d("time goal edited", array[0]);

                    Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                    if (datapertandingan.moveToFirst()) {
                        inputgoal(editTextinputnomorpunggung.getText().toString(), teamA,
                                getidpertandingan(), babakint);
                        inputshotongoal(editTextinputnomorpunggung.getText().toString(), teamA,
                                getidpertandingan());
                        inputdatagoal(editTextinputnomorpunggung.getText().toString(), teamA,
                                getidpertandingan(), array[0], "Pinalty" + statusgoal);
                    } else {
                        Log.d("belum ada ", "data pertadingan");
                        inputgoal(editTextinputnomorpunggung.getText().toString(), teamA,
                                getidpertandingan(), babakint);
                        inputshotongoal(editTextinputnomorpunggung.getText().toString(), teamA,
                                getidpertandingan());
                        inputdatagoal(editTextinputnomorpunggung.getText().toString(), teamA,
                                getidpertandingan(), array[0], "Pinalty" + statusgoal);

                    }
                    dialog.dismiss();
                }

            }


        });

        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextinputplayer.getText().toString().isEmpty() && editTextinputnomorpunggung.getText().toString().isEmpty()) {


                    tanding.setShootOnTargetTeamA(tanding.getShootOnTargetTeamA() + 1);
                    tanding.setPinaltyTeamA(tanding.getPinaltyTeamA() + 1);
                    tanding.setFoulTeamB(tanding.getFoulTeamB() + 1);
                    tanding.setSavesTeamB(tanding.getSavesTeamB() + 1);
                    String chronotext = chronometer.getText().toString();
                    String array[] = chronotext.split(":");
                    Integer arrayint = Integer.parseInt(array[0]) + timematchint;
                    array[0] = String.valueOf(arrayint);
                    Log.d("time goal edited", array[0]);


                    //if (TextUtils.isEmpty(editTextinputplayer.getText().toString())) {
                    pemain = mSpinner.getSelectedItem().toString();
                    //} else {
                    //  pemain = editTextinputplayer.getText().toString();

                    //}

                    //goalnotea = pemain + " (P)'" + array[0];

                    //cetakgoalteama.add(goalnotea);
                    //arrayAdaptercetakgoalteama = new ArrayAdapter<>(recordstat.this, R.layout
                    // .support_simple_spinner_dropdown_item, cetakgoalteama);


                    Log.d("Pemain Goal Team A", pemain);
                    //Log.d("Pemain Goal Team A", cetakgoalteama.get(0));
                    //Log.d("Pemain Goal Team A", cetakgoalteama.get(1));
                    //int datagoalteama = dbpemain.loaddataidpemain(pemain, teamA);
                    //List<String> listpemaingoalteama = new ArrayList<String>();
                    Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                    if (datapertandingan.moveToFirst()) {
                        inputshotongoal(pemain, teamA, getidpertandingan());
                        inputdatagoal(pemain, teamA, getidpertandingan(), array[0],
                                "MISSED" + statusgoal);
                    } else {
                        Log.d("belum ada ", "data pertadingan");
                        inputshotongoal(pemain, teamA, getidpertandingan());
                        inputdatagoal(pemain, teamA, getidpertandingan(), array[0],
                                "MISSED" + statusgoal);

                    }
                    dialog.dismiss();
                } else if (editTextinputplayer.getText().toString().isEmpty() || editTextinputnomorpunggung.getText().toString().isEmpty()) {
                    Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak Boleh " +
                            "Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    String namapemain = editTextinputplayer.getText().toString();
                    String posisipemain = posisispinner.getSelectedItem().toString();
                    int nomorpunggungpemain =
                            Integer.parseInt(editTextinputnomorpunggung.getText().toString());
                    setDataPemain(teamA, namapemain, posisipemain, nomorpunggungpemain);
                    Toast.makeText(recordstat.this, "Input Data Pemain", Toast.LENGTH_SHORT).show();


                    tanding.setShootOnTargetTeamA(tanding.getShootOnTargetTeamA() + 1);
                    tanding.setPinaltyTeamA(tanding.getPinaltyTeamA() + 1);
                    tanding.setFoulTeamB(tanding.getFoulTeamB() + 1);
                    tanding.setSavesTeamB(tanding.getSavesTeamB() + 1);
                    String chronotext = chronometer.getText().toString();
                    String array[] = chronotext.split(":");
                    Integer arrayint = Integer.parseInt(array[0]) + timematchint;
                    array[0] = String.valueOf(arrayint);
                    Log.d("time goal edited", array[0]);

                    Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                    if (datapertandingan.moveToFirst()) {
                        inputshotongoal(editTextinputnomorpunggung.getText().toString(), teamA,
                                getidpertandingan());
                        inputdatagoal(editTextinputnomorpunggung.getText().toString(), teamA,
                                getidpertandingan(), array[0], "MISSED" + statusgoal);
                    } else {
                        Log.d("belum ada ", "data pertadingan");
                        inputshotongoal(editTextinputnomorpunggung.getText().toString(), teamA,
                                getidpertandingan());
                        inputdatagoal(editTextinputnomorpunggung.getText().toString(), teamA,
                                getidpertandingan(), array[0], "MISSED" + statusgoal);

                    }
                    dialog.dismiss();
                }
            }
        });
        passingstatusteama = "no";
        passingstatusteamb = "no";
    }

    public void pinaltyteamb(View v) {
        pinalty.start();
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();

        Cursor datagoalteamb = dbpemain.loaddatateam(teamB);
        List<String> listpemaingoalteamb = new ArrayList<String>();
        datagoalteamb.moveToFirst();
        while (!datagoalteamb.isAfterLast()) {
            listpemaingoalteamb.add(datagoalteamb.getString(3));
            Log.d("Data spinner ", datagoalteamb.getString(3));
            datagoalteamb.moveToNext();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(recordstat.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
        final Spinner mSpinner = (Spinner) mView.findViewById(R.id.spinnerplayer);
        final EditText editTextinputplayer =
                (EditText) mView.findViewById(R.id.editTextinputplayer);
        final Spinner posisispinner = (Spinner) mView.findViewById(R.id.spinnerposisi3);
        final EditText editTextinputnomorpunggung =
                (EditText) mView.findViewById(R.id.textNomorPunggung2);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(recordstat.this,
                R.layout.support_simple_spinner_dropdown_item, listpemaingoalteamb);
        mSpinner.setAdapter(arrayAdapter);

        builder.setTitle("Pick Player");

        builder.setPositiveButton("GOAL", null);
        builder.setNegativeButton("MISSED", null);
        builder.setNeutralButton("CANCEL", null);
        builder.setView(mView);
        final AlertDialog dialog = builder.create();
        dialog.show();
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextinputplayer.getText().toString().isEmpty() && editTextinputnomorpunggung.getText().toString().isEmpty()) {

                    tanding.setGoalTeamB(tanding.getGoalTeamB() + 1);
                    tanding.setShootOnTargetTeamB(tanding.getShootOnTargetTeamB() + 1);
                    tanding.setPinaltyTeamB(tanding.getPinaltyTeamB() + 1);
                    tanding.setFoulTeamA(tanding.getFoulTeamA() + 1);
                    String chronotext = chronometer.getText().toString();
                    String array[] = chronotext.split(":");
                    Integer arrayint = Integer.parseInt(array[0]) + timematchint;
                    array[0] = String.valueOf(arrayint);
                    Log.d("time goal edited", array[0]);


                    pemain = mSpinner.getSelectedItem().toString();


                    Log.d("Pemain Goal Team A", pemain);

                    Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                    if (datapertandingan.moveToFirst()) {
                        inputgoal(pemain, teamB, getidpertandingan(), babakint);
                        inputshotongoal(pemain, teamB, getidpertandingan());
                        inputdatagoal(pemain, teamB, getidpertandingan(), array[0],
                                "Pinalty" + statusgoal);
                    } else {
                        Log.d("belum ada ", "data pertadingan");
                        inputgoal(pemain, teamB, getidpertandingan(), babakint);
                        inputshotongoal(pemain, teamB, getidpertandingan());
                        inputdatagoal(pemain, teamB, getidpertandingan(), array[0],
                                "Pinalty" + statusgoal);

                    }
                    dialog.dismiss();
                } else if (editTextinputplayer.getText().toString().isEmpty() || editTextinputnomorpunggung.getText().toString().isEmpty()) {
                    Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak Boleh " +
                            "Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    String namapemain = editTextinputplayer.getText().toString();
                    String posisipemain = posisispinner.getSelectedItem().toString();
                    int nomorpunggungpemain =
                            Integer.parseInt(editTextinputnomorpunggung.getText().toString());
                    setDataPemain(teamB, namapemain, posisipemain, nomorpunggungpemain);
                    Toast.makeText(recordstat.this, "Input Data Pemain", Toast.LENGTH_SHORT).show();

                    tanding.setGoalTeamB(tanding.getGoalTeamB() + 1);
                    tanding.setShootOnTargetTeamB(tanding.getShootOnTargetTeamB() + 1);
                    tanding.setPinaltyTeamB(tanding.getPinaltyTeamB() + 1);
                    tanding.setFoulTeamA(tanding.getFoulTeamA() + 1);
                    String chronotext = chronometer.getText().toString();
                    String array[] = chronotext.split(":");
                    Integer arrayint = Integer.parseInt(array[0]) + timematchint;
                    array[0] = String.valueOf(arrayint);
                    Log.d("time goal edited", array[0]);

                    Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                    if (datapertandingan.moveToFirst()) {
                        inputgoal(editTextinputnomorpunggung.getText().toString(), teamB,
                                getidpertandingan(), babakint);
                        inputshotongoal(editTextinputnomorpunggung.getText().toString(), teamB,
                                getidpertandingan());
                        inputdatagoal(editTextinputnomorpunggung.getText().toString(), teamB,
                                getidpertandingan(), array[0], "Pinalty" + statusgoal);
                    } else {
                        Log.d("belum ada ", "data pertadingan");
                        inputgoal(editTextinputnomorpunggung.getText().toString(), teamB,
                                getidpertandingan(), babakint);
                        inputshotongoal(editTextinputnomorpunggung.getText().toString(), teamB,
                                getidpertandingan());
                        inputdatagoal(editTextinputnomorpunggung.getText().toString(), teamB,
                                getidpertandingan(), array[0], "Pinalty" + statusgoal);

                    }
                    dialog.dismiss();
                }

            }


        });

        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextinputplayer.getText().toString().isEmpty() && editTextinputnomorpunggung.getText().toString().isEmpty()) {


                    tanding.setShootOnTargetTeamB(tanding.getShootOnTargetTeamB() + 1);
                    tanding.setPinaltyTeamB(tanding.getPinaltyTeamB() + 1);
                    tanding.setFoulTeamA(tanding.getFoulTeamA() + 1);
                    tanding.setSavesTeamA(tanding.getSavesTeamA() + 1);
                    String chronotext = chronometer.getText().toString();
                    String array[] = chronotext.split(":");
                    Integer arrayint = Integer.parseInt(array[0]) + timematchint;
                    array[0] = String.valueOf(arrayint);
                    Log.d("time goal edited", array[0]);


                    //if (TextUtils.isEmpty(editTextinputplayer.getText().toString())) {
                    pemain = mSpinner.getSelectedItem().toString();
                    //} else {
                    //  pemain = editTextinputplayer.getText().toString();

                    //}

                    //goalnotea = pemain + " (P)'" + array[0];

                    //cetakgoalteama.add(goalnotea);
                    //arrayAdaptercetakgoalteama = new ArrayAdapter<>(recordstat.this, R.layout
                    // .support_simple_spinner_dropdown_item, cetakgoalteama);


                    Log.d("Pemain Goal Team A", pemain);
                    //Log.d("Pemain Goal Team A", cetakgoalteama.get(0));
                    //Log.d("Pemain Goal Team A", cetakgoalteama.get(1));
                    //int datagoalteama = dbpemain.loaddataidpemain(pemain, teamA);
                    //List<String> listpemaingoalteama = new ArrayList<String>();
                    Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                    if (datapertandingan.moveToFirst()) {
                        inputshotongoal(pemain, teamB, getidpertandingan());
                        inputdatagoal(pemain, teamB, getidpertandingan(), array[0],
                                "MISSED" + statusgoal);
                    } else {
                        Log.d("belum ada ", "data pertadingan");
                        inputshotongoal(pemain, teamB, getidpertandingan());
                        inputdatagoal(pemain, teamB, getidpertandingan(), array[0],
                                "MISSED" + statusgoal);

                    }
                    dialog.dismiss();
                } else if (editTextinputplayer.getText().toString().isEmpty() || editTextinputnomorpunggung.getText().toString().isEmpty()) {
                    Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak Boleh " +
                            "Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    String namapemain = editTextinputplayer.getText().toString();
                    String posisipemain = posisispinner.getSelectedItem().toString();
                    int nomorpunggungpemain =
                            Integer.parseInt(editTextinputnomorpunggung.getText().toString());
                    setDataPemain(teamB, namapemain, posisipemain, nomorpunggungpemain);
                    Toast.makeText(recordstat.this, "Input Data Pemain", Toast.LENGTH_SHORT).show();


                    tanding.setShootOnTargetTeamB(tanding.getShootOnTargetTeamB() + 1);
                    tanding.setPinaltyTeamB(tanding.getPinaltyTeamB() + 1);
                    tanding.setFoulTeamA(tanding.getFoulTeamA() + 1);
                    tanding.setSavesTeamA(tanding.getSavesTeamA() + 1);
                    String chronotext = chronometer.getText().toString();
                    String array[] = chronotext.split(":");
                    Integer arrayint = Integer.parseInt(array[0]) + timematchint;
                    array[0] = String.valueOf(arrayint);
                    Log.d("time goal edited", array[0]);

                    Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                    if (datapertandingan.moveToFirst()) {
                        inputshotongoal(editTextinputnomorpunggung.getText().toString(), teamB,
                                getidpertandingan());
                        inputdatagoal(editTextinputnomorpunggung.getText().toString(), teamB,
                                getidpertandingan(), array[0], "MISSED" + statusgoal);
                    } else {
                        Log.d("belum ada ", "data pertadingan");
                        inputshotongoal(editTextinputnomorpunggung.getText().toString(), teamB,
                                getidpertandingan());
                        inputdatagoal(editTextinputnomorpunggung.getText().toString(), teamB,
                                getidpertandingan(), array[0], "MISSED" + statusgoal);

                    }
                    dialog.dismiss();
                }
            }
        });
        passingstatusteama = "no";
        passingstatusteamb = "no";
    }

    public void freekickteama(View v) {
        freekick.start();
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
        freekick.start();
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
        goalkick.start();
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        passingstatusteama = "no";
        passingstatusteamb = "no";
        tanding.setGoalkickTeamA(tanding.getGoalkickTeamA() + 1);
    }

    public void goalkickteamb(View v) {
        goalkick.start();
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        passingstatusteama = "no";
        passingstatusteamb = "no";
        tanding.setGoalkickTeamB(tanding.getGoalkickTeamB() + 1);
    }


    public void showpopupshootinga(View v) {
        shooting.start();
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
        shooting.start();
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
        yellow.start();


        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.getMenu().add(1, R.id.yellowhome, 1, teamA);
        popup.getMenu().add(1, R.id.yellowaway, 2, teamB);
        popup.show();
        passingstatusteama = "no";
        passingstatusteamb = "no";

    }

    public void redcard(View v) {
        red.start();

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
                final EditText editTextinputplayer =
                        (EditText) mView.findViewById(R.id.editTextinputplayer);
                final Spinner posisispinner = (Spinner) mView.findViewById(R.id.spinnerposisi3);
                final EditText editTextinputnomorpunggung =
                        (EditText) mView.findViewById(R.id.textNomorPunggung2);
                final ArrayAdapter<String> arrayAdapter =
                        new ArrayAdapter<String>(recordstat.this,
                                R.layout.support_simple_spinner_dropdown_item, listpemaingoalteama);
                mSpinner.setAdapter(arrayAdapter);


                builder.setTitle("Pick Player");

                builder.setPositiveButton("OK", null);
                builder.setNegativeButton("CANCEL", null);
                builder.setView(mView);
                final AlertDialog dialog = builder.create();
                dialog.show();
                Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editTextinputplayer.getText().toString().isEmpty() && editTextinputnomorpunggung.getText().toString().isEmpty()) {
                            tanding.setGoalTeamA(tanding.getGoalTeamA() + 1);
                            tanding.setShootOnTargetTeamA(tanding.getShootOnTargetTeamA() + 1);
                            pemain = mSpinner.getSelectedItem().toString();
                            String chronotext = chronometer.getText().toString();

                            String array[] = chronotext.split(":");
                            Integer arrayint = Integer.parseInt(array[0]) + timematchint;
                            array[0] = String.valueOf(arrayint);

                            Log.d("time goal", array[0]);

                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputgoal(pemain, teamA, getidpertandingan(), babakint);
                                inputshotongoal(pemain, teamA, getidpertandingan());
                                inputdatagoal(pemain, teamA, getidpertandingan(), array[0], "");
                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputgoal(pemain, teamA, getidpertandingan(), babakint);
                                inputshotongoal(pemain, teamA, getidpertandingan());
                                inputdatagoal(pemain, teamA, getidpertandingan(), array[0], "");
                            }
                            dialog.dismiss();
                        } else if (editTextinputplayer.getText().toString().isEmpty() || editTextinputnomorpunggung.getText().toString().isEmpty()) {
                            Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak " +
                                    "Boleh Kosong", Toast.LENGTH_SHORT).show();
                        } else {
                            String namapemain = editTextinputplayer.getText().toString();
                            String posisipemain = posisispinner.getSelectedItem().toString();
                            int nomorpunggungpemain =
                                    Integer.parseInt(editTextinputnomorpunggung.getText().toString());
                            setDataPemain(teamA, namapemain, posisipemain, nomorpunggungpemain);
                            Toast.makeText(recordstat.this, "Input Data Pemain",
                                    Toast.LENGTH_SHORT).show();

                            tanding.setGoalTeamA(tanding.getGoalTeamA() + 1);
                            tanding.setShootOnTargetTeamA(tanding.getShootOnTargetTeamA() + 1);
                            String chronotext = chronometer.getText().toString();

                            String array[] = chronotext.split(":");
                            Integer arrayint = Integer.parseInt(array[0]) + timematchint;
                            array[0] = String.valueOf(arrayint);

                            Log.d("time goal", array[0]);

                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputgoal(editTextinputnomorpunggung.getText().toString(), teamA,
                                        getidpertandingan(), babakint);
                                inputshotongoal(editTextinputnomorpunggung.getText().toString(),
                                        teamA, getidpertandingan());
                                inputdatagoal(editTextinputnomorpunggung.getText().toString(),
                                        teamA, getidpertandingan(), array[0], "");
                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputgoal(editTextinputnomorpunggung.getText().toString(), teamA,
                                        getidpertandingan(), babakint);
                                inputshotongoal(editTextinputnomorpunggung.getText().toString(),
                                        teamA, getidpertandingan());
                                inputdatagoal(editTextinputnomorpunggung.getText().toString(),
                                        teamA, getidpertandingan(), array[0], "");
                            }
                            dialog.dismiss();

                        }

                    }
                });


                return true;
            case R.id.shootontarget:

                //Toast.makeText(this, "Shoot On Target Team A", Toast.LENGTH_SHORT).show();
                Cursor datashootontargeta = dbpemain.loaddatateam(teamA);
                List<String> listpemainshootontargeta = new ArrayList<String>();
                datashootontargeta.moveToFirst();
                while (!datashootontargeta.isAfterLast()) {
                    listpemainshootontargeta.add(datashootontargeta.getString(3));
                    Log.d("Data spinner ", datashootontargeta.getString(3));
                    datashootontargeta.moveToNext();
                }
                AlertDialog.Builder buildershootontargeta =
                        new AlertDialog.Builder(recordstat.this);
                View mViewshootontargeta = getLayoutInflater().inflate(R.layout.dialog_spinner,
                        null);
                final Spinner mSpinnershootontargeta =
                        (Spinner) mViewshootontargeta.findViewById(R.id.spinnerplayer);
                final EditText editTextinputplayershootontargeta =
                        (EditText) mViewshootontargeta.findViewById(R.id.editTextinputplayer);
                final Spinner posisispinnershootontargeta =
                        (Spinner) mViewshootontargeta.findViewById(R.id.spinnerposisi3);
                final EditText editTextinputnomorpunggungshootontargeta =
                        (EditText) mViewshootontargeta.findViewById(R.id.textNomorPunggung2);
                final ArrayAdapter<String> arrayAdaptershootontargeta =
                        new ArrayAdapter<String>(recordstat.this,
                                R.layout.support_simple_spinner_dropdown_item, listpemainshootontargeta);
                mSpinnershootontargeta.setAdapter(arrayAdaptershootontargeta);


                buildershootontargeta.setTitle("Pick Player");

                buildershootontargeta.setPositiveButton("OK", null);
                buildershootontargeta.setNegativeButton("CANCEL", null);
                buildershootontargeta.setView(mViewshootontargeta);
                final AlertDialog dialogshootontargeta = buildershootontargeta.create();
                dialogshootontargeta.show();
                Button positiveButtonshootontargeta =
                        dialogshootontargeta.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButtonshootontargeta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editTextinputplayershootontargeta.getText().toString().isEmpty() && editTextinputnomorpunggungshootontargeta.getText().toString().isEmpty()) {
                            tanding.setShootOnTargetTeamA(tanding.getShootOnTargetTeamA() + 1);
                            tanding.setSavesTeamB(tanding.getSavesTeamB() + 1);
                            Toast.makeText(recordstat.this, "Shoot On Target Team A",
                                    Toast.LENGTH_SHORT).show();
                            pemain = mSpinnershootontargeta.getSelectedItem().toString();
                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputshotongoal(pemain, teamA, getidpertandingan());
                                //inputsaves(teamA, getidpertandingan(), babakint);
                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputshotongoal(pemain, teamA, getidpertandingan());
                                //inputsaves(teamA, getidpertandingan(), babakint);
                            }
                            dialogshootontargeta.dismiss();

                        } else if (editTextinputplayershootontargeta.getText().toString().isEmpty() || editTextinputnomorpunggungshootontargeta.getText().toString().isEmpty()) {
                            Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak " +
                                    "Boleh Kosong", Toast.LENGTH_SHORT).show();
                        } else {
                            String namapemain =
                                    editTextinputplayershootontargeta.getText().toString();
                            String posisipemain =
                                    posisispinnershootontargeta.getSelectedItem().toString();
                            int nomorpunggungpemain =
                                    Integer.parseInt(editTextinputnomorpunggungshootontargeta.getText().toString());
                            setDataPemain(teamA, namapemain, posisipemain, nomorpunggungpemain);
                            Toast.makeText(recordstat.this, "Input Data Pemain",
                                    Toast.LENGTH_SHORT).show();
                            tanding.setShootOnTargetTeamA(tanding.getShootOnTargetTeamA() + 1);
                            tanding.setSavesTeamB(tanding.getSavesTeamB() + 1);
                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputshotongoal(editTextinputnomorpunggungshootontargeta.getText().toString(), teamA, getidpertandingan());
                                //inputsaves(teamA, getidpertandingan(), babakint);
                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputshotongoal(editTextinputnomorpunggungshootontargeta.getText().toString(), teamA, getidpertandingan());
                                //inputsaves(teamA, getidpertandingan(), babakint);
                            }
                            dialogshootontargeta.dismiss();
                        }
                    }


                });

                return true;
            case R.id.shootofftarget:
                Cursor datashootofftargeta = dbpemain.loaddatateam(teamA);
                List<String> listpemainshootofftargeta = new ArrayList<String>();
                datashootofftargeta.moveToFirst();
                while (!datashootofftargeta.isAfterLast()) {
                    listpemainshootofftargeta.add(datashootofftargeta.getString(3));
                    Log.d("Data spinner ", datashootofftargeta.getString(3));
                    datashootofftargeta.moveToNext();
                }
                AlertDialog.Builder buildershootofftargeta =
                        new AlertDialog.Builder(recordstat.this);
                View mViewshootofftargeta = getLayoutInflater().inflate(R.layout.dialog_spinner,
                        null);
                final Spinner mSpinnershootofftargeta =
                        (Spinner) mViewshootofftargeta.findViewById(R.id.spinnerplayer);
                final EditText editTextinputplayershootofftargeta =
                        (EditText) mViewshootofftargeta.findViewById(R.id.editTextinputplayer);
                final Spinner posisispinnershootofftargeta =
                        (Spinner) mViewshootofftargeta.findViewById(R.id.spinnerposisi3);
                final EditText editTextinputnomorpunggungshootofftargeta =
                        (EditText) mViewshootofftargeta.findViewById(R.id.textNomorPunggung2);
                ArrayAdapter<String> arrayAdaptershootofftargeta =
                        new ArrayAdapter<String>(recordstat.this,
                                R.layout.support_simple_spinner_dropdown_item, listpemainshootofftargeta);
                mSpinnershootofftargeta.setAdapter(arrayAdaptershootofftargeta);


                buildershootofftargeta.setPositiveButton("OK", null);
                buildershootofftargeta.setNegativeButton("CANCEL", null);
                buildershootofftargeta.setView(mViewshootofftargeta);
                final AlertDialog dialogshootofftargeta = buildershootofftargeta.create();
                dialogshootofftargeta.show();
                Button positiveButtonshootofftargeta =
                        dialogshootofftargeta.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButtonshootofftargeta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editTextinputplayershootofftargeta.getText().toString().isEmpty() && editTextinputnomorpunggungshootofftargeta.getText().toString().isEmpty()) {
                            tanding.setShootOffTargetTeamA(tanding.getShootOffTargetTeamA() + 1);
                            Toast.makeText(recordstat.this, "Shoot Off Target Team A",
                                    Toast.LENGTH_SHORT).show();
                            pemain = mSpinnershootofftargeta.getSelectedItem().toString();
                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputshotoffgoal(pemain, teamA, getidpertandingan());
                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputshotoffgoal(pemain, teamA, getidpertandingan());
                            }
                            dialogshootofftargeta.dismiss();
                        } else if (editTextinputplayershootofftargeta.getText().toString().isEmpty() || editTextinputnomorpunggungshootofftargeta.getText().toString().isEmpty()) {
                            Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak " +
                                    "Boleh Kosong", Toast.LENGTH_SHORT).show();
                        } else {
                            String namapemain =
                                    editTextinputplayershootofftargeta.getText().toString();
                            String posisipemain =
                                    posisispinnershootofftargeta.getSelectedItem().toString();
                            int nomorpunggungpemain =
                                    Integer.parseInt(editTextinputnomorpunggungshootofftargeta.getText().toString());
                            setDataPemain(teamA, namapemain, posisipemain, nomorpunggungpemain);
                            Toast.makeText(recordstat.this, "Input Data Pemain",
                                    Toast.LENGTH_SHORT).show();
                            tanding.setShootOffTargetTeamA(tanding.getShootOffTargetTeamA() + 1);
                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputshotoffgoal(editTextinputnomorpunggungshootofftargeta.getText().toString(), teamA, getidpertandingan());

                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputshotoffgoal(editTextinputnomorpunggungshootofftargeta.getText().toString(), teamA, getidpertandingan());

                            }
                            dialogshootofftargeta.dismiss();
                        }
                    }


                });

                return true;
            case R.id.goalb:

                Cursor datagoalteamb = dbpemain.loaddatateam(teamB);
                List<String> listpemaingoalteamb = new ArrayList<String>();
                datagoalteamb.moveToFirst();
                while (!datagoalteamb.isAfterLast()) {
                    listpemaingoalteamb.add(datagoalteamb.getString(3));
                    Log.d("list pemain goal team a", datagoalteamb.getString(3));
                    datagoalteamb.moveToNext();
                }


                AlertDialog.Builder builderb = new AlertDialog.Builder(recordstat.this);
                View mViewb = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                final Spinner mSpinnerb = (Spinner) mViewb.findViewById(R.id.spinnerplayer);
                final EditText editTextinputplayerb =
                        (EditText) mViewb.findViewById(R.id.editTextinputplayer);
                final Spinner posisispinnerb = (Spinner) mViewb.findViewById(R.id.spinnerposisi3);
                final EditText editTextinputnomorpunggungb =
                        (EditText) mViewb.findViewById(R.id.textNomorPunggung2);
                final ArrayAdapter<String> arrayAdapterb =
                        new ArrayAdapter<String>(recordstat.this,
                                R.layout.support_simple_spinner_dropdown_item, listpemaingoalteamb);
                mSpinnerb.setAdapter(arrayAdapterb);


                builderb.setTitle("Pick Player");

                builderb.setPositiveButton("OK", null);
                builderb.setNegativeButton("CANCEL", null);
                builderb.setView(mViewb);
                final AlertDialog dialogb = builderb.create();
                dialogb.show();
                Button positiveButtonb = dialogb.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButtonb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editTextinputplayerb.getText().toString().isEmpty() && editTextinputnomorpunggungb.getText().toString().isEmpty()) {
                            tanding.setGoalTeamB(tanding.getGoalTeamB() + 1);
                            tanding.setShootOnTargetTeamB(tanding.getShootOnTargetTeamB() + 1);
                            pemain = mSpinnerb.getSelectedItem().toString();
                            String chronotext = chronometer.getText().toString();

                            String array[] = chronotext.split(":");
                            Integer arrayint = Integer.parseInt(array[0]) + timematchint;
                            array[0] = String.valueOf(arrayint);

                            Log.d("time goal", array[0]);

                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputgoal(pemain, teamB, getidpertandingan(), babakint);
                                inputshotongoal(pemain, teamB, getidpertandingan());
                                inputdatagoal(pemain, teamB, getidpertandingan(), array[0], "");
                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputgoal(pemain, teamB, getidpertandingan(), babakint);
                                inputshotongoal(pemain, teamB, getidpertandingan());
                                inputdatagoal(pemain, teamB, getidpertandingan(), array[0], "");
                            }
                            dialogb.dismiss();
                        } else if (editTextinputplayerb.getText().toString().isEmpty() || editTextinputnomorpunggungb.getText().toString().isEmpty()) {
                            Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak " +
                                    "Boleh Kosong", Toast.LENGTH_SHORT).show();
                        } else {
                            String namapemain = editTextinputplayerb.getText().toString();
                            String posisipemain = posisispinnerb.getSelectedItem().toString();
                            int nomorpunggungpemain =
                                    Integer.parseInt(editTextinputnomorpunggungb.getText().toString());
                            setDataPemain(teamB, namapemain, posisipemain, nomorpunggungpemain);
                            Toast.makeText(recordstat.this, "Input Data Pemain",
                                    Toast.LENGTH_SHORT).show();

                            tanding.setGoalTeamB(tanding.getGoalTeamB() + 1);
                            tanding.setShootOnTargetTeamB(tanding.getShootOnTargetTeamB() + 1);
                            String chronotext = chronometer.getText().toString();

                            String array[] = chronotext.split(":");
                            Integer arrayint = Integer.parseInt(array[0]) + timematchint;
                            array[0] = String.valueOf(arrayint);

                            Log.d("time goal", array[0]);

                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputgoal(editTextinputnomorpunggungb.getText().toString(), teamB
                                        , getidpertandingan(), babakint);
                                inputshotongoal(editTextinputnomorpunggungb.getText().toString(),
                                        teamB, getidpertandingan());
                                inputdatagoal(editTextinputnomorpunggungb.getText().toString(),
                                        teamB, getidpertandingan(), array[0], "");
                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputgoal(editTextinputnomorpunggungb.getText().toString(), teamB
                                        , getidpertandingan(), babakint);
                                inputshotongoal(editTextinputnomorpunggungb.getText().toString(),
                                        teamB, getidpertandingan());
                                inputdatagoal(editTextinputnomorpunggungb.getText().toString(),
                                        teamB, getidpertandingan(), array[0], "");
                            }
                            dialogb.dismiss();

                        }

                    }
                });


                return true;
            case R.id.shootontargetb:
                Cursor datashootontargetb = dbpemain.loaddatateam(teamB);
                List<String> listpemainshootontargetb = new ArrayList<String>();
                datashootontargetb.moveToFirst();
                while (!datashootontargetb.isAfterLast()) {
                    listpemainshootontargetb.add(datashootontargetb.getString(3));
                    Log.d("Data spinner ", datashootontargetb.getString(3));
                    datashootontargetb.moveToNext();
                }
                AlertDialog.Builder buildershootontargetb =
                        new AlertDialog.Builder(recordstat.this);
                View mViewshootontargetb = getLayoutInflater().inflate(R.layout.dialog_spinner,
                        null);
                final Spinner mSpinnershootontargetb =
                        (Spinner) mViewshootontargetb.findViewById(R.id.spinnerplayer);
                final EditText editTextinputplayershootontargetb =
                        (EditText) mViewshootontargetb.findViewById(R.id.editTextinputplayer);
                final Spinner posisispinnershootontargetb =
                        (Spinner) mViewshootontargetb.findViewById(R.id.spinnerposisi3);
                final EditText editTextinputnomorpunggungshootontargetb =
                        (EditText) mViewshootontargetb.findViewById(R.id.textNomorPunggung2);
                final ArrayAdapter<String> arrayAdaptershootontargetb =
                        new ArrayAdapter<String>(recordstat.this,
                                R.layout.support_simple_spinner_dropdown_item, listpemainshootontargetb);
                mSpinnershootontargetb.setAdapter(arrayAdaptershootontargetb);


                buildershootontargetb.setTitle("Pick Player");

                buildershootontargetb.setPositiveButton("OK", null);
                buildershootontargetb.setNegativeButton("CANCEL", null);
                buildershootontargetb.setView(mViewshootontargetb);
                final AlertDialog dialogshootontargetb = buildershootontargetb.create();
                dialogshootontargetb.show();
                Button positiveButtonshootontargetb =
                        dialogshootontargetb.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButtonshootontargetb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editTextinputplayershootontargetb.getText().toString().isEmpty() && editTextinputnomorpunggungshootontargetb.getText().toString().isEmpty()) {
                            tanding.setShootOnTargetTeamB(tanding.getShootOnTargetTeamB() + 1);
                            tanding.setSavesTeamA(tanding.getSavesTeamA() + 1);
                            Toast.makeText(recordstat.this, "Shoot On Target Team B",
                                    Toast.LENGTH_SHORT).show();
                            pemain = mSpinnershootontargetb.getSelectedItem().toString();
                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputshotongoal(pemain, teamB, getidpertandingan());
                                //inputsaves(teamB, getidpertandingan(), babakint);
                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputshotongoal(pemain, teamB, getidpertandingan());
                                //inputsaves(teamB, getidpertandingan(), babakint);
                            }
                            dialogshootontargetb.dismiss();

                        } else if (editTextinputplayershootontargetb.getText().toString().isEmpty() || editTextinputnomorpunggungshootontargetb.getText().toString().isEmpty()) {
                            Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak " +
                                    "Boleh Kosong", Toast.LENGTH_SHORT).show();
                        } else {
                            String namapemain =
                                    editTextinputplayershootontargetb.getText().toString();
                            String posisipemain =
                                    posisispinnershootontargetb.getSelectedItem().toString();
                            int nomorpunggungpemain =
                                    Integer.parseInt(editTextinputnomorpunggungshootontargetb.getText().toString());
                            setDataPemain(teamB, namapemain, posisipemain, nomorpunggungpemain);
                            Toast.makeText(recordstat.this, "Input Data Pemain",
                                    Toast.LENGTH_SHORT).show();
                            tanding.setShootOnTargetTeamB(tanding.getShootOnTargetTeamB() + 1);
                            tanding.setSavesTeamA(tanding.getSavesTeamA() + 1);
                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputshotongoal(editTextinputnomorpunggungshootontargetb.getText().toString(), teamB, getidpertandingan());
                                //inputsaves(teamB, getidpertandingan(), babakint);
                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputshotongoal(editTextinputnomorpunggungshootontargetb.getText().toString(), teamB, getidpertandingan());
                                //inputsaves(teamB, getidpertandingan(), babakint);
                            }
                            dialogshootontargetb.dismiss();
                        }
                    }


                });

                return true;
            case R.id.shootofftargetb:
                Cursor datashootofftargetb = dbpemain.loaddatateam(teamB);
                List<String> listpemainshootofftargetb = new ArrayList<String>();
                datashootofftargetb.moveToFirst();
                while (!datashootofftargetb.isAfterLast()) {
                    listpemainshootofftargetb.add(datashootofftargetb.getString(3));
                    Log.d("Data spinner ", datashootofftargetb.getString(3));
                    datashootofftargetb.moveToNext();
                }
                AlertDialog.Builder buildershootofftargetb =
                        new AlertDialog.Builder(recordstat.this);
                View mViewshootofftargetb = getLayoutInflater().inflate(R.layout.dialog_spinner,
                        null);
                final Spinner mSpinnershootofftargetb =
                        (Spinner) mViewshootofftargetb.findViewById(R.id.spinnerplayer);
                final EditText editTextinputplayershootofftargetb =
                        (EditText) mViewshootofftargetb.findViewById(R.id.editTextinputplayer);
                final Spinner posisispinnershootofftargetb =
                        (Spinner) mViewshootofftargetb.findViewById(R.id.spinnerposisi3);
                final EditText editTextinputnomorpunggungshootofftargetb =
                        (EditText) mViewshootofftargetb.findViewById(R.id.textNomorPunggung2);
                ArrayAdapter<String> arrayAdaptershootofftargetb =
                        new ArrayAdapter<String>(recordstat.this,
                                R.layout.support_simple_spinner_dropdown_item, listpemainshootofftargetb);
                mSpinnershootofftargetb.setAdapter(arrayAdaptershootofftargetb);


                buildershootofftargetb.setPositiveButton("OK", null);
                buildershootofftargetb.setNegativeButton("CANCEL", null);
                buildershootofftargetb.setView(mViewshootofftargetb);
                final AlertDialog dialogshootofftargetb = buildershootofftargetb.create();
                dialogshootofftargetb.show();
                Button positiveButtonshootofftargetb =
                        dialogshootofftargetb.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButtonshootofftargetb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editTextinputplayershootofftargetb.getText().toString().isEmpty() && editTextinputnomorpunggungshootofftargetb.getText().toString().isEmpty()) {
                            tanding.setShootOffTargetTeamB(tanding.getShootOffTargetTeamB() + 1);
                            Toast.makeText(recordstat.this, "Shoot Off Target Team B",
                                    Toast.LENGTH_SHORT).show();
                            pemain = mSpinnershootofftargetb.getSelectedItem().toString();
                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputshotoffgoal(pemain, teamB, getidpertandingan());
                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputshotoffgoal(pemain, teamB, getidpertandingan());
                            }
                            dialogshootofftargetb.dismiss();
                        } else if (editTextinputplayershootofftargetb.getText().toString().isEmpty() || editTextinputnomorpunggungshootofftargetb.getText().toString().isEmpty()) {
                            Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak " +
                                    "Boleh Kosong", Toast.LENGTH_SHORT).show();
                        } else {
                            String namapemain =
                                    editTextinputplayershootofftargetb.getText().toString();
                            String posisipemain =
                                    posisispinnershootofftargetb.getSelectedItem().toString();
                            int nomorpunggungpemain =
                                    Integer.parseInt(editTextinputnomorpunggungshootofftargetb.getText().toString());
                            setDataPemain(teamB, namapemain, posisipemain, nomorpunggungpemain);
                            Toast.makeText(recordstat.this, "Input Data Pemain",
                                    Toast.LENGTH_SHORT).show();
                            tanding.setShootOffTargetTeamB(tanding.getShootOffTargetTeamB() + 1);
                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputshotoffgoal(editTextinputnomorpunggungshootofftargetb.getText().toString(), teamB, getidpertandingan());

                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputshotoffgoal(editTextinputnomorpunggungshootofftargetb.getText().toString(), teamB, getidpertandingan());

                            }
                            dialogshootofftargetb.dismiss();
                        }
                    }


                });

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

                AlertDialog.Builder builderyellowhome =
                        new AlertDialog.Builder(recordstat.this);
                View mViewyellowhome = getLayoutInflater().inflate(R.layout.dialog_spinner,
                        null);
                final Spinner mSpinneryellowhome =
                        (Spinner) mViewyellowhome.findViewById(R.id.spinnerplayer);
                final EditText editTextinputplayeryellowhome =
                        (EditText) mViewyellowhome.findViewById(R.id.editTextinputplayer);
                final Spinner posisispinneryellowhome =
                        (Spinner) mViewyellowhome.findViewById(R.id.spinnerposisi3);
                final EditText editTextinputnomorpunggungyellowhome =
                        (EditText) mViewyellowhome.findViewById(R.id.textNomorPunggung2);
                ArrayAdapter<String> arrayAdapteryellowhome =
                        new ArrayAdapter<String>(recordstat.this,
                                R.layout.support_simple_spinner_dropdown_item, listpemainyellowhome);
                mSpinneryellowhome.setAdapter(arrayAdapteryellowhome);


                builderyellowhome.setPositiveButton("OK", null);
                builderyellowhome.setNegativeButton("CANCEL", null);
                builderyellowhome.setView(mViewyellowhome);
                final AlertDialog dialogyellowhome = builderyellowhome.create();
                dialogyellowhome.show();
                Button positiveButtonyellowhome =
                        dialogyellowhome.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButtonyellowhome.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editTextinputplayeryellowhome.getText().toString().isEmpty() && editTextinputnomorpunggungyellowhome.getText().toString().isEmpty()) {
                            tanding.setYellowcardTeamA(tanding.getYellowcardTeamA() + 1);
                            Toast.makeText(recordstat.this, "Yellow Team A", Toast.LENGTH_SHORT).show();
                            String pemain = mSpinneryellowhome.getSelectedItem().toString();
                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input yellow");
                                inputyellow(pemain, teamA, getidpertandingan());

                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputyellow(pemain, teamA, getidpertandingan());
                            }
                        dialogyellowhome.dismiss();
                        } else if (editTextinputplayeryellowhome.getText().toString().isEmpty() || editTextinputnomorpunggungyellowhome.getText().toString().isEmpty()) {
                            Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak " +
                                    "Boleh Kosong", Toast.LENGTH_SHORT).show();
                        } else {
                            String namapemain =
                                    editTextinputplayeryellowhome.getText().toString();
                            String posisipemain =
                                    posisispinneryellowhome.getSelectedItem().toString();
                            int nomorpunggungpemain =
                                    Integer.parseInt(editTextinputnomorpunggungyellowhome.getText().toString());
                            setDataPemain(teamA, namapemain, posisipemain, nomorpunggungpemain);
                            Toast.makeText(recordstat.this, "Input Data Pemain",
                                    Toast.LENGTH_SHORT).show();
                            tanding.setYellowcardTeamA(tanding.getYellowcardTeamA() + 1);
                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputyellow(editTextinputnomorpunggungyellowhome.getText().toString(), teamA, getidpertandingan());

                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputyellow(editTextinputnomorpunggungyellowhome.getText().toString(), teamA, getidpertandingan());

                            }
                            dialogyellowhome.dismiss();
                        }
                    }


                });

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

                AlertDialog.Builder builderyellowaway =
                        new AlertDialog.Builder(recordstat.this);
                View mViewyellowaway = getLayoutInflater().inflate(R.layout.dialog_spinner,
                        null);
                final Spinner mSpinneryellowaway =
                        (Spinner) mViewyellowaway.findViewById(R.id.spinnerplayer);
                final EditText editTextinputplayeryellowaway =
                        (EditText) mViewyellowaway.findViewById(R.id.editTextinputplayer);
                final Spinner posisispinneryellowaway =
                        (Spinner) mViewyellowaway.findViewById(R.id.spinnerposisi3);
                final EditText editTextinputnomorpunggungyellowaway =
                        (EditText) mViewyellowaway.findViewById(R.id.textNomorPunggung2);
                ArrayAdapter<String> arrayAdapteryellowaway =
                        new ArrayAdapter<String>(recordstat.this,
                                R.layout.support_simple_spinner_dropdown_item, listpemainyellowaway);
                mSpinneryellowaway.setAdapter(arrayAdapteryellowaway);


                builderyellowaway.setPositiveButton("OK", null);
                builderyellowaway.setNegativeButton("CANCEL", null);
                builderyellowaway.setView(mViewyellowaway);
                final AlertDialog dialogyellowaway = builderyellowaway.create();
                dialogyellowaway.show();
                Button positiveButtonyellowaway =
                        dialogyellowaway.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButtonyellowaway.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editTextinputplayeryellowaway.getText().toString().isEmpty() && editTextinputnomorpunggungyellowaway.getText().toString().isEmpty()) {
                            tanding.setYellowcardTeamB(tanding.getYellowcardTeamB() + 1);
                            Toast.makeText(recordstat.this, "Yellow Team B", Toast.LENGTH_SHORT).show();
                            String pemain = mSpinneryellowaway.getSelectedItem().toString();
                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input yellow");
                                inputyellow(pemain, teamB, getidpertandingan());

                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputyellow(pemain, teamB, getidpertandingan());
                            }
                            dialogyellowaway.dismiss();
                        } else if (editTextinputplayeryellowaway.getText().toString().isEmpty() || editTextinputnomorpunggungyellowaway.getText().toString().isEmpty()) {
                            Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak " +
                                    "Boleh Kosong", Toast.LENGTH_SHORT).show();
                        } else {
                            String namapemain =
                                    editTextinputplayeryellowaway.getText().toString();
                            String posisipemain =
                                    posisispinneryellowaway.getSelectedItem().toString();
                            int nomorpunggungpemain =
                                    Integer.parseInt(editTextinputnomorpunggungyellowaway.getText().toString());
                            setDataPemain(teamB, namapemain, posisipemain, nomorpunggungpemain);
                            Toast.makeText(recordstat.this, "Input Data Pemain",
                                    Toast.LENGTH_SHORT).show();
                            tanding.setYellowcardTeamB(tanding.getYellowcardTeamB() + 1);
                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputyellow(editTextinputnomorpunggungyellowaway.getText().toString(), teamB, getidpertandingan());

                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputyellow(editTextinputnomorpunggungyellowaway.getText().toString(), teamB, getidpertandingan());

                            }
                            dialogyellowaway.dismiss();
                        }
                    }


                });

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

                AlertDialog.Builder builderredhome =
                        new AlertDialog.Builder(recordstat.this);
                View mViewredhome = getLayoutInflater().inflate(R.layout.dialog_spinner,
                        null);
                final Spinner mSpinnerredhome =
                        (Spinner) mViewredhome.findViewById(R.id.spinnerplayer);
                final EditText editTextinputplayerredhome =
                        (EditText) mViewredhome.findViewById(R.id.editTextinputplayer);
                final Spinner posisispinnerredhome =
                        (Spinner) mViewredhome.findViewById(R.id.spinnerposisi3);
                final EditText editTextinputnomorpunggungredhome =
                        (EditText) mViewredhome.findViewById(R.id.textNomorPunggung2);
                ArrayAdapter<String> arrayAdapterredhome =
                        new ArrayAdapter<String>(recordstat.this,
                                R.layout.support_simple_spinner_dropdown_item, listpemainredhome);
                mSpinnerredhome.setAdapter(arrayAdapterredhome);


                builderredhome.setPositiveButton("OK", null);
                builderredhome.setNegativeButton("CANCEL", null);
                builderredhome.setView(mViewredhome);
                final AlertDialog dialogredhome = builderredhome.create();
                dialogredhome.show();
                Button positiveButtonredhome =
                        dialogredhome.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButtonredhome.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editTextinputplayerredhome.getText().toString().isEmpty() && editTextinputnomorpunggungredhome.getText().toString().isEmpty()) {
                            tanding.setRedcardTeamA(tanding.getRedcardTeamA() + 1);
                            Toast.makeText(recordstat.this, "Yellow Team A", Toast.LENGTH_SHORT).show();
                            String pemain = mSpinnerredhome.getSelectedItem().toString();
                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input yellow");
                                inputred(pemain, teamA, getidpertandingan());

                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputred(pemain, teamA, getidpertandingan());
                            }
                            dialogredhome.dismiss();
                        } else if (editTextinputplayerredhome.getText().toString().isEmpty() || editTextinputnomorpunggungredhome.getText().toString().isEmpty()) {
                            Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak " +
                                    "Boleh Kosong", Toast.LENGTH_SHORT).show();
                        } else {
                            String namapemain =
                                    editTextinputplayerredhome.getText().toString();
                            String posisipemain =
                                    posisispinnerredhome.getSelectedItem().toString();
                            int nomorpunggungpemain =
                                    Integer.parseInt(editTextinputnomorpunggungredhome.getText().toString());
                            setDataPemain(teamA, namapemain, posisipemain, nomorpunggungpemain);
                            Toast.makeText(recordstat.this, "Input Data Pemain",
                                    Toast.LENGTH_SHORT).show();
                            tanding.setRedcardTeamA(tanding.getRedcardTeamA() + 1);
                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputred(editTextinputnomorpunggungredhome.getText().toString(), teamA, getidpertandingan());

                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputred(editTextinputnomorpunggungredhome.getText().toString(), teamA, getidpertandingan());

                            }
                            dialogredhome.dismiss();
                        }
                    }


                });

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

                AlertDialog.Builder builderredaway =
                        new AlertDialog.Builder(recordstat.this);
                View mViewredaway = getLayoutInflater().inflate(R.layout.dialog_spinner,
                        null);
                final Spinner mSpinnerredaway =
                        (Spinner) mViewredaway.findViewById(R.id.spinnerplayer);
                final EditText editTextinputplayerredaway =
                        (EditText) mViewredaway.findViewById(R.id.editTextinputplayer);
                final Spinner posisispinnerredaway   =
                        (Spinner) mViewredaway.findViewById(R.id.spinnerposisi3);
                final EditText editTextinputnomorpunggungredaway =
                        (EditText) mViewredaway.findViewById(R.id.textNomorPunggung2);
                ArrayAdapter<String> arrayAdapterredaway =
                        new ArrayAdapter<String>(recordstat.this,
                                R.layout.support_simple_spinner_dropdown_item, listpemainredaway);
                mSpinnerredaway.setAdapter(arrayAdapterredaway);


                builderredaway.setPositiveButton("OK", null);
                builderredaway.setNegativeButton("CANCEL", null);
                builderredaway.setView(mViewredaway);
                final AlertDialog dialogredaway = builderredaway.create();
                dialogredaway.show();
                Button positiveButtonredaway =
                        dialogredaway.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButtonredaway.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editTextinputplayerredaway.getText().toString().isEmpty() && editTextinputnomorpunggungredaway.getText().toString().isEmpty()) {
                            tanding.setRedcardTeamB(tanding.getRedcardTeamB() + 1);
                            Toast.makeText(recordstat.this, "Yellow Team B", Toast.LENGTH_SHORT).show();
                            String pemain = mSpinnerredaway.getSelectedItem().toString();
                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input yellow");
                                inputred(pemain, teamB, getidpertandingan());

                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputred(pemain, teamB, getidpertandingan());
                            }
                            dialogredaway.dismiss();
                        } else if (editTextinputplayerredaway.getText().toString().isEmpty() || editTextinputnomorpunggungredaway.getText().toString().isEmpty()) {
                            Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak " +
                                    "Boleh Kosong", Toast.LENGTH_SHORT).show();
                        } else {
                            String namapemain =
                                    editTextinputplayerredaway.getText().toString();
                            String posisipemain =
                                    posisispinnerredaway.getSelectedItem().toString();
                            int nomorpunggungpemain =
                                    Integer.parseInt(editTextinputnomorpunggungredaway.getText().toString());
                            setDataPemain(teamB, namapemain, posisipemain, nomorpunggungpemain);
                            Toast.makeText(recordstat.this, "Input Data Pemain",
                                    Toast.LENGTH_SHORT).show();
                            tanding.setRedcardTeamB(tanding.getRedcardTeamB() + 1);
                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputred(editTextinputnomorpunggungredaway.getText().toString(), teamB, getidpertandingan());

                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputred(editTextinputnomorpunggungredaway.getText().toString(), teamB, getidpertandingan());

                            }
                            dialogredaway.dismiss();
                        }
                    }


                });

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
                Toast.makeText(recordstat.this, "Offside Team B", Toast.LENGTH_SHORT).show();
                return true;


            case R.id.owngoal:


                Cursor dataowngoalteam = dbpemain.loaddatateam(teamA);
                List<String> listpemainowngoalteam = new ArrayList<String>();
                dataowngoalteam.moveToFirst();
                while (!dataowngoalteam.isAfterLast()) {
                    listpemainowngoalteam.add(dataowngoalteam.getString(3));
                    Log.d("list pemain goal team a", dataowngoalteam.getString(3));
                    dataowngoalteam.moveToNext();
                }


                AlertDialog.Builder builderowngoal = new AlertDialog.Builder(recordstat.this);
                View mViewowngoal = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                final Spinner mSpinnerowngoal = (Spinner) mViewowngoal.findViewById(R.id.spinnerplayer);
                final EditText editTextinputplayerowngoal =
                        (EditText) mViewowngoal.findViewById(R.id.editTextinputplayer);
                final Spinner posisispinnerowngoal = (Spinner) mViewowngoal.findViewById(R.id.spinnerposisi3);
                final EditText editTextinputnomorpunggungowngoal =
                        (EditText) mViewowngoal.findViewById(R.id.textNomorPunggung2);
                final ArrayAdapter<String> arrayAdapterowngoal =
                        new ArrayAdapter<String>(recordstat.this,
                                R.layout.support_simple_spinner_dropdown_item, listpemainowngoalteam);
                mSpinnerowngoal.setAdapter(arrayAdapterowngoal);


                builderowngoal.setTitle("Pick Player");

                builderowngoal.setPositiveButton("OK", null);
                builderowngoal.setNegativeButton("CANCEL", null);
                builderowngoal.setView(mViewowngoal);
                final AlertDialog dialogowngoal = builderowngoal.create();
                dialogowngoal.show();
                Button positiveButtonowngoal = dialogowngoal.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButtonowngoal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editTextinputplayerowngoal.getText().toString().isEmpty() && editTextinputnomorpunggungowngoal.getText().toString().isEmpty()) {
                            tanding.setGoalTeamB(tanding.getGoalTeamB() + 1);
                            pemain = mSpinnerowngoal.getSelectedItem().toString();
                            String chronotext = chronometer.getText().toString();

                            String array[] = chronotext.split(":");
                            Integer arrayint = Integer.parseInt(array[0]) + timematchint;
                            array[0] = String.valueOf(arrayint);

                            Log.d("time goal", array[0]);

                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputdatagoal(pemain, teamA, getidpertandingan(), array[0], "(OG)");
                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputdatagoal(pemain, teamA, getidpertandingan(), array[0], "(OG)");
                            }
                            dialogowngoal.dismiss();
                        } else if (editTextinputplayerowngoal.getText().toString().isEmpty() || editTextinputnomorpunggungowngoal.getText().toString().isEmpty()) {
                            Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak " +
                                    "Boleh Kosong", Toast.LENGTH_SHORT).show();
                        } else {
                            String namapemain = editTextinputplayerowngoal.getText().toString();
                            String posisipemain = posisispinnerowngoal.getSelectedItem().toString();
                            int nomorpunggungpemain =
                                    Integer.parseInt(editTextinputnomorpunggungowngoal.getText().toString());
                            setDataPemain(teamA, namapemain, posisipemain, nomorpunggungpemain);
                            Toast.makeText(recordstat.this, "Input Data Pemain",
                                    Toast.LENGTH_SHORT).show();

                            tanding.setGoalTeamB(tanding.getGoalTeamB() + 1);
                            String chronotext = chronometer.getText().toString();

                            String array[] = chronotext.split(":");
                            Integer arrayint = Integer.parseInt(array[0]) + timematchint;
                            array[0] = String.valueOf(arrayint);

                            Log.d("time goal", array[0]);

                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputdatagoal(editTextinputnomorpunggungowngoal.getText().toString(),
                                        teamA, getidpertandingan(), array[0], "(OG)");
                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputdatagoal(editTextinputnomorpunggungowngoal.getText().toString(),
                                        teamA, getidpertandingan(), array[0], "");
                            }
                            dialogowngoal.dismiss();

                        }

                    }
                });


                return true;

            case R.id.owngoalb:


                Cursor dataowngoalteamb = dbpemain.loaddatateam(teamB);
                List<String> listpemainowngoalteamb = new ArrayList<String>();
                dataowngoalteamb.moveToFirst();
                while (!dataowngoalteamb.isAfterLast()) {
                    listpemainowngoalteamb.add(dataowngoalteamb.getString(3));
                    Log.d("list pemain goal team a", dataowngoalteamb.getString(3));
                    dataowngoalteamb.moveToNext();
                }


                AlertDialog.Builder builderowngoalb = new AlertDialog.Builder(recordstat.this);
                View mViewowngoalb = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                final Spinner mSpinnerowngoalb = (Spinner) mViewowngoalb.findViewById(R.id.spinnerplayer);
                final EditText editTextinputplayerowngoalb =
                        (EditText) mViewowngoalb.findViewById(R.id.editTextinputplayer);
                final Spinner posisispinnerowngoalb = (Spinner) mViewowngoalb.findViewById(R.id.spinnerposisi3);
                final EditText editTextinputnomorpunggungowngoalb =
                        (EditText) mViewowngoalb.findViewById(R.id.textNomorPunggung2);
                final ArrayAdapter<String> arrayAdapterowngoalb =
                        new ArrayAdapter<String>(recordstat.this,
                                R.layout.support_simple_spinner_dropdown_item, listpemainowngoalteamb);
                mSpinnerowngoalb.setAdapter(arrayAdapterowngoalb);


                builderowngoalb.setTitle("Pick Player");

                builderowngoalb.setPositiveButton("OK", null);
                builderowngoalb.setNegativeButton("CANCEL", null);
                builderowngoalb.setView(mViewowngoalb);
                final AlertDialog dialogowngoalb = builderowngoalb.create();
                dialogowngoalb.show();
                Button positiveButtonowngoalb = dialogowngoalb.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButtonowngoalb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editTextinputplayerowngoalb.getText().toString().isEmpty() && editTextinputnomorpunggungowngoalb.getText().toString().isEmpty()) {
                            tanding.setGoalTeamA(tanding.getGoalTeamA() + 1);
                            pemain = mSpinnerowngoalb.getSelectedItem().toString();
                            String chronotext = chronometer.getText().toString();

                            String array[] = chronotext.split(":");
                            Integer arrayint = Integer.parseInt(array[0]) + timematchint;
                            array[0] = String.valueOf(arrayint);

                            Log.d("time goal", array[0]);

                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputdatagoal(pemain, teamB, getidpertandingan(), array[0], "(OG)");
                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputdatagoal(pemain, teamB, getidpertandingan(), array[0], "(OG)");
                            }
                            dialogowngoalb.dismiss();
                        } else if (editTextinputplayerowngoalb.getText().toString().isEmpty() || editTextinputnomorpunggungowngoalb.getText().toString().isEmpty()) {
                            Toast.makeText(recordstat.this, "Nama Pemain & Nomor Punggung Tidak " +
                                    "Boleh Kosong", Toast.LENGTH_SHORT).show();
                        } else {
                            String namapemain = editTextinputplayerowngoalb.getText().toString();
                            String posisipemain = posisispinnerowngoalb.getSelectedItem().toString();
                            int nomorpunggungpemain =
                                    Integer.parseInt(editTextinputnomorpunggungowngoalb.getText().toString());
                            setDataPemain(teamB, namapemain, posisipemain, nomorpunggungpemain);
                            Toast.makeText(recordstat.this, "Input Data Pemain",
                                    Toast.LENGTH_SHORT).show();

                            tanding.setGoalTeamA(tanding.getGoalTeamA() + 1);
                            String chronotext = chronometer.getText().toString();

                            String array[] = chronotext.split(":");
                            Integer arrayint = Integer.parseInt(array[0]) + timematchint;
                            array[0] = String.valueOf(arrayint);

                            Log.d("time goal", array[0]);

                            Cursor datapertandingan = dbpertandingan.loaddatapertandingan();
                            if (datapertandingan.moveToFirst()) {
                                Log.d("Enter if ", "input goal");
                                inputdatagoal(editTextinputnomorpunggungowngoalb.getText().toString(),
                                        teamB, getidpertandingan(), array[0], "(OG)");
                            } else {
                                Log.d("belum ada ", "data pertadingan");
                                inputdatagoal(editTextinputnomorpunggungowngoalb.getText().toString(),
                                        teamB, getidpertandingan(), array[0], "");
                            }
                            dialogowngoalb.dismiss();

                        }

                    }
                });


                return true;

            default:
                return false;


        }
    }
}
