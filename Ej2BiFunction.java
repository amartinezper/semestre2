package lambdas.BiFunction;

import java.util.function.BiFunction;

public class Ej2BiFunction {
    public static void main(String[] args) {

        BiFunction<String, String, String> nombreCompleto =
                (nombre, apellido) -> nombre + " " + apellido;

        System.out.println(nombreCompleto.apply("Ana", "Rojas"));
    }
}
