package com.company.vehicles;

import com.company.details.Engine;
import com.company.proffesions.Driver;

public class Lorry extends Car{
    int weightPower;
    public Lorry(String mark,
                 String klass,
                 double weight,
                 Driver driver,
                 Engine engine,
                 int weightPower) {
        super(  mark,
                klass,
                weight,
                driver,
                engine);
        this.weightPower =weightPower;
    }
    @Override
    public String toString(){
        return "Lorry{"+driver+klass+weight+mark+engine+weightPower+'}';
    }
}
