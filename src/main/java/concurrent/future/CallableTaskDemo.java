package concurrent.future;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableTaskDemo {

    @Test
    void testCallableTestDemo() {
        //create the thread pool
        ExecutorService service = Executors.newFixedThreadPool(10);

        //submit callable task for execution
        Future<Integer> future = service.submit(new CallableTask());

        /**
         * Future As name means a @placeholder for the value which will arrive
         * sometimes in the future
         */

        //perform some unrelated operations

        //Future methods

        //Cancel the task
        future.cancel(false); //whether or not cancel task already in thread

        //Returns true if task was cancelled
        future.isCancelled();

        //Return true is task is completed (successfully or otherwise
        future.isDone();

        //if finish in 1 sec, your future is not ready
        try {
            Integer result = future.get(); //blocking operation
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    void testMultipleCallableTestDemo() {
        //create the thread pool
        ExecutorService service = Executors.newFixedThreadPool(10);

        List<Future> allFutures = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Future<Integer> future = service.submit(new CallableTask());
            allFutures.add(future);
        }

        //100 futures for 100 placeholders

        //perform some unrelated operations

        //100 seconds some completed and some not completed
        for (Future<Integer> allFuture : allFutures) {
            try {
                //wait for 1 second for future, if no value, through TimeoutException
                Integer integer = allFuture.get(1, TimeUnit.SECONDS);
                System.out.println(integer);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
