package com.example.fometic;

public class TeamBola {
    private int idTeam;
    private String namaTeam;
    private String formasiTeam;


    public TeamBola(){}

    public TeamBola(int idTeam, String namaTeam, String formasiTeam){
        this.idTeam=idTeam;
        this.namaTeam=namaTeam;
        this.formasiTeam=formasiTeam;
    }


    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public String getNamaTeam() {
        return namaTeam;
    }

    public void setNamaTeam(String namaTeam) {
        this.namaTeam = namaTeam;
    }

    public String getFormasiTeam() {
        return formasiTeam;
    }

    public void setFormasiTeam(String formasiTeam) {
        this.formasiTeam = formasiTeam;
    }
}
