package main.java.thread;

import java.io.IOException;

/**
 * User: linsen
 * Date: 17/12/15
 * Time: 上午9:45
 * Description:
 */
public class Daemon {

    public static class TestMain4 extends Thread {
        public TestMain4() {
        }

        /**
         * 线程的run方法，它将和其他线程同时运行
         */
        public void run() {
            for (int i = 1; i <= 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println(i);
            }
        }

    }

    public static void main(String[] args) {
        TestMain4 test = new TestMain4();
        test.setDaemon(true);
        test.start();
        System.out.println("isDaemon = " + test.isDaemon());
        try {
            // 接受输入，使程序在此停顿，一旦接收到用户输入，main线程结束，守护线程自动结束
            System.in.read();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
