package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class UseCyclicBarrier implements Runnable{
    private CyclicBarrier barrier;
    public UseCyclicBarrier(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        Integer millis = new Random().nextInt(10000);
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
            this.barrier.await(); // 线程阻塞
            System.out.println("开吃:" + Thread.currentThread().getName());
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        int num = 8;
        CyclicBarrier barrier = new CyclicBarrier(num);
        List<CompletableFuture> list = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            CompletableFuture<Void> future =
                    CompletableFuture.runAsync(new UseCyclicBarrier(barrier));
            list.add(future);
        }
        for (CompletableFuture future : list) {
            future.get();
        }
        barrier.reset();
    }
}
