package com.flyingticketsapp.classexercise.model;

public class Traveller {

    private int id;
    private String name;
    private String surname;
    private String nationality;
    private String NIEorPassPort;
    private int age;
    private boolean bag;

    public Traveller(int id, String name, String surname, String nationality, String NIEorPassPort, int age, boolean bag) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.NIEorPassPort = NIEorPassPort;
        this.age = age;
        this.bag = bag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNIEorPassPort() {
        return NIEorPassPort;
    }

    public void setNIEorPassPort(String NIEorPassPort) {
        this.NIEorPassPort = NIEorPassPort;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBag() {
        return bag;
    }

    public void setBag(boolean bag) {
        this.bag = bag;
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nationality='" + nationality + '\'' +
                ", NIEorPassPort='" + NIEorPassPort + '\'' +
                ", age=" + age +
                ", bag=" + bag +
                '}';
    }
}
