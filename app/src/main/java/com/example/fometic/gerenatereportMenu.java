package com.example.fometic;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
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
    String formationteama;
    String formationteamb;
    int ballpossesionteama;
    int ballpossesionteamb;
    String namateama;
    String namateamb;
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
    String venue;
    String event;
    ArrayList<String> cetakgoalteama = new ArrayList<>();
    ArrayList<String> pertandinganpemainteama = new ArrayList<>();
    ArrayList<String> pertandinganpemainteamb = new ArrayList<>();
    ArrayAdapter<String> arrayAdaptercetakgoalteama;
    ArrayList<String> cetakgoalteamb = new ArrayList<>();
    ArrayAdapter<String> arrayAdaptercetakgoalteamb;

    PertandinganDBHandler dbpertandingan = new PertandinganDBHandler(this);
    goalDBHandler dbgoal = new goalDBHandler(this);
    PemainDBHandler dbpemain = new PemainDBHandler(this);
    TeamDBHandler dbteam = new TeamDBHandler(this);
    PertandinganPemainDBHandler dbpertandinganpemain = new PertandinganPemainDBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenatereport_menu);
        Button search = findViewById(R.id.buttonsearch);
        getTeamData();
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namateama = teamA.getSelectedItem().toString();
                namateamb = teamB.getSelectedItem().toString();
                getdatapertandingan(namateama, namateamb);
            }
        });
    }

    public void getTeamData() {
        TeamDBHandler db = new TeamDBHandler(this);
        Cursor loadDataTeam = db.loaddatateam();
        List<String> spinnerArray = new ArrayList<String>();
        loadDataTeam.moveToFirst();
        while (!loadDataTeam.isAfterLast()) {
            spinnerArray.add(loadDataTeam.getString(1));
            Log.d("Data spinner ", loadDataTeam.getString(1));
            loadDataTeam.moveToNext();
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, spinnerArray);
        teamA = findViewById(R.id.spinnerteamhome);
        teamA.setAdapter(arrayAdapter);

        teamB = findViewById(R.id.spinnerteamaway);
        teamB.setAdapter(arrayAdapter);
    }

    public void getdatapemainteama(String teama, int idpertandingan, int babak){
        Cursor datateama=dbpemain.loaddatateam(teama);
        String b="Nama Pemain, Nomor Punggung, Jumlah Goal, Jumlah Yellow Card, Jumlah Red Card, Jumlah Shot on Target, Jumlah Shot off Target";
        pertandinganpemainteama.add(b);
        datateama.moveToFirst();
        while (!datateama.isAfterLast()){
            int idpemain=datateama.getInt(0);
            String nama=datateama.getString(1);
            String nomorpunggung=datateama.getString(3);
            Cursor datapertandinganpemain= dbpertandinganpemain.loaddatawithstat(idpemain, idpertandingan, babak);
            datapertandinganpemain.moveToFirst();
            while(!datapertandinganpemain.isAfterLast()){
                String a= nama+", "+nomorpunggung+", "+datapertandinganpemain.getInt(2)+", "+datapertandinganpemain.getInt(3)+", "+datapertandinganpemain.getInt(4)+", "+datapertandinganpemain.getInt(5)+", "+datapertandinganpemain.getInt(6);
                Log.d("data team a",a);
                pertandinganpemainteama.add(a);
                datapertandinganpemain.moveToNext();
            }
            datateama.moveToNext();
        }
    }

    public void getdatapemainteamb(String teamb, int idpertandingan, int babak){
        Cursor datateamb=dbpemain.loaddatateam(teamb);
        String b="Nama Pemain, Nomor Punggung, Jumlah Goal, Jumlah Yellow Card, Jumlah Red Card, Jumlah Shot on Target, Jumlah Shot off Target";
        pertandinganpemainteamb.add(b);
        datateamb.moveToFirst();
        while (!datateamb.isAfterLast()){
            int idpemain=datateamb.getInt(0);
            String nama=datateamb.getString(1);
            String nomorpunggung=datateamb.getString(3);
            Cursor datapertandinganpemain= dbpertandinganpemain.loaddatawithstat(idpemain, idpertandingan, babak);
            datapertandinganpemain.moveToFirst();
            while(!datapertandinganpemain.isAfterLast()){
                String a= nama+", "+nomorpunggung+", "+datapertandinganpemain.getInt(2)+", "+datapertandinganpemain.getInt(3)+", "+datapertandinganpemain.getInt(4)+", "+datapertandinganpemain.getInt(5)+", "+datapertandinganpemain.getInt(6);
                Log.d("data team b", a);
                pertandinganpemainteamb.add(a);
                datapertandinganpemain.moveToNext();
            }
            datateamb.moveToNext();
        }
    }

    public void getdatapertandingan(final String teama, final String teamb) {
        ArrayList<HashMap<String, String>> data = dbpertandingan.loaddatapertandinganreport(teama, teamb);
        final ListView lv = (ListView) findViewById(R.id.listpertandingan);
        ListAdapter adapter = new SimpleAdapter(gerenatereportMenu.this, data, R.layout.list_row, new String[]{"idpertandingan", "timtandingskor", "babak", "tanggal"}, new int[]{R.id.babakid, R.id.timtandingskor, R.id.babak, R.id.tanggal});
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String UserInfo = lv.getItemAtPosition(position).toString();
                Log.d("User Info", UserInfo);
                String UserInfo2 = UserInfo.substring(UserInfo.indexOf("idpertandingan="));
                String userId = UserInfo2.substring(UserInfo2.indexOf("=") + 1, UserInfo2.indexOf(","));
                Log.d("User ID", userId);
                int babak = Integer.parseInt(userId.substring(0, 1));
                int idpertandingan = Integer.valueOf(userId.substring(1, userId.length()));
                Log.d("babak",Integer.toString(babak));
                Log.d("idpertandingan",Integer.toString(idpertandingan));
                Cursor datapertandingan = dbpertandingan.loaddatapertandinganshow(idpertandingan, babak);
                datapertandingan.moveToFirst();
                getdatapemainteama(teama, idpertandingan, babak);
                getdatapemainteamb(teamb, idpertandingan, babak);
                formationteama = datapertandingan.getString(2);
                formationteamb = datapertandingan.getString(18);
                venue = datapertandingan.getString(40);
                event = datapertandingan.getString(39);
                passingteama = datapertandingan.getInt(3);
                passingteamb = datapertandingan.getInt(19);
                tacklingteama = datapertandingan.getInt(4);
                tacklingteamb = datapertandingan.getInt(20);
                interceptteama = datapertandingan.getInt(8);
                interceptteamb = datapertandingan.getInt(24);
                savesteama = datapertandingan.getInt(9);
                savesteamb = datapertandingan.getInt(25);
                throwinteama = datapertandingan.getInt(10);
                throwinteamb = datapertandingan.getInt(26);
                cornerkickteama = datapertandingan.getInt(14);
                cornerkickteamb = datapertandingan.getInt(30);
                ballpossesionteama = datapertandingan.getInt(36);
                ballpossesionteamb = datapertandingan.getInt(37);
                foulteama = datapertandingan.getInt(43);
                foulteamb = datapertandingan.getInt(44);
                offsideteama = datapertandingan.getInt(41);
                offsideteamb = datapertandingan.getInt(42);
                goalteama = datapertandingan.getInt(5);
                goalteamb = datapertandingan.getInt(21);
                shootontargetteama = datapertandingan.getInt(6);
                shootontargetteamb = datapertandingan.getInt(22);
                shootofftargetteama = datapertandingan.getInt(7);
                shootofftargetteamb = datapertandingan.getInt(23);
                yellowcardteama = datapertandingan.getInt(16);
                yellowcardteamb = datapertandingan.getInt(32);
                redcardteama = datapertandingan.getInt(15);
                redcardteamb = datapertandingan.getInt(31);
                if (babak == 1 || babak == 2 || babak == 3 || babak == 4) {
                    Cursor goalpemainteama = dbgoal.loaddatagoal(String.valueOf(idpertandingan), String.valueOf(dbteam.loaddataidteam(String.valueOf(namateama))), babak);
                    goalpemainteama.moveToFirst();
                    while (!goalpemainteama.isAfterLast()) {
                        String a = dbpemain.loadnamapemain(goalpemainteama.getInt(2)) + " '" + goalpemainteama.getString(3)+ " " +goalpemainteama.getString(4);
                        cetakgoalteama.add(a);
                        goalpemainteama.moveToNext();
                    }

                    Cursor goalpemainteamb = dbgoal.loaddatagoal(String.valueOf(idpertandingan), String.valueOf(dbteam.loaddataidteam(String.valueOf(namateamb))), babak);
                    goalpemainteamb.moveToFirst();
                    while (!goalpemainteamb.isAfterLast()) {
                        String a = dbpemain.loadnamapemain(goalpemainteamb.getInt(2)) + " '" + goalpemainteamb.getString(3) + " " +goalpemainteamb.getString(4);
                        cetakgoalteamb.add(a);
                        goalpemainteamb.moveToNext();
                    }
                } else{
                    Toast.makeText(gerenatereportMenu.this, "Babak tidak terdaftar", Toast.LENGTH_SHORT).show();
                }
                    /**Cursor goalpemainteama = dbgoal.loaddatagoalbabakdua(String.valueOf(idpertandingan), String.valueOf(dbteam.loaddataidteam(String.valueOf(namateama))));
                    goalpemainteama.moveToFirst();
                    while (!goalpemainteama.isAfterLast()) {
                        String a = dbpemain.loadnamapemain(goalpemainteama.getInt(2)) + " (" + goalpemainteama.getString(3) + ") " + goalpemainteama.getString(4);
                        cetakgoalteama.add(a);
                        goalpemainteama.moveToNext();
                    }**/

                //Cursor datapertandinganpemain = dbpertandinganpemain.loadHandler(idpertandingan, babak);
                //datapertandingan.moveToFirst();

                Intent intent = new Intent(gerenatereportMenu.this, choosegeneratereport.class);
                intent.putExtra("teama", namateama);
                intent.putExtra("teamb", namateamb);
                intent.putExtra("formationteamb", formationteamb);
                intent.putExtra("formationteama", formationteama);
                intent.putExtra("formationteamb", formationteamb);
                intent.putExtra("venue", venue);
                intent.putExtra("event", event);
                intent.putExtra("passingteama", passingteama);
                intent.putExtra("passingteamb", passingteamb);
                intent.putExtra("tacklingteama", tacklingteama);
                intent.putExtra("tacklingteamb", tacklingteamb);
                intent.putExtra("interceptteama", interceptteama);
                intent.putExtra("interceptteamb", interceptteamb);
                intent.putExtra("savesteama", savesteama);
                intent.putExtra("savesteamb", savesteamb);
                intent.putExtra("throwinteama", throwinteama);
                intent.putExtra("throwinteamb", throwinteamb);
                intent.putExtra("cornerkickteama", cornerkickteama);
                intent.putExtra("cornerkickteamb", cornerkickteamb);
                intent.putExtra("ballpossesionteama", ballpossesionteama);
                intent.putExtra("ballpossesionteamb", ballpossesionteamb);
                intent.putExtra("foulteama", foulteama);
                intent.putExtra("foulteamb", foulteamb);
                intent.putExtra("offsideteama", offsideteama);
                intent.putExtra("offsideteamb", offsideteamb);
                intent.putExtra("goalteama", goalteama);
                intent.putExtra("goalteamb", goalteamb);
                intent.putExtra("shootontargetteama", shootontargetteama);
                intent.putExtra("shootontargetteamb", shootontargetteamb);
                intent.putExtra("shootofftargetteama", shootofftargetteama);
                intent.putExtra("shootofftargetteamb", shootofftargetteamb);
                intent.putExtra("yellowcardteama", yellowcardteama);
                intent.putExtra("yellowcardteamb", yellowcardteamb);
                intent.putExtra("redcardteama", redcardteama);
                intent.putExtra("redcardteamb", redcardteamb);
                intent.putExtra("ballpossesionteama", ballpossesionteama);
                intent.putExtra("ballpossesionteamb", ballpossesionteamb);
                intent.putStringArrayListExtra("cetakgoalteama", cetakgoalteama);
                intent.putStringArrayListExtra("cetakgoalteamb", cetakgoalteamb);
                intent.putStringArrayListExtra("datapertandinganpemainteama", pertandinganpemainteama);
                intent.putStringArrayListExtra("datapertandinganpemainteamb", pertandinganpemainteamb);
                startActivity(intent);
                pertandinganpemainteama.clear();
                pertandinganpemainteamb.clear();
                cetakgoalteama.clear();
                cetakgoalteamb.clear();

                //Toast.makeText(getBaseContext(), lv.getItemAtPosition(position).toString()+userId+","+babak+","+idpertandingan, Toast.LENGTH_LONG).show();
            }
        });
    }


}
