package concurrent.executorservice;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ExecutorServiceDemo {

    /**
     * 如果你的任务十分消耗CPU，则理想的任务池线程数量 = CPU的核心数量
     * 如果你的任务是高IO消耗，则你的任务池数量越大越好，这样至少有一些线程可以处理你的任务而不会
     * 让客户端进行等待。
     */

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

    @Test
    void testIdealThreadExecutorService() {
        // 获取CPU核心
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        //提交任务
        for (int i = 10; i < 100; i++) {
            service.execute(new Task());
        }
    }

    @Test
    void testConstructorExecutorService() {
        //custom service
        ExecutorService service = new ThreadPoolExecutor(10, 100, 120, TimeUnit.SECONDS, new ArrayBlockingQueue<>(300));

        try {
            service.execute(new Task());
        } catch (RejectedExecutionException exception) {
            System.err.println("task rejected " + exception.getMessage());
        }

    }


}

/*
自定义的队列插入错误处理器，可以实现一些logging
 */
class CustomRejectionHandler implements RejectedExecutionHandler {

    /**
     * Method that may be invoked by a {@link ThreadPoolExecutor} when
     * {@link ThreadPoolExecutor#execute execute} cannot accept a
     * task.  This may occur when no more threads or queue slots are
     * available because their bounds would be exceeded, or upon
     * shutdown of the Executor.
     *
     * <p>In the absence of other alternatives, the method may throw
     * an unchecked {@link RejectedExecutionException}, which will be
     * propagated to the caller of {@code execute}.
     *
     * @param r        the runnable task requested to be executed
     * @param executor the executor attempting to execute this task
     * @throws RejectedExecutionException if there is no remedy
     */
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        //logging
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