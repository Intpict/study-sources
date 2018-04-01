package main.java.thread;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by My-PC on 2018/4/1.
 */
public class ExecutorPoolAndInterupt {

    /**
     * task class
     */
    public static class Task implements Runnable {

        int i;

        Task(int i) {
            this.i = i;
        }

        public void run() {
            int count = 2;
            while (count-- > 0) {
                if (i == 1) {
                    try {
                        Thread.sleep(15000);
                    } catch (InterruptedException e) {
                        System.out.println("interrupted! ");
                        throw new RuntimeException("interrupted! ");
                    }
                } else {
                    System.out.println("Thread[" + i + "] count is " + count);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        ArrayList<Future> futures = new ArrayList<Future>();
        for(int i = 0; i < 3; i++) {
            futures.add(service.scheduleAtFixedRate(new Task(i), 0, 2, TimeUnit.SECONDS));
        }
        Thread.sleep(10000);
        // 线程1被中断，但是不影响线程池其他两个线程的调度
        futures.get(1).cancel(true);
        System.out.println("Thread[1] has been interupted! ");
    }

}
