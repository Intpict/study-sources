package main.java.base.constructor;

public class Test {

    public Test(int i) {
        System.out.println("Test" + i);
    }

    public static void main(String[] args) {
        SubClass sub1 = new SubClass();
//        SubClass sub2 = new SubClass(1);
    }

}
