package lambda.without;

import org.junit.jupiter.api.Test;

public class Lambdas {
    
    @Test
    void testWithOutLambdas() {
        Cat cat = new Cat();
        printThing(cat);
    }

    static void printThing(Printable thing) {
        thing.print();
    }
    
}
