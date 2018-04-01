package main.java.base.classloader;

/**
 * User: linsen
 * Date: 18/3/16
 * Time: 下午2:13
 * Description:
 */
public class ClassLoaderTest {
    /** 引导类加载器BootStrap ClassLoader加载的路径 */
    private static String bootClassPath = System.getProperty("sun.boot.class.path");
    private static String extClassPath = System.getProperty("java.ext.dirs");
    private static String appClassPath = System.getProperty("java.class.path");

    public static void main(String[] args) {
        System.out.println("bootClassPath: " + bootClassPath);
        System.out.println("extClassPath: " + extClassPath);
        System.out.println("appClassPath: " + appClassPath);
    }

}
