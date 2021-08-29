package homework;

public class UseThreadJoin {
	private static String res = ""; 

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName()+"线程开始");
                try {
                    Thread.sleep(1000);
					res = "Hell0!";
                    System.out.println(thread.getName()+"线程结束！");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		System.out.println("res="+res);

        System.out.println("主线程结束！");

    }
}
