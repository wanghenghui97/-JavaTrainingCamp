package homework;

public class UseThreadSleep {
    private static String result = "";
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    result = "Hello!";
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread thread = Thread.currentThread();
                System.out.println("当前线程："+thread.getName());
            }
        };



        Thread thread = new Thread(runnable);
        thread.setName("test-thread-1");
        thread.setDaemon(false);		// 设置守护线程
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result:"+result);
    }
}
