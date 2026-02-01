package objects;

public class Tobacco implements Product {
    @Override
    public void doStuff() {
        System.out.println("Табак засушен и собран в тюки");
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Tobacco;
    }
}