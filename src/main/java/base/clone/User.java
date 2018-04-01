package main.java.base.clone;

import main.java.base.compare.UserDownComparator;

import java.util.Arrays;

/**
 * User: linsen
 * Date: 17/12/7
 * Time: 下午4:24
 * Description: User类
 */
public class User implements Cloneable {

    private String id;
    private int age;

    public User(String id, int age) {
        this.id = id;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(id);
        sb.append(" ,");
        sb.append(age);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        User user1 = new User(new String("1"), 18);
        User user2 = user1.clone();
        System.out.println(user1 == user2);
        System.out.println(user1.getId() == user2.getId());
        System.out.println(user1.getAge() == user2.getAge());
    }


}
