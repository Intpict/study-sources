package main.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: linsen
 * Date: 18/4/2
 * Time: 下午8:00
 * Description:
 */
public class syncInterupt {

    private static Object mutux = new Object();

    private static ReentrantLock lock = new ReentrantLock();

    private static volatile boolean flag = false;

    public static class SyncTask implements Runnable {

        @Override
        public void run() {
            try {
                /*
                // 同步块阻塞不能被interupt中断
                synchronized (mutux) {
                    if (!flag) {
                        flag = true;
                    }
                    // 保持锁不释放，使第二个线程阻塞在同步块上
                    while (true) ;
                }
                */

                // 直接使用lock无法被中断
                // lock.lock();
                lock.lockInterruptibly();
                if (!flag) {
                    flag = true;
                }
                // 保持锁不释放，使第二个线程阻塞在同步块上
                while (true) ;


            } catch (Exception e) {
                System.out.println("Interupted! ");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future future1 = service.submit(new SyncTask()), future2;
        // 锁被占住，再启动第二个线程
        while (!flag) ;

        future2 = service.submit(new SyncTask());
        System.out.println("线程2被启动~");
        Thread.sleep(2000);

        future2.cancel(true);

    }

}
