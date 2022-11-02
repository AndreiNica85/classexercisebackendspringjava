package com.flyingticketsapp.classexercise.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Flight {
    private int id;
    private String origin;
    private String destination;
    private List<String> scales;
    private LocalDateTime departureDate;
    private LocalTime transitTime;
    private Plane plane;
    private double price;


    public Flight(int id, String origin, String destination, List<String> scales, LocalDateTime departureDate, LocalTime transitTime, Plane plane, double price) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.scales = scales;
        this.departureDate = departureDate;
        this.transitTime = transitTime;
        this.plane = plane;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<String> getScales() {
        return scales;
    }

    public void setScales(List<String> scales) {
        this.scales = scales;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getTransitTime() {
        return transitTime;
    }

    public void setTransitTime(LocalTime transitTime) {
        this.transitTime = transitTime;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
