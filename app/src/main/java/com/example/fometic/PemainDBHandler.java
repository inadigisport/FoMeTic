package com.example.fometic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PemainDBHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="dbpemain";
    public static final int DATABASE_VERSION=1;
    public static final String ID_PEMAIN="idPemain";
    public static final String TABLE_PEMAIN="tablePemain";
    public static final String NAMA_PEMAIN="nama";
    public static final String POSISI_PEMAIN="posisi";
    public static final String NOMOR_PUNGGUNG_PEMAIN="nomor";
    public static final String ID_TEAM="idteam";
    public static final String NAMA_TEAM="namateam";

    public PemainDBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        String createTablePemain="CREATE TABLE "+TABLE_PEMAIN+" ("+ID_PEMAIN+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAMA_PEMAIN+" STRING, "+ID_TEAM+" INT, "+NOMOR_PUNGGUNG_PEMAIN+" INT, "+POSISI_PEMAIN+" STRING, "+NAMA_TEAM+" STRING)";
        db.execSQL(createTablePemain);
        Log.d("status create data", createTablePemain);
    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int i, int i1){}

    public void addHandler(PemainBola pemainbola, int idteam) {
        ContentValues values = new ContentValues();
        values.put(ID_TEAM, idteam);
        values.put(NAMA_PEMAIN,pemainbola.getNamaPemain());
        values.put(NOMOR_PUNGGUNG_PEMAIN,pemainbola.getNomorPunggung());
        values.put(POSISI_PEMAIN, pemainbola.getPosisi());
        values.put(NAMA_TEAM, pemainbola.getTeam());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_PEMAIN, null,values);
        db.close();
    }

    public Cursor loaddataidpemain(String nama, String namateam){
        String query="SELECT * FROM "+TABLE_PEMAIN+" WHERE "+ID_PEMAIN+"='"+nama+"' AND "+NAMA_TEAM+"='"+namateam+"'";
        Log.d(nama, namateam);
        return (loadHandler(query));
    }

    public Cursor loaddatateam(String team){
        String query="SELECT * FROM "+TABLE_PEMAIN+" WHERE "+NAMA_TEAM+"='"+team+"'";
        return (loadHandler(query));
    }

    public Cursor loaddataposisi(String posisi, String team){
        String query="SELECT * FROM "+TABLE_PEMAIN+" WHERE "+NAMA_TEAM+"='"+team+"' AND "+POSISI_PEMAIN+"='"+posisi+"'";
        return (loadHandler(query));
    }


    public Cursor loadHandler(String query){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        String result="";
        while (cursor.moveToNext()) {
            String nama_pemain=cursor.getString(0);
            int idpemain=cursor.getInt(1);
            int idteam=cursor.getInt(2);
            int nomorpunggung=cursor.getInt(3);
            String posisi_pemain=cursor.getString(4);
            String namateam=cursor.getString(5);

            result += String.valueOf(idpemain) + " " + nama_pemain + " "+ nomorpunggung+

                    System.getProperty("line.separator");
        }
        Log.d("Isi Database pemain", result);
        return cursor;
    }

}
