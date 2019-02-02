package main.java.base.constructor;

public class SubClass extends FatherClass {

    static {
        System.out.println("sub static domain");
    }

    {
        System.out.println("初始化子类成员变量！");
    }

    public SubClass() {
        System.out.println("sub, 无参！");
    }

    public SubClass(int c) {
        super(c);
        System.out.println("sub, 有参！"); //系统会自动先调用父类的无参构造函数，除非使用super显式调用
    }

    public void printf() {
        super.printf();
        System.out.println("sub printf");
    }

    public static void staticPrintf() {
        System.out.println("sub static printf");
    }

    public static void main(String[] args) {
        FatherClass a = new SubClass(3);
        System.out.println(a instanceof FatherClass);
        System.out.println(a.getClass() == FatherClass.class);
        System.out.println(FatherClass.class.isInstance(a));
        System.out.println(SubClass.class.isInstance(a));
        a.printf();
        a.staticPrintf();
        SubClass b = (SubClass)a;
        b.staticPrintf();

    }

}
