package com.example.trishlapokharna.scoutingtakethree;

/**
 * Created by TrishlaPokharna on 2/11/17.
 */

public class RoboInfo {
    String matchT;
    String teamT;
    String scouterT;
    String notesT;
    String endGameT = "N";
    String result = "Lose";

    static final RoboInfo me = new RoboInfo();

    public static RoboInfo getInstance() {
        return me;
    }

    //AUTONOMOUS

    //match text
    public void setMatchT(String str){
        matchT = str;
    }
    public String getMatchT(){
        return matchT;
    }

    //team text
    public void setTeamT(String str){
        teamT = str;
    }
    public String getTeamT(){
        return teamT;
    }

    //scouter text
    public void setScouterT(String str){
        scouterT = str;
    }
    public String getScouterT(){
        return scouterT;
    }


    //POST MATCH
    public void setNotesT(String str){
        notesT = str;
    }
    public String getNotesT(){
        return notesT;
    }

    public void setEndGameT(String str) {endGameT = str; }
    public String getEndGameT() {return endGameT; }

    public void setResult(String str) {result = str; }
    public String getResult() {return result; }

}
