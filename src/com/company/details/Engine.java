package com.company.details;

public class Engine {
    private int power;
    private String proizv;

    public Engine(int power,
                  String proizv) {
        this.power = power;
        this.proizv = proizv;
    }

    @Override
    public String toString() {
        return "Engine{" + power + proizv + '}';
    }
}
