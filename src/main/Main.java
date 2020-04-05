package main;

import main.Exceptions.CannotGetMoreFoodException;
import main.Food.BaseFood;
import main.Food.Cake;
import main.Food.McBurger;
import main.Food.Nuts;

import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Vector<Squirrel> squirrels = new Vector<>();

        String nextToken = input.nextLine();

        while(!nextToken.equals("stop")){
            Squirrel newSquirrel = readSquirrel(nextToken);
            squirrels.addElement(newSquirrel);
            nextToken = input.nextLine();
        }

        nextToken = input.nextLine();

        while (!nextToken.equals("stop")) {
            for (Squirrel squirrel : squirrels) {
                while (!nextToken.equals("stop")) {
                    try {
                        BaseFood newFood = readFood(nextToken);

                        squirrel.addFood(newFood);

                        nextToken = input.nextLine();
                    } catch (CannotGetMoreFoodException ignored) {
                        break;
                    }
                }

                if (nextToken.equals("stop")) break;
            }
        }

        squirrels.forEach((squirrel) -> System.out.println(squirrel.toString()));
    }

    private static Squirrel readSquirrel(String input) {
        Scanner scanner = new Scanner(input);
        scanner.useDelimiter(",");
        String name = scanner.next();
        String type = scanner.next();
        int age = scanner.nextInt();
        return new Squirrel(name, type, age);
    }

    private static BaseFood readFood(String input) throws IllegalArgumentException{
        Scanner scanner = new Scanner(input);
        scanner.useDelimiter(" ");
        String type = scanner.next();
        int quality = scanner.nextInt();
        int quantity = scanner.nextInt();

        switch (type) {
            case "nuts":
                return new Nuts(quantity, quality);
            case "cake":
                return new Cake(quantity, quality);
            case "mcburger":
                return new McBurger(quantity, quality);
            default:
                throw new IllegalArgumentException();
        }
    }
}
