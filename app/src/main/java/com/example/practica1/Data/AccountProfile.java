package com.example.practica1.Data;

import java.util.Date;

public class AccountProfile {
    // int imageId;
    private String name;
    private String picture_URI;
    private int maxScore;
    private Date last_game_date;

    public AccountProfile(String name , String picture_URI){
        this.name=name;
        this.picture_URI = picture_URI;
        this.maxScore = 0;
        this.last_game_date = null;
    }

    public AccountProfile(String name, String picture_URI, int maxScore){
        this.name=name;
        this.picture_URI = picture_URI;
        this.maxScore = maxScore;
        this.last_game_date = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public Date getLast_game_date() {
        return last_game_date;
    }

    public String getDateAsString(){
        if(last_game_date == null)
            return "--/--/--";
        else{
            return last_game_date.toString();
        }
    }

    public String getPicture_URI() {
        return picture_URI;
    }

    public void setPicture_URI(String picture_URI) {
        this.picture_URI = picture_URI;
    }

    public void setLast_game_date(Date last_game_date) {
        this.last_game_date = last_game_date;
    }
}
