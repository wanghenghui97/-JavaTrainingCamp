package homework;

public class UseWait {
    private static Object lock = new Object();
    private static Object lock2 = new Object();


    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                Thread thread = Thread.currentThread();
                System.out.println(thread.getName() + "线程开始");
                try {
                    Thread.sleep(1000);
                    System.out.println(thread.getName() + "线程结束！");
                    lock2.notifyAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);

        synchronized (lock) {
            thread.start();
            try {
                lock2.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("主线程结束！");
    }
}
