package lambdas.Predicate;

import java.util.function.Predicate;

public class Ej2Predicate {
    public static void main(String[] args) {

        Predicate<String> largoMayorA5 = texto -> texto.length() > 5;

        System.out.println(largoMayorA5.test("hola"));       // false
        System.out.println(largoMayorA5.test("programar")); // true
    }
}
