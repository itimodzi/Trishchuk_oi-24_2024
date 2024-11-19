package com.example.house;

public class House {

    private int id;
    private int apartmentNumber;
    private double area;
    private int floor;
    private int rooms;
    private String street;
    private boolean found;

    public House(int id, int apartmentNumber, double area, int floor, int rooms, String street) {
        this.id = id;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.rooms = rooms;
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Квартира [id = " + id + ", Номер квартири = " + apartmentNumber + ", Площа = " + area +
                " sqm, Поверх = " + floor + ", Кількість кімнат = " + rooms + ", Вулиця = " + street + "]";
    }
}
