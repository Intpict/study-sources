package main.java.trans;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * Created by lisong on 2018/3/28.
 */
public class main {
    private static final int CYCLE_NUM = 50002;
    private static final int THREAD_NUM = 1009;

    public static class TransNoWorker implements Runnable {
        @Override
        public void run() {
            TransNoUtil.generate1("TT");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        // dowork
        PerformUtil.concurrentExecute(new TransNoWorker(), THREAD_NUM, CYCLE_NUM);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        System.out.println("当前TransNo值为：" + TransNoUtil.generate1("TT"));
    }

}
