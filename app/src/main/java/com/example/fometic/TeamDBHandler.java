package com.example.fometic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TeamDBHandler extends SQLiteOpenHelper {
    //information of database

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "footballDB";
    public static final String TABLE_NAME = "Pemain";
    public static final String TABLE_TEAM = "Team";
    public static final String COLUMN_ID_TEAM = "teamID";
    public static final String COLUMN_NAMA_TEAM = "teamNama";
    public static final String COLUMN_FORMASI_TEAM = "teamFormasi";




    //initialize the database

    public TeamDBHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        String createTableTeam="CREATE TABLE "+TABLE_TEAM+" (" +COLUMN_ID_TEAM+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_NAMA_TEAM+ " TEXT, "+COLUMN_FORMASI_TEAM+" STRING)";

        db.execSQL(createTableTeam);
    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    public Cursor loaddatateam(){
        String query = "Select * FROM " + TABLE_TEAM;
        return loadHandler(query);
    }

    public int loaddataidteam(String nama){
        int i=0;
        String query = "Select * FROM " + TABLE_TEAM+" WHERE "+COLUMN_NAMA_TEAM+"='"+nama+"'";
        Cursor idteam=loadHandler(query);
        idteam.moveToFirst();
        i=idteam.getInt(0);
        Log.d("load data id team", Integer.toString(i));
        return i;
    }

    public Cursor loaddatareport(String team){
        String query = "Select * FROM " + TABLE_TEAM+ " WHERE "+COLUMN_NAMA_TEAM+"='"+team+"'";
        return loadHandler(query);
    }

    public Cursor loadHandler(String query) {
        String result="";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {

            int id_team = cursor.getInt(0);

            String nama_team = cursor.getString(1);

            String formasi = cursor.getString(2);

            result += String.valueOf(id_team) + " " + nama_team + " "+ formasi+

                    System.getProperty("line.separator");

        }

        Log.d("Isi Database", result);

        return cursor;

    }



    public void addHandler(TeamBola teamBola) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMA_TEAM, teamBola.getNamaTeam());
        values.put(COLUMN_FORMASI_TEAM, teamBola.getFormasiTeam());
        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_TEAM, null, values);
        Log.d("Data nama team :", teamBola.getNamaTeam());
        db.close();
        loaddatateam();
    }


    public TeamBola findHandler(String namaTeam) {
        String query = "Select * FROM " + TABLE_NAME + "WHERE" + COLUMN_NAMA_TEAM + " = " + "'" + namaTeam + "'";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        TeamBola teambola = new TeamBola();

        if (cursor.moveToFirst()) {

            cursor.moveToFirst();

            teambola.setIdTeam(Integer.parseInt(cursor.getString(0)));

            teambola.setNamaTeam(cursor.getString(1));

            cursor.close();

        } else {

            teambola = null;

        }

        db.close();

        return teambola;
    }

    public boolean deleteHandler(int ID) {
        boolean result = false;

        String query = "Select*FROM" + TABLE_TEAM + "WHERE" + COLUMN_ID_TEAM + "= '" + String.valueOf(ID) + "'";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        TeamBola teambola = new TeamBola();

        if (cursor.moveToFirst()) {

            teambola.setIdTeam(Integer.parseInt(cursor.getString(0)));

            db.delete(TABLE_TEAM, COLUMN_ID_TEAM + "=?",

                    new String[] {

                String.valueOf(teambola.getIdTeam())

            });

            cursor.close();

            result = true;

        }

        db.close();

        return result;
    }

    public boolean updateHandler(int ID, String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues update = new ContentValues();

        update.put(COLUMN_ID_TEAM, ID);

        update.put(COLUMN_NAMA_TEAM, name);

        return db.update(TABLE_TEAM, update, COLUMN_ID_TEAM + "=" + ID, null) > 0;
    }
}
