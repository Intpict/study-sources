package main.java.base.abstractest;

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

    {
        i = 2;
    }

    // 无论是静态还是非静态,代码块或者非代码块初始都是按照赋值顺序进行
    // static final 类型的不能在构造方法中完成初始化
    public int i = 0;

    @Override
    public void run() {
        System.out.println(i);
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

    // 此方法编译报错，因为final标记的方法不能被重写
/*    public void publicFinalGo() {
        System.out.println("SubClass publicFinalGo()");
    }*/

    public void publicGo() {
        System.out.println("SubClass publicGo()");
        privateGo();
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
