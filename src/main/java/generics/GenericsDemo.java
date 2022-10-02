package generics;

import org.junit.jupiter.api.Test;

public class GenericsDemo {

    @Test
    void testGenericsDemo() {

        //指定类型
        Printer<Integer> printer = new Printer<>(23);
        printer.print();

        Printer<Double> doublePrinter = new Printer<>(23.5);
        doublePrinter.print();

    }


}
