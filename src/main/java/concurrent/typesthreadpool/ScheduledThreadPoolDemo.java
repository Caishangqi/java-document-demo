package concurrent.typesthreadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {

    /*
     * 使用与如果你想让一个任务延迟运行
     *
     * 该池会储存所有的任务到队列中，但是这个队列是延迟队列并且
     * 无法保证顺序，这些任务会按照什么时候执行分配到任务队列中
     *
     * 假如说你提交2种任务，一种10秒后执行，一种10分钟后执行，
     * 那么10秒的任务会在任务队列的首部。
     *
     * 延迟的三种
     * Service.schedule
     * Service.scheduleAtFixedRate 固定时间
     * Service.scheduleAtFixedDelay 按照前任务执行后的时间
     */

    @Test
    void testScheduledThreadPoolDemo() {

        //for scheduling of tasks
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        //task to run after 10 second delay
        service.schedule(new DemoTask(),10, TimeUnit.SECONDS);

        //task to run repeatedly every 10 seconds
        service.scheduleAtFixedRate(new DemoTask(),15,10,TimeUnit.SECONDS);

        //task to run repeatedly 10 seconds after previous task completes
        service.scheduleWithFixedDelay(new DemoTask(),15,10,TimeUnit.SECONDS);


    }

}
