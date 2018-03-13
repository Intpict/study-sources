package main.java.base.list;

import java.util.ArrayList;

/**
 * User: linsen
 * Date: 17/12/8
 * Time: 下午4:30
 * Description:
 */
public class ArrayListTest {

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public static void main(String[] args) {
        ArrayList<String> alist = new ArrayList(5);
        System.out.println(alist.size());
        // 两个数组比较的是地址，所以返回false
        System.out.println(EMPTY_ELEMENTDATA == DEFAULTCAPACITY_EMPTY_ELEMENTDATA);

    }


}
