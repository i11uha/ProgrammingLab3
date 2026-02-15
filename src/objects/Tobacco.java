package objects;

public class Tobacco implements Product {
    @Override
    public void productCreation() {
        System.out.println("Табак засушен и собран в тюки");
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Tobacco;
    }
}