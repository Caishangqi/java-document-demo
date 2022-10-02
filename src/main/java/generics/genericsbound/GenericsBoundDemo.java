package generics.genericsbound;


import org.junit.jupiter.api.Test;

public class GenericsBoundDemo {

    @Test
    void testGenericsBoundDemo() {

        //指定类型
        Printer<Dog> dogPrinter = new Printer<>(new Dog());
        dogPrinter.print();

        Printer<Cat> catPrinter = new Printer<>(new Cat());
        catPrinter.print();

    }

}
