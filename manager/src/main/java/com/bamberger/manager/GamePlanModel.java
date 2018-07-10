package com.bamberger.manager;

import java.util.List;

public class GamePlanModel {

    private String name;
    private String filename;
    private int lenght;
    private int frequency;
    private List<String> plan;

    public GamePlanModel(String name, String filename, int length, int frequency, List<String> plan){
        this.name = name;
        this.filename = filename;
        this.lenght = length;
        this.frequency = frequency;
        this.plan = plan;
    }

    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getLenght() {
        return lenght;
    }

    public List<String> getPlan() {
        return plan;
    }

    public String getFilename() {
        return filename;
    }
}
