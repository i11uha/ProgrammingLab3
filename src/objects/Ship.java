package objects;

import enums.NativeLanguage;

public class Ship implements WorldObject {
    private String name;
    private int capacity;
    private NativeLanguage currentNativeLanguage;

    @Override
    public String getName() { return name; }

    @Override
    public void setName(String name) {this.name = name;}

    public void goTo(NativeLanguage d) {
        this.currentNativeLanguage = d;
        System.out.println("Корабль " + name + " отправляется в " + d);
    }

    public int getCapacity() { return capacity; }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    public NativeLanguage getCurrentDestination() { return currentNativeLanguage; }

    public void setCurrentDestination(NativeLanguage nativeLanguage) { this.currentNativeLanguage = nativeLanguage; }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Ship s)) return false;
        return capacity == s.capacity && java.util.Objects.equals(name, s.name) && currentNativeLanguage == s.currentNativeLanguage;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, capacity, currentNativeLanguage);
    }

    @Override
    public String toString() {
        return "Ship{name='" + name + "', dest=" + currentNativeLanguage + "}";
    }
}