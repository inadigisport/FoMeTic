package com.example.fometic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class PertandinganDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "pertandingandb";
    public static final String TABLE_PERTANDINGAN = "tablePertandingan";
    public static final String ID_PERTANDINGAN = "idPertandingan";
    private static final String ID_TEAMA = "idteama";
    private static final String ID_TEAMB = "idteamb";
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
    public static final String JUMLAH_YELLOW_CARD_TEAM_A = "yellowCardTeamA";
    public static final String JUMLAH_RED_CARD_TEAM_A = "redCardTeamA";
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
    public static final String JUMLAH_YELLOW_CARD_TEAM_B = "yellowCardTeamB";
    public static final String JUMLAH_RED_CARD_TEAM_B = "redCardTeamB";
    public static final String BABAK = "babak";
    public static final String POSESSION_TEAMA = "posessionteamA";
    public static final String POSESSION_TEAMB = "posessionteamB";
    public static final String TANGGAL_PERTANDINGAN = "tanggalpertandingan";
    public static final String EVENT = "event";
    public static final String VENUE = "venue";
    public static final String OFFSIDE_TEAM_A = "offsideteamA";
    public static final String OFFSIDE_TEAM_B = "offsideteamB";
    public static final String FOUL_TEAM_A = "foulteamA";
    public static final String FOUL_TEAM_B = "foulteamB";
    public static final String TIME_MATCH = "timematch";

    public PertandinganDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableTeam = "CREATE TABLE " + TABLE_PERTANDINGAN + " (" + ID_PERTANDINGAN + " INTEGER, " + COLUMN_NAMA_TEAM_A + " STRING, " + COLUMN_FORMASI_TEAM_A + " STRING, " + JUMLAH_PASSING_TEAM_A + " INT, " + JUMLAH_TACKLING_TEAM_A + " INT, " + JUMLAH_SHOOT_GOAL_TEAM_A + " INT, " + JUMLAH_SHOOT_ON_TARGET_TEAM_A + " INT, " + JUMLAH_SHOOT_OFF_TARGET_TEAM_A + " INT, " + JUMLAH_INTERCEPT_TEAM_A + " INT, " + JUMLAH_SAVES_TEAM_A + " INT," + JUMLAH_THROWIN_TEAM_A + " INT, " + JUMLAH_FREEKICK_TEAM_A + " INT, " + JUMLAH_PINALTY_TEAM_A + " INT, " + JUMLAH_GOALKICK_TEAM_A + " INT, " + JUMLAH_CORNERKICK_TEAM_A + " INT, " + JUMLAH_RED_CARD_TEAM_A + " INT, " + JUMLAH_YELLOW_CARD_TEAM_A + " INT, " + COLUMN_NAMA_TEAM_B + " STRING, " + COLUMN_FORMASI_TEAM_B + " STRING, " + JUMLAH_PASSING_TEAM_B + " INT, " + JUMLAH_TACKLING_TEAM_B + " INT, " + JUMLAH_SHOOT_GOAL_TEAM_B + " INT, " + JUMLAH_SHOOT_ON_TARGET_TEAM_B + " INT, " + JUMLAH_SHOOT_OFF_TARGET_TEAM_B + " INT, " + JUMLAH_INTERCEPT_TEAM_B + " INT, " + JUMLAH_SAVES_TEAM_B + " INT," + JUMLAH_THROWIN_TEAM_B + " INT, " + JUMLAH_FREEKICK_TEAM_B + " INT, " + JUMLAH_PINALTY_TEAM_B + " INT, " + JUMLAH_GOALKICK_TEAM_B + " INT, " + JUMLAH_CORNERKICK_TEAM_B + " INT, " + JUMLAH_RED_CARD_TEAM_B + " INT, " + JUMLAH_YELLOW_CARD_TEAM_B + " INT, " + BABAK + " INT, " + ID_TEAMA + " INT, " + ID_TEAMB + " INT, " + POSESSION_TEAMA + " INT, " + POSESSION_TEAMB + " INT, " + TANGGAL_PERTANDINGAN + " STRING, " + EVENT + " STRING, " + VENUE + " STRING, " + OFFSIDE_TEAM_A + " INT, " + OFFSIDE_TEAM_B + " INT, " + FOUL_TEAM_A + " INT, " + FOUL_TEAM_B + " INT, " + TIME_MATCH + " INT)";
        db.execSQL(createTableTeam);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public ArrayList<HashMap<String, String>> loaddatapertandinganreport(String teama, String teamb) {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> Listpertandingan = new ArrayList<>();
        String query = "Select * FROM " + TABLE_PERTANDINGAN + " WHERE (" + COLUMN_NAMA_TEAM_A + "='" + teama + "' AND  " + COLUMN_NAMA_TEAM_B + "='" + teamb + "') OR (" + COLUMN_NAMA_TEAM_A + "='" + teamb + "' AND  " + COLUMN_NAMA_TEAM_B + "='" + teama + "')";
        Cursor datateam = loadHandler(query);
        if (datateam.moveToFirst()) {
            while (!datateam.isAfterLast()) {
                HashMap<String, String> user = new HashMap<>();
                user.put("idpertandingan", datateam.getString(33) + datateam.getString(0));
                user.put("timtandingskor", datateam.getString(1) + " " + datateam.getString(5) + " - " + datateam.getString(21) + " " + datateam.getString(17));
                user.put("babak", "Babak " + datateam.getString(33));
                user.put("tanggal", datateam.getString(38));
                Listpertandingan.add(user);
                datateam.moveToNext();
            }

        } else {
            Log.d("Tidak ada data ", query);
        }
        return Listpertandingan;
    }

    public Cursor loaddatapertandingan() {
        String query = "Select * FROM " + TABLE_PERTANDINGAN;
        return loadHandler(query);
    }

    public Cursor loaddatapertandinganshow(int id, int babak) {
        String query = "Select * FROM " + TABLE_PERTANDINGAN + " WHERE " + ID_PERTANDINGAN + "=" + id + " AND  " + BABAK + "=" + babak;
        return loadHandler(query);
    }

    public HashMap<String, String> loaddatafullmatch(int id, int babak) {
        //ArrayList<HashMap<String, String>> Listpertandingan = new ArrayList<>();
        HashMap<String, String> user = new HashMap<>();
        if (babak == 2) {
            Cursor datababak2 = loaddatapertandinganshow(id, babak);
            datababak2.moveToFirst();
            Cursor datababak1 = loaddatapertandinganshow(id, babak - 1);
            datababak1.moveToFirst();
            if (datababak1.getString(1) == datababak2.getString(1)) {
                user.put("namateama", datababak2.getString(1));
                user.put("namateamb", datababak2.getString(17));
                user.put("venue", datababak2.getString(40));
                user.put("event", datababak2.getString(39));
                user.put("formasiteama", datababak2.getString(2));
                user.put("formasiteamb", datababak2.getString(18));
                user.put("tanggal", datababak2.getString(38));
                user.put("goalteama", String.valueOf(datababak2.getInt(5) + datababak1.getInt(5)));
                user.put("goalteamb", String.valueOf(datababak2.getInt(21) + datababak1.getInt(21)));
                user.put("passingteama", String.valueOf(datababak2.getInt(3) + datababak1.getInt(3)));
                user.put("passingteamb", String.valueOf(datababak2.getInt(19) + datababak1.getInt(19)));
                user.put("tacklingteama", String.valueOf(datababak2.getInt(4) + datababak1.getInt(4)));
                user.put("tacklingteamb", String.valueOf(datababak2.getInt(20) + datababak1.getInt(20)));
                user.put("interceptteama", String.valueOf(datababak2.getInt(8) + datababak1.getInt(8)));
                user.put("interceptteamb", String.valueOf(datababak2.getInt(24) + datababak1.getInt(24)));
                user.put("savesteama", String.valueOf(datababak2.getInt(9) + datababak1.getInt(9)));
                user.put("savesteamb", String.valueOf(datababak2.getInt(25) + datababak1.getInt(25)));
                user.put("throwinteama", String.valueOf(datababak2.getInt(10) + datababak1.getInt(10)));
                user.put("throwinteamb", String.valueOf(datababak2.getInt(26) + datababak1.getInt(26)));
                user.put("cornerkickteama", String.valueOf(datababak2.getInt(14) + datababak1.getInt(14)));
                user.put("cornerkickteamb", String.valueOf(datababak2.getInt(30) + datababak1.getInt(30)));
                user.put("ballposessionteama", String.valueOf(((datababak2.getInt(36) * datababak2.getInt(45)) + (datababak1.getInt(36) * datababak1.getInt(45)))/  (datababak2.getInt(45) + datababak1.getInt(45))*100));
                Log.d("ballposessionteama",String.valueOf(datababak2.getInt(36) * datababak2.getInt(45))+"+"+(datababak1.getInt(36) * datababak1.getInt(45))+"/"+(datababak2.getInt(45) + datababak1.getInt(45))*100);
                user.put("ballposessionteamb", String.valueOf(((datababak2.getInt(37) * datababak2.getInt(45)) + (datababak1.getInt(37) * datababak1.getInt(45))) / (datababak2.getInt(45) + datababak1.getInt(45))*100));
                Log.d("ballposessionteamb",String.valueOf(datababak2.getInt(37) * datababak2.getInt(45))+"+"+(datababak1.getInt(37) * datababak1.getInt(45))+"/"+(datababak2.getInt(45) + datababak1.getInt(45))*100);
                user.put("foulteama", String.valueOf(datababak2.getInt(43) + datababak1.getInt(43)));
                user.put("foulteamb", String.valueOf(datababak2.getInt(44) + datababak1.getInt(44)));
                user.put("offsideteama", String.valueOf(datababak2.getInt(41) + datababak1.getInt(41)));
                user.put("offsideteamb", String.valueOf(datababak2.getInt(42) + datababak1.getInt(42)));
                user.put("shotontargetteama", String.valueOf(datababak2.getInt(6) + datababak1.getInt(6)));
                user.put("shotontargetteamb", String.valueOf(datababak2.getInt(22) + datababak1.getInt(22)));
                user.put("shotofftargetteama", String.valueOf(datababak2.getInt(7) + datababak1.getInt(7)));
                user.put("shotofftargetteamb", String.valueOf(datababak2.getInt(23) + datababak1.getInt(23)));
                user.put("yellowcardteama", String.valueOf(datababak2.getInt(16) + datababak1.getInt(16)));
                user.put("yellowcardteamb", String.valueOf(datababak2.getInt(32) + datababak1.getInt(32)));
                user.put("redcardteama", String.valueOf(datababak2.getInt(17) + datababak1.getInt(17)));
                user.put("redcardteamb", String.valueOf(datababak2.getInt(33) + datababak1.getInt(33)));
                //Listpertandingan.add(user);
            } else {
                user.put("namateama", datababak2.getString(1));
                user.put("namateamb", datababak2.getString(17));
                user.put("venue", datababak2.getString(40));
                user.put("event", datababak2.getString(39));
                user.put("formasiteama", datababak2.getString(2));
                user.put("formasiteamb", datababak2.getString(18));
                user.put("tanggal", datababak2.getString(38));
                user.put("goalteama", String.valueOf(datababak2.getInt(5) + datababak1.getInt(21)));
                user.put("goalteamb", String.valueOf(datababak2.getInt(21) + datababak1.getInt(5)));
                user.put("passingteama", String.valueOf(datababak2.getInt(3) + datababak1.getInt(19)));
                user.put("passingteamb", String.valueOf(datababak2.getInt(19) + datababak1.getInt(3)));
                user.put("tacklingteama", String.valueOf(datababak2.getInt(4) + datababak1.getInt(20)));
                user.put("tacklingteamb", String.valueOf(datababak2.getInt(20) + datababak1.getInt(4)));
                user.put("interceptteama", String.valueOf(datababak2.getInt(8) + datababak1.getInt(24)));
                user.put("interceptteamb", String.valueOf(datababak2.getInt(24) + datababak1.getInt(8)));
                user.put("savesteama", String.valueOf(datababak2.getInt(9) + datababak1.getInt(25)));
                user.put("savesteamb", String.valueOf(datababak2.getInt(25) + datababak1.getInt(9)));
                user.put("throwinteama", String.valueOf(datababak2.getInt(10) + datababak1.getInt(26)));
                user.put("throwinteamb", String.valueOf(datababak2.getInt(26) + datababak1.getInt(10)));
                user.put("cornerkickteama", String.valueOf(datababak2.getInt(14) + datababak1.getInt(30)));
                user.put("cornerkickteamb", String.valueOf(datababak2.getInt(30) + datababak1.getInt(14)));
                user.put("ballposessionteama", String.valueOf((Double)((datababak2.getDouble(36) * datababak2.getDouble(45)) + (datababak1.getDouble(37) * datababak1.getDouble(45)))/(datababak2.getDouble(45) + datababak1.getDouble(45))));
                //Log.d("ballposessionteama",String.valueOf(datababak2.getInt(36) * datababak2.getInt(45))+"+"+(datababak1.getInt(37) * datababak1.getInt(45))+"/"+(datababak2.getInt(45) + datababak1.getInt(45))*100);
                user.put("ballposessionteamb", String.valueOf((Double)((datababak2.getDouble(37) * datababak2.getDouble(45)) + (datababak1.getDouble(36)* datababak1.getDouble(45)))/(datababak2.getDouble(45) + datababak1.getDouble(45))));
                //Log.d("ballposessionteamb",String.valueOf(datababak2.getDouble(37) * datababak2.getInt(45))+"+"+(datababak1.getInt(36) * datababak1.getInt(45))+"/"+(datababak2.getInt(45) + datababak1.getInt(45))*100);
                Log.d("tes divide",String.valueOf((Double)2525.0/7000*100));
                user.put("foulteama", String.valueOf(datababak2.getInt(43) + datababak1.getInt(44)));
                user.put("foulteamb", String.valueOf(datababak2.getInt(44) + datababak1.getInt(43)));
                user.put("offsideteama", String.valueOf(datababak2.getInt(41) + datababak1.getInt(42)));
                user.put("offsideteamb", String.valueOf(datababak2.getInt(42) + datababak1.getInt(41)));
                user.put("shotontargetteama", String.valueOf(datababak2.getInt(6) + datababak1.getInt(22)));
                user.put("shotontargetteamb", String.valueOf(datababak2.getInt(22) + datababak1.getInt(6)));
                user.put("shotofftargetteama", String.valueOf(datababak2.getInt(7) + datababak1.getInt(23)));
                user.put("shotofftargetteamb", String.valueOf(datababak2.getInt(23) + datababak1.getInt(7)));
                user.put("yellowcardteama", String.valueOf(datababak2.getInt(16) + datababak1.getInt(32)));
                user.put("yellowcardteamb", String.valueOf(datababak2.getInt(32) + datababak1.getInt(16)));
                user.put("redcardteama", String.valueOf(datababak2.getInt(15) + datababak1.getInt(31)));
                user.put("redcardteamb", String.valueOf(datababak2.getInt(31) + datababak1.getInt(15)));
            }
        } else if (babak == 4) {
            Cursor datababak4 = loaddatapertandinganshow(id, babak);
            Cursor datababak3 = loaddatapertandinganshow(id, babak - 1);
            Cursor datababak2 = loaddatapertandinganshow(id, babak - 2);
            Cursor datababak1 = loaddatapertandinganshow(id, babak - 3);
            datababak1.moveToFirst();
            datababak2.moveToFirst();
            datababak3.moveToFirst();
            datababak4.moveToFirst();
            if (datababak1.getString(1) == datababak2.getString(1) && datababak3.getString(1) == datababak4.getString(1) && datababak2.getString(1) == datababak3.getString(1)) {
                user.put("namateama", datababak2.getString(1));
                user.put("namateamb", datababak2.getString(17));
                user.put("venue", datababak2.getString(40));
                user.put("event", datababak2.getString(39));
                user.put("formasiteama", datababak2.getString(2));
                user.put("formasiteamb", datababak2.getString(18));
                user.put("tanggal", datababak2.getString(38));
                user.put("goalteama", String.valueOf(datababak2.getInt(5) + datababak1.getInt(5) + datababak3.getInt(5) + datababak4.getInt(5)));
                user.put("goalteamb", String.valueOf(datababak2.getInt(21) + datababak1.getInt(21) + datababak3.getInt(21) + datababak4.getInt(21)));
                user.put("passingteama", String.valueOf(datababak2.getInt(3) + datababak1.getInt(3) + datababak3.getInt(3) + datababak4.getInt(3)));
                user.put("passingteamb", String.valueOf(datababak2.getInt(19) + datababak1.getInt(19) + datababak3.getInt(19) + datababak4.getInt(19)));
                user.put("tacklingteama", String.valueOf(datababak2.getInt(4) + datababak1.getInt(4) + datababak3.getInt(4) + datababak4.getInt(4)));
                user.put("tacklingteamb", String.valueOf(datababak2.getInt(20) + datababak1.getInt(20) + datababak3.getInt(20) + datababak4.getInt(20)));
                user.put("interceptteama", String.valueOf(datababak2.getInt(8) + datababak1.getInt(8) + datababak3.getInt(8) + datababak4.getInt(8)));
                user.put("interceptteamb", String.valueOf(datababak2.getInt(24) + datababak1.getInt(24) + datababak3.getInt(24) + datababak4.getInt(24)));
                user.put("savesteama", String.valueOf(datababak2.getInt(9) + datababak1.getInt(9) + datababak3.getInt(9) + datababak4.getInt(9)));
                user.put("savesteamb", String.valueOf(datababak2.getInt(25) + datababak1.getInt(25) + datababak3.getInt(25) + datababak4.getInt(25)));
                user.put("throwinteama", String.valueOf(datababak2.getInt(10) + datababak1.getInt(10) + datababak3.getInt(10) + datababak4.getInt(10)));
                user.put("throwinteamb", String.valueOf(datababak2.getInt(26) + datababak1.getInt(26) + datababak3.getInt(26) + datababak4.getInt(26)));
                user.put("cornerkickteama", String.valueOf(datababak2.getInt(14) + datababak1.getInt(14) + datababak3.getInt(14) + datababak4.getInt(14)));
                user.put("cornerkickteamb", String.valueOf(datababak2.getInt(30) + datababak1.getInt(30) + datababak3.getInt(30) + datababak4.getInt(30)));
                user.put("ballposessionteama", String.valueOf(((datababak2.getInt(36) * datababak2.getInt(45)) + (datababak1.getInt(36) * datababak1.getInt(45)) + (datababak3.getInt(36) * datababak3.getInt(45)) + (datababak4.getInt(36) * datababak4.getInt(45))) / (datababak2.getInt(45) + datababak1.getInt(45) + datababak3.getInt(45) + datababak4.getInt(45))));
                user.put("ballposessionteamb", String.valueOf(((datababak2.getInt(37) * datababak2.getInt(45)) + (datababak1.getInt(37) * datababak1.getInt(45)) + (datababak3.getInt(37) * datababak3.getInt(45)) + (datababak4.getInt(37) * datababak4.getInt(45))) / (datababak2.getInt(45) + datababak1.getInt(45) + datababak3.getInt(45) + datababak4.getInt(45))));
                user.put("foulteama", String.valueOf(datababak2.getInt(43) + datababak1.getInt(43) + datababak3.getInt(43) + datababak4.getInt(43)));
                user.put("foulteamb", String.valueOf(datababak2.getInt(44) + datababak1.getInt(44) + datababak3.getInt(44) + datababak4.getInt(44)));
                user.put("offsideteama", String.valueOf(datababak2.getInt(41) + datababak1.getInt(41) + datababak3.getInt(41) + datababak4.getInt(41)));
                user.put("offsideteamb", String.valueOf(datababak2.getInt(42) + datababak1.getInt(42) + datababak3.getInt(42) + datababak4.getInt(42)));
                user.put("shotontargetteama", String.valueOf(datababak2.getInt(6) + datababak1.getInt(6) + datababak3.getInt(6) + datababak4.getInt(6)));
                user.put("shotontargetteamb", String.valueOf(datababak2.getInt(22) + datababak1.getInt(22) + datababak3.getInt(22) + datababak4.getInt(22)));
                user.put("shotofftargetteama", String.valueOf(datababak2.getInt(7) + datababak1.getInt(7) + datababak3.getInt(7) + datababak4.getInt(7)));
                user.put("shotofftargetteamb", String.valueOf(datababak2.getInt(23) + datababak1.getInt(23) + datababak3.getInt(23) + datababak4.getInt(23)));
                user.put("yellowcardteama", String.valueOf(datababak2.getInt(16) + datababak1.getInt(16) + datababak3.getInt(16) + datababak4.getInt(16)));
                user.put("yellowcardteamb", String.valueOf(datababak2.getInt(32) + datababak1.getInt(32) + datababak3.getInt(32) + datababak4.getInt(32)));
                user.put("redcardteama", String.valueOf(datababak2.getInt(17) + datababak1.getInt(17) + datababak3.getInt(17) + datababak4.getInt(17)));
                user.put("redcardteamb", String.valueOf(datababak2.getInt(33) + datababak1.getInt(33) + datababak3.getInt(33) + datababak4.getInt(33)));
            }else if(datababak1.getString(1) == datababak3.getString(1) && datababak2.getString(1) == datababak4.getString(1)){
                user.put("namateama", datababak2.getString(1));
                user.put("namateamb", datababak2.getString(17));
                user.put("venue", datababak2.getString(40));
                user.put("event", datababak2.getString(39));
                user.put("formasiteama", datababak2.getString(2));
                user.put("formasiteamb", datababak2.getString(18));
                user.put("tanggal", datababak2.getString(38));
                user.put("goalteama", String.valueOf(datababak2.getInt(5) + datababak1.getInt(21) + datababak3.getInt(21) + datababak4.getInt(5)));
                user.put("goalteamb", String.valueOf(datababak2.getInt(21) + datababak1.getInt(5) + datababak3.getInt(5) + datababak4.getInt(21)));
                user.put("passingteama", String.valueOf(datababak2.getInt(3) + datababak1.getInt(19) + datababak3.getInt(19) + datababak4.getInt(3)));
                user.put("passingteamb", String.valueOf(datababak2.getInt(19) + datababak1.getInt(3) + datababak3.getInt(3) + datababak4.getInt(19)));
                user.put("tacklingteama", String.valueOf(datababak2.getInt(4) + datababak1.getInt(20) + datababak3.getInt(20) + datababak4.getInt(4)));
                user.put("tacklingteamb", String.valueOf(datababak2.getInt(20) + datababak1.getInt(4) + datababak3.getInt(4) + datababak4.getInt(20)));
                user.put("interceptteama", String.valueOf(datababak2.getInt(8) + datababak1.getInt(24) + datababak3.getInt(24) + datababak4.getInt(8)));
                user.put("interceptteamb", String.valueOf(datababak2.getInt(24) + datababak1.getInt(8) + datababak3.getInt(8) + datababak4.getInt(24)));
                user.put("savesteama", String.valueOf(datababak2.getInt(9) + datababak1.getInt(25) + datababak3.getInt(25) + datababak4.getInt(9)));
                user.put("savesteamb", String.valueOf(datababak2.getInt(25) + datababak1.getInt(9) + datababak3.getInt(9) + datababak4.getInt(25)));
                user.put("throwinteama", String.valueOf(datababak2.getInt(10) + datababak1.getInt(26) + datababak3.getInt(26) + datababak4.getInt(10)));
                user.put("throwinteamb", String.valueOf(datababak2.getInt(26) + datababak1.getInt(10) + datababak3.getInt(10) + datababak4.getInt(26)));
                user.put("cornerkickteama", String.valueOf(datababak2.getInt(14) + datababak1.getInt(30) + datababak3.getInt(30) + datababak4.getInt(14)));
                user.put("cornerkickteamb", String.valueOf(datababak2.getInt(30) + datababak1.getInt(14) + datababak3.getInt(14) + datababak4.getInt(30)));
                user.put("ballposessionteama", String.valueOf((Double)((datababak2.getDouble(36) * datababak2.getInt(45)) + (datababak1.getDouble(37) * datababak1.getInt(45)) + (datababak3.getDouble(37) * datababak3.getInt(45)) + (datababak4.getDouble(36) * datababak4.getInt(45))) / (datababak2.getInt(45) + datababak1.getInt(45) + datababak3.getInt(45) + datababak4.getInt(45))));
                user.put("ballposessionteamb", String.valueOf((Double)((datababak2.getDouble(37) * datababak2.getInt(45)) + (datababak1.getDouble(36) * datababak1.getInt(45)) + (datababak3.getDouble(36) * datababak3.getInt(45)) + (datababak4.getDouble(37) * datababak4.getInt(45)))/ (datababak2.getInt(45) + datababak1.getInt(45) + datababak3.getInt(45) + datababak4.getInt(45))));
                user.put("foulteama", String.valueOf(datababak2.getInt(43) + datababak1.getInt(44) + datababak3.getInt(44) + datababak4.getInt(43)));
                user.put("foulteamb", String.valueOf(datababak2.getInt(44) + datababak1.getInt(43) + datababak3.getInt(43) + datababak4.getInt(44)));
                user.put("offsideteama", String.valueOf(datababak2.getInt(41) + datababak1.getInt(42) + datababak3.getInt(42) + datababak4.getInt(41)));
                user.put("offsideteamb", String.valueOf(datababak2.getInt(42) + datababak1.getInt(41) + datababak3.getInt(41) + datababak4.getInt(42)));
                user.put("shotontargetteama", String.valueOf(datababak2.getInt(6) + datababak1.getInt(22) + datababak3.getInt(22) + datababak4.getInt(6)));
                user.put("shotontargetteamb", String.valueOf(datababak2.getInt(22) + datababak1.getInt(6) + datababak3.getInt(6) + datababak4.getInt(22)));
                user.put("shotofftargetteama", String.valueOf(datababak2.getInt(7) + datababak1.getInt(23) + datababak3.getInt(23) + datababak4.getInt(7)));
                user.put("shotofftargetteamb", String.valueOf(datababak2.getInt(23) + datababak1.getInt(7) + datababak3.getInt(7) + datababak4.getInt(23)));
                user.put("yellowcardteama", String.valueOf(datababak2.getInt(16) + datababak1.getInt(32) + datababak3.getInt(32) + datababak4.getInt(16)));
                user.put("yellowcardteamb", String.valueOf(datababak2.getInt(32) + datababak1.getInt(16) + datababak3.getInt(16) + datababak4.getInt(32)));
                user.put("redcardteama", String.valueOf(datababak2.getInt(15) + datababak1.getInt(31) + datababak3.getInt(31) + datababak4.getInt(15)));
                user.put("redcardteamb", String.valueOf(datababak2.getInt(31) + datababak1.getInt(15) + datababak3.getInt(15) + datababak4.getInt(31)));
            }else if(datababak1.getString(1) == datababak4.getString(1) && datababak2.getString(1) == datababak3.getString(1)){
                user.put("namateama", datababak2.getString(1));
                user.put("namateamb", datababak2.getString(17));
                user.put("venue", datababak2.getString(40));
                user.put("event", datababak2.getString(39));
                user.put("formasiteama", datababak2.getString(2));
                user.put("formasiteamb", datababak2.getString(18));
                user.put("tanggal", datababak2.getString(38));
                user.put("goalteama", String.valueOf(datababak2.getInt(21) + datababak1.getInt(5) + datababak3.getInt(21) + datababak4.getInt(5)));
                user.put("goalteamb", String.valueOf(datababak2.getInt(5) + datababak1.getInt(21) + datababak3.getInt(5) + datababak4.getInt(21)));
                user.put("passingteama", String.valueOf(datababak2.getInt(19) + datababak1.getInt(3) + datababak3.getInt(19) + datababak4.getInt(3)));
                user.put("passingteamb", String.valueOf(datababak2.getInt(3) + datababak1.getInt(19) + datababak3.getInt(3) + datababak4.getInt(19)));
                user.put("tacklingteama", String.valueOf(datababak2.getInt(20) + datababak1.getInt(4) + datababak3.getInt(20) + datababak4.getInt(4)));
                user.put("tacklingteamb", String.valueOf(datababak2.getInt(4) + datababak1.getInt(20) + datababak3.getInt(4) + datababak4.getInt(20)));
                user.put("interceptteama", String.valueOf(datababak2.getInt(24) + datababak1.getInt(8) + datababak3.getInt(24) + datababak4.getInt(8)));
                user.put("interceptteamb", String.valueOf(datababak2.getInt(8) + datababak1.getInt(24) + datababak3.getInt(8) + datababak4.getInt(24)));
                user.put("savesteama", String.valueOf(datababak2.getInt(25) + datababak1.getInt(9) + datababak3.getInt(25) + datababak4.getInt(9)));
                user.put("savesteamb", String.valueOf(datababak2.getInt(9) + datababak1.getInt(25) + datababak3.getInt(9) + datababak4.getInt(25)));
                user.put("throwinteama", String.valueOf(datababak2.getInt(26) + datababak1.getInt(10) + datababak3.getInt(26) + datababak4.getInt(10)));
                user.put("throwinteamb", String.valueOf(datababak2.getInt(10) + datababak1.getInt(26) + datababak3.getInt(10) + datababak4.getInt(26)));
                user.put("cornerkickteama", String.valueOf(datababak2.getInt(30) + datababak1.getInt(14) + datababak3.getInt(30) + datababak4.getInt(14)));
                user.put("cornerkickteamb", String.valueOf(datababak2.getInt(14) + datababak1.getInt(30) + datababak3.getInt(14) + datababak4.getInt(30)));
                user.put("ballposessionteama", String.valueOf((Double)((datababak2.getDouble(37) * datababak2.getInt(45)) + (datababak1.getDouble(36) * datababak1.getInt(45)) + (datababak3.getDouble(37) * datababak3.getInt(45)) + (datababak4.getDouble(36) * datababak4.getInt(45))) / (datababak2.getInt(45) + datababak1.getInt(45) + datababak3.getInt(45) + datababak4.getInt(45))));
                user.put("ballposessionteamb", String.valueOf((Double)((datababak2.getDouble(36) * datababak2.getInt(45)) + (datababak1.getDouble(37) * datababak1.getInt(45)) + (datababak3.getDouble(36) * datababak3.getInt(45)) + (datababak4.getDouble(37) * datababak4.getInt(45)))/ (datababak2.getInt(45) + datababak1.getInt(45) + datababak3.getInt(45) + datababak4.getInt(45))));
                user.put("foulteama", String.valueOf(datababak2.getInt(44) + datababak1.getInt(43) + datababak3.getInt(44) + datababak4.getInt(43)));
                user.put("foulteamb", String.valueOf(datababak2.getInt(43) + datababak1.getInt(44) + datababak3.getInt(43) + datababak4.getInt(44)));
                user.put("offsideteama", String.valueOf(datababak2.getInt(42) + datababak1.getInt(41) + datababak3.getInt(42) + datababak4.getInt(41)));
                user.put("offsideteamb", String.valueOf(datababak2.getInt(41) + datababak1.getInt(42) + datababak3.getInt(41) + datababak4.getInt(42)));
                user.put("shotontargetteama", String.valueOf(datababak2.getInt(22) + datababak1.getInt(6) + datababak3.getInt(22) + datababak4.getInt(6)));
                user.put("shotontargetteamb", String.valueOf(datababak2.getInt(6) + datababak1.getInt(22) + datababak3.getInt(6) + datababak4.getInt(22)));
                user.put("shotofftargetteama", String.valueOf(datababak2.getInt(23) + datababak1.getInt(7) + datababak3.getInt(23) + datababak4.getInt(7)));
                user.put("shotofftargetteamb", String.valueOf(datababak2.getInt(7) + datababak1.getInt(23) + datababak3.getInt(7) + datababak4.getInt(23)));
                user.put("yellowcardteama", String.valueOf(datababak2.getInt(32) + datababak1.getInt(16) + datababak3.getInt(32) + datababak4.getInt(16)));
                user.put("yellowcardteamb", String.valueOf(datababak2.getInt(16) + datababak1.getInt(32) + datababak3.getInt(16) + datababak4.getInt(32)));
                user.put("redcardteama", String.valueOf(datababak2.getInt(31) + datababak1.getInt(15) + datababak3.getInt(31) + datababak4.getInt(15)));
                user.put("redcardteamb", String.valueOf(datababak2.getInt(15) + datababak1.getInt(31) + datababak3.getInt(15) + datababak4.getInt(31)));
            }
        }
        return user;
    }

    public Cursor loadHandler(String query) {

        String result = "";

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

            int yellowcard_team_a = cursor.getInt(16);

            int redcard_team_a = cursor.getInt(15);

            String nama_team_b = cursor.getString(17);

            String formasi_team_b = cursor.getString(18);

            int passing_team_b = cursor.getInt(19);

            int tackling_team_b = cursor.getInt(20);

            int goal_team_b = cursor.getInt(21);

            int shoot_ongoal_team_b = cursor.getInt(22);

            int shoot_offgoal_team_b = cursor.getInt(23);

            int intercept_team_b = cursor.getInt(24);

            int saves_team_b = cursor.getInt(25);

            int throwin_team_b = cursor.getInt(26);

            int freekick_team_b = cursor.getInt(27);

            int pinalty_team_b = cursor.getInt(28);

            int goalkick_team_b = cursor.getInt(29);

            int cornerkick_team_b = cursor.getInt(30);

            int yellowcard_team_b = cursor.getInt(32);

            int redcard_team_b = cursor.getInt(31);

            int babak = cursor.getInt(33);

            int idteama = cursor.getInt(34);

            int idteamb = cursor.getInt(35);

            String posessionteama = cursor.getString(36);

            String posessionteamb = cursor.getString(37);

            String waktupertandingan = cursor.getString(38);

            String event = cursor.getString(39);

            String venue = cursor.getString(40);

            int offsideteama = cursor.getInt(41);

            int offsideteamb = cursor.getInt(42);

            int foulteama = cursor.getInt(43);

            int foulteamb = cursor.getInt(44);

            int timematch = cursor.getInt(45);

            result += String.valueOf(id_pertandingan) + " " + nama_team_a + " " + goal_team_a + " - " + goal_team_b + " " + nama_team_b +

                    System.getProperty("line.separator");

        }

        Log.d("Isi Database", result);

        return cursor;

    }


    public void addHandler(Pertandingan pertandingan) {
        ContentValues values = new ContentValues();
        values.put(ID_PERTANDINGAN, pertandingan.getIdPertandingan()); //done
        values.put(COLUMN_NAMA_TEAM_A, pertandingan.getNamaTeamA()); //done
        values.put(COLUMN_FORMASI_TEAM_A, pertandingan.getFormasiTeamA()); //done
        values.put(JUMLAH_PASSING_TEAM_A, pertandingan.getPassingTeamA()); //done
        values.put(JUMLAH_TACKLING_TEAM_A, pertandingan.getTacklingTeamA()); //done
        values.put(JUMLAH_SHOOT_GOAL_TEAM_A, pertandingan.getGoalTeamA()); //done
        values.put(JUMLAH_SHOOT_ON_TARGET_TEAM_A, pertandingan.getShootOnTargetTeamA()); //done
        values.put(JUMLAH_SHOOT_OFF_TARGET_TEAM_A, pertandingan.getShootOffTargetTeamA()); //done
        values.put(JUMLAH_INTERCEPT_TEAM_A, pertandingan.getInterceptTeamA()); //done
        values.put(JUMLAH_SAVES_TEAM_A, pertandingan.getSavesTeamA());//done
        values.put(JUMLAH_THROWIN_TEAM_A, pertandingan.getThrowinTeamA()); //done
        values.put(JUMLAH_FREEKICK_TEAM_A, pertandingan.getFreekickTeamA()); //done
        values.put(JUMLAH_PINALTY_TEAM_A, pertandingan.getPinaltyTeamA()); //done
        values.put(JUMLAH_GOALKICK_TEAM_A, pertandingan.getGoalkickTeamA()); //done
        values.put(JUMLAH_CORNERKICK_TEAM_A, pertandingan.getCornerkickTeamA()); //done
        values.put(JUMLAH_YELLOW_CARD_TEAM_A, pertandingan.getYellowcardTeamA()); //done
        values.put(JUMLAH_RED_CARD_TEAM_A, pertandingan.getRedcardTeamA());//done
        values.put(COLUMN_NAMA_TEAM_B, pertandingan.getNamaTeamB());//done
        values.put(COLUMN_FORMASI_TEAM_B, pertandingan.getFormasiTeamB()); //done
        values.put(JUMLAH_PASSING_TEAM_B, pertandingan.getPassingTeamB()); //done
        values.put(JUMLAH_TACKLING_TEAM_B, pertandingan.getTacklingTeamB()); //done
        values.put(JUMLAH_SHOOT_GOAL_TEAM_B, pertandingan.getGoalTeamB()); //done
        values.put(JUMLAH_SHOOT_ON_TARGET_TEAM_B, pertandingan.getShootOnTargetTeamB()); //done
        values.put(JUMLAH_SHOOT_OFF_TARGET_TEAM_B, pertandingan.getShootOffTargetTeamB()); //done
        values.put(JUMLAH_INTERCEPT_TEAM_B, pertandingan.getInterceptTeamB()); //done
        values.put(JUMLAH_SAVES_TEAM_B, pertandingan.getSavesTeamB()); //done
        values.put(JUMLAH_THROWIN_TEAM_B, pertandingan.getThrowinTeamB()); //done
        values.put(JUMLAH_FREEKICK_TEAM_B, pertandingan.getFreekickTeamB()); //done
        values.put(JUMLAH_PINALTY_TEAM_B, pertandingan.getPinaltyTeamB()); //done
        values.put(JUMLAH_GOALKICK_TEAM_B, pertandingan.getGoalkickTeamB()); //done
        values.put(JUMLAH_CORNERKICK_TEAM_B, pertandingan.getCornerkickTeamB()); //done
        values.put(JUMLAH_YELLOW_CARD_TEAM_B, pertandingan.getYellowcardTeamB()); //done
        values.put(JUMLAH_RED_CARD_TEAM_B, pertandingan.getRedcardTeamB()); //done
        values.put(BABAK, pertandingan.getBabak()); //done
        values.put(ID_TEAMA, pertandingan.getIdTeamA()); //done
        values.put(ID_TEAMB, pertandingan.getIdTeamB()); //done
        values.put(POSESSION_TEAMA, pertandingan.getPosessionTeamA());
        values.put(POSESSION_TEAMB, pertandingan.getPosessionTeamB());
        values.put(TANGGAL_PERTANDINGAN, pertandingan.getWaktupertandingan().toString());
        values.put(EVENT, pertandingan.getEvent());
        values.put(VENUE, pertandingan.getVenue());
        values.put(OFFSIDE_TEAM_A, pertandingan.getOffsideTeamA());
        values.put(OFFSIDE_TEAM_B, pertandingan.getOffsideTeamB());
        values.put(FOUL_TEAM_A, pertandingan.getFoulTeamA());
        values.put(FOUL_TEAM_B, pertandingan.getFoulTeamB());
        values.put(TIME_MATCH, pertandingan.getTimematch());
        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_PERTANDINGAN, null, values);
        Log.d("Data nama team :", pertandingan.getNamaTeamA());
        db.close();
    }


    public void export() throws IOException {
        SQLiteDatabase db= this.getReadableDatabase();
        SqliteExporter dbexport=new SqliteExporter();
        dbexport.export(db);
    }
}
