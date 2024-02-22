package com.company.vehicles;

import com.company.details.Engine;
import com.company.proffesions.Driver;

public class SportCar extends Car{
    int speed;
    public SportCar(String mark,
                    String klass,
                    double weight,
                    Driver driver,
                    Engine engine,
                    int speed) {
        super(mark,
                klass,
                weight,
                driver,
                engine);
        this.speed = speed;
    }
}
