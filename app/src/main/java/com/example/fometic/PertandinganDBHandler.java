package com.example.fometic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PertandinganDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "footballDB.db";
    public static final String TABLE_PERTANDINGAN = "tablePertandingan";
    public static final String ID_PERTANDINGAN = "idPertandingan";
    public static final String COLUMN_ID_TEAM_A = "IDTeamA";
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
    public static final String COLUMN_ID_TEAM_B = "IDTeamB";
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

    public PertandinganDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableTeam="CREATE TABLE "+TABLE_PERTANDINGAN+" ("+ID_PERTANDINGAN+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_ID_TEAM_A+" INT, "+COLUMN_NAMA_TEAM_A+" STRING, "+COLUMN_FORMASI_TEAM_A+" STRING, "+JUMLAH_PASSING_TEAM_A+" INT, "+JUMLAH_TACKLING_TEAM_A+" INT, "+JUMLAH_SHOOT_GOAL_TEAM_A+" INT, "+JUMLAH_SHOOT_ON_TARGET_TEAM_A+" INT, "+JUMLAH_SHOOT_OFF_TARGET_TEAM_A+" INT, "+JUMLAH_INTERCEPT_TEAM_A+" INT, "+JUMLAH_SAVES_TEAM_A+" INT,"+JUMLAH_THROWIN_TEAM_A+" INT, "+JUMLAH_FREEKICK_TEAM_A+" INT, "+JUMLAH_PINALTY_TEAM_A+" INT, "+JUMLAH_GOALKICK_TEAM_A+" INT, "+JUMLAH_CORNERKICK_TEAM_A+" INT, "+COLUMN_JUMLAH_ANGGOTA_TEAM_A+" INT, "+JUMLAH_RED_CARD_TEAM_A+" INT, "+JUMLAH_YELLOW_CARD_TEAM_A+" INT, "+STATUS_TEAM_A+" STRING, "+COLUMN_ID_TEAM_B+" INT, "+COLUMN_NAMA_TEAM_A+" STRING, "+COLUMN_FORMASI_TEAM_B+" STRING, "+JUMLAH_PASSING_TEAM_B+" INT, "+JUMLAH_TACKLING_TEAM_B+" INT, "+JUMLAH_SHOOT_GOAL_TEAM_B+" INT, "+JUMLAH_SHOOT_ON_TARGET_TEAM_B+" INT, "+JUMLAH_SHOOT_OFF_TARGET_TEAM_B+" INT, "+JUMLAH_INTERCEPT_TEAM_B+" INT, "+JUMLAH_SAVES_TEAM_B+" INT,"+JUMLAH_THROWIN_TEAM_B+" INT, "+JUMLAH_FREEKICK_TEAM_B+" INT, "+JUMLAH_PINALTY_TEAM_B+" INT, "+JUMLAH_GOALKICK_TEAM_B+" INT, "+JUMLAH_CORNERKICK_TEAM_B+" INT, "+COLUMN_JUMLAH_ANGGOTA_TEAM_B+" INT, "+JUMLAH_RED_CARD_TEAM_B+" INT, "+JUMLAH_YELLOW_CARD_TEAM_B+" INT, "+STATUS_TEAM_B+" STRING)";;
        db.execSQL(createTableTeam);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
