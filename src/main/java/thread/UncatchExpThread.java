package main.java.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * User: linsen
 * Date: 18/2/8
 * Time: 上午10:36
 * Description:
 */
public class UncatchExpThread {

    private static ScheduledExecutorService excutor = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) throws Exception {
        // 如果异常未捕获,线程将会停止工作
        /*excutor.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        Formatter t1 = new Formatter(System.out);
                        t1.format("test format: %% %d \n", 2);
                        throw new RuntimeException("test1");
                    }
                },
                0,
                2,
                TimeUnit.SECONDS
        );*/

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               while (true) {
                   System.out.println("test exception!");
                   try {
                       Thread.sleep(2000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   throw new RuntimeException("test1");
               }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i++ < 10) {
                    System.out.println("test exception!");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 一个线程抛出异常不会影响其他线程的执行
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("end!");
    }

}
