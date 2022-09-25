package concurrent.threadpool;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LifeCycleThreadPool {

    @Test
    void testLifeCycleOfThreadPool() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            service.execute(new DemoTask());
        }

        //initiate shutdown
        //just initiate, not shut down the whole executor (thread still run the task and qunen)
        //task after submit will not accept
        service.shutdown();

        //will throw RejectionExecutionException
        service.execute(new DemoTask());

        //will return true, since the shutdown has begun
        service.isShutdown();

        //will return true if all task are completed
        //including queued ones
        service.isTerminated();

        //block until all tasks are completed or if timeout occurs
        service.awaitTermination(10, TimeUnit.SECONDS);

        //will initiate shutdown and return all queued tasks
        List<Runnable> runnableList = service.shutdownNow();

    }

}
