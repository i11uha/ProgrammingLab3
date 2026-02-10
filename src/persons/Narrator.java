package persons;

import objects.Product;
import objects.Tobacco;

public class Narrator extends Planter {

    public void dream(String dreamContent) {
        System.out.println(name + " мечтает: \"" + dreamContent + "\"");
    }

    @Override
    public Product factoryHarvest() {
        // Если под табаком 0 — ничего не растёт
        if (currentPlantation.getTobaccoSquare() <= 0) {
            return null;
        }
        return new Tobacco();
    }

}