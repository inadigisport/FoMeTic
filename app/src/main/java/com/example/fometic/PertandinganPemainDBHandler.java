package com.example.fometic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PertandinganPemainDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "footballDB.db";
    private static final String ID_PERTANDINGAN= "idpertandinga";
    private static final String ID_PEMAIN="idpemain";
    private static final String JUMLAH_GOAL="jumlahgoal";
    private static final String JUMLAH_YELLOWCARD="jumlahyellowcard";
    private static final String JUMLAH_REDCARD="jumlahredcard";
    private static final String JUMLAH_SHOTONTARGET="jumlahshotontarget";
    private static final String JUMLAH_SHOTOFFTARGET="jumlahshotofftarget";

    public PertandinganPemainDBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
