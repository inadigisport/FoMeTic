package com.example.fometic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Date;

public class PertandinganDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "pertandingandb";
    public static final String TABLE_PERTANDINGAN = "tablePertandingan";
    public static final String ID_PERTANDINGAN = "idPertandingan";
    private static final String ID_TEAMA ="idteama";
    private static final String ID_TEAMB ="idteamb";
    public static final String COLUMN_NAMA_TEAM_A = "namaTeamA";
    public static final String COLUMN_FORMASI_TEAM_A = "formasiTeamA";
    public static final String JUMLAH_PASSING_TEAM_A = "passingTeamA";
    public static final String JUMLAH_TACKLING_TEAM_A = "tacklingTeamA";
    public static final String JUMLAH_SHOOT_GOAL_TEAM_A = "goalTeamA";
    public static final String JUMLAH_SHOOT_ON_TARGET_TEAM_A = "shootOnTargetTeamA";
    public static final String JUMLAH_SHOOT_OFF_TARGET_TEAM_A = "shootOffTargetTeamA";
    public static final String JUMLAH_INTERCEPT_TEAM_A = "interceptTeamA";
    public static final String JUMLAH_SAVES_TEAM_A = "savesTeamA";
    public static final String JUMLAH_THROWIN_TEAM_A = "throwinTeamA";
    public static final String JUMLAH_FREEKICK_TEAM_A = "freekickTeamA";
    public static final String JUMLAH_PINALTY_TEAM_A = "pinaltyTeamA";
    public static final String JUMLAH_GOALKICK_TEAM_A = "goalkickTeamA";
    public static final String JUMLAH_CORNERKICK_TEAM_A = "cornerkickTeamA";
    public static final String COLUMN_JUMLAH_ANGGOTA_TEAM_A = "jumlahAnggotaTeamA";
    public static final String JUMLAH_YELLOW_CARD_TEAM_A = "yellowCardTeamA";
    public static final String JUMLAH_RED_CARD_TEAM_A =  "redCardTeamA";
    public static final String STATUS_TEAM_A =  "statusTeamA";
    public static final String COLUMN_NAMA_TEAM_B = "namaTeamB";
    public static final String COLUMN_FORMASI_TEAM_B = "formasiTeamB";
    public static final String JUMLAH_PASSING_TEAM_B = "passingTeamB";
    public static final String JUMLAH_TACKLING_TEAM_B = "tacklingTeamB";
    public static final String JUMLAH_SHOOT_GOAL_TEAM_B = "goalTeamB";
    public static final String JUMLAH_SHOOT_ON_TARGET_TEAM_B = "shootOnTargetTeamB";
    public static final String JUMLAH_SHOOT_OFF_TARGET_TEAM_B = "shootOffTargetTeamB";
    public static final String JUMLAH_INTERCEPT_TEAM_B = "interceptTeamB";
    public static final String JUMLAH_SAVES_TEAM_B = "savesTeamB";
    public static final String JUMLAH_THROWIN_TEAM_B = "throwinTeamB";
    public static final String JUMLAH_FREEKICK_TEAM_B = "freekickTeamB";
    public static final String JUMLAH_PINALTY_TEAM_B = "pinaltyTeamB";
    public static final String JUMLAH_GOALKICK_TEAM_B = "goalkickTeamB";
    public static final String JUMLAH_CORNERKICK_TEAM_B = "cornerkickTeamB";
    public static final String COLUMN_JUMLAH_ANGGOTA_TEAM_B = "jumlahAnggotaTeamB";
    public static final String JUMLAH_YELLOW_CARD_TEAM_B = "yellowCardTeamB";
    public static final String JUMLAH_RED_CARD_TEAM_B =  "redCardTeamB";
    public static final String STATUS_TEAM_B =  "statusTeamB";
    public static final String BABAK =  "babak";
    public static final String POSESSION_TEAMA = "posessionteamA";
    public static final String POSESSION_TEAMB = "posessionteamB";
    public static final String TANGGAL_PERTANDINGAN = "tanggalpertandingan";

    public PertandinganDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableTeam="CREATE TABLE "+TABLE_PERTANDINGAN+" ("+ID_PERTANDINGAN+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_NAMA_TEAM_A+" STRING, "+COLUMN_FORMASI_TEAM_A+" STRING, "+JUMLAH_PASSING_TEAM_A+" INT, "+JUMLAH_TACKLING_TEAM_A+" INT, "+JUMLAH_SHOOT_GOAL_TEAM_A+" INT, "+JUMLAH_SHOOT_ON_TARGET_TEAM_A+" INT, "+JUMLAH_SHOOT_OFF_TARGET_TEAM_A+" INT, "+JUMLAH_INTERCEPT_TEAM_A+" INT, "+JUMLAH_SAVES_TEAM_A+" INT,"+JUMLAH_THROWIN_TEAM_A+" INT, "+JUMLAH_FREEKICK_TEAM_A+" INT, "+JUMLAH_PINALTY_TEAM_A+" INT, "+JUMLAH_GOALKICK_TEAM_A+" INT, "+JUMLAH_CORNERKICK_TEAM_A+" INT, "+COLUMN_JUMLAH_ANGGOTA_TEAM_A+" INT, "+JUMLAH_RED_CARD_TEAM_A+" INT, "+JUMLAH_YELLOW_CARD_TEAM_A+" INT, "+STATUS_TEAM_A+" STRING, "+COLUMN_NAMA_TEAM_B+" STRING, "+COLUMN_FORMASI_TEAM_B+" STRING, "+JUMLAH_PASSING_TEAM_B+" INT, "+JUMLAH_TACKLING_TEAM_B+" INT, "+JUMLAH_SHOOT_GOAL_TEAM_B+" INT, "+JUMLAH_SHOOT_ON_TARGET_TEAM_B+" INT, "+JUMLAH_SHOOT_OFF_TARGET_TEAM_B+" INT, "+JUMLAH_INTERCEPT_TEAM_B+" INT, "+JUMLAH_SAVES_TEAM_B+" INT,"+JUMLAH_THROWIN_TEAM_B+" INT, "+JUMLAH_FREEKICK_TEAM_B+" INT, "+JUMLAH_PINALTY_TEAM_B+" INT, "+JUMLAH_GOALKICK_TEAM_B+" INT, "+JUMLAH_CORNERKICK_TEAM_B+" INT, "+COLUMN_JUMLAH_ANGGOTA_TEAM_B+" INT, "+JUMLAH_RED_CARD_TEAM_B+" INT, "+JUMLAH_YELLOW_CARD_TEAM_B+" INT, "+STATUS_TEAM_B+" STRING, "+BABAK+" INT, "+ID_TEAMA+" INT, "+ID_TEAMB+" INT, "+POSESSION_TEAMA+" DOUBLE, "+POSESSION_TEAMB+ " DOUBLE, "+TANGGAL_PERTANDINGAN+ " DATE)";;
        db.execSQL(createTableTeam);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public Cursor loadHandler(String teamA, String teamB) {

        String result = "";

        String query = "Select * FROM " + TABLE_PERTANDINGAN +" WHERE "+COLUMN_NAMA_TEAM_A+ "="+teamA+ " AND "+COLUMN_NAMA_TEAM_B+"="+teamB;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {

            int id_pertandingan = cursor.getInt(0);

            String nama_team_a = cursor.getString(1);

            String formasi_team_a = cursor.getString(2);

            int passing_team_a = cursor.getInt(3);

            int tackling_team_a = cursor.getInt(4);

            int goal_team_a = cursor.getInt(5);

            int shoot_ongoal_team_a = cursor.getInt(6);

            int shoot_offgoal_team_a = cursor.getInt(7);

            int intercept_team_a = cursor.getInt(8);

            int saves_team_a = cursor.getInt(9);

            int throwin_team_a = cursor.getInt(10);

            int freekick_team_a = cursor.getInt(11);

            int pinalty_team_a = cursor.getInt(12);

            int goalkick_team_a = cursor.getInt(13);

            int cornerkick_team_a = cursor.getInt(14);

            int jumlah_squad_team_a = cursor.getInt(15);

            int yellowcard_team_a = cursor.getInt(16);

            int redcard_team_a = cursor.getInt(17);

            String status_team_a = cursor.getString(18);

            String nama_team_b = cursor.getString(19);

            String formasi_team_b = cursor.getString(20);

            int passing_team_b = cursor.getInt(21);

            int tackling_team_b = cursor.getInt(22);

            int goal_team_b = cursor.getInt(23);

            int shoot_ongoal_team_b = cursor.getInt(24);

            int shoot_offgoal_team_b = cursor.getInt(25);

            int intercept_team_b = cursor.getInt(26);

            int saves_team_b = cursor.getInt(27);

            int throwin_team_b = cursor.getInt(28);

            int freekick_team_b = cursor.getInt(29);

            int pinalty_team_b = cursor.getInt(30);

            int goalkick_team_b = cursor.getInt(31);

            int cornerkick_team_b = cursor.getInt(32);

            int jumlah_squad_team_b = cursor.getInt(33);

            int yellowcard_team_b = cursor.getInt(34);

            int redcard_team_b = cursor.getInt(35);

            String status_team_b = cursor.getString(36);

            int babak= cursor.getInt(37);

            int idteama= cursor.getInt(38);

            int idteamb= cursor.getInt(39);

            Double posessionteama= cursor.getDouble(40);

            Double posessionteamb= cursor.getDouble(41);

            String tanggal = cursor.getString(42);

            result += String.valueOf(id_pertandingan) + " " + nama_team_a + " "+ goal_team_a+" - "+goal_team_b+ " "+nama_team_b+

                    System.getProperty("line.separator");

        }

        Log.d("Isi Database", result);

        return cursor;

    }


    public void addHandler(Pertandingan pertandingan) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMA_TEAM_A, pertandingan.getNamaTeamA());
        values.put(COLUMN_FORMASI_TEAM_A, pertandingan.getFormasiTeamA());
        values.put(JUMLAH_PASSING_TEAM_A, pertandingan.getPassingTeamA());
        values.put(JUMLAH_TACKLING_TEAM_A, pertandingan.getTacklingTeamA());
        values.put(JUMLAH_SHOOT_GOAL_TEAM_A, pertandingan.getGoalTeamA());
        values.put(JUMLAH_SHOOT_ON_TARGET_TEAM_A, pertandingan.getShootOnTargetTeamA());
        values.put(JUMLAH_SHOOT_OFF_TARGET_TEAM_A, pertandingan.getShootOffTargetTeamA());
        values.put(JUMLAH_INTERCEPT_TEAM_A, pertandingan.getInterceptTeamA());
        values.put(JUMLAH_SAVES_TEAM_A, pertandingan.getSavesTeamA());
        values.put(JUMLAH_THROWIN_TEAM_A, pertandingan.getThrowinTeamA());
        values.put(JUMLAH_FREEKICK_TEAM_A, pertandingan.getFreekickTeamA());
        values.put(JUMLAH_PINALTY_TEAM_A, pertandingan.getPinaltyTeamA());
        values.put(JUMLAH_GOALKICK_TEAM_A, pertandingan.getGoalkickTeamA());
        values.put(JUMLAH_CORNERKICK_TEAM_A, pertandingan.getCornerkickTeamA());
        values.put(COLUMN_JUMLAH_ANGGOTA_TEAM_A, pertandingan.getJumlahAnggotaTeamA());
        values.put(JUMLAH_YELLOW_CARD_TEAM_A, pertandingan.getYellowcardTeamA());
        values.put(JUMLAH_RED_CARD_TEAM_A, pertandingan.getRedcardTeamA());
        values.put(STATUS_TEAM_A, pertandingan.getStatusTeamA());
        values.put(COLUMN_NAMA_TEAM_B, pertandingan.getNamaTeamB());
        values.put(COLUMN_FORMASI_TEAM_B, pertandingan.getFormasiTeamB());
        values.put(JUMLAH_PASSING_TEAM_B, pertandingan.getPassingTeamB());
        values.put(JUMLAH_TACKLING_TEAM_B, pertandingan.getTacklingTeamB());
        values.put(JUMLAH_SHOOT_GOAL_TEAM_B, pertandingan.getGoalTeamB());
        values.put(JUMLAH_SHOOT_ON_TARGET_TEAM_B, pertandingan.getShootOnTargetTeamB());
        values.put(JUMLAH_SHOOT_OFF_TARGET_TEAM_B, pertandingan.getShootOffTargetTeamB());
        values.put(JUMLAH_INTERCEPT_TEAM_B, pertandingan.getInterceptTeamB());
        values.put(JUMLAH_SAVES_TEAM_B, pertandingan.getSavesTeamB());
        values.put(JUMLAH_THROWIN_TEAM_B, pertandingan.getThrowinTeamB());
        values.put(JUMLAH_FREEKICK_TEAM_B, pertandingan.getFreekickTeamB());
        values.put(JUMLAH_PINALTY_TEAM_B, pertandingan.getPinaltyTeamB());
        values.put(JUMLAH_GOALKICK_TEAM_B, pertandingan.getGoalkickTeamB());
        values.put(JUMLAH_CORNERKICK_TEAM_B, pertandingan.getCornerkickTeamB());
        values.put(COLUMN_JUMLAH_ANGGOTA_TEAM_B, pertandingan.getJumlahAnggotaTeamB());
        values.put(JUMLAH_YELLOW_CARD_TEAM_B, pertandingan.getYellowcardTeamB());
        values.put(JUMLAH_RED_CARD_TEAM_B, pertandingan.getRedcardTeamB());
        values.put(STATUS_TEAM_B, pertandingan.getStatusTeamB());
        values.put(BABAK, pertandingan.getBabak());
        values.put(ID_TEAMA,pertandingan.getIdTeamA());
        values.put(ID_TEAMB,pertandingan.getIdTeamB());
        values.put(POSESSION_TEAMA,pertandingan.getPosessionTeamA());
        values.put(POSESSION_TEAMB,pertandingan.getPosessionTeamB());
        values.put(TANGGAL_PERTANDINGAN, pertandingan.getTanggalpertandingan().toString());
        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_PERTANDINGAN, null, values);
        Log.d("Data nama team :", pertandingan.getNamaTeamA());
        db.close();
    }
}
