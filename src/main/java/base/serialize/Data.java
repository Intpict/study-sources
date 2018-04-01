package main.java.base.serialize;

import java.io.Serializable;

/**
 * User: linsen
 * Date: 18/3/16
 * Time: 上午11:49
 * Description:
 */
public class Data implements Serializable {
    private static final long serialVersionUID = -6600779263944926857L;
    int i;
    Data(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return String.valueOf(i);
    }
}
