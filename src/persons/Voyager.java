package persons;

import events.Voyage;
import objects.ProductsTrade;

import java.util.ArrayList;

public class Voyager extends Person {
    private Voyage currentVoyage;

    @Override
    public void work() {
        if (currentVoyage != null) {
            try {
                currentVoyage.sail(new ArrayList<>());
            } catch (Exception exception) {
                System.err.println("Миссия провалена: " + exception.getMessage());
            }
        } else {
            throw new IllegalStateException("Рейс не назначен");
        }
    }

    public ProductsTrade adjustPriceByMood(ProductsTrade original, boolean knowsLocalLanguage) {
        if (original == null) return null;
        // Идея в том, что от настроения путешествинника зависит то какую цену он сможет предложить покупателю => сможет заработать сам
        // чеем настроение хуже тем выручка ниже
        double baseCost = original.cost();
        double moodMultiplier = switch (this.mood) {
            case AMBITIOUS -> 1.5;
            case CONTENT -> 1.2;
            case RESTLESS -> 0.9;
            case SAD, REGRETFUL -> 0.7;
            default -> 1.0;
        };

        double languageBonus = knowsLocalLanguage ? 1.2 : 1.0; // если знает язык то он получит выручки на 20% больше
        double adjustedCost = baseCost * moodMultiplier * languageBonus;
        adjustedCost = Math.max(0.1, adjustedCost);

        return new ProductsTrade(original.name(), original.count(), adjustedCost);
    }

    public Voyage getCurrentVoyage() {
        return currentVoyage;
    }

    public void setCurrentVoyage(Voyage currentVoyage) {
        this.currentVoyage = currentVoyage;
        System.out.println(name + " назначен руководить рейсом в " + currentVoyage.getDestination());
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) return false;
        Voyager that = (Voyager) object;
        return java.util.Objects.equals(currentVoyage, that.currentVoyage);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), currentVoyage);
    }

    @Override
    public String toString() {
        return "Voyager{" + super.toString() +
                ", voyage=" + (currentVoyage != null ? currentVoyage.getDestination() : "none") +
                '}';
    }
}