package persons;

import objects.Plantation;
import objects.Product;
import exceptions.OverloadException;

public abstract class Planter extends Person {
    protected Plantation currentPlantation; // чтобы потомки могли использовать

    @Override
    public void work() {
        if (currentPlantation == null) {
            throw new IllegalStateException(name + " не имеет плантации для работы!");
        }
        Product product = factoryHarvest();
        if (product != null) {
            double area = 5.0 * getMoodMultiplier();
            try {
                currentPlantation.plantProduct(product, area);
                System.out.println(name + " успешно обработал " + String.format("%.1f", area) + " гектаров.");
            } catch (OverloadException e) {
                System.err.println("Ошибка при работе: " + e.getMessage());
            }
        }
    }

    // реализуется в подклассах. Это необходимо для Factory паттерна
    public abstract Product factoryHarvest();

    public Plantation getCurrentPlantation() {
        return currentPlantation;
    }

    // урожайность по настроению
    // Идея в том, что от настроения плантатора зависит то сколько он сможет произвести единиц товара => сможет заработать сам
    // чеем настроение хуже тем выручка ниже
    private double getMoodMultiplier() {
        return switch (this.mood) {
            case AMBITIOUS, CONTENT -> 1.4;   // +40% хорошо работает
            case RESTLESS -> 1.0;             // нейтрально
            case SAD, REGRETFUL -> 0.6;       // -40% плохо работает
        };
    }

    public void setCurrentPlantation(Plantation currentPlantation) {
        this.currentPlantation = currentPlantation;
        System.out.println(name + " назначен управлять плантацией в " + currentPlantation.getLocation());
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) return false;
        Planter that = (Planter) object;
        return java.util.Objects.equals(currentPlantation, that.currentPlantation);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), currentPlantation);
    }

    @Override
    public String toString() {
        return "Planter{" + super.toString() +
                ", plantation=" + (currentPlantation != null ? currentPlantation.getLocation() : "null") +
                '}';
    }
}