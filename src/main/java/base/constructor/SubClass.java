package main.java.base.constructor;

public class SubClass extends FatherClass {

    public SubClass() {
        System.out.println("sub, 无参！");
    }

    public SubClass(int c) {
        System.out.println("sub, 有参！"); //系统会自动先调用父类的无参构造函数
    }

}
