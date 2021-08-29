package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class UseCountDownLatch implements Runnable {
	private CountDownLatch latch;
	
	public UseCountDownLatch(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		Integer millis = new Random().nextInt(10000);
		try {
		TimeUnit.MILLISECONDS.sleep(millis);
		this.latch.countDown();
		System.out.println("我的任务OK了:"+Thread.currentThread().getName());
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args)throws Exception {
		int num = 100;
		CountDownLatch latch = new CountDownLatch(num);
		List<CompletableFuture> list = new ArrayList<>(num);
		for (int i = 0; i < num; i++) {
			CompletableFuture<Void> future = CompletableFuture.runAsync(new UseCountDownLatch(latch));
			list.add(future);
		}
		latch.await();
		for (CompletableFuture future : list) {
			future.get();
		}
	}

}