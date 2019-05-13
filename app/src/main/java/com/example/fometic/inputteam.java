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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class inputteam extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button button;
    EditText editText;
    EditText textjumlahsquad;
    String teamname;
    String formation;
    Spinner spinner;
    ListView listViewTeam;
    ArrayAdapter<String > arrayAdapter;
    public static final String kata_kunci = "inadigisport";
    TeamDBHandler db=new TeamDBHandler(this);
    TeamBola teambola = new TeamBola();





    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputteam);
        getTeamData();
        button = (Button) findViewById(R.id.button6);
        editText = (EditText) findViewById(R.id.namaTeam);
        spinner = findViewById(R.id.spinner);
        listViewTeam=findViewById(R.id.listViewTeam);
        listViewTeam.setAdapter(arrayAdapter);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                formation = spinner.getSelectedItem().toString();

                formation = spinner.getSelectedItem().toString();
                Log.d("isi formasi ", formation);

                teamname = editText.getText().toString();
                teambola.setNamaTeam(teamname);
                teambola.setFormasiTeam(formation);

                db.addHandler(teambola);


                finish();
            }
        });


    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //String text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void inputTeam(String name, String formation){
        TeamDBHandler databaseTeam = new TeamDBHandler(this);
        TeamBola teamBola= new TeamBola();
        teamBola.setNamaTeam(name);
        teamBola.setFormasiTeam(formation);
        databaseTeam.addHandler(teamBola);
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

        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, spinnerArray);
        //teamA= findViewById(R.id.spinnerteamA);
        //teamA.setAdapter(arrayAdapter);

        //teamB= findViewById(R.id.spinnerteamB);
        //teamB.setAdapter(arrayAdapter);
    }

}
