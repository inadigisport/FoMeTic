package com.example.fometic;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

public class recordstat extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private Chronometer chronometer;
    private boolean running;
    Button buttonshootingteama;
    Button buttonshootingteamb;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordstat);

        chronometer = findViewById(R.id.chronometer);


    }

    public void startChronometer(View v) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            running = true;

        }
    }

    public void stopChronometer(View v) {
        if (running) {
            chronometer.stop();
            running = false;

        }

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
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.goal:
                Toast.makeText(this, "Goal Team A", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.shootontarget:
                Toast.makeText(this, "Shoot On Target Team A", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.shootofftarget:
                Toast.makeText(this, "Shoot Off Target Team A", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.goalb:
                Toast.makeText(this, "Goal Team B", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.shootontargetb:
                Toast.makeText(this, "Shoot On Target Team B", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.shootofftargetb:
                Toast.makeText(this, "Shoot Off Target Team B", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return false;


        }
    }
}
