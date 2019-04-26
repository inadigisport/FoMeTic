package com.example.fometic;

public class TeamBola {
    private int idTeam;
    private String namaTeam;
    private String formasiTeam;
    private int jumlahAnggotaTeam;
    private int passingTeam;
    private int tacklingTeam;
    private int goalTeam;
    private int shootOnTargetTeam;
    private int shootOffTargetTeam;
    private int interceptTeam;
    private int savesTeam;
    private int throwinTeam;
    private int freekickTeam;
    private int pinaltyTeam;
    private int goalkickTeam;
    private int cornerkickTeam;
    private int yellowcardTeam;
    private int redcardTeam;
    private String statusTeam;

    public TeamBola(){}

    public TeamBola(int idTeam, String namaTeam, String formasiTeam, int jumlahTeam, int passingTeam, int tacklingTeam, int goalTeam, int shootOnTargetTeam, int shootOffTargetTeam, int interceptTeam, int savesTeam, int throwinTeam, int freekickTeam, int pinaltyTeam, int goalkickTeam, int cornerkickTeam, int yellowcardTeam, int redcardTeam, String statusTeam){
        this.idTeam=idTeam;
        this.namaTeam=namaTeam;
        this.formasiTeam=formasiTeam;
        this.setJumlahAnggotaTeam(jumlahTeam);
        this.setPassingTeam(passingTeam);
        this.setTacklingTeam(tacklingTeam);
        this.setGoalTeam(goalTeam);
        this.setShootOnTargetTeam(shootOnTargetTeam);
        this.setShootOffTargetTeam(shootOffTargetTeam);
        this.setInterceptTeam(interceptTeam);
        this.setSavesTeam(savesTeam);
        this.setThrowinTeam(throwinTeam);
        this.setFreekickTeam(freekickTeam);
        this.setPinaltyTeam(pinaltyTeam);
        this.setGoalkickTeam(goalkickTeam);
        this.setCornerkickTeam(cornerkickTeam);
        this.setYellowcardTeam(yellowcardTeam);
        this.setRedcardTeam(redcardTeam);
        this.setStatusTeam(statusTeam);
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

    public int getJumlahTeam() {
        return getJumlahAnggotaTeam();
    }

    public void setJumlahTeam(int jumlahAnggotaTeam) {
        this.setJumlahAnggotaTeam(jumlahAnggotaTeam);
    }

    public int getJumlahAnggotaTeam() {
        return jumlahAnggotaTeam;
    }

    public void setJumlahAnggotaTeam(int jumlahAnggotaTeam) {
        this.jumlahAnggotaTeam = jumlahAnggotaTeam;
    }

    public int getPassingTeam() {
        return passingTeam;
    }

    public void setPassingTeam(int passingTeam) {
        this.passingTeam = passingTeam;
    }

    public int getTacklingTeam() {
        return tacklingTeam;
    }

    public void setTacklingTeam(int tacklingTeam) {
        this.tacklingTeam = tacklingTeam;
    }

    public int getGoalTeam() {
        return goalTeam;
    }

    public void setGoalTeam(int goalTeam) {
        this.goalTeam = goalTeam;
    }

    public int getShootOnTargetTeam() {
        return shootOnTargetTeam;
    }

    public void setShootOnTargetTeam(int shootOnTargetTeam) {
        this.shootOnTargetTeam = shootOnTargetTeam;
    }

    public int getShootOffTargetTeam() {
        return shootOffTargetTeam;
    }

    public void setShootOffTargetTeam(int shootOffTargetTeam) {
        this.shootOffTargetTeam = shootOffTargetTeam;
    }

    public int getInterceptTeam() {
        return interceptTeam;
    }

    public void setInterceptTeam(int interceptTeam) {
        this.interceptTeam = interceptTeam;
    }

    public int getSavesTeam() {
        return savesTeam;
    }

    public void setSavesTeam(int savesTeam) {
        this.savesTeam = savesTeam;
    }

    public int getThrowinTeam() {
        return throwinTeam;
    }

    public void setThrowinTeam(int throwinTeam) {
        this.throwinTeam = throwinTeam;
    }

    public int getFreekickTeam() {
        return freekickTeam;
    }

    public void setFreekickTeam(int freekickTeam) {
        this.freekickTeam = freekickTeam;
    }

    public int getPinaltyTeam() {
        return pinaltyTeam;
    }

    public void setPinaltyTeam(int pinaltyTeam) {
        this.pinaltyTeam = pinaltyTeam;
    }

    public int getGoalkickTeam() {
        return goalkickTeam;
    }

    public void setGoalkickTeam(int goalkickTeam) {
        this.goalkickTeam = goalkickTeam;
    }

    public int getCornerkickTeam() {
        return cornerkickTeam;
    }

    public void setCornerkickTeam(int cornerkickTeam) {
        this.cornerkickTeam = cornerkickTeam;
    }

    public int getYellowcardTeam() {
        return yellowcardTeam;
    }

    public void setYellowcardTeam(int yellowcardTeam) {
        this.yellowcardTeam = yellowcardTeam;
    }

    public int getRedcardTeam() {
        return redcardTeam;
    }

    public void setRedcardTeam(int redcardTeam) {
        this.redcardTeam = redcardTeam;
    }

    public String getStatusTeam() {
        return statusTeam;
    }

    public void setStatusTeam(String statusTeam) {
        this.statusTeam = statusTeam;
    }
}
