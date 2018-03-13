package main.java.base.reflect;

import main.java.base.compare.User;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * User: linsen
 * Date: 18/2/11
 * Time: 上午11:25
 * Description:
 */
public class ClazzTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<User> c = (Class<User>) Class.forName("main.java.base.compare.User");
        Constructor c0 = c.getDeclaredConstructor(new Class[]{String.class, int.class});
        c0.setAccessible(true);
        User user = (User) c0.newInstance(new Object[]{"test1", 1});
        System.out.println(c.getMethods()[4]);
        System.out.println(user);

    }

}
