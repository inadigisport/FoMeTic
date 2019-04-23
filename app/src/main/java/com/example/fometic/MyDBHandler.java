package com.example.fometic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper {
    //information of database

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "footballDB.db";
    public static final String TABLE_NAME = "Pemain";
    public static final String COLUMN_ID_PEMAIN = "pemainID";
    public static final String COLUMN_NOMOR = "pemainNomor";
    public static final String COLUMN_NAMA_PEMAIN = "pemainNama";
    public static final String COLUMN_TEAM_PEMAIN = "teamPemain";
    public static final String TABLE_NAME_TEAM = "Team";
    public static final String COLUMN_ID_TEAM = "teamID";
    public static final String COLUMN_NAMA_TEAM = "teamNama";
    public static final String COLUMN_FORMASI_TEAM = "teamFormasi";
    public static final String COLUMN_JUMLAH_ANGGOTA_TEAM = "jumlahAnggotaTeam";


    //initialize the database

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, DATABASE_NAME, factory, DATABASE_VERSION);

    }

    @Override

    public void onCreate(SQLiteDatabase db) {}

    @Override

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    public String loadHandler() {

        String result = "";

        String query = "Select * FROM " + TABLE_NAME_TEAM;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {

            int result_0 = cursor.getInt(0);

            String result_1 = cursor.getString(1);

            result += String.valueOf(result_0) + " " + result_1 +

                    System.getProperty("line.separator");

        }

        cursor.close();

        db.close();

        return result;

    }

    public void addHandler(TeamBola teamBola) {
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID_TEAM, teamBola.getIdTeam());

        values.put(COLUMN_NAMA_TEAM, teamBola.getNamaTeam());

        values.put(COLUMN_FORMASI_TEAM, teamBola.getFormasiTeam());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_NAME_TEAM, null, values);

        db.close();
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

        String query = "Select*FROM" + TABLE_NAME_TEAM + "WHERE" + COLUMN_ID_TEAM + "= '" + String.valueOf(ID) + "'";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        TeamBola teambola = new TeamBola();

        if (cursor.moveToFirst()) {

            teambola.setIdTeam(Integer.parseInt(cursor.getString(0)));

            db.delete(TABLE_NAME_TEAM, COLUMN_ID_TEAM + "=?",

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

        ContentValues args = new ContentValues();

        args.put(COLUMN_ID_TEAM, ID);

        args.put(COLUMN_NAMA_TEAM, name);

        return db.update(TABLE_NAME_TEAM, args, COLUMN_ID_TEAM + "=" + ID, null) > 0;
    }
}
