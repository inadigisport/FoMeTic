package com.example.fometic;

public class PemainBola {
    private int idPemain;
    private String namaPemain;
    private int nomorPunggung;
    private String idTeamPemain;

    public PemainBola(){}
    public PemainBola (int idPemain, String namaPemain, int nomorPunggung, String idTeamPemain){
        this.setIdPemain(idPemain);
        this.setNamaPemain(namaPemain);
        this.setNomorPunggung(nomorPunggung);
        this.setIdTeamPemain(idTeamPemain);
    }


    public int getIdPemain() {
        return idPemain;
    }

    public void setIdPemain(int idPemain) {
        this.idPemain = idPemain;
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

    public String getIdTeamPemain() {
        return idTeamPemain;
    }

    public void setIdTeamPemain(String idTeamPemain) {
        this.idTeamPemain = idTeamPemain;
    }
}
