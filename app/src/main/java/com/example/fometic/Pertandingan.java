package com.example.fometic;

import java.sql.Time;
import java.util.Date;

public class Pertandingan {
    private int idPertandingan;
    private int idTeamA;
    private String namaTeamA;
    private String formasiTeamA;
    private int passingTeamA;
    private int tacklingTeamA;
    private int goalTeamA;
    private int shootOnTargetTeamA;
    private int shootOffTargetTeamA;
    private int interceptTeamA;
    private int savesTeamA;
    private int throwinTeamA;
    private int freekickTeamA;
    private int pinaltyTeamA;
    private int goalkickTeamA;
    private int cornerkickTeamA;
    private int yellowcardTeamA;
    private int redcardTeamA;
    private int babak;
    private int idTeamB;
    private String namaTeamB;
    private String formasiTeamB;
    private int passingTeamB;
    private int tacklingTeamB;
    private int goalTeamB;
    private int shootOnTargetTeamB;
    private int shootOffTargetTeamB;
    private int interceptTeamB;
    private int savesTeamB;
    private int throwinTeamB;
    private int freekickTeamB;
    private int pinaltyTeamB;
    private int goalkickTeamB;
    private int cornerkickTeamB;
    private int yellowcardTeamB;
    private int redcardTeamB;
    private int posessionTeamA;
    private int posessionTeamB;
    private Date waktupertandingan;
    private String event;
    private String venue;
    private int offsideTeamA;
    private int offsideTeamB;
    private int foulTeamA;
    private int foulTeamB;
    private int timematch;

    public Pertandingan() {
    }

    public Pertandingan(int idPertandingan, int idTeamA, String namaTeamA, String formasiTeamA, int passingTeamA, int tacklingTeamA, int goalTeamA, int shootOnTargetTeamA, int shootOffTargetTeamA, int interceptTeamA, int savesTeamA, int throwinTeamA, int freekickTeamA, int pinaltyTeamA, int goalkickTeamA, int cornerkickTeamA, int yellowcardTeamA, int redcardTeamA, int idTeamB, String namaTeamB, String formasiTeamB, int passingTeamB, int tacklingTeamB, int goalTeamB, int shootOnTargetTeamB, int shootOffTargetTeamB, int interceptTeamB, int savesTeamB, int throwinTeamB, int freekickTeamB, int pinaltyTeamB, int goalkickTeamB, int cornerkickTeamB, int yellowcardTeamB, int redcardTeamB, int posessionTeamA, int posessionTeamB, Time waktupertandingan, String venue, String event, int offsideTeamA, int offsideTeamB, int foulTeamA, int foulTeamB, int timematch) {
        this.setIdPertandingan(idPertandingan);
        this.setIdTeamA(idTeamA);
        this.setNamaTeamA(namaTeamA);
        this.setFormasiTeamA(formasiTeamA);
        this.setPassingTeamA(passingTeamA);
        this.setTacklingTeamA(tacklingTeamA);
        this.setGoalTeamA(goalTeamA);
        this.setShootOnTargetTeamA(shootOnTargetTeamA);
        this.setShootOffTargetTeamA(shootOffTargetTeamA);
        this.setInterceptTeamA(interceptTeamA);
        this.setSavesTeamA(savesTeamA);
        this.setThrowinTeamA(throwinTeamA);
        this.setFreekickTeamA(freekickTeamA);
        this.setPinaltyTeamA(pinaltyTeamA);
        this.setGoalkickTeamA(goalkickTeamA);
        this.setCornerkickTeamA(cornerkickTeamA);
        this.setYellowcardTeamA(yellowcardTeamA);
        this.setRedcardTeamA(redcardTeamA);
        this.setIdTeamB(idTeamB);
        this.setNamaTeamB(namaTeamB);
        this.setFormasiTeamB(formasiTeamB);
        this.setPassingTeamB(passingTeamB);
        this.setTacklingTeamB(tacklingTeamB);
        this.setGoalTeamB(goalTeamB);
        this.setShootOnTargetTeamB(shootOnTargetTeamB);
        this.setShootOffTargetTeamB(shootOffTargetTeamB);
        this.setInterceptTeamB(interceptTeamB);
        this.setSavesTeamB(savesTeamB);
        this.setThrowinTeamB(throwinTeamB);
        this.setFreekickTeamB(freekickTeamB);
        this.setPinaltyTeamB(pinaltyTeamB);
        this.setGoalkickTeamB(goalkickTeamB);
        this.setCornerkickTeamB(cornerkickTeamB);
        this.setYellowcardTeamB(yellowcardTeamB);
        this.setRedcardTeamB(redcardTeamB);
        this.setPosessionTeamA(posessionTeamA);
        this.setPosessionTeamB(posessionTeamB);
        this.setWaktupertandingan(waktupertandingan);
        this.setVenue(venue);
        this.setEvent(event);
        this.setFoulTeamA(foulTeamA);
        this.setFoulTeamB(foulTeamB);
        this.setOffsideTeamA(offsideTeamA);
        this.setOffsideTeamB(offsideTeamB);
        this.setTimematch(timematch);
    }

