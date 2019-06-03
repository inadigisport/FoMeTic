package com.example.fometic;

public class goal {
    private int idpertandingan;
    private int idteam;
    private int idpemain;
    private String namateam;
    private String namapemain;
    private int nomorpunggung;
    private String menit;
    private String statusgoal;
    private int babak;
    private double elapsedchronometerteamint;
    private double elapsedchronometerteambint;

    public goal(){}

    public goal(int idpertandingan, String namateam, String namapemain, int nomorpunggung, String menit, int idteam, int idpemain, String statusgoal, int babak){
        this.idpertandingan=idpertandingan;
        this.namapemain=namapemain;
        this.namateam=namateam;
        this.nomorpunggung=nomorpunggung;
        this.menit=menit;
        this.setIdteam(idteam);
        this.setIdpemain(idpemain);
        this.setStatusgoal(statusgoal);
        this.setBabak(babak);
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

    public String getMenit() {
        return menit;
    }

    public void setMenit(String menit) {
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

    public String getStatusgoal() {
        return statusgoal;
    }

    public void setStatusgoal(String statusgoal) {
        this.statusgoal = statusgoal;
    }

    public double getElapsedchronometerteamint() {
        return elapsedchronometerteamint;
    }

    public void setElapsedchronometerteamint(double elapsedchronometerteamint) {
        this.elapsedchronometerteamint = elapsedchronometerteamint;
    }

    public double getElapsedchronometerteambint() {
        return elapsedchronometerteambint;
    }

    public void setElapsedchronometerteambint(double elapsedchronometerteambint) {
        this.elapsedchronometerteambint = elapsedchronometerteambint;
    }

    public int getBabak() {
        return babak;
    }

    public void setBabak(int babak) {
        this.babak = babak;
    }
}
