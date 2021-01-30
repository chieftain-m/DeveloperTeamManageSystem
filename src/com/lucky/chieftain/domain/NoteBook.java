package com.lucky.chieftain.domain;

public class NoteBook implements Equipment{
    private String model;
    private double price;

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
