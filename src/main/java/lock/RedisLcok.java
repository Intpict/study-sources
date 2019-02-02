package main.java.lock;

/**
 * User: linsen
 * Date: 18/4/26
 * Time: 上午9:56
 * Description:
 */
public class RedisLcok {

    /**
     * Jedis类
     */
    class Jedis {
        // ...
        public boolean setNx(String key, String value, int expire) {
            return true;
        }

        // ...
        public String get(String key) {
            String ans = "ans";
            return ans;
        }

        public void delete(String key) {
            return;
        }

    }

    // 模拟jedis对象
    Jedis jedis = new Jedis();

    // 锁的有效时间，假设为10秒
    static final int EXPIRE_TIME = 10000;

    // 可重入次数
    private volatile int state = 0;

    // 当前持有锁的线程
    private volatile Thread mThread = null;

    /**
     * @param key
     * @param value
     * @param timeout 锁获取的超时时间，timeout时间内未获取锁，则返回false
     * @return
     */
    public boolean lock(String key, String value, long timeout) {
        // 判断当前lock操作是否为重入操作
        if (value.equals(jedis.get(key)) && Thread.currentThread().equals(mThread)) {
            // 同一个线程的操作，不会出现并发，所以不用考虑原子性
            state++;
            return true;
        }

        long currentTime = System.currentTimeMillis();
        long endTime = currentTime + timeout;
        for (; ; ) {
            if (currentTime > endTime) {
                break;
            } else {
                currentTime = System.currentTimeMillis();
                if (jedis.setNx(key, value, EXPIRE_TIME)) {
                    mThread = Thread.currentThread();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {
        // 说明当前的锁的确为当前线程所加
        if (value.equals(jedis.get(key)) && Thread.currentThread().equals(mThread)) {
            // 有重入操作
            if (state > 0) {
                state--;
            } else {
                jedis.delete(key);
            }
        }
    }

}
