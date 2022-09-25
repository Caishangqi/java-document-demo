package concurrent.typesthreadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadedExecutorDemo {

    /*
     * 只有一个线程的线程池，如果因为任务导致线程被杀死，
     * 这个线程池会新建一个新的线程
     *
     * 这种任务池确保了你的任务按照你想要的顺序执行，因
     * 为只有一个线程。
     */

    @Test
    void testSingleThreadedExecutorDemo() {
        //size
        ExecutorService service = Executors.newSingleThreadExecutor();

        //提交任务
        for (int i = 10; i < 100; i++) {
            service.execute(new DemoTask());
        }

        System.out.println("（！）线程 " + Thread.currentThread().getName());
    }


}
