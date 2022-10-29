package streams;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class BaseUse {

    @Test
    void TestBaseStreamAPI() {
        //select 3 distinct smallest number
        int [] number = {4,1,13,90,16,2,0};

        IntStream.of(number)
                .distinct()
                .sorted() // method chaining for complicated logic
                .limit(3)
                .forEach(System.out::println);

        // original array is not mutated!

        //Also you can do some basic static operator :)
        IntStream.of(number)
                .sorted()
                .limit(3)
                .sum(); //average() count() min() max()

    }

}
