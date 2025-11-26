package lambdas.Biconsumer;

import java.util.function.BiConsumer;

public class Ej1BiConsumer {
    public static void main(String[] args) {

        BiConsumer<String, Integer> mostrar =
                (nombre, edad) -> System.out.println(nombre + " tiene " + edad + " años");

        mostrar.accept("Lucas", 20);
    }
}