    public int getIdTeamA() {
        return idTeamA;
    }

    public void setIdTeamA(int idTeamA) {
        this.idTeamA = idTeamA;
    }

    public String getNamaTeamA() {
        return namaTeamA;
    }

    public void setNamaTeamA(String namaTeamA) {
        this.namaTeamA = namaTeamA;
    }

    public String getFormasiTeamA() {
        return formasiTeamA;
    }

    public void setFormasiTeamA(String formasiTeamA) {
        this.formasiTeamA = formasiTeamA;
    }

    public int getPassingTeamA() {
        return passingTeamA;
    }

    public void setPassingTeamA(int passingTeamA) {
        this.passingTeamA = passingTeamA;
    }

    public int getTacklingTeamA() {
        return tacklingTeamA;
    }

    public void setTacklingTeamA(int tacklingTeamA) {
        this.tacklingTeamA = tacklingTeamA;
    }

    public int getGoalTeamA() {
        return goalTeamA;
    }

    public void setGoalTeamA(int goalTeamA) {
        this.goalTeamA = goalTeamA;
    }

    public int getShootOnTargetTeamA() {
        return shootOnTargetTeamA;
    }

    public void setShootOnTargetTeamA(int shootOnTargetTeamA) {
        this.shootOnTargetTeamA = shootOnTargetTeamA;
    }

    public int getShootOffTargetTeamA() {
        return shootOffTargetTeamA;
    }

    public void setShootOffTargetTeamA(int shootOffTargetTeamA) {
        this.shootOffTargetTeamA = shootOffTargetTeamA;
    }

    public int getInterceptTeamA() {
        return interceptTeamA;
    }

    public void setInterceptTeamA(int interceptTeamA) {
        this.interceptTeamA = interceptTeamA;
    }

    public int getSavesTeamA() {
        return savesTeamA;
    }

    public void setSavesTeamA(int savesTeamA) {
        this.savesTeamA = savesTeamA;
    }

    public int getThrowinTeamA() {
        return throwinTeamA;
    }

    public void setThrowinTeamA(int throwinTeamA) {
        this.throwinTeamA = throwinTeamA;
    }

    public int getFreekickTeamA() {
        return freekickTeamA;
    }

    public void setFreekickTeamA(int freekickTeamA) {
        this.freekickTeamA = freekickTeamA;
    }

    public int getPinaltyTeamA() {
        return pinaltyTeamA;
    }

    public void setPinaltyTeamA(int pinaltyTeamA) {
        this.pinaltyTeamA = pinaltyTeamA;
    }

    public int getGoalkickTeamA() {
        return goalkickTeamA;
    }

    public void setGoalkickTeamA(int goalkickTeamA) {
        this.goalkickTeamA = goalkickTeamA;
    }

    public int getCornerkickTeamA() {
        return cornerkickTeamA;
    }

    public void setCornerkickTeamA(int cornerkickTeamA) {
        this.cornerkickTeamA = cornerkickTeamA;
    }

    public int getYellowcardTeamA() {
        return yellowcardTeamA;
    }

    public void setYellowcardTeamA(int yellowcardTeamA) {
        this.yellowcardTeamA = yellowcardTeamA;
    }

    public int getRedcardTeamA() {
        return redcardTeamA;
    }

    public void setRedcardTeamA(int redcardTeamA) {
        this.redcardTeamA = redcardTeamA;
    }

    public int getBabak() {
        return babak;
    }

    public void setBabak(int babak) {
        this.babak = babak;
    }

    public int getIdTeamB() {
        return idTeamB;
    }

    public void setIdTeamB(int idTeamB) {
        this.idTeamB = idTeamB;
    }

    public String getNamaTeamB() {
        return namaTeamB;
    }

    public void setNamaTeamB(String namaTeamB) {
        this.namaTeamB = namaTeamB;
    }

    public String getFormasiTeamB() {
        return formasiTeamB;
    }

