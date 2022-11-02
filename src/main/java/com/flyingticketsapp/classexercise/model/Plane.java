package com.flyingticketsapp.classexercise.model;

import java.util.ArrayList;
import java.util.List;

public class Plane {

    private int id;
    private String airline;
    private boolean luggage;
    private List<Traveller> sits;

    public Plane(int id, String airline, boolean luggage, List<Traveller> sits) {
        this.id = id;
        this.airline = airline;
        this.luggage = luggage;
        this.sits = sits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public boolean isLuggage() {
        return luggage;
    }

    public void setLuggage(boolean luggage) {
        this.luggage = luggage;
    }

    public List<Traveller> getSits() {
        return sits;
    }

    public void setSits(List<Traveller> sits) {
        this.sits = sits;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", airline='" + airline + '\'' +
                ", luggage=" + luggage +
                ", sits=" + sits +
                '}';
    }
}
