package se.dl.java;

import org.junit.Before;
import org.junit.Test;
import se.dl.java.domain.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaExpressionsTest {

    private List<Dish> menu;

    @Before
    public void setUp() {
        new Dish("sf", false, 800, Dish.Type.FISH);

        menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
    }

    @Test
    public void staringLambdaExpressions() {
        System.out.println("Lambda");
        System.out.println("Size " + menu.size());
    }

    @Test
    public void sortList() {


    }
}