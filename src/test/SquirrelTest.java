package test;

// import org.elsys.squirrels.Squirrel;
// import org.elsys.squirrels.food.Cake;
// import org.elsys.squirrels.food.Nuts;
// import org.junit.jupiter.api.BeforeEach;

import main.Exceptions.CannotGetMoreFoodException;
import main.Food.Cake;
import main.Food.Nuts;
import main.Squirrel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquirrelTest {
    Squirrel squirrel;

    @BeforeEach
    void setUp() {
        squirrel = new Squirrel("Test", "Species", 5);
    }

    @Test
    void passWinter() throws Exception {
        squirrel.addFood(new Nuts(10, 10));
        squirrel.addFood(new Cake(10, 10));
        assertEquals(squirrel.getBurrow().getTotalFoodScore(), 200);

        squirrel.passWinter();
        assertEquals(squirrel.getBurrow().getTotalFoodScore(), 168.63, 0.01);
        assertEquals(squirrel.getAge(), 6);

        squirrel.passWinter();
        assertEquals(squirrel.getBurrow().getTotalFoodScore(), 123.51, 0.01);
        assertEquals(squirrel.getAge(), 7);
    }

    @Test
    void addFood() {
        try {
            Nuts nuts = new Nuts(10, 10);

            squirrel.addFood(nuts);
            assertEquals(squirrel.getBurrow().getTotalFoodScore(), 100);
            squirrel.addFood(nuts);
            assertEquals(squirrel.getBurrow().getTotalFoodScore(), 200);
            squirrel.addFood(nuts);
            assertEquals(squirrel.getBurrow().getTotalFoodScore(), 300);
            squirrel.addFood(nuts);
            assertEquals(squirrel.getBurrow().getTotalFoodScore(), 400);
            assertThrows(CannotGetMoreFoodException.class, () -> squirrel.addFood(nuts));
            squirrel.addFood(nuts);
        } catch (Exception e) {
            assertEquals(squirrel.getBurrow().getTotalFoodScore(), 400);
        }
    }
}
