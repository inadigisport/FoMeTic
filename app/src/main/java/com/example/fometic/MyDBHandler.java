package com.example.fometic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBHandler extends SQLiteOpenHelper {
    //information of database

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "footballDB.db";
    public static final String TABLE_NAME = "Pemain";
    public static final String COLUMN_ID_PEMAIN = "pemainID";
    public static final String COLUMN_NOMOR = "pemainNomor";
    public static final String COLUMN_NAMA_PEMAIN = "pemainNama";
    public static final String COLUMN_TEAM_PEMAIN = "teamPemain";
    public static final String TABLE_TEAM = "Team";
    public static final String COLUMN_ID_TEAM = "teamID";
    public static final String COLUMN_NAMA_TEAM = "teamNama";
    public static final String COLUMN_FORMASI_TEAM = "teamFormasi";
    public static final String JUMLAH_PASSING_TEAM = "passingTeam";
    public static final String JUMLAH_TACKLING_TEAM = "tacklingTeam";
    public static final String JUMLAH_SHOOT_GOAL_TEAM = "goalTeam";
    public static final String JUMLAH_SHOOT_ON_TARGET_TEAM = "shootOnTargetTeam";
    public static final String JUMLAH_SHOOT_OFF_TARGET_TEAM = "shootOffTargetTeam";
    public static final String JUMLAH_INTERCEPT_TEAM = "interceptTeam";
    public static final String JUMLAH_SAVES_TEAM = "savesTeam";
    public static final String JUMLAH_THROWIN_TEAM = "throwinTeam";
    public static final String JUMLAH_FREEKICK_TEAM = "freekickTeam";
    public static final String JUMLAH_PINALTY_TEAM = "pinaltyTeam";
    public static final String JUMLAH_GOALKICK_TEAM = "goalkickTeam";
    public static final String JUMLAH_CORNERKICK_TEAM = "cornerkickTeam";
    public static final String COLUMN_JUMLAH_ANGGOTA_TEAM = "jumlahAnggotaTeam";
    public static final String JUMLAH_YELLOW_CARD_TEAM = "yellowCardTeam";
    public static final String JUMLAH_RED_CARD_TEAM =  "redCardTeam";
    public static final String STATUS_TEAM =  "statusTeam";


    //initialize the database

    public MyDBHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        String createTableTeam="CREATE TABLE "+TABLE_TEAM+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_NAMA_TEAM+ " TEXT, "+COLUMN_FORMASI_TEAM+" TEXT, "+JUMLAH_PASSING_TEAM+" INT, "+JUMLAH_TACKLING_TEAM+" INT, "+JUMLAH_SHOOT_GOAL_TEAM+" INT, "+JUMLAH_SHOOT_ON_TARGET_TEAM+" INT, "+JUMLAH_SHOOT_OFF_TARGET_TEAM+" INT, "+JUMLAH_INTERCEPT_TEAM+" INT, "+JUMLAH_SAVES_TEAM+" INT,"+JUMLAH_THROWIN_TEAM+" INT, "+JUMLAH_FREEKICK_TEAM+" INT, "+JUMLAH_PINALTY_TEAM+" INT, "+JUMLAH_GOALKICK_TEAM+" INT, "+JUMLAH_CORNERKICK_TEAM+" INT, "+COLUMN_JUMLAH_ANGGOTA_TEAM+" INT, "+JUMLAH_RED_CARD_TEAM+" INT, "+JUMLAH_YELLOW_CARD_TEAM+" INT, "+STATUS_TEAM+" INT)";
        db.execSQL(createTableTeam);
    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    public String loadHandler() {

        String result = "";

        String query = "Select * FROM " + TABLE_TEAM;

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
        values.put(JUMLAH_PASSING_TEAM, teamBola.getPassingTeam());
        values.put(JUMLAH_TACKLING_TEAM, teamBola.getTacklingTeam());
        values.put(JUMLAH_SHOOT_GOAL_TEAM, teamBola.getGoalTeam());
        values.put(JUMLAH_SHOOT_ON_TARGET_TEAM, teamBola.getShootOnTargetTeam());
        values.put(JUMLAH_SHOOT_OFF_TARGET_TEAM, teamBola.getShootOffTargetTeam());
        values.put(JUMLAH_INTERCEPT_TEAM, teamBola.getInterceptTeam());
        values.put(JUMLAH_SAVES_TEAM, teamBola.getSavesTeam());
        values.put(JUMLAH_THROWIN_TEAM, teamBola.getThrowinTeam());
        values.put(JUMLAH_FREEKICK_TEAM, teamBola.getFreekickTeam());
        values.put(JUMLAH_PINALTY_TEAM, teamBola.getPinaltyTeam());
        values.put(JUMLAH_GOALKICK_TEAM, teamBola.getGoalkickTeam());
        values.put(JUMLAH_CORNERKICK_TEAM, teamBola.getCornerkickTeam());
        values.put(COLUMN_JUMLAH_ANGGOTA_TEAM, teamBola.getJumlahAnggotaTeam());
        values.put(JUMLAH_YELLOW_CARD_TEAM, teamBola.getYellowcardTeam());
        values.put(JUMLAH_RED_CARD_TEAM, teamBola.getRedcardTeam());
        values.put(STATUS_TEAM, teamBola.getStatusTeam());
        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_TEAM, null, values);
        Log.d("Data nama team", teamBola.getNamaTeam());
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
