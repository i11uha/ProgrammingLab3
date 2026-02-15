package persons;

import objects.Product;
import objects.Tobacco;

public class Narrator extends Planter {

    public void dream(String dreamContent) {
        System.out.println(name + " мечтает: \"" + dreamContent + "\"");
    }

    @Override
    public Product factoryHarvest() {
        // eсли под табаком 0 то ничего не растёт
        if (currentPlantation.getTobaccoSquare() <= 0) {
            return null;
        }
        return new Tobacco();
    }

}