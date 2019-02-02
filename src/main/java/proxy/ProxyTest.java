package main.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * User: linsen
 * Date: 18/4/17
 * Time: 下午5:02
 * Description:
 */
public class ProxyTest {

    public static class CarHandler implements InvocationHandler {

        Car realCar;

        CarHandler(Car car) {
            realCar = car;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Proxy invoking! ");
            return method.invoke(realCar, args);
        }
    }

    public static void main(String[] args) {
        Car car = new Car("bwm");
        // 运行失败
        // jdk动态代理，必须代理接口，Car.class不是接口而是一个实现类，会抛出IllegalArgumentException异常
        Car proxyCar = (Car) Proxy.newProxyInstance(Car.class.getClassLoader(), new Class[] {Car.class}, new CarHandler(car));
        proxyCar.drive();

    }

}
