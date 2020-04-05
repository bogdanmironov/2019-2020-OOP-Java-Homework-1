package main;

import main.Exceptions.CannotGetMoreFoodException;
import main.Food.BaseFood;


public class Squirrel {
    private String name;
    private String type;
    private int age;
    private int collectCycles = 4;

    Burrow burrow = new Burrow();

    private void incrementAge() {
        age++;
    }

    private void decrementCollectCycles() {
        collectCycles--;
    }

    private void resetCollectCycles() {
        collectCycles = 4;
    }

    private boolean canCollect() {
        return collectCycles > 0;
    }

    public int getAge() {
        return age;
    }

    public Squirrel(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public String toString() {
        return "<" + type + ">" + " " + name + "(" + age + "): " + burrow.toString();
    }

    public void addFood(BaseFood food) throws CannotGetMoreFoodException {
        if (canCollect()) {
            burrow.addFood(food);
            decrementCollectCycles();
        } else {
            throw new CannotGetMoreFoodException("Cannot collect more food");
        }

    }

    public void passWinter() {
        burrow.passWinter();
        incrementAge();
        resetCollectCycles();
    }

    public Burrow getBurrow() {
        return burrow;
    }
}
