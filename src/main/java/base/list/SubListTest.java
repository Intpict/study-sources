package main.java.base.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: linsen
 * Date: 18/3/23
 * Time: 下午5:30
 * Description:
 */
public class SubListTest {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            arr.add(i);

        List<Integer> subArr = arr.subList(0, 5);
        System.out.println(subArr);

        subArr.clear();
        System.out.println(arr);


    }

}
