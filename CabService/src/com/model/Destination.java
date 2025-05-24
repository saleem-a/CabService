package com.model;

public class Destination {
    private State state;
    private City city;

    public Destination(State state, City city) {
        this.state = state;
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "state=" + state +
                ", city=" + city +
                '}';
    }
}
