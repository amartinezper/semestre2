package lambdas.Predicate;

import java.util.function.Predicate;

public class Ej1Predicate {
    public static void main(String[] args) {

        Predicate<Integer> esPar = n -> n % 2 == 0;

        System.out.println(esPar.test(4)); // true
        System.out.println(esPar.test(7)); // false
    }
}
