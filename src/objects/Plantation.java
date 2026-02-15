package objects;
import java.util.Random;

import enums.Mood;
import exceptions.InvalidTradeException;
import exceptions.OverloadException;
import persons.Planter;

public class Plantation extends Field {
    private double tobaccoSquare;
    private double sugarCaneSquare;
    private Planter owner;

    public Plantation(String location, double square) {
        this.location = location;
        this.square = square;
        System.out.println("Создана плантация в " + location + " площадью " + square + " га");
    }

    public void expandArea(double additional) {
        this.square += additional;
        System.out.println("Плантация в " + location + " расширена на " + additional + " га (итого: " + square + ")");
    }

    public void tradeWith(Plantation other) throws InvalidTradeException {
        if (other == null) throw new InvalidTradeException("Невозможно торговать с пустой плантацией");
        System.out.println("Торгует плантация " + this.owner.getName() + " и плантация " + other.owner.getName() + ".");
    }

    public ProductsTrade prepareForExport() {
        Random rand = new Random();

        // Базовое количество тюков
        int baseBales = 50;
        int moodModifier = 0;


        if (owner != null) {
            Mood mood = owner.getMood();
            moodModifier = switch (mood) {
                case AMBITIOUS, CONTENT -> +10;   // +10 тюков
                case RESTLESS -> 0;               // как есть
                case SAD, REGRETFUL -> -15;       // -15 тюков
            };

        }

        int count = baseBales + moodModifier + rand.nextInt(-5, 6); // ±5 случайности
        count = Math.max(5, count); // минимум 5 тюков

        System.out.println("С плантации " + location + " подготовлено " + count + " тюков табака к экспорту.");
        return new ProductsTrade("Tobacco", count, 12.5);
    }

    public void plantProduct(Product product, double area) throws OverloadException {
        if (area > square) throw new OverloadException("\n" + "Недостаточно земли для посадки");
        products.add(product);
        product.productCreation();
        if (product instanceof Tobacco) tobaccoSquare += area;
        else if (product instanceof SugarCane) sugarCaneSquare += area;
    }

    public double getTobaccoSquare() { return tobaccoSquare; }

    public void setTobaccoSquare(double square) { tobaccoSquare = square; }

    public double getSugarCaneSquare() { return sugarCaneSquare; }

    public void setSugarCaneSquare(double square) { sugarCaneSquare = square; }

    public void setOwner(Planter owner) {
        this.owner = owner;
    }

    public Planter getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Plantation p)) return false;
        return Double.compare(p.square, square) == 0 && Double.compare(p.tobaccoSquare, tobaccoSquare) == 0 && Double.compare(p.sugarCaneSquare, sugarCaneSquare) == 0 && java.util.Objects.equals(location, p.location);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(location, square, tobaccoSquare, sugarCaneSquare);
    }

    @Override
    public String toString() {
        return "Plantation{location='" + location + "', total=" + square + ", tobacco=" + tobaccoSquare + "}";
    }
}