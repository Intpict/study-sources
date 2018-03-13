package main.java.base.thread;

import java.util.Formatter;
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

    private static ScheduledExecutorService excutor = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) throws Exception {
        // 如果异常未捕获,线程将会停止工作
        /*excutor.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        Formatter t = new Formatter(System.out);
                        t.format("test format: %% %d \n", 2);
                        throw new RuntimeException("test1");
                    }
                },
                0,
                2,
                TimeUnit.SECONDS
        );*/

        new Thread(new Runnable() {
            @Override
            public void run() {
               while (true) {
                   System.out.println("test exception!");
                   throw new RuntimeException("test1");
               }
            }
        }).start();

        System.out.println("end!");
    }

}
