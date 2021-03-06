package com.example.fometic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import static android.os.Environment.*;

public class goalDBHandler extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="footballDB.db";
    public static final String TABLE_GOAL="tablegoal";
    public static final String ID_PERTANDINGAN="idpertandingan";
    public static final String ID_TEAM="idteam";
    public static final String ID_PEMAIN="idpemain";
    public static final String MENIT_GOAL="menitgoal";
    public static final String STATUS_GOAL="statusgoal";
    public static final String BABAK="babak";

    public goalDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable="CREATE TABLE "+TABLE_GOAL+" ("+ID_PERTANDINGAN+" INT, "+ID_TEAM+" INT, "+ID_PEMAIN+" INT, "+MENIT_GOAL+" STRING, "+STATUS_GOAL+" STRING, "+BABAK+" INT)";
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
        values.put(MENIT_GOAL,goal.getMenit());
        values.put(STATUS_GOAL, goal.getStatusgoal());
        values.put(BABAK, goal.getBabak());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_GOAL, null,values);
        db.close();
        Log.d("Input data goal ",goal.getStatusgoal());
    }

    public Cursor loaddatagoal(String idpertandingan, String idteam, int babak){
        String query="SELECT * FROM "+TABLE_GOAL+" WHERE "+ID_PERTANDINGAN+"='"+idpertandingan+"' AND "+ID_TEAM+" = '"+idteam+"' AND "+BABAK+"="+babak ;
        return (loadHandler(query));
    }

    public Cursor loaddatagoalbabakdua(String idpertandingan, String idteam){
        //String result="";
        String query="SELECT * FROM "+TABLE_GOAL+" WHERE "+ID_PERTANDINGAN+"='"+idpertandingan+"' AND "+ID_TEAM+" = '"+idteam+"'";
        //Cursor datagoal=loadHandler(query);
        //datagoal.moveToFirst();
        //while (!datagoal.isAfterLast()){

        //result += String.valueOf(id_pertandingan) + " " + nama_team_a + " " + goal_team_a + " - " + goal_team_b + " " + nama_team_b +

          //      System.getProperty("line.separator");
        return loadHandler(query);
    }

    public Cursor loadHandler(String query){
        String result="";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id_pertandingan=cursor.getInt(0);
            int id_team=cursor.getInt(1);
            int id_pemain=cursor.getInt(2);
            String menit_goal=cursor.getString(3);
            String status_goal=cursor.getString(4);
            int babak=cursor.getInt(5);
            Log.d("id pemain="+id_pemain,"menit goal="+menit_goal);
            cursor.moveToNext();
        }
        return cursor;
    }


    public void export() throws IOException {
        SQLiteDatabase db= this.getReadableDatabase();
        SqliteExporter dbexport=new SqliteExporter();
        dbexport.export(db);
    }
}
