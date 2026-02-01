package persons;

import objects.Product;
import objects.SugarCane;

public class Neighbour extends Planter {

    @Override
    public Product factoryHarvest() {
        return new SugarCane();
    }
}