package persons;

import objects.Product;
import objects.Tobacco;

public class Narrator extends Planter {

    public void dream(String dreamContent) {
        System.out.println(name + " мечтает: \"" + dreamContent + "\"");
    }

    @Override
    public Product factoryHarvest() {
        return new Tobacco();
    }
}