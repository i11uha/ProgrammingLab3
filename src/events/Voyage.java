package events;

import enums.Destination;
import exceptions.OverloadException;
import objects.ProductsTrade;
import objects.Ship;

import java.util.ArrayList;

public class Voyage extends Activity {
    private Ship ship;
    private Destination destination;
    private ArrayList<ProductsTrade> cargo = new ArrayList<>();

    public void sail(ArrayList<ProductsTrade> initialCargo) throws OverloadException {
        if (initialCargo.size() > ship.getCapacity()) {
            throw new OverloadException("Груз превышает вместимость корабля");
        }
        loadCargo(initialCargo);
        ship.goTo(destination);
        unloadAtDestination();
    }

    public void loadCargo(ArrayList<ProductsTrade> items) {
        cargo.addAll(items);
    }

    public void unloadAtDestination() {
        // Суммируем все count из ProductsTrade
        int totalBales = cargo.stream()
                .mapToInt(ProductsTrade::count) // получаем count каждого товара
                .sum();

        System.out.println("Разгрузка " + totalBales + " тюков в " + destination);
        cargo.clear();
    }

    public Ship getShip() {return ship;}
    public void setShip(Ship ship) {this.ship = ship;}

    public Destination getDestination() {return destination;}
    public void setDestination(Destination destination) {this.destination = destination;}

    public ArrayList<ProductsTrade> getCargo() {return cargo;}
    public void setCargo(ArrayList<ProductsTrade> cargo) {this.cargo = cargo;}


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Voyage voyage)) return false;
        return java.util.Objects.equals(ship, voyage.ship) &&
                destination == voyage.destination;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(ship, destination);
    }

    @Override
    public String toString() {
        return "Voyage{ship=" + ship.getName() + ", to=" + destination + "}";
    }
}