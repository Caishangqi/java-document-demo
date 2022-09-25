package concurrent.typesthreadpool;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {

    @Test
    void TestFixedThreadDemo(){
        //size
        ExecutorService service = Executors.newFixedThreadPool(10);

        //提交任务
        for (int i = 10; i < 100; i++) {
            service.execute(new DemoTask());
        }

        System.out.println("（！）线程 " + Thread.currentThread().getName());
    }

}
