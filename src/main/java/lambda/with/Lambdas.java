package lambda.with;

import lambda.without.Cat;
import lambda.without.Printable;
import lambda.without.PrintableWithParms;
import lambda.without.PrintableWithReturn;
import org.junit.jupiter.api.Test;

public class Lambdas {

    @Test
    void testWithLambdas() {
        Cat cat = new Cat();
        printThing(() -> {
            System.out.println("Lambdas Meow");
        });


        //We can also use as an object, save method
        Printable lambdaPrintable = ()-> System.out.println("lambdaPrintable with object");
        printThing(lambdaPrintable);
    }

    @Test
    void testWithParameterLambdas() {

        PrintableWithParms lambdaPrintable = (item)-> System.out.println(item + "Wooo, this with parameters");
        printThingWithArgs(lambdaPrintable);

    }

    @Test
    void testWithReturnLambdas() {

        PrintableWithReturn lambdaPrintable = (item)->{
            return "A return Value";
        };
        System.out.println(printThingWithReturn(lambdaPrintable));

    }

    static void printThing(Printable thing) {
        thing.print();
    }

    static void printThingWithArgs(PrintableWithParms thing) {
        thing.print("! ");
    }

    static String printThingWithReturn(PrintableWithReturn thing) {
        return thing.print("! ");
    }

}
