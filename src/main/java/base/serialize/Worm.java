package main.java.base.serialize;

import java.io.*;
import java.util.Random;

/**
 * User: linsen
 * Date: 18/3/16
 * Time: 下午1:42
 * Description:
 */
public class Worm implements Serializable {
    private static final long serialVersionUID = 2826975882508663466L;

    private static Random rand = new Random(47);

    private Data[] data = {
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10))
    };

    private Worm next;

    private char c;

    public Worm(int i, char x) {
        System.out.println("Worm constructor: " + i);
        c = x;
        if (--i > 0) {
            next = new Worm(i, (char)(x + 1));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(':');
        sb.append(c);
        sb.append('(');
        for (Data d : data) {
            sb.append(d);
        }
        sb.append(')');
        if (null != next) {
            sb.append(next);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Worm w = new Worm(6, 'a');
        System.out.println("w = " + w);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/java/base/serialize/worm.out"));
        out.writeObject("Worm storage\n");
        out.writeObject(w);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/java/base/serialize/worm.out"));
        String s = (String)in.readObject();
        Worm w2 = (Worm)in.readObject();
        System.out.println(s + "w2 = " + w2);
        System.out.println(w == w2); // false，因为是两个不同的对象，地址必然不一样

    }


}
