package main.java.base.stringtest;

public class StringBufferTest {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");
        // 有效字符串长度
        System.out.println("length: " + sb.length());
        // value字符数组容量
        System.out.println("capacity: " + sb.capacity());

        // trim操作
        sb.trimToSize();
        // 有效字符串长度
        System.out.println("length: " + sb.length());
        // value字符数组容量
        System.out.println("capacity: " + sb.capacity());

        // 添加字符串(不超过capacity)，查看容量变化
        sb.append("World");
        // 有效字符串长度
        System.out.println("length: " + sb.length());
        // value字符数组容量
        System.out.println("capacity: " + sb.capacity());

        // 添加字符串(超过capacity)，查看容量变化
        // 扩容方法: count + appendStr.len > value.len * 2 + 2 ? count + appendStr.len : value.len * 2 + 2
        sb.append("ttttttttttttttttttttttttttttttttttttt");
        // 有效字符串长度
        System.out.println("length: " + sb.length());
        // value字符数组容量
        System.out.println("capacity: " + sb.capacity());

        /*******
         *
         * 总结:
         *
         * 1. trimTosize用于将多余的缓冲区空间释放出来
         * 2. StringBuilder和StringBuffer均继承 AbstractStringBuilder，所以大部分实现一样，差别只在于是否 线程安全
         *
         */

        sb.getClass().getName();

    }

}
