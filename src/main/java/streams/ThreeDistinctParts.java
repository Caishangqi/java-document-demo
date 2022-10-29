package streams;

import org.junit.jupiter.api.Test;

import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @link to original Source of documentation <a href="https://www.youtube.com/watch?v=N3gQdIn90CI&t=2s&ab_channel=DefogTech">...</a>
 */
public class ThreeDistinctParts {

    @Test
    void testDistinctPart() {
        int [] number = {4,1,13,90,16,2,0};

        IntStream.of(number) // create the stream
                .distinct() // process the stream
                .sorted() // process the stream
                .limit(3) // process the stream
                .forEach(System.out::println); //consume the stream (extract value from stream)
    }

    @Test
    void testCreatStream() {
        int [] number = {4,1,13,90,16,2,0};

        IntStream.of(number); // from array
        IntStream.range(1,101); //1...100
        IntStream.rangeClosed(1,100); //1...100
        // IntStream.generate(supplier) from supplier
    }

    @Test
    void testProcessStream() {
        int [] number = {4,1,13,90,16,2,0};

        IntStream.of(number).distinct(); //distinct
        IntStream.of(number).sorted(); //sort
        IntStream.of(number).limit(3); //get first 3
        IntStream.of(number).skip(3); //skip first 3
        IntStream.of(number).filter(num -> num%2 == 0); //only even
        IntStream.of(number).map(num -> num * 2); //double each num
        IntStream.of(number).boxed(); //convert each num to integer

    }

    @Test
    void testConsumeStream() {

        int [] number = {4,1,13,90,16,2,0};

        IntStream.of(number).average();
        IntStream.of(number).min();
        IntStream.of(number).max();
        IntStream.of(number).sum();
        IntStream.of(number).count();

        IntStream.range(1,100).forEach(System.out::println); //print 1 to 99
        IntStream.range(1,100).toArray(); //collect into array
        IntStream.range(1,100).boxed().collect(Collectors.toList()); //collect into List

        //Return true or false
        IntStream.of(number).anyMatch(num -> num%2 == 1); //is any num odd
        IntStream.of(number).allMatch(num -> num%2 == 1); //are all num odd

    }

}
