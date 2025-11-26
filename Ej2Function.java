package lambdas.Function;

import java.util.function.Function;

public class Ej2Function {
    public static void main(String[] args) {

        Function<String, Integer> longitud = s -> s.length();

        System.out.println(longitud.apply("Java")); // 4
    }
}
