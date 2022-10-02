package concurrent.completablefuture;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureDemo {

    /**
     * CompletableFuture 可以当任务没有完成时不阻塞主线程
     * 默认使用ForkJoinPool进行处理
     * 也可以指定特定线程执行
     */
    @Test
    void testCompletableFuture() {

        ExecutorService cpuBound = Executors.newFixedThreadPool(4);
        ExecutorService ioBound = Executors.newCachedThreadPool();

        int baseNumber = 10;

        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> getRandom(0), cpuBound)
                .thenApply(result -> getRandom(result)); //把上个方法的结果 result 传入这个内

        try {
            Integer integer = integerCompletableFuture.get();
            System.out.println(integer);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


    }

    public Integer getRandom(Integer base) {
        int result = new Random().nextInt();
        System.out.println("the method return the value: " + result + "and the base value: " + base);
        return result;
    }

}
