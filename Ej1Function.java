package lambdas.Function;

import java.util.function.Function;

public class Ej1Function {
    public static void main(String[] args) {

        Function<Double, Double> celsiusAF = c -> (c * 9/5) + 32;

        System.out.println(celsiusAF.apply(25.0)); // 77.0
    }
}

