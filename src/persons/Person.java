package persons;

import exceptions.NoHarvestException;
import objects.Course;
import objects.ProductsTrade;
import objects.WorldObject;
import enums.Mood;
import enums.Nationality;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class Person implements WorldObject {
    protected String name;
    protected Mood mood;
    protected Nationality nationality;
    protected ArrayList<ProductsTrade> inventory = new ArrayList<>();
    protected int workingCapital;
    private Set<Nationality> knownLanguages = new HashSet<>();

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void speak(String message) {
        System.out.println(name + " Сказал: " + message);
    }

    public void study(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Курс не может быть null");
        }
        System.out.println(name + " изучает: " + course.getTitle());
        if (course.getTitle().contains("Португальский")) {
            knownLanguages.add(Nationality.PORTUGUESE);
        } else if (course.getTitle().contains("Английский")) {
            knownLanguages.add(Nationality.ENGLISH);
        }
    }

    public boolean knowsLanguage(Nationality lang) {
        return knownLanguages.contains(lang);
    }

    public void setMood(Mood mood) {
        this.mood = mood;
        System.out.println(this.name + " теперь чувствует себя: " + mood);
    }

    public Mood getMood() { return mood; }

    public void setNationality(Nationality nationality) {}

    public Nationality getNationality() { return nationality; }

    public void setInventory(ArrayList<ProductsTrade> inventory) { this.inventory = inventory; }
    public void removeInventory(ArrayList<ProductsTrade> items) { this.inventory.removeAll(items); }
    public ArrayList<ProductsTrade> getInventory() { return inventory; }

    public void setWorkingCapital(int workingCapital) { this.workingCapital = workingCapital; }

    public int getWorkingCapital() { return workingCapital; }

    public abstract void work() throws NoHarvestException;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Person p)) return false;
        return workingCapital == p.workingCapital && java.util.Objects.equals(name, p.name) && mood == p.mood && nationality == p.nationality;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, mood, nationality, workingCapital);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', mood=" + mood + ", nationality=" + nationality + "}";
    }
}