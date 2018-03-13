package main.java.base.abstract_test;

import java.util.ArrayList;

/**
 * User: linsen
 * Date: 18/1/30
 * Time: 下午4:28
 * Description:
 */
public class SubClass extends AbstractClass implements BaseInterface {

    {
        i = 1;
    }

    public int i = 0;

    @Override
    public void run() {
        System.out.println(i);
    }

    {
        i = 2;
    }

    /**
     * final方法不允许override，但是允许overload
     *
     * @param i
     */
    public final void run1(int i) {

    }

    public void privateGo() {
        System.out.println("SubClass privateGo()");
    }


    public void invoke(ArrayList<String> oj) {
        System.out.println(oj);
    }

    public static void main(String[] args) {
        new SubClass().run();
        new SubClass().publicGo();

        ArrayList<String> strs = new ArrayList<String>();
        strs.add("test");

        new SubClass().invoke(strs);

    }

}
