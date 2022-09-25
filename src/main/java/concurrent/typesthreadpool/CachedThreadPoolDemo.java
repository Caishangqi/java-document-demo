package concurrent.typesthreadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo {

    /*
     * 没有固定大小的线程的线程池，并且没有任务队列，原先的任务队列被替换成了
     * synchronous Queue，这个队列只能装一个任务。每当你提交一个新的任务，
     * 该任务会储存到这个任务队列，这个任务队列会寻找线程池中空闲的线程。如果
     * 在线程池中找不到空闲的线程，那么他就会新建一个线程并且把它加入到线程池。
     *
     * (!) 如果一个线程在这里闲置60秒则该线程会被杀死
     */

    @Test
    void TestCachedThreadDemo(){
        // for lot of short lived task
        ExecutorService service = Executors.newCachedThreadPool();

        //提交任务
        for (int i = 10; i < 100; i++) {
            service.execute(new DemoTask());
        }

        System.out.println("（！）线程 " + Thread.currentThread().getName());
    }

}
