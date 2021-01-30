package com.lucky.chieftain.domain;

public class Printer implements Equipment{

    private String type;
    private String name;

    public Printer(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }
}
