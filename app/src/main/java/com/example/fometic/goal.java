package com.example.fometic;

import android.widget.Chronometer;

public class goal {
    private int idpertandingan;
    private int idteam;
    private int idpemain;
    private String namateam;
    private String namapemain;
    private int nomorpunggung;
    private Double menit;
    double elapsedchronometerteamint;
    double elapsedchronometerteambint;

    public goal(){}

    public goal(int idpertandingan, String namateam, String namapemain, int nomorpunggung, Double menit, int idteam, int idpemain){
        this.idpertandingan=idpertandingan;
        this.namapemain=namapemain;
        this.namateam=namateam;
        this.nomorpunggung=nomorpunggung;
        this.menit=menit;
        this.setIdteam(idteam);
        this.setIdpemain(idpemain);
    }


    public int getIdpertandingan() {
        return idpertandingan;
    }

    public void setIdpertandingan(int idpertandingan) {
        this.idpertandingan = idpertandingan;
    }

    public String getNamateam() {
        return namateam;
    }

    public void setNamateam(String namateam) {
        this.namateam = namateam;
    }

    public String getNamapemain() {
        return namapemain;
    }

    public void setNamapemain(String namapemain) {
        this.namapemain = namapemain;
    }

    public int getNomorpunggung() {
        return nomorpunggung;
    }

    public void setNomorpunggung(int nomorpunggung) {
        this.nomorpunggung = nomorpunggung;
    }

    public Double getMenit() {
        return menit;
    }

    public void setMenit(Double menit) {
        this.menit = menit;
    }

    public int getIdteam() {
        return idteam;
    }

    public void setIdteam(int idteam) {
        this.idteam = idteam;
    }

    public int getIdpemain() {
        return idpemain;
    }

    public void setIdpemain(int idpemain) {
        this.idpemain = idpemain;
    }

}