    public void setFormasiTeamB(String formasiTeamB) {
        this.formasiTeamB = formasiTeamB;
    }

    public int getPassingTeamB() {
        return passingTeamB;
    }

    public void setPassingTeamB(int passingTeamB) {
        this.passingTeamB = passingTeamB;
    }

    public int getTacklingTeamB() {
        return tacklingTeamB;
    }

    public void setTacklingTeamB(int tacklingTeamB) {
        this.tacklingTeamB = tacklingTeamB;
    }

    public int getGoalTeamB() {
        return goalTeamB;
    }

    public void setGoalTeamB(int goalTeamB) {
        this.goalTeamB = goalTeamB;
    }

    public int getShootOnTargetTeamB() {
        return shootOnTargetTeamB;
    }

    public void setShootOnTargetTeamB(int shootOnTargetTeamB) {
        this.shootOnTargetTeamB = shootOnTargetTeamB;
    }

    public int getShootOffTargetTeamB() {
        return shootOffTargetTeamB;
    }

    public void setShootOffTargetTeamB(int shootOffTargetTeamB) {
        this.shootOffTargetTeamB = shootOffTargetTeamB;
    }

    public int getInterceptTeamB() {
        return interceptTeamB;
    }

    public void setInterceptTeamB(int interceptTeamB) {
        this.interceptTeamB = interceptTeamB;
    }

    public int getSavesTeamB() {
        return savesTeamB;
    }

    public void setSavesTeamB(int savesTeamB) {
        this.savesTeamB = savesTeamB;
    }

    public int getThrowinTeamB() {
        return throwinTeamB;
    }

    public void setThrowinTeamB(int throwinTeamB) {
        this.throwinTeamB = throwinTeamB;
    }

    public int getFreekickTeamB() {
        return freekickTeamB;
    }

    public void setFreekickTeamB(int freekickTeamB) {
        this.freekickTeamB = freekickTeamB;
    }

    public int getPinaltyTeamB() {
        return pinaltyTeamB;
    }

    public void setPinaltyTeamB(int pinaltyTeamB) {
        this.pinaltyTeamB = pinaltyTeamB;
    }

    public int getGoalkickTeamB() {
        return goalkickTeamB;
    }

    public void setGoalkickTeamB(int goalkickTeamB) {
        this.goalkickTeamB = goalkickTeamB;
    }

    public int getCornerkickTeamB() {
        return cornerkickTeamB;
    }

    public void setCornerkickTeamB(int cornerkickTeamB) {
        this.cornerkickTeamB = cornerkickTeamB;
    }

    public int getYellowcardTeamB() {
        return yellowcardTeamB;
    }

    public void setYellowcardTeamB(int yellowcardTeamB) {
        this.yellowcardTeamB = yellowcardTeamB;
    }

    public int getRedcardTeamB() {
        return redcardTeamB;
    }

    public void setRedcardTeamB(int redcardTeamB) {
        this.redcardTeamB = redcardTeamB;
    }

    public int getPosessionTeamA() {
        return posessionTeamA;
    }

    public void setPosessionTeamA(int posessionTeamA) {
        this.posessionTeamA = posessionTeamA;
    }

    public int getPosessionTeamB() {
        return posessionTeamB;
    }

    public void setPosessionTeamB(int posessionTeamB) {
        this.posessionTeamB = posessionTeamB;
    }

    public int getIdPertandingan() {
        return idPertandingan;
    }

    public void setIdPertandingan(int idPertandingan) {
        this.idPertandingan = idPertandingan;
    }


    public Date getWaktupertandingan() {
        return waktupertandingan;
    }

    public void setWaktupertandingan(Date waktupertandingan) {
        this.waktupertandingan = waktupertandingan;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getOffsideTeamA() {
        return offsideTeamA;
    }

    public void setOffsideTeamA(int offsideTeamA) {
        this.offsideTeamA = offsideTeamA;
    }

    public int getOffsideTeamB() {
        return offsideTeamB;
    }

    public void setOffsideTeamB(int offsideTeamB) {
        this.offsideTeamB = offsideTeamB;
    }

    public int getFoulTeamA() {
        return foulTeamA;
    }

    public void setFoulTeamA(int foulTeamA) {
        this.foulTeamA = foulTeamA;
    }

    public int getFoulTeamB() {
        return foulTeamB;
    }

    public void setFoulTeamB(int foulTeamB) {
        this.foulTeamB = foulTeamB;
    }

    public int getTimematch() {
        return timematch;
    }

    public void setTimematch(int timematch) {
        this.timematch = timematch;
    }
}