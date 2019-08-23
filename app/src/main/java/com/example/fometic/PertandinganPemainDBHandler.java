package com.example.fometic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.IOException;

public class PertandinganPemainDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "pertandinganpemaindb";
    private static final String TABLE_PERTANDINGAN_PEMAIN="tablepertandinganpemain";
    private static final String ID_PERTANDINGAN= "idpertandingan";
    private static final String ID_PEMAIN="idpemain";
    private static final String JUMLAH_GOAL="jumlahgoal";
    private static final String JUMLAH_YELLOWCARD="jumlahyellowcard";
    private static final String JUMLAH_REDCARD="jumlahredcard";
    private static final String JUMLAH_SHOTONTARGET="jumlahshotontarget";
    private static final String JUMLAH_SHOTOFFTARGET="jumlahshotofftarget";
    private static final String JUMLAH_TACKLING="jumlahtackling";
    private static final String JUMLAH_INTERCEPT="jumlahintercept";
    private static final String JUMLAH_SAVES="jumlahsaves";
    private static final String BABAK="babak";

    public PertandinganPemainDBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableTeam="CREATE TABLE "+TABLE_PERTANDINGAN_PEMAIN+" ("+ID_PERTANDINGAN+" INT, "+ID_PEMAIN+" INT,"+JUMLAH_GOAL+" INT, "+JUMLAH_YELLOWCARD+" INT, "+JUMLAH_REDCARD+" INT, "+JUMLAH_SHOTONTARGET+" INT, "+JUMLAH_SHOTOFFTARGET+" INT, "+BABAK+" INT, "+JUMLAH_TACKLING+" INT, "+JUMLAH_INTERCEPT+" INT, "+JUMLAH_SAVES+" INT)";
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
        values.put(BABAK,pertandingan.getBabak());
        values.put(JUMLAH_TACKLING, pertandingan.getJumlahtackling());
        values.put(JUMLAH_INTERCEPT, pertandingan.getJumlahintercept());
        values.put(JUMLAH_SAVES, pertandingan.getJumlahsaves());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_PERTANDINGAN_PEMAIN, null, values);
        db.close();
    }

    public Cursor loadHandler(String query){
        String result = "";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            int id_pertandingan = cursor.getInt(0);
            int id_pemain = cursor.getInt(1);
            int jumlah_goal = cursor.getInt(2);
            int jumlah_yellowcard = cursor.getInt(3);
            int jumlah_redcard = cursor.getInt(4);
            int jumlah_shotontarget = cursor.getInt(5);
            int jumlah_shotofftarget = cursor.getInt(6);
            int babak=cursor.getInt(7);
            int jumlah_tackling = cursor.getInt(8);
            int jumlah_intercept = cursor.getInt(9);
            int jumlah_saves = cursor.getInt(10);
            //Log.d("Jumlah goal", Integer.toString(jumlah_goal));
            cursor.moveToNext();
        }
        return cursor;
    }

    public Cursor loaddatapertandinganpemain(int idpemain, int idpertandingan, int babak){
        String query = "Select * FROM " + TABLE_PERTANDINGAN_PEMAIN+ " WHERE "+ID_PEMAIN+" = "+idpemain+" AND "+ID_PERTANDINGAN+"="+idpertandingan+ " AND "+BABAK+"="+babak;
        return loadHandler(query);
    }

    public Cursor loaddatawithstat (int idpemain, int idpertandingan, int babak){
        String query = "Select * FROM " + TABLE_PERTANDINGAN_PEMAIN+ " WHERE "+ID_PEMAIN+"="+idpemain+" AND "+ID_PERTANDINGAN+"="+idpertandingan+" AND "+BABAK+"="+babak;
        return loadHandler(query);
    }


    public int jumlahgoal(int ID, int IDPemain, int babak){
        Log.d("Enter Jumlah Goal",IDPemain+" "+ID);
        int i=0;
        Cursor goal=loaddatapertandinganpemain(IDPemain, ID, babak);
        goal.moveToFirst();
        i = goal.getInt(2) + 1;
        Log.d("Jumlah Goal tambah",Integer.toString(i));
        return i;
    }

    public int jumlahyellow(int ID, int IDPemain, int babak){
        Log.d("Enter Jumlah Yellow",IDPemain+" "+ID);
        int i=0;
        Cursor goal=loaddatapertandinganpemain(IDPemain, ID, babak);
        goal.moveToFirst();
        Log.d("Jumlah Yellow before",Integer.toString(goal.getInt(3)));
        i = goal.getInt(3) + 1;
        Log.d("Jumlah Yellow tambah",Integer.toString(i));
        return i;

    }

    public int jumlahred(int ID, int IDPemain, int babak){
        Log.d("Enter Jumlah Red",IDPemain+" "+ID);
        int i=0;
        Cursor goal=loaddatapertandinganpemain(IDPemain, ID, babak);
        goal.moveToFirst();
        i = goal.getInt(4) + 1;
        return i;
    }

    public int jumlahintercept(int ID, int IDPemain, int babak){
        Log.d("Enter Jumlah Red",IDPemain+" "+ID);
        int i=0;
        Cursor goal=loaddatapertandinganpemain(IDPemain, ID, babak);
        goal.moveToFirst();
        i = goal.getInt(9) + 1;
        return i;
    }


    public int jumlahtackling(int ID, int IDPemain, int babak){
        Log.d("Enter Jumlah Red",IDPemain+" "+ID);
        int i=0;
        Cursor goal=loaddatapertandinganpemain(IDPemain, ID, babak);
        goal.moveToFirst();
        i = goal.getInt(8) + 1;
        return i;
    }

    public int jumlahsaves(int ID, int IDPemain, int babak){
        Log.d("Enter Jumlah Red",IDPemain+" "+ID);
        int i=0;
        Cursor goal=loaddatapertandinganpemain(IDPemain, ID, babak);
        goal.moveToFirst();
        i = goal.getInt(10) + 1;
        return i;
    }


    public int jumlahshotongoal(int ID, int IDPemain, int babak){
        Log.d("Enter Jumlah Red",IDPemain+" "+ID);
        int i=0;
        Cursor goal=loaddatapertandinganpemain(IDPemain, ID, babak);
        goal.moveToFirst();
        i = goal.getInt(5) + 1;
        return i;
    }


    public int jumlahshotoffgoal(int ID, int IDPemain, int babak){
        Log.d("Enter Jumlah Red",IDPemain+" "+ID);
        int i=0;
        Cursor goal=loaddatapertandinganpemain(IDPemain, ID, babak);
        goal.moveToFirst();
        i = goal.getInt(6) + 1;
        return i;
    }

    public boolean updategoal(int ID, int IDPemain, int babak) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues update = new ContentValues();

        update.put(JUMLAH_GOAL, jumlahgoal(ID, IDPemain, babak));


        return db.update(TABLE_PERTANDINGAN_PEMAIN, update, ID_PERTANDINGAN + "=" + ID +" AND "+ID_PEMAIN+"="+IDPemain+ " AND "+BABAK+"="+babak, null) > 0;


    }

    public boolean updateyellow(int ID, int IDPemain, int babak) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues update = new ContentValues();

        update.put(JUMLAH_YELLOWCARD, jumlahyellow(ID, IDPemain, babak));


        return db.update(TABLE_PERTANDINGAN_PEMAIN, update, ID_PERTANDINGAN + "=" + ID +" AND "+ID_PEMAIN+"="+IDPemain+ " AND "+BABAK+"="+babak, null) > 0;


    }

    public boolean updatered(int ID, int IDPemain, int babak) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues update = new ContentValues();

        update.put(JUMLAH_REDCARD, jumlahred(ID, IDPemain, babak));


        return db.update(TABLE_PERTANDINGAN_PEMAIN, update, ID_PERTANDINGAN + "=" + ID +" AND "+ID_PEMAIN+"="+IDPemain+ " AND "+BABAK+"="+babak, null) > 0;


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

    public Cursor loaddatapemain(){
        String query = "Select * FROM " + TABLE_PERTANDINGAN_PEMAIN;
        return loadHandler(query);
    }

    public boolean updateshotongoal(int ID, int IDPemain, int babak) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues update = new ContentValues();

        update.put(JUMLAH_SHOTONTARGET, jumlahshotongoal(ID, IDPemain, babak));


        return db.update(TABLE_PERTANDINGAN_PEMAIN, update, ID_PERTANDINGAN + "=" + ID +" AND "+ID_PEMAIN+"="+IDPemain+ " AND "+BABAK+"="+babak, null) > 0;


    }

    public boolean updateshotoffgoal(int ID, int IDPemain, int babak) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues update = new ContentValues();

        update.put(JUMLAH_SHOTOFFTARGET, jumlahshotoffgoal(ID, IDPemain, babak));


        return db.update(TABLE_PERTANDINGAN_PEMAIN, update, ID_PERTANDINGAN + "=" + ID +" AND "+ID_PEMAIN+"="+IDPemain+ " AND "+BABAK+"="+babak, null) > 0;

    }

    public boolean updateintercept(int ID, int IDPemain, int babak) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues update = new ContentValues();

        update.put(JUMLAH_INTERCEPT, jumlahintercept(ID, IDPemain, babak));


        return db.update(TABLE_PERTANDINGAN_PEMAIN, update, ID_PERTANDINGAN + "=" + ID +" AND "+ID_PEMAIN+"="+IDPemain+ " AND "+BABAK+"="+babak, null) > 0;
    }

    public boolean updatesaves(int ID, int IDPemain, int babak) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues update = new ContentValues();

        update.put(JUMLAH_SAVES, jumlahsaves(ID, IDPemain, babak));


        return db.update(TABLE_PERTANDINGAN_PEMAIN, update, ID_PERTANDINGAN + "=" + ID +" AND "+ID_PEMAIN+"="+IDPemain+ " AND "+BABAK+"="+babak, null) > 0;
    }

    public boolean updatetackling(int ID, int IDPemain, int babak) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues update = new ContentValues();

        update.put(JUMLAH_TACKLING, jumlahtackling(ID, IDPemain, babak));


        return db.update(TABLE_PERTANDINGAN_PEMAIN, update, ID_PERTANDINGAN + "=" + ID +" AND "+ID_PEMAIN+"="+IDPemain+ " AND "+BABAK+"="+babak, null) > 0;
    }

    public void export() throws IOException {
        SQLiteDatabase db= this.getReadableDatabase();
        SqliteExporter dbexport=new SqliteExporter();
        dbexport.export(db);
    }
}
