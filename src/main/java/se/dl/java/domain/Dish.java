package se.dl.java.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
    @ToString
public class Dish {

    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;

    public enum Type { MEAT, FISH, OTHER }

    public static String addHeader(String text) {
        return text + " adding header text";
    }
}
