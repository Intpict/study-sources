package main.java.base.compare;

import java.util.Comparator;

/**
 * User: linsen
 * Date: 17/12/7
 * Time: 下午4:36
 * Description: User降序比较类
 */
public class UserDownComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o2.getAge() - o1.getAge();
    }

}
