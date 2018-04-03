package main.java.trans;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * TransNo工具类
 * 
 * @author lisong
 * 
 */
public class TransNoUtil {

    private static AtomicInteger counter = new AtomicInteger();
    private static final int LIMIT_VALUE = 99;
    private static final Object mutux = new Object();
    private static final Sequence sequence = new Sequence("seq", -1, 0, LIMIT_VALUE, true, 1);

    /**
     * 生成transNo: 2位nodeId + 4位随机数
     * 
     * @return
     */
    public static String generate1(String nodeId) {
        int value = counter.getAndIncrement();
        if (value > LIMIT_VALUE) {
            synchronized (mutux) {
                if (counter.get() > LIMIT_VALUE) {
                    counter.set(0);
                }
            }
            return generate1(nodeId);
        }
        return nodeId + String.format("%04d", value);
    }

    /**
     * 生成transNo: 2位nodeId + 4位随机数
     *
     * @return
     */
    public static String generate2(String nodeId) {
        int value = sequence.getNextValue();
        return nodeId + String.format("%04d", value);
    }


}
