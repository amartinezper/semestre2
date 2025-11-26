package lambdas.Consumer;

import java.util.*;
import java.util.function.Consumer;

public class Ej2Consumer {
    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>();
        Consumer<Integer> agregar = n -> numeros.add(n);

        agregar.accept(10);
        agregar.accept(20);

        System.out.println(numeros);
    }
}

