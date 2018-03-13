package main.java.base.stringtest;

/**
 * User: linsen
 * Date: 18/3/13
 * Time: 上午10:57
 * Description:
 */
public class InternTest {

    public static void main(String[] args) {

        String str = new StringBuilder("hell").append("o").toString();

        System.out.println(str.intern() == str);

        String str1 = "hello";

        System.out.println(str == str1);

    }

}
