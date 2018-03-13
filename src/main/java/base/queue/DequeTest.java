package main.java.base.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * User: linsen
 * Date: 18/3/4
 * Time: 下午2:57
 * Description:
 */
public class DequeTest {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        deque.add("test1");  // 此时等价于addLast
        deque.add("test2");
        for (String str : deque) {
            System.out.println(str);
        }

        deque.addFirst("test3");
        for (String str : deque) {
            System.out.println(str);
        }
    }

}
