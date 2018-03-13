package main.java.base.runtimetest;

/**
 * User: linsen
 * Date: 17/12/22
 * Time: 上午10:50
 * Description:
 */
public class ConstantFolding {

    static final int number1 = 5;  // 静态常变量
    static final int number2 = 6;
    static int number3 = 5;
    static int number4 = 6;

    public static void main(String[] args) {
        int product1 = number1 * number2; //line A，编译器确定
        int product2 = number3 * number4; //line B
        int product3 = product1 * 20;  // 虽然product1在编译器确定，但是他是局部变量，仍可变，因此product3是运行时确定
    }

}
