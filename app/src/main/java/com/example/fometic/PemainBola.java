package com.example.fometic;

public class PemainBola {
    private String namaPemain;
    private int idPemain;
    private int nomorPunggung;
    private String posisi;
    private String idteam;
    private String team;

    public PemainBola(){}
    public PemainBola (String namaPemain, int nomorPunggung, String posisi, String idteam, int idpemain, String team){
        this.namaPemain=namaPemain;
        this.nomorPunggung=nomorPunggung;
        this.posisi=posisi;
        this.setIdteam(idteam);
        this.setIdPemain(idpemain);
        this.setTeam(team);
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


    public int getIdPemain() {
        return idPemain;
    }

    public void setIdPemain(int idPemain) {
        this.idPemain = idPemain;
    }

    public String getIdteam() {
        return idteam;
    }

    public void setIdteam(String idteam) {
        this.idteam = idteam;
    }


    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
