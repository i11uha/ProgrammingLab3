package objects;

import  java.util.ArrayList;

public abstract class Field implements WorldObject {
    protected String name;
    protected String location;
    protected ArrayList<Product> products = new ArrayList<Product>();
    protected double square;

    @Override
    public void setName(String name) {this.name = name; }

    @Override
    public String getName() {return name; }

    public void expandArea(double area) {
        if (area < 0) throw new IllegalArgumentException("Нельзя присоединить отрицательное количество");
        this.square += area;
    }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public double getSquare() { return square; }

    public void setSquare(double square) { this.square = square; }

    public ArrayList<Product> getProducts() {
        return products;
    }
}