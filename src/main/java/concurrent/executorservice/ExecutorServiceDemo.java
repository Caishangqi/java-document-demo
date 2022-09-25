package concurrent.executorservice;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

    @Test
    void testExecutorService() {
        //任务池，10个线程在里面，执行完第一个任务去执行第二个
        ExecutorService service = Executors.newFixedThreadPool(10);

        //提交任务
        for (int i = 10; i < 100; i++) {
            service.execute(new Task());
        }

        System.out.println("（！）线程 " + Thread.currentThread().getName());
    }


}

class Task implements Runnable {
    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println("线程 " + Thread.currentThread().getName());
    }
}