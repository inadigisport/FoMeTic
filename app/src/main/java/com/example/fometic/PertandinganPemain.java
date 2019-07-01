package com.example.fometic;

public class PertandinganPemain {
    private int idpemain;
    private int idpertandingan;
    private int jumlahgoal;
    private int jumlahyellowcard;
    private int jumlahredcard;
    private int jumlahshotontarget;
    private int jumlahshotofftarget;
    private int babak;

    public PertandinganPemain(){}

    public PertandinganPemain(int idpemain, int idpertandingan, int jumlahgoal, int jumlahyellowcard, int jumlahredcard, int jumlahshotontarget, int jumlahshotofftarget, int babak){
        this.idpemain=idpemain;
        this.idpertandingan=idpertandingan;
        this.jumlahgoal=jumlahgoal;
        this.jumlahyellowcard=jumlahyellowcard;
        this.jumlahredcard=jumlahredcard;
        this.jumlahshotontarget=jumlahshotontarget;
        this.jumlahshotofftarget=jumlahshotofftarget;
        this.setBabak(babak);
    }


    public int getIdpemain() {
        return idpemain;
    }

    public void setIdpemain(int idpemain) {
        this.idpemain = idpemain;
    }

    public int getIdpertandingan() {
        return idpertandingan;
    }

    public void setIdpertandingan(int idpertandingan) {
        this.idpertandingan = idpertandingan;
    }

    public int getJumlahgoal() {
        return jumlahgoal;
    }

    public void setJumlahgoal(int jumlahgoal) {
        this.jumlahgoal = jumlahgoal;
    }

    public int getJumlahyellowcard() {
        return jumlahyellowcard;
    }

    public void setJumlahyellowcard(int jumlahyellowcard) {
        this.jumlahyellowcard = jumlahyellowcard;
    }

    public int getJumlahredcard() {
        return jumlahredcard;
    }

    public void setJumlahredcard(int jumlahredcard) {
        this.jumlahredcard = jumlahredcard;
    }

    public int getJumlahshotontarget() {
        return jumlahshotontarget;
    }

    public void setJumlahshotontarget(int jumlahshotontarget) {
        this.jumlahshotontarget = jumlahshotontarget;
    }

    public int getJumlahshotofftarget() {
        return jumlahshotofftarget;
    }

    public void setJumlahshotofftarget(int jumlahshotofftarget) {
        this.jumlahshotofftarget = jumlahshotofftarget;
    }

    public int getBabak() {
        return babak;
    }

    public void setBabak(int babak) {
        this.babak = babak;
    }
}
