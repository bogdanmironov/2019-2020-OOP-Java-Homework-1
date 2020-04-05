package main.Food;

public class Nuts extends BaseFood {
    public Nuts(double quantity, double quality) {
        super(quantity, quality);
    }

    @Override
    public void passWinter() {
        incrementAge();
    }

    @Override
    public String toString() {
        return "Type:Nuts; Quantity:" + getQuantity() + "; Quality:" + getQuality();
    }
}
