package com.example.fometic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PemainDBHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="pemainDB";
    public static final int DATABASE_VERSION=1;
    public static final String ID_PERTANDINGAN="idPertandingan";
    public static final String TABLE_PEMAIN="tablePemain";
    public static final String NAMA_PEMAIN="nama";
    public static final String POSISI_PEMAIN="posisi";
    public static final String NOMOR_PUNGGUNG_PEMAIN="nomor";
    public static final String NAMA_TEAM="team";
    public static final String JUMLAH_GOAL="goal";
    public static final String JUMLAH_YELLOWCARD="yellowcard";
    public static final String JUMLAH_REDCARD="redcard";

    public PemainDBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        String createTablePemain="CREATE TABLE "+TABLE_PEMAIN+" ("+NAMA_PEMAIN+" STRING, "+NOMOR_PUNGGUNG_PEMAIN+" STRING, "+POSISI_PEMAIN+" STRING, "+NAMA_TEAM+" STRING, "+JUMLAH_GOAL+" INT, "+JUMLAH_YELLOWCARD+" INT, "+JUMLAH_REDCARD+" INT, "+ID_PERTANDINGAN+" INT)";
        db.execSQL(createTablePemain);
    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int i, int i1){}

    public void addHandler(PemainBola pemainbola) {
        ContentValues values = new ContentValues();
        values.put(ID_PERTANDINGAN,pemainbola.getIdPertandingan());
        values.put(NAMA_PEMAIN,pemainbola.getNamaPemain());
        values.put(NOMOR_PUNGGUNG_PEMAIN,pemainbola.getNomorPunggung());
        values.put(NAMA_TEAM, pemainbola.getTeam());
        values.put(POSISI_PEMAIN, pemainbola.getPosisi());
        values.put(JUMLAH_GOAL, pemainbola.getGoal());
        values.put(JUMLAH_YELLOWCARD,pemainbola.getYellowcard());
        values.put(JUMLAH_REDCARD,pemainbola.getRedcard());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_PEMAIN, null,values);
        db.close();
    }


    public void loadHandler(String nama, String team){
        String result="";
        String query="SELECT * FROM "+TABLE_PEMAIN+" WHERE "+NAMA_TEAM+"="+team+" AND "+NAMA_PEMAIN+"="+nama;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String nama_pemain=cursor.getString(0);
            String nomor_punggung=cursor.getString(1);
            String posisi_pemain=cursor.getColumnName(2);
            String team_pemain=cursor.getString(3);
            int jumlah_gol=cursor.getInt(4);
            int jumlah_yellowcard=cursor.getInt(5);
            int jumlah_redcard=cursor.getInt(6);
            int idpertandingan=cursor.getInt(7);
        }
    }
}
