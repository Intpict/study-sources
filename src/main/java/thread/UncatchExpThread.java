package main.java.thread;

import java.util.Formatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * User: linsen
 * Date: 18/2/8
 * Time: 上午10:36
 * Description:
 */
public class UncatchExpThread {

    private static ExecutorService excutor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws Exception {
        // execute如果异常未捕获,线程将会停止工作,对于单线程池，会重启新的线程执行后面的任务
        excutor.execute (
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread());
                        Formatter t1 = new Formatter(System.out);
                        t1.format("test format: %% %d \n", 1);
                        throw new RuntimeException("test1");
                    }
                }
        );
        // submit会抓住异常，因此线程不会挂
        excutor.submit (
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread());
                        Formatter t1 = new Formatter(System.out);
                        t1.format("test format: %% %d \n", 2);
                        throw new RuntimeException("test1");
                    }
                }
        );

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
