package main.java.base.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * User: linsen
 * Date: 17/12/21
 * Time: 下午4:20
 * Description:
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put(null, "1");

        // hashmap遍历的第一种方式
        for (String k : map.keySet())
            System.out.println(map.get(k));

        // hashmap遍历的第二种方式
        for (Map.Entry<String, String> k : map.entrySet())
            System.out.println(k.getValue());

        // hashmap遍历的第三种方式
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext())
            System.out.println(it.next().getValue());

    }

}
