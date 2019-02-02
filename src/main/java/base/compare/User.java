package main.java.base.compare;

import java.util.Arrays;

/**
 * User: linsen
 * Date: 17/12/7
 * Time: 下午4:24
 * Description: User类
 */
public class User implements Comparable<User> {

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

    @Override
    public int compareTo(User o) {
        return this.age - o.age;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(id);
        sb.append(" ,");
        sb.append(age);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        User[] users = {new User("001", 11), new User("002", 10)};

        // 默认排序方式，按照age升序
        Arrays.sort(users);ˇ
        for(User user : users) {
            System.out.println(user);
        }

        System.out.println("------------------------------------");

        // 使用自定义比较器，按照age降序
        Arrays.sort(users, new UserDownComparator());
        for(User user : users) {
            System.out.println(user);
        }

    }


}
