package objects;

public record ProductsTrade(String name, int count, double cost) {
    public double sell() {
        return count * cost;
    }
    public boolean buy(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Количество должно быть больше 0");
        }
        else {
            return quantity <= count;
        }
    }
}