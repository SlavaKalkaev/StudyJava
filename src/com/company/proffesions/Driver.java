package com.company.proffesions;

public class Driver {
    protected String fullName;
    protected int workYear;

    public Driver(String fullName,
                  int workYear) {
        this.fullName = fullName;
        this.workYear = workYear;
    }

    @Override
    public String toString() {
        return "Driver{" + fullName + workYear + '}';
    }
}
