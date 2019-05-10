package com.example.fometic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PertandinganPemainDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "pertandinganpemaindb";
    private static final String TABLE_PERTANDINGAN_PEMAIN="tablepertandinganpemain";
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
        String createTableTeam="CREATE TABLE "+TABLE_PERTANDINGAN_PEMAIN+" ("+ID_PERTANDINGAN+" INT, "+ID_PEMAIN+" INT,"+JUMLAH_GOAL+" INT, "+JUMLAH_YELLOWCARD+" INT, "+JUMLAH_REDCARD+" INT, "+JUMLAH_SHOTONTARGET+" INT, "+JUMLAH_SHOTOFFTARGET+" INT)";
        db.execSQL(createTableTeam);
    }

    public void addHandler(PertandinganPemain pertandingan){
        ContentValues values = new ContentValues();
        values.put(ID_PERTANDINGAN,pertandingan.getIdpertandingan());
        values.put(ID_PEMAIN,pertandingan.getIdpemain());
        values.put(JUMLAH_GOAL,pertandingan.getJumlahgoal());
        values.put(JUMLAH_YELLOWCARD,pertandingan.getJumlahyellowcard());
        values.put(JUMLAH_REDCARD,pertandingan.getJumlahredcard());
        values.put(JUMLAH_SHOTONTARGET,pertandingan.getJumlahshotontarget());
        values.put(JUMLAH_SHOTOFFTARGET,pertandingan.getJumlahshotofftarget());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_PERTANDINGAN_PEMAIN, null, values);
        db.close();
    }

    public Cursor loadHandler(){
        String result = "";

        String query = "Select * FROM " + TABLE_PERTANDINGAN_PEMAIN;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            int id_pertandingan = cursor.getInt(0);
            int id_pemain = cursor.getInt(1);
            int jumlah_goal = cursor.getInt(2);
            int jumlah_yellowcard = cursor.getInt(3);
            int jumlah_redcard = cursor.getInt(4);
            int jumlah_shotontarget = cursor.getInt(5);
            int jumlah_shotofftarget = cursor.getInt(6);
        }
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean updateHandler(int ID, int IDPemain) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues update = new ContentValues();

        //update.put(JUMLAH_GOAL, );


        return db.update(TABLE_PERTANDINGAN_PEMAIN, update, ID_PERTANDINGAN + "=" + ID +"AND "+ID_PEMAIN+"="+IDPemain, null) > 0;
    }
}
