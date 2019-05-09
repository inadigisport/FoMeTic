package com.example.fometic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class goalDBHandler extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="footballDB.db";
    public static final String TABLE_GOAL="tablegoal";
    public static final String ID_PERTANDINGAN="idpertandingan";
    public static final String ID_TEAM="idteam";
    public static final String ID_PEMAIN="idpemain";
    public static final String NAMA_PEMAIN="namapemain";
    public static final String NOMOR_PUNGGUNG="nomorpunggung";
    public static final String NAMA_TEAM="namateam";
    public static final String MENIT_GOAL="menitgoal";

    public goalDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable="CREATE TABLE "+TABLE_GOAL+" ("+ID_PERTANDINGAN+" INT, "+ID_TEAM+" INT, "+ID_PEMAIN+" INT, "+NAMA_PEMAIN+" STRING, "+NOMOR_PUNGGUNG+" INT, "+NAMA_TEAM+" STRING, "+MENIT_GOAL+" STRING)";
        db.execSQL(createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addHandler(goal goal){
        ContentValues values=new ContentValues();
        values.put(ID_PERTANDINGAN,goal.getIdpertandingan());
        values.put(ID_TEAM,goal.getIdteam());
        values.put(ID_PEMAIN,goal.getIdpemain());
        values.put(NAMA_PEMAIN,goal.getNamapemain());
        values.put(NOMOR_PUNGGUNG,goal.getNomorpunggung());
        values.put(NAMA_TEAM,goal.getNamateam());
        values.put(MENIT_GOAL,Double.toString(goal.getMenit()));
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_GOAL, null,values);
        db.close();
    }

    public Cursor loaddatagoal(String idpertandingan){
        String query="SELECT * FROM "+TABLE_GOAL+" WHERE "+ID_PERTANDINGAN+"='"+idpertandingan+"'";
        return (loadHandler(query));
    }

    public Cursor loadHandler(String query){
        String result="";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int id_pertandingan=cursor.getInt(0);
            int id_team=cursor.getInt(1);
            int id_pemain=cursor.getInt(2);
            String nama_pemain=cursor.getString(3);
            int nomor_punggung=cursor.getInt(4);
            String nama_team=cursor.getString(5);
            String menit_goal=cursor.getString(6);
        }
        return cursor;
    }
}
