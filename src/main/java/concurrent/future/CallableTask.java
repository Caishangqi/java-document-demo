package concurrent.future;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {

        Thread.sleep(3000);

        return new Random().nextInt();
    }
}
