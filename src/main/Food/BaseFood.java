package main.Food;

public abstract class BaseFood {
    private double quantity;
    private double quality;
    private int age;

    public BaseFood(double quantity, double quality) {
        this.quantity = quantity;
        this.quality = quality;
        this.age = 0;
    }

    public int getAge() {
        return age;
    }

    protected void incrementAge() {
        age++;
    }

    protected double getQuantity() {
        return quantity;
    }

    protected void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    protected double getQuality() {
        return quality;
    }

    protected void setQuality(double quality) {
        this.quality = quality;
    }

    public double getFoodScore() {
        return quality * quantity;
    }

    public abstract void passWinter();

    public abstract String toString();
}




