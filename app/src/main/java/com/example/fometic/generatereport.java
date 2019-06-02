package com.example.fometic;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class generatereport extends AppCompatActivity {

    String teamA;
    String teamB;
    TextView textviewteama;
    TextView textviewteamb;
    TextView textviewformationa;
    TextView textviewformationb;
    TextView textViewballpossesionteama;
    TextView textViewballpossesionteamb;
    TextView textViewpassingteama;
    TextView textViewpassingteamb;
    TextView textViewtacklingteama;
    TextView textViewtacklingteamb;
    TextView textViewinterceptteama;
    TextView textViewinterceptteamb;
    TextView textViewsavesteama;
    TextView textViewsavesteamb;
    TextView textViewthrowinteama;
    TextView textViewthrowinteamb;
    TextView textViewcornerkickteama;
    TextView textViewcornerkickteamb;
    TextView textViewfoulteama;
    TextView textViewfoulteamb;
    TextView textViewoffsideteama;
    TextView textViewoffsideteamb;
    TextView textViewgoalteama;
    TextView textViewgoalteamb;
    TextView textViewshootontargetteama;
    TextView textViewshootontargetteamb;
    TextView textViewshootofftargetteama;
    TextView textViewshootofftargetteamb;
    TextView textViewyellowcardteama;
    TextView textViewyellowcardteamb;
    TextView textViewredcardteama;
    TextView textViewredcardteamb;
    TextView textViewlistpemaingoalteama;
    TextView textViewlistpemaingoalteamb;
    TextView textViewvenue;
    TextView textViewevent;
    TextView textViewtanggal;
    ArrayList<String > cetakgoalteama = new ArrayList<>();
    ArrayList<String > cetakgoalteamb = new ArrayList<>();


    String formationA;
    String formationB;
    String formationteama;
    String formationteamb;
    String venue;
    String event;

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
    int timematch;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_generatereport);
        teamA= getIntent().getStringExtra("teama");
        teamB= getIntent().getStringExtra("teamb");
        formationteama= getIntent().getStringExtra("formationteama");
        formationteamb= getIntent().getStringExtra("formationteamb");
        venue= getIntent().getStringExtra("venue");
        event= getIntent().getStringExtra("event");
        Log.d("venue", venue);
        textviewteama=findViewById(R.id.textViewteama);
        textviewteama.setText(teamA);
        textviewteamb=findViewById(R.id.textViewteamb);
        textviewteamb.setText(teamB);
        textViewvenue=findViewById(R.id.textViewvenue);
        textViewvenue.setText(venue);
        textViewevent=findViewById(R.id.textViewevent);
        textViewevent.setText(event);
        //getFormationData();
        textviewformationa=findViewById(R.id.textViewformationA);
        textviewformationb=findViewById(R.id.textViewformationB);
        textviewformationa.setText(formationteama);
        textviewformationb.setText(formationteamb);

        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        Date todayDate = new Date();
        String thisDate = currentDate.format(todayDate);
        textViewtanggal = findViewById(R.id.textViewtanggal);
        textViewtanggal.setText(thisDate);



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
        cetakgoalteama= getIntent().getExtras().getStringArrayList("cetakgoalteama");
        cetakgoalteamb= getIntent().getExtras().getStringArrayList("cetakgoalteamb");

        textViewballpossesionteama=findViewById(R.id.textViewballpossesionteama);
        textViewballpossesionteamb=findViewById(R.id.textViewballpossesionteamb);
        textViewballpossesionteama.setText(Integer.toString(ballpossesionteama));
        textViewballpossesionteamb.setText(Integer.toString(ballpossesionteamb));
        textViewpassingteama=findViewById(R.id.textViewpassingteama);
        textViewpassingteamb=findViewById(R.id.textViewpassingteamb);
        textViewpassingteama.setText(Integer.toString(passingteama));
        textViewpassingteamb.setText(Integer.toString(passingteamb));
        textViewtacklingteama=findViewById(R.id.textViewtacklingteama);
        textViewtacklingteamb=findViewById(R.id.textViewtacklingteamb);
        textViewtacklingteama.setText(Integer.toString(tacklingteama));
        textViewtacklingteamb.setText(Integer.toString(tacklingteamb));
        textViewinterceptteama=findViewById(R.id.textViewinterceptteama);
        textViewinterceptteamb=findViewById(R.id.textViewinterceptteamb);
        textViewinterceptteama.setText(Integer.toString(interceptteama));
        textViewinterceptteamb.setText(Integer.toString(interceptteamb));
        textViewsavesteama=findViewById(R.id.textViewsavesteama);
        textViewsavesteamb=findViewById(R.id.textViewsavesteamb);
        textViewsavesteama.setText(Integer.toString(savesteama));
        textViewsavesteamb.setText(Integer.toString(savesteamb));
        textViewcornerkickteama=findViewById(R.id.textViewcornerkickteama);
        textViewcornerkickteamb=findViewById(R.id.textViewcornerkickteamb);
        textViewcornerkickteama.setText(Integer.toString(cornerkickteama));
        textViewcornerkickteamb.setText(Integer.toString(cornerkickteamb));
        textViewfoulteama=findViewById(R.id.textViewfoulteama);
        textViewfoulteamb=findViewById(R.id.textViewfoulteamb);
        textViewfoulteama.setText(Integer.toString(foulteama));
        textViewfoulteamb.setText(Integer.toString(foulteamb));
        textViewoffsideteama=findViewById(R.id.textViewoffsideteama);
        textViewoffsideteamb=findViewById(R.id.textViewoffsideteamb);
        textViewoffsideteama.setText(Integer.toString(offsideteama));
        textViewoffsideteamb.setText(Integer.toString(offsideteamb));
        textViewgoalteama=findViewById(R.id.textViewgoalteama);
        textViewgoalteamb=findViewById(R.id.textViewgoalteamb);
        textViewgoalteama.setText(Integer.toString(goalteama));
        textViewgoalteamb.setText(Integer.toString(goalteamb));
        textViewshootontargetteama=findViewById(R.id.textViewshootontargetteama);
        textViewshootontargetteamb=findViewById(R.id.textViewshootontargetteamb);
        textViewshootontargetteama.setText(Integer.toString(shootontargetteama));
        textViewshootontargetteamb.setText(Integer.toString(shootontargetteamb));
        textViewshootofftargetteama=findViewById(R.id.textViewshootofftargetteama);
        textViewshootofftargetteamb=findViewById(R.id.textViewshootofftargetteamb);
        textViewshootofftargetteama.setText(Integer.toString(shootofftargetteama));
        textViewshootofftargetteamb.setText(Integer.toString(shootofftargetteamb));
        textViewyellowcardteama=findViewById(R.id.textViewyellowcardteama);
        textViewyellowcardteamb=findViewById(R.id.textViewyellowcardteamb);
        textViewyellowcardteama.setText(Integer.toString(yellowcardteama));
        textViewyellowcardteamb.setText(Integer.toString(yellowcardteamb));
        textViewredcardteama=findViewById(R.id.textViewredcardteama);
        textViewredcardteamb=findViewById(R.id.textViewredcardteamb);
        textViewredcardteama.setText(Integer.toString(redcardteama));
        textViewredcardteamb.setText(Integer.toString(redcardteamb));

        textViewlistpemaingoalteama=findViewById(R.id.textViewlistpemaingoalteama);
        textViewlistpemaingoalteama.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder builder=new StringBuilder();
        for (String detail  : cetakgoalteama){
            builder.append(detail + "\n" );

        }
        textViewlistpemaingoalteama.setText(builder.toString());

        textViewlistpemaingoalteamb=findViewById(R.id.textViewlistpemaingoalteamb);
        textViewlistpemaingoalteama.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        StringBuilder builderteamb=new StringBuilder();
        for (String detail  : cetakgoalteamb){
            builderteamb.append(detail + "\n" );

        }
        textViewlistpemaingoalteamb.setText(builderteamb.toString());

    }

    /**public void getFormationData(){
        TeamDBHandler db = new TeamDBHandler(this);
        Cursor loadDataTeam=db.loaddatareport(teamA);
        loadDataTeam.moveToFirst();
        while (!loadDataTeam.isAfterLast()) {
        formationA = loadDataTeam.getString(2);
        Log.d("formasi team A ",formationA);
        loadDataTeam.moveToNext();
        }
        Cursor loadDataTeamb=db.loaddatareport(teamB);
        loadDataTeamb.moveToFirst();
        while (!loadDataTeamb.isAfterLast()) {
            formationB = loadDataTeamb.getString(2);
            Log.d("formasi team A ",formationB);
            loadDataTeamb.moveToNext();
        }



    }**/


}
