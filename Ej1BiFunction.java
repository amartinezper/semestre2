package lambdas.BiFunction;

import java.util.function.BiFunction;

public class Ej1BiFunction {
    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> sumar = (a, b) -> a + b;

        System.out.println(sumar.apply(5, 7)); // 12
    }
}
