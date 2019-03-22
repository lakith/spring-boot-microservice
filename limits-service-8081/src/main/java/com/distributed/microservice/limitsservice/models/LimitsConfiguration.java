package com.distributed.microservice.limitsservice.models;

public class LimitsConfiguration {

    private  int maximum;
    private  int minimum;

    public LimitsConfiguration() {
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }
}
