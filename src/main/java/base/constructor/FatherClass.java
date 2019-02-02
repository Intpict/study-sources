package main.java.base.constructor;

public class FatherClass {

    static {
        System.out.println("father static domain");
    }

    {
        System.out.println("初始化父类成员变量！");
    }

    /**
     * 如果此方法没有，子类必须显式调用基类有参构造方法
     */
    public FatherClass() {
        System.out.println("father, 无参！");
    }

    public FatherClass(int c) {
        System.out.println("father, 有参！");
    }

    public void printf() {
        System.out.println("father printf");
    }

    public static void staticPrintf() {
        System.out.println("father static printf");
    }

}
