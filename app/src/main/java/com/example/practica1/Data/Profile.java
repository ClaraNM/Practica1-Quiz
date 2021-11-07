package com.example.practica1.Data;

public class Profile {
    String name;
    int score=0;
    String time=null;
    public Profile(String name, int score, String time){
        this.name=name;
        this.score=score;
        this.time  =time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
