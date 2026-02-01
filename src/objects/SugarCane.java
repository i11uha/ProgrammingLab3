package objects;

public class SugarCane implements Product {
    @Override
    public void doStuff() {
        System.out.println("Сахарный тростник собран");
    }

    @Override
    public String toString() {
        return "SugarCane{}";
    }
}