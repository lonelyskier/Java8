package se.dl.java.lambda;

import org.junit.Before;
import org.junit.Test;
import se.dl.java.domain.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.*;

public class LambdaExpressionsTest {

    /*
        Lambda expressions används där Functional Interfaces kan användas.
        Functional Interface -> ett interface med endast en abstract method




     */

    private List<Dish> menu;

    @Before
    public void setUp() {
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

    // Comparator har en static helper metod som man kan använda -> comparing
    // Man skickar in ett lambda med bara ett argument -> anger vad som ska jämföras

    @Test
    public void sortList() {
        Comparator<Dish> caloriesComparing = comparing(Dish::getCalories);
        menu.sort(caloriesComparing);

        // De olika functional interfaces innehåller en del hjälpmetoder:
        // För Comparators

        // Man kan sortera en lista baklänges
        menu.sort(caloriesComparing.reversed());

        // Och även göra en ny sortering efter en annan om två värden är lika
        Comparator<Dish> nameComparision = comparing(Dish::getName);
        menu.sort(caloriesComparing.thenComparing(nameComparision));

        // För Predicate
        Predicate<Dish> isVegeterianPredicate = Dish::isVegetarian;
        Predicate<Dish> isHighCalorieDish = Dish -> Dish.getCalories()> 500;

        isVegeterianPredicate.negate();

        isVegeterianPredicate.and(isHighCalorieDish);

        // För Functions
        // andThen då man lägger ihop functions på varandra.
        // compose
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x + 2;
        Function<Integer, Integer> h = f.andThen(g);
        int result = h.apply(3);
        System.out.println(result);

        Function<String, String> addingHeader = Dish::addHeader;
        String hello = addingHeader.apply("Hello");
        System.out.println(hello);
        Function<String, String> twoFunc = addingHeader.andThen(Dish::addHeader);
        String helloAgain_ = twoFunc.apply("HelloAgain ");
        System.out.println(helloAgain_);
    }
}