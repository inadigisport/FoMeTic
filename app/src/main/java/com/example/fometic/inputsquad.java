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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class inputsquad extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView textnamapemain;
    Spinner team;
    TextView textnomorpunggung;
    Spinner spinnerposisi;
    Button buttonadd;
    Button buttonsubmit;
    public static final String kata_kunci = "inadigisport";
    String teamname;
    String namapemain;
    String posision;
    int nomorpunggung;
    PemainBola datapemain= new PemainBola();
    PemainDBHandler dbpemain=new PemainDBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputsquad);
        textnamapemain=findViewById(R.id.TextNama);
        spinnerposisi=findViewById(R.id.spinnerposisi);
        textnomorpunggung=findViewById(R.id.TextNomorPunggung);
        team=findViewById(R.id.spinnerTeam);
        getTeamData();


        //Intent intent = getIntent();
        //teamname = intent.getStringExtra(kata_kunci);
        //textView11 = (TextView) findViewById(R.id.textView11);

        //textView11.setText(teamname);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.position, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerposisi.setAdapter(adapter2);
        spinnerposisi.setOnItemSelectedListener(this);

        buttonadd=findViewById(R.id.buttonAdd);
        buttonadd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setDataPemain();
                textnamapemain.setText("");
                textnomorpunggung.setText("");
                spinnerposisi.setSelection(0);
                Toast.makeText(inputsquad.this, "Data berhasil ditambah", Toast.LENGTH_SHORT).show();
            }
        });


        buttonsubmit=findViewById(R.id.buttonSubmit);
        buttonsubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setDataPemain();
                Toast.makeText(inputsquad.this, "Data berhasil ditambah", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //String text2 = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), text2, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
        team= findViewById(R.id.spinnerTeam);
        team.setAdapter(arrayAdapter);
    }

    public void setDataPemain(){
        textnamapemain=findViewById(R.id.TextNama);
        spinnerposisi=findViewById(R.id.spinnerposisi);
        textnomorpunggung=findViewById(R.id.TextNomorPunggung);
        team=findViewById(R.id.spinnerTeam);
        datapemain.setNamaPemain(textnamapemain.getText().toString());
        datapemain.setPosisi(spinnerposisi.getSelectedItem().toString());
        datapemain.setNomorPunggung(Integer.parseInt(textnomorpunggung.getText().toString()));
        datapemain.setTeam(team.getSelectedItem().toString());
        dbpemain.addHandler(datapemain);
    }
}

