package lambdas.Supplier;

import java.util.function.Supplier;

public class Ej2Supplier {
    public static void main(String[] args) {

        Supplier<String> saludo = () -> "Bienvenido al sistema";

        System.out.println(saludo.get());
    }
}
