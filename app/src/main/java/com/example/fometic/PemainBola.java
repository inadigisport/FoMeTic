package com.example.fometic;

public class PemainBola {
    private String namaPemain;
    private int nomorPunggung;
    private String posisi;
    private String team;
    private int goal;
    private int yellowcard;
    private int redcard;

    public PemainBola(){}
    public PemainBola (String namaPemain, int nomorPunggung, String posisi, String team, int goal, int yellowcard, int redcard){
        this.namaPemain=namaPemain;
        this.nomorPunggung=nomorPunggung;
        this.posisi=posisi;
        this.team=team;
        this.goal=goal;
        this.yellowcard=yellowcard;
        this.redcard=redcard;
    }


    public String getNamaPemain() {
        return namaPemain;
    }

    public void setNamaPemain(String namaPemain) {
        this.namaPemain = namaPemain;
    }

    public int getNomorPunggung() {
        return nomorPunggung;
    }

    public void setNomorPunggung(int nomorPunggung) {
        this.nomorPunggung = nomorPunggung;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getYellowcard() {
        return yellowcard;
    }

    public void setYellowcard(int yellowcard) {
        this.yellowcard = yellowcard;
    }

    public int getRedcard() {
        return redcard;
    }

    public void setRedcard(int redcard) {
        this.redcard = redcard;
    }
}
