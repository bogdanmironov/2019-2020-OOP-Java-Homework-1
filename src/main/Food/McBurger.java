package main.Food;

public class McBurger extends BaseFood {

    public McBurger(double quantity, double quality) {
        super(quantity, quality);
    }

    @Override
    public void passWinter() {
        incrementAge();

        if (getAge() == 1) {
            double newQuantity = getQuantity() * 0.8;
            double newQuality = getQuality() * 0.5;

            setQuality(newQuality);
            setQuantity(newQuantity);
        }
    }

    @Override
    public String toString() {
        return "Type:McBurger; Quantity:" + getQuantity() + "; Quality:" + getQuality();
    }
}
