package com.company.proffesions;

public class Person extends Driver{
    int age;
    public Person(String fullName,
                  int workYear,
                  int age) {
        super(  fullName,
                workYear);
        this.age = age;
    }
}
