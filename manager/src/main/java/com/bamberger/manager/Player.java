package com.bamberger.manager;

public class Player {

    String name;
    int score;

    Player(String name){
        this.name = name;
        this.score = 0;
;    }

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

    public void addScore(int addition){
        this.score+=addition;
    }
}
