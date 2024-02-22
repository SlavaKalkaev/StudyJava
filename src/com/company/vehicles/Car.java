package com.company.vehicles;

import com.company.details.Engine;
import com.company.proffesions.Driver;
import com.company.proffesions.Person;

public class Car {
    protected String mark;
    protected String klass;
    protected double weight;
    protected Driver driver;
    protected Engine engine;

    public Car(
            String mark,
            String klass,
            double weight,
            Driver driver,
            Engine engine){
        this.driver = driver;
        this.klass = klass;
        this.weight = weight;
        this.mark = mark;
        this.engine = engine;
    }
    public void start(){
        System.out.println("go");
    }
    public void stop(){
        System.out.println(mark + " stop");
    }
    public void turnRight(){
        System.out.println(mark + " поворот направо");
    }
    public void turnLeft(){
        System.out.println(mark + " поворот налево");
    }

    @Override
    public String toString(){
        return "Car{"+driver+klass+weight+mark+engine+'}';
   }
}
class Pipi {
    public static void main(String[] args) {
        Car BMW = new Car("bmw",
                            "1",
                            2500,
                            new Driver("dima",15),
                            new Engine(700,"bmw"));
        Person person = new Person("dima",15,45);
        SportCar Bmw = new SportCar("bmw",
                "m4",
                2300,
                new Driver("nikita",8),
                new Engine(800,"bmw"),
                300);
        Lorry porter = new Lorry("huidai",
                "5",
                4000,
                new Driver("lflf",15),
                new Engine(890,"lklo"),
                23456);
        System.out.println(BMW);
        BMW.stop();
        Bmw.turnRight();
        System.out.println(porter);

    }
}