package main.Food;

public class Cake extends BaseFood {

    public Cake(double quantity, double quality) {
        super(quantity, quality);
    }

    @Override
    public void passWinter() {
        incrementAge();

        double newQuantity = getQuantity() * 0.7;
        double newQuality = getQuality() * (0.1 + 1.99 / Math.pow(2, getAge() / 0.85));

        setQuality(newQuality);
        setQuantity(newQuantity);
    }

    @Override
    public String toString() {
        return "Type: Cake; Quantity:" + getQuantity() + ";Quality:" + getQuality() + ";";
    }
}
