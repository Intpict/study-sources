package main.java.base.xiebian;

import java.util.ArrayList;

/**
 * User: linsen
 * Date: 18/2/13
 * Time: 下午2:46
 * Description:
 */
public class FanXingTest {

    public static void main(String[] args) {

        ArrayList<? extends Number> alist = new ArrayList<Number>();
        // alist.add(new Integer(5)); 编译不通过，因为? extends Number限定类型为Number的"某一个子类"，不能保证一定为Integer

        ArrayList<? super Number> alist1 = new ArrayList<Object>();
        alist1.add(new Integer(5)); // 此时编译可以通过，因为Integer必然满足是Number，Number必然满足是？

        ArrayList<? extends Integer> alist2 = new ArrayList<Integer>();
        //  alist2.add(new Integer(2)); // 原因如1，说明本类型元素也不能add

    }

}
