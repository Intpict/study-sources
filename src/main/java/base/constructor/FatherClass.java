package main.java.base.constructor;

public class FatherClass {

    /**
     * 如果此方法没有，子类必须显示调用基类有参构造方法
     */
    public FatherClass() {
        System.out.println("father, 无参！");
    }

    public FatherClass(int c) {
        System.out.println("father, 有参！");
    }

}
