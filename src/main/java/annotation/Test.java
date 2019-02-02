package main.java.annotation;

/**
 * User: linsen
 * Date: 18/5/14
 * Time: 上午10:24
 * Description:
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException {
        Apple apple = new Apple();
        AppleUtil.init(apple);
        System.out.println(apple.getAppleColor());
        System.out.println(apple.getAppleName());
    }

}
