package com.example.fometic;

import android.app.Activity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class InputName extends AppCompatActivity {
    TextView textnamapemain;
    TextView textnomorpunggung;
    Spinner spinnerposisi;
    Spinner team;
    PemainBola datapemain= new PemainBola();
    PemainDBHandler dbpemain=new PemainDBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_name);
        getTeamData();
        spinnerposisi = findViewById(R.id.spinnerposisi2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.position, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerposisi.setAdapter(adapter2);


        Button button = findViewById(R.id.buttonSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDataPemain();

                finish();

            }
        });



    }

    public void setDataPemain(){
        textnamapemain=findViewById(R.id.textNama);
        spinnerposisi=findViewById(R.id.spinnerposisi2);
        textnomorpunggung=findViewById(R.id.textNomorPunggung);
        team=findViewById(R.id.spinnerTeam2);
        datapemain.setNamaPemain(textnamapemain.getText().toString());
        datapemain.setPosisi(spinnerposisi.getSelectedItem().toString());
        datapemain.setNomorPunggung(Integer.parseInt(textnomorpunggung.getText().toString()));
        datapemain.setTeam(team.getSelectedItem().toString());
        dbpemain.addHandler(datapemain);
    }

    public void getTeamData(){
        TeamDBHandler db = new TeamDBHandler(this);
        Cursor loadDataTeam=db.loadHandler();
        List<String> spinnerArray=new ArrayList<String>();
        loadDataTeam.moveToFirst();
        while (!loadDataTeam.isAfterLast()) {
            spinnerArray.add(loadDataTeam.getString(1));
            Log.d("Data spinner ",loadDataTeam.getString(1));
            loadDataTeam.moveToNext();
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, spinnerArray);
        team= findViewById(R.id.spinnerTeam2);
        team.setAdapter(arrayAdapter);
    }



}
