package com.example.fometic;

public class goal {
    private int idpertandingan;
    private String namateam;
    private String namapemain;
    private int nomorpunggung;
    private int menit;

    public goal(){}

    public goal(int idpertandingan, String namateam, String namapemain, int nomorpunggung, int menit){

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

    public int getMenit() {
        return menit;
    }

    public void setMenit(int menit) {
        this.menit = menit;
    }
}
