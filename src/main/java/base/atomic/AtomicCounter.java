package main.java.base.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: linsen
 * Date: 17/12/8
 * Time: 上午9:12
 * Description: 原子计数器
 */
public class AtomicCounter {

    private static AtomicInteger count = new AtomicInteger(999998);

    private static int limit = 999999;

    public static String generate() {
        count.compareAndSet(limit, 0);
        return String.format("%06d", count.incrementAndGet());
    }

    public static void main(String[] args) {
        System.out.println(AtomicCounter.generate());
        System.out.println(AtomicCounter.generate());
    }
}
