package lambdas.Biconsumer;

import java.util.*;
import java.util.function.BiConsumer;

public class Ej2BiConsumer {
    public static void main(String[] args) {

        Map<String, Integer> mapa = new HashMap<>();

        BiConsumer<String, Integer> agregar = (clave, valor) -> mapa.put(clave, valor);

        agregar.accept("A", 10);
        agregar.accept("B", 20);

        System.out.println(mapa);
    }
}
