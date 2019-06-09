package com.hd.game.domain;

public class GameState {
    private int Uid;
    private String Applelist;
    private int Direction;
    private int Nextdirection;
    private int Movedelay;
    private long Score;
    private String Snaketail;
    private String Troublelist;
    private String Slowlist;
    private String Quicklist;
    private int Troubleclass;

    public String getTroublelist() {
        return Troublelist;
    }

    public void setTroublelist(String troublelist) {
        Troublelist = troublelist;
    }

    public String getSlowlist() {
        return Slowlist;
    }

    public void setSlowlist(String slowlist) {
        Slowlist = slowlist;
    }

    public String getQuicklist() {
        return Quicklist;
    }

    public void setQuicklist(String quicklist) {
        Quicklist = quicklist;
    }

    public int getTroubleclass() {
        return Troubleclass;
    }

    public void setTroubleclass(int troubleclass) {
        Troubleclass = troubleclass;
    }

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public String getApplelist() {
        return Applelist;
    }

    public void setApplelist(String applelist) {
        Applelist = applelist;
    }

    public int getDirection() {
        return Direction;
    }

    public void setDirection(int direction) {
        Direction = direction;
    }

    public int getNextdirection() {
        return Nextdirection;
    }

    public void setNextdirection(int nextdirection) {
        Nextdirection = nextdirection;
    }

    public int getMovedelay() {
        return Movedelay;
    }

    public void setMovedelay(int movedelay) {
        Movedelay = movedelay;
    }

    public long getScore() {
        return Score;
    }

    public void setScore(long score) {
        Score = score;
    }

    public String getSnaketail() {
        return Snaketail;
    }

    public void setSnaketail(String snaketail) {
        Snaketail = snaketail;
    }
}
