package lambdas.Supplier;

import java.util.function.Supplier;

public class Ej1Supplier {
    public static void main(String[] args) {

        Supplier<Integer> random = () -> (int)(Math.random() * 100);

        System.out.println(random.get());
    }
}

