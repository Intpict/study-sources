package main.java.base.abstractest;

/**
 * User: linsen
 * Date: 18/1/30
 * Time: 下午4:27
 * Description:
 */
public abstract class AbstractClass {

    abstract public void run();

    private int value1;

    /**
     * private定义的方法默认为final，不能被重载
     */
    private void privateGo() {
        System.out.println("AbstractClass privateGo()");
    }

    public final void publicFinalGo() {
        System.out.println("AbstractClass publicFinalGo()");
    }

    public void publicGo() {
        System.out.println("AbstractClass publicGo()");
        privateGo();
    }

}
