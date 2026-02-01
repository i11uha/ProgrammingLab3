package objects;

import enums.Destination;

public class Ship implements WorldObject {
    private String name;
    private int capacity;
    private Destination currentDestination;

    @Override
    public String getName() { return name; }

    @Override
    public void setName(String name) {this.name = name;}

    public void goTo(Destination d) {
        this.currentDestination = d;
        System.out.println("Корабль " + name + " отправляется в " + d);
    }

    public int getCapacity() { return capacity; }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    public Destination getCurrentDestination() { return currentDestination; }

    public void setCurrentDestination(Destination destination) { this.currentDestination = destination; }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Ship s)) return false;
        return capacity == s.capacity && java.util.Objects.equals(name, s.name) && currentDestination == s.currentDestination;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, capacity, currentDestination);
    }

    @Override
    public String toString() {
        return "Ship{name='" + name + "', dest=" + currentDestination + "}";
    }
}