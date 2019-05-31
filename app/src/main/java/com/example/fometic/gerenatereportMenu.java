package com.example.fometic;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class gerenatereportMenu extends AppCompatActivity {

    Spinner teamA;
    Spinner teamB;

    PertandinganDBHandler dbpertandingan=new PertandinganDBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenatereport_menu);
        Button search= findViewById(R.id.buttonsearch);
        getTeamData();
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teamachoosen=teamA.getSelectedItem().toString();
                String teambchoosen=teamB.getSelectedItem().toString();
                getdatapertandingan(teamachoosen,teambchoosen);
            }
        });
    }

    public void getTeamData(){
        TeamDBHandler db = new TeamDBHandler(this);
        Cursor loadDataTeam=db.loaddatateam();
        List<String> spinnerArray=new ArrayList<String>();
        loadDataTeam.moveToFirst();
        while (!loadDataTeam.isAfterLast()) {
            spinnerArray.add(loadDataTeam.getString(1));
            Log.d("Data spinner ",loadDataTeam.getString(1));
            loadDataTeam.moveToNext();
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, spinnerArray);
        teamA= findViewById(R.id.spinnerteamhome);
        teamA.setAdapter(arrayAdapter);

        teamB= findViewById(R.id.spinnerteamaway);
        teamB.setAdapter(arrayAdapter);
    }

    public void getdatapertandingan(String teama, String teamb){
        ArrayList<HashMap<String, String>> data=dbpertandingan.loaddatapertandinganreport(teama,teamb);
        ListView lv = (ListView) findViewById(R.id.listpertandingan);
        ListAdapter adapter = new SimpleAdapter(gerenatereportMenu.this, data, R.layout.list_row,new String[]{"timtandingskor","babak","tanggal"}, new int[]{R.id.timtandingskor, R.id.babak, R.id.tanggal});
        lv.setAdapter(adapter);
    }
}
