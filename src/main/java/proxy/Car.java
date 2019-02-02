package main.java.proxy;

/**
 * User: linsen
 * Date: 18/4/17
 * Time: 下午5:02
 * Description:
 */
public class Car {

    String name;

    public Car(String name) {
        this.name = name;
    }

    public void drive() {
        System.out.println("drive car: " + name);
    }

}
