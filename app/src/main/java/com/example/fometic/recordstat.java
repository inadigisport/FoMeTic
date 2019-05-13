package com.example.fometic;

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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.common.server.converter.StringToIntConverter;

import java.util.ArrayList;
import java.util.List;

public class recordstat extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {


    private Chronometer chronometer;
    private Chronometer chronometerteam;
    private TextView textViewpossesionteama;
    private TextView textViewpossesionteamb;
    private boolean running;
    double possesionteama;
    double possesionteamb;
    TextView textviewteama;
    TextView textviewteamb;
    String teamA;
    String teamB;


    int ballpossesionteama;
    int ballpossesionteamb;
    long elapsedchronometerteam;
    long elapsedchronometerteamb;
    double elapsedchronometerteamint;
    double elapsedchronometerteambint;
    int passingteama ;
    int passingteamb ;
    int tacklingteama ;
    int tacklingteamb ;
    int interceptteama ;
    int interceptteamb ;
    int savesteama ;
    int savesteamb  ;
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







    Pertandingan tanding = new Pertandingan();
    PemainDBHandler dbpemain = new PemainDBHandler(this);
    PertandinganDBHandler dbpertandingan = new PertandinganDBHandler(this);
    PertandinganPemainDBHandler dbpertandinganpemain = new PertandinganPemainDBHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordstat);
        Bundle bundle = getIntent().getExtras();
        teamA=bundle.getString("teama");
        teamB=bundle.getString("teamb");
        chronometer = findViewById(R.id.chronometer);
        chronometerteam = findViewById(R.id.chronometerteam);
        textviewteama=findViewById(R.id.textViewteama);
        textviewteama.setText(teamA);
        textviewteamb=findViewById(R.id.textViewteamb);
        textviewteamb.setText(teamB);
        tanding.setBabak(1);




        textViewpossesionteama = findViewById(R.id.textViewpossesionteama);
        textViewpossesionteamb = findViewById(R.id.textViewpossesionteamb);

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
        intent.putExtra("teama",teamA);
        Log.d("team A choosen",teamA);
        intent.putExtra("teamb",teamB);
        Log.d("team B choosen",teamB);
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
        //intent.putExtra("cetakgoalteama",cetakgoalteama);


        startActivity(intent);

        //Intent intent = new Intent(this, recordstatsecond.class);
        //startActivity(intent);
    }

    public void passingteama(View v) {

        passingteama = passingteama + 1;
        Log.d("passing team a", Integer.toString((passingteama)));

        String chronotext = chronometerteam.getText().toString();
        String array[] = chronotext.split(":");
        if (array.length == 2) {
            elapsedchronometerteamint = Integer.parseInt(array[0])*60 + Integer.parseInt(array[1]);
        }
        else if (array.length == 3) {
            elapsedchronometerteamint = Integer.parseInt(array[0])*60*60 + Integer.parseInt(array[1])*60 + Integer.parseInt(array[2]);
        }



        Log.d("milisecond chronometer", Double.toString(elapsedchronometerteamint));

        possesionteama = possesionteama + elapsedchronometerteamint;
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();
        tanding.setPassingTeamA(tanding.getPassingTeamA()+1);

        ballpossesionteama = (int)((possesionteama / (possesionteama + possesionteamb)) * 100);
        ballpossesionteamb = (int)((possesionteamb / (possesionteama + possesionteamb)) * 100);
        textViewpossesionteama.setText(Integer.toString(ballpossesionteama));
        textViewpossesionteamb.setText(Integer.toString(ballpossesionteamb));




    }

    public void passingteamb(View v) {

        passingteamb = passingteamb +1;
        Log.d("passing team b", Integer.toString((passingteamb)));
        String chronotext = chronometerteam.getText().toString();
        String array[] = chronotext.split(":");
        if (array.length == 2) {
            elapsedchronometerteambint = Integer.parseInt(array[0])*60 + Integer.parseInt(array[1]);
        }
        else if (array.length == 3) {
            elapsedchronometerteambint = Integer.parseInt(array[0])*60*60 + Integer.parseInt(array[1])*60 + Integer.parseInt(array[2]);
        }
        Log.d("milisecond chronometer", Double.toString(elapsedchronometerteambint));
        possesionteamb = possesionteamb + elapsedchronometerteambint;
        //Log.d("elapsed team b", Double.toString(possesionteamb));
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();
        tanding.setPassingTeamB(tanding.getPassingTeamB()+1);


        ballpossesionteamb = (int)((possesionteamb / (possesionteama + possesionteamb))*100) ;
        ballpossesionteama = (int)((possesionteama / (possesionteama + possesionteamb))*100) ;

        //Log.d("Cek possesion", Double.toString(ballpossesionteamb));
        textViewpossesionteama.setText(Integer.toString(ballpossesionteama));
        textViewpossesionteamb.setText(Integer.toString(ballpossesionteamb));

    }

    public void tacklingteama(View v) {
        tacklingteama = tacklingteama + 1;
        Log.d("tackling team a", Integer.toString((tacklingteama)));

        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();
        tanding.setTacklingTeamA(tanding.getTacklingTeamA()+1);

    }

    public void tacklingteamb(View v) {
        tacklingteamb = tacklingteamb +1;
        Log.d("tackling team b", Integer.toString((tacklingteamb)));

        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();
        tanding.setTacklingTeamB(tanding.getTacklingTeamB()+1);

    }

    public void interceptteama(View v) {
        interceptteama = interceptteama +1;
        Log.d("intercept team a", Integer.toString((interceptteama)));


        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();
        tanding.setInterceptTeamA(tanding.getInterceptTeamA()+1);

    }

    public void interceptteamb(View v) {
        interceptteamb = interceptteamb +1;
        Log.d("intercept team b", Integer.toString((interceptteamb)));


        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.start();
        tanding.setInterceptTeamB(tanding.getInterceptTeamB()+1);

    }


    public void throwinteama(View v) {
        throwinteama = throwinteama + 1;
        Log.d("throw in team a", Integer.toString((throwinteama)));

        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setThrowinTeamA(tanding.getThrowinTeamA()+1);

    }

    public void throwinteamb(View v) {
        throwinteamb = throwinteamb+1;
        Log.d("throw in team b", Integer.toString((throwinteamb)));

        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setThrowinTeamB(tanding.getThrowinTeamB()+1);
    }

    public void cornerkickteama(View v) {
        cornerkickteama = cornerkickteama + 1;
        Log.d("corner kick team a", Integer.toString((cornerkickteama)));



        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setCornerkickTeamA(tanding.getCornerkickTeamA()+1);
    }
    public void cornerkickteamb(View v) {
       cornerkickteamb = cornerkickteamb + 1;
        Log.d("corner kick team b", Integer.toString((cornerkickteamb)));

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
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_freekick);
        popup.show();
    }

    public void freekickteamb(View v) {
        chronometerteam.setBase(SystemClock.elapsedRealtime());
        chronometerteam.stop();
        tanding.setFreekickTeamB(tanding.getFreekickTeamB()+1);
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_freekickb);
        popup.show();
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


        String chronotext = chronometerteam.getText().toString();
        String array[] = chronotext.split(":");
        if (array.length == 2) {
            elapsedchronometerteamint = Integer.parseInt(array[0])*60 + Integer.parseInt(array[1]);
        }
        else if (array.length == 3) {
            elapsedchronometerteamint = Integer.parseInt(array[0])*60*60 + Integer.parseInt(array[1])*60 + Integer.parseInt(array[2]);
        }
        Log.d("milisecond chronometer", Double.toString(elapsedchronometerteamint));
        possesionteama = possesionteama + elapsedchronometerteamint;

        ballpossesionteama = (int)((possesionteama / (possesionteama + possesionteamb)) * 100);
        ballpossesionteamb = (int)((possesionteamb / (possesionteama + possesionteamb)) * 100);
        textViewpossesionteama.setText(Integer.toString(ballpossesionteama));
        textViewpossesionteamb.setText(Integer.toString(ballpossesionteamb));

        chronometerteam.stop();
        chronometerteam.setBase(SystemClock.elapsedRealtime());



        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_shooting);
        popup.show();
    }

    public void showpopupshootingb(View v) {



        String chronotext = chronometerteam.getText().toString();
        String array[] = chronotext.split(":");
        if (array.length == 2) {
            elapsedchronometerteambint = Integer.parseInt(array[0])*60 + Integer.parseInt(array[1]);
        }
        else if (array.length == 3) {
            elapsedchronometerteambint = Integer.parseInt(array[0])*60*60 + Integer.parseInt(array[1])*60 + Integer.parseInt(array[2]);
        }
        Log.d("milisecond chronometer", Double.toString(elapsedchronometerteamint));
        possesionteamb = possesionteamb + elapsedchronometerteambint;

        ballpossesionteama = (int)((possesionteama / (possesionteama + possesionteamb)) * 100);
        ballpossesionteamb = (int)((possesionteamb / (possesionteama + possesionteamb)) * 100);
        textViewpossesionteama.setText(Integer.toString(ballpossesionteama));
        textViewpossesionteamb.setText(Integer.toString(ballpossesionteamb));

        chronometerteam.stop();
        chronometerteam.setBase(SystemClock.elapsedRealtime());

        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_shootingb);
        popup.show();
    }

    public void yellowcard(View v) {


        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.getMenu().add(1, R.id.yellowhome, 1, teamA);
        popup.getMenu().add(1, R.id.yellowaway,2, teamB);
        popup.show();

    }

    public void redcard(View v) {

        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.getMenu().add(1, R.id.redhome, 1, teamA);
        popup.getMenu().add(1, R.id.redaway, 2,teamB);
        popup.show();
    }

    public void inputname () {
        Intent intent = new Intent(this, InputName.class);
        startActivity(intent);

    }
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.goal:
                goalteama = goalteama + 1;

                shootontargetteama=shootontargetteama+1;
                Cursor datagoalteama=dbpemain.loaddatateam(teamA);
                List<String> listpemaingoalteama=new ArrayList<String>();
                datagoalteama.moveToFirst();
                while (!datagoalteama.isAfterLast()) {
                    listpemaingoalteama.add(datagoalteama.getString(0));
                    Log.d("list pemain goal team a",datagoalteama.getString(0));
                    datagoalteama.moveToNext();
                }



                AlertDialog.Builder builder = new AlertDialog.Builder(recordstat.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                final Spinner mSpinner = (Spinner) mView.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemaingoalteama );
                mSpinner.setAdapter(arrayAdapter);


                builder.setTitle("Pick Player");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(recordstat.this, "Goal Team A", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        String pemain=mSpinner.getSelectedItem().toString();
                        List<String> cetakgoalteama = new ArrayList<>();
                        cetakgoalteama.add(pemain);


                        Log.d("Pemain Goal Team A", pemain);
                        Log.d("data array", cetakgoalteama.get(0));
                        Log.d("data array", cetakgoalteama.get(1));

                        Cursor datagoalteama=dbpemain.loaddataidpemain(pemain, teamA);
                        List<String> listpemaingoalteama=new ArrayList<String>();
                        int i=0;
                        if (datagoalteama.moveToFirst()){
                            while (!datagoalteama.isAfterLast()) {
                                listpemaingoalteama.add(datagoalteama.getString(0));
                                Log.d("Data spinner ",datagoalteama.getString(0));
                                datagoalteama.moveToNext();
                                i=i+1;
                            }
                        }else{
                            Toast.makeText(recordstat.this, "Data not found", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setNeutralButton("INPUT NAME", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        inputname();

                    }
                });
                builder.setView(mView);
                AlertDialog dialog = builder.create();
                dialog.show();
                tanding.setGoalTeamA(tanding.getGoalTeamA()+1);

                return true;
            case R.id.shootontarget:
                shootontargetteama = shootontargetteama+1;
                savesteamb=savesteamb+1;
                //Toast.makeText(this, "Shoot On Target Team A", Toast.LENGTH_SHORT).show();
                Cursor datashootontargeta=dbpemain.loaddatateam(teamA);
                List<String> listpemainshootontargeta=new ArrayList<String>();
                datashootontargeta.moveToFirst();
                while (!datashootontargeta.isAfterLast()) {
                    listpemainshootontargeta.add(datashootontargeta.getString(0));
                    Log.d("Data spinner ",datashootontargeta.getString(0));
                    datashootontargeta.moveToNext();
                }
                AlertDialog.Builder buildershootontargeta = new AlertDialog.Builder(recordstat.this);
                View mViewshootontargeta = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                Spinner mSpinnershootontargeta = (Spinner) mViewshootontargeta.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdaptershootontargeta = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemainshootontargeta );
                mSpinnershootontargeta.setAdapter(arrayAdaptershootontargeta);


                buildershootontargeta.setTitle("Pick Player");
                buildershootontargeta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(recordstat.this, "Goal Team A", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }

                });
                buildershootontargeta.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                buildershootontargeta.setNeutralButton("INPUT NAME", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        inputname();

                    }
                });
                buildershootontargeta.setView(mViewshootontargeta);
                AlertDialog dialogshootontargeta = buildershootontargeta.create();
                dialogshootontargeta.show();


                chronometerteam.start();
                tanding.setShootOnTargetTeamA(tanding.getShootOffTargetTeamA()+1);
                return true;
            case R.id.shootofftarget:
                shootofftargetteama=shootofftargetteama+1;
                //Toast.makeText(this, "Shoot Off Target Team A", Toast.LENGTH_SHORT).show();
                Cursor datashootofftargeta=dbpemain.loaddatateam(teamA);
                List<String> listpemainshootofftargeta=new ArrayList<String>();
                datashootofftargeta.moveToFirst();
                while (!datashootofftargeta.isAfterLast()) {
                    listpemainshootofftargeta.add(datashootofftargeta.getString(0));
                    Log.d("Data spinner ",datashootofftargeta.getString(0));
                    datashootofftargeta.moveToNext();
                }
                AlertDialog.Builder buildershootofftargeta = new AlertDialog.Builder(recordstat.this);
                View mViewshootofftargeta = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                Spinner mSpinnershootofftargeta = (Spinner) mViewshootofftargeta.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdaptershootofftargeta = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemainshootofftargeta );
                mSpinnershootofftargeta.setAdapter(arrayAdaptershootofftargeta);


                buildershootofftargeta.setTitle("Pick Player");
                buildershootofftargeta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(recordstat.this, "Goal Team A", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }

                });
                buildershootofftargeta.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                buildershootofftargeta.setNeutralButton("INPUT NAME", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        inputname();

                    }
                });
                buildershootofftargeta.setView(mViewshootofftargeta);
                AlertDialog dialogshootofftargeta = buildershootofftargeta.create();
                dialogshootofftargeta.show();

                tanding.setShootOffTargetTeamA(tanding.getShootOffTargetTeamA()+1);

                return true;
            case R.id.goalb:
                goalteamb=goalteamb+1;
                shootontargetteamb=shootontargetteamb+1;
                TeamDBHandler dbgoalb = new TeamDBHandler(this);
                Cursor loadDataTeamgoalb=dbgoalb.loaddatateam();
                List<String> spinnerArraygoalb=new ArrayList<String>();
                loadDataTeamgoalb.moveToFirst();
                while (!loadDataTeamgoalb.isAfterLast()) {
                    spinnerArraygoalb.add(loadDataTeamgoalb.getString(1));
                    Log.d("Data spinner ",loadDataTeamgoalb.getString(1));
                    loadDataTeamgoalb.moveToNext();
                }
                Cursor datagoalteamb=dbpemain.loaddatateam(teamB);
                List<String> listpemaingoalteamb=new ArrayList<String>();
                datagoalteamb.moveToFirst();
                while (!datagoalteamb.isAfterLast()) {
                    listpemaingoalteamb.add(datagoalteamb.getString(0));
                    Log.d("Data spinner ",datagoalteamb.getString(0));
                    datagoalteamb.moveToNext();
                }
                AlertDialog.Builder buildergoalb = new AlertDialog.Builder(recordstat.this);
                View mViewgoalb = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                Spinner mSpinnergoalb = (Spinner) mViewgoalb.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdaptergoalb = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemaingoalteamb );
                mSpinnergoalb.setAdapter(arrayAdaptergoalb);

                tanding.setGoalTeamB(tanding.getGoalTeamB()+1);


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

                buildergoalb.setNeutralButton("INPUT NAME", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        inputname();
                    }
                });


                buildergoalb.setView(mViewgoalb);
                AlertDialog dialoggoalb = buildergoalb.create();
                dialoggoalb.show();
                //Toast.makeText(this, "Goal Team B", Toast.LENGTH_SHORT).show();

                return true;
            case R.id.shootontargetb:
                shootontargetteamb=shootontargetteamb+1;
                savesteama=savesteama+1;
                //Toast.makeText(this, "Shoot On Target Team B", Toast.LENGTH_SHORT).show();
                Cursor datashootontargetb=dbpemain.loaddatateam(teamB);
                List<String> listpemainshootontargetb=new ArrayList<String>();
                datashootontargetb.moveToFirst();
                while (!datashootontargetb.isAfterLast()) {
                    listpemainshootontargetb.add(datashootontargetb.getString(0));
                    Log.d("Data spinner ",datashootontargetb.getString(0));
                    datashootontargetb.moveToNext();
                }
                AlertDialog.Builder buildershootontargetb = new AlertDialog.Builder(recordstat.this);
                View mViewshootontargetb = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                Spinner mSpinnershootontargetb = (Spinner) mViewshootontargetb.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdaptershootontargetb = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemainshootontargetb );
                mSpinnershootontargetb.setAdapter(arrayAdaptershootontargetb);


                buildershootontargetb.setTitle("Pick Player");
                buildershootontargetb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(recordstat.this, "Goal Team A", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }

                });
                buildershootontargetb.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                buildershootontargetb.setNeutralButton("INPUT NAME", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        inputname();

                    }
                });
                buildershootontargetb.setView(mViewshootontargetb);
                AlertDialog dialogshootontargetb = buildershootontargetb.create();
                dialogshootontargetb.show();

                chronometerteam.start();
                tanding.setShootOnTargetTeamB(tanding.getShootOffTargetTeamB()+1);
                return true;
            case R.id.shootofftargetb:
                shootofftargetteamb=shootofftargetteamb+1;
                //Toast.makeText(this, "Shoot Off Target Team B", Toast.LENGTH_SHORT).show();
                Cursor datashootofftargetb=dbpemain.loaddatateam(teamB);
                List<String> listpemainshootofftargetb=new ArrayList<String>();
                datashootofftargetb.moveToFirst();
                while (!datashootofftargetb.isAfterLast()) {
                    listpemainshootofftargetb.add(datashootofftargetb.getString(0));
                    Log.d("Data spinner ",datashootofftargetb.getString(0));
                    datashootofftargetb.moveToNext();
                }
                AlertDialog.Builder buildershootofftargetb = new AlertDialog.Builder(recordstat.this);
                View mViewshootofftargetb = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                Spinner mSpinnershootofftargetb = (Spinner) mViewshootofftargetb.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdaptershootofftargetb = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemainshootofftargetb );
                mSpinnershootofftargetb.setAdapter(arrayAdaptershootofftargetb);


                buildershootofftargetb.setTitle("Pick Player");
                buildershootofftargetb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(recordstat.this, "Goal Team A", Toast.LENGTH_SHORT).show();
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
                tanding.setShootOffTargetTeamB(tanding.getShootOffTargetTeamB()+1);


                return true;

            case R.id.yellowhome:
                yellowcardteama = yellowcardteama + 1;
                Toast.makeText(this, "Yellow Card Team Home", Toast.LENGTH_SHORT).show();
                chronometerteam.setBase(SystemClock.elapsedRealtime());
                chronometerteam.stop();
                Cursor datayellowhome=dbpemain.loaddatateam(teamA);
                List<String> listpemainyellowhome=new ArrayList<String>();
                datayellowhome.moveToFirst();
                while (!datayellowhome.isAfterLast()) {
                    listpemainyellowhome.add(datayellowhome.getString(0));
                    Log.d("Data spinner ",datayellowhome.getString(0));
                    datayellowhome.moveToNext();
                }

                AlertDialog.Builder builderyellowhome = new AlertDialog.Builder(recordstat.this);
                View mViewyellowhome = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                Spinner mSpinneryellowhome = (Spinner) mViewyellowhome.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdapteryellowhome = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemainyellowhome );
                mSpinneryellowhome.setAdapter(arrayAdapteryellowhome);

                builderyellowhome.setTitle("Pick Player");
                builderyellowhome.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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
                yellowcardteamb = yellowcardteamb + 1;
                Toast.makeText(this, "Yellow Card Team Away", Toast.LENGTH_SHORT).show();
                chronometerteam.setBase(SystemClock.elapsedRealtime());
                chronometerteam.stop();
                Cursor datayellowaway=dbpemain.loaddatateam(teamB);
                List<String> listpemainyellowaway=new ArrayList<String>();
                datayellowaway.moveToFirst();
                while (!datayellowaway.isAfterLast()) {
                    listpemainyellowaway.add(datayellowaway.getString(0));
                    Log.d("Data spinner ",datayellowaway.getString(0));
                    datayellowaway.moveToNext();
                }

                AlertDialog.Builder builderyellowaway = new AlertDialog.Builder(recordstat.this);
                View mViewyellowaway = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                Spinner mSpinneryellowaway = (Spinner) mViewyellowaway.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdapteryellowaway = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemainyellowaway );
                mSpinneryellowaway.setAdapter(arrayAdapteryellowaway);

                builderyellowaway.setTitle("Pick Player");
                builderyellowaway.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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
                redcardteama = redcardteama + 1;
                Toast.makeText(this, "Red Card Team Home", Toast.LENGTH_SHORT).show();
                chronometerteam.setBase(SystemClock.elapsedRealtime());
                chronometerteam.stop();
                Cursor dataredhome=dbpemain.loaddatateam(teamA);
                List<String> listpemainredhome=new ArrayList<String>();
                dataredhome.moveToFirst();
                while (!dataredhome.isAfterLast()) {
                    listpemainredhome.add(dataredhome.getString(0));
                    Log.d("Data spinner ",dataredhome.getString(0));
                    dataredhome.moveToNext();
                }

                AlertDialog.Builder builderredhome = new AlertDialog.Builder(recordstat.this);
                View mViewredhome = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                Spinner mSpinnerredhome = (Spinner) mViewredhome.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdapterredhome = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemainredhome );
                mSpinnerredhome.setAdapter(arrayAdapterredhome);

                builderredhome.setTitle("Pick Player");
                builderredhome.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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
                redcardteamb = redcardteamb + 1;
                Toast.makeText(this, "Red Card Team Away", Toast.LENGTH_SHORT).show();
                chronometerteam.setBase(SystemClock.elapsedRealtime());
                chronometerteam.stop();
                Cursor dataredaway=dbpemain.loaddatateam(teamB);
                List<String> listpemainredaway=new ArrayList<String>();
                dataredaway.moveToFirst();
                while (!dataredaway.isAfterLast()) {
                    listpemainredaway.add(dataredaway.getString(0));
                    Log.d("Data spinner ",dataredaway.getString(0));
                    dataredaway.moveToNext();
                }

                AlertDialog.Builder builderredaway = new AlertDialog.Builder(recordstat.this);
                View mViewredaway = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                Spinner mSpinnerredaway = (Spinner) mViewredaway.findViewById(R.id.spinnerplayer);
                ArrayAdapter<String> arrayAdapterredaway = new ArrayAdapter<String>(recordstat.this, R.layout.support_simple_spinner_dropdown_item, listpemainredaway );
                mSpinnerredaway.setAdapter(arrayAdapterredaway);

                builderredaway.setTitle("Pick Player");
                builderredaway.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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
                foulteamb = foulteamb + 1;
                Log.d ("hitung foul team a",Integer.toString(foulteama));
                return true;

            case R.id.offsidehome:
                offsideteamb = offsideteamb + 1;
                Log.d ("hitung offside team a",Integer.toString(offsideteama));
                return true;
            case R.id.foulaway:
                foulteama = foulteama + 1;
                Log.d ("hitung foul team b",Integer.toString(foulteamb));
                return true;

            case R.id.offsideaway:
                offsideteama = offsideteama + 1;
                Log.d ("hitung offside team b",Integer.toString(offsideteamb));
                return true;

            default:
                return false;


        }
    }
}
