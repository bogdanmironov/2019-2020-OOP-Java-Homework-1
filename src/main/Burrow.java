package main;

import main.Food.BaseFood;

import java.util.Vector;

public class Burrow {
    Vector<BaseFood> food;

    public Burrow() {
        this.food = new Vector<>();
    }

    public Burrow(Vector<BaseFood> food) {
        this.food = food;
    }

    public void addFood(BaseFood newFood) {
        food.addElement(newFood);
    }

    public void passWinter() {
        food.forEach(BaseFood::passWinter);
    }

    public double getTotalFoodScore() {
        return food
                .stream()
                .mapToDouble(BaseFood::getFoodScore)
                .sum();
    }

    public String toString() {
        return food.toString();
    }
}
