package main.java.base.constructor;

import java.util.Collection;
import java.util.Iterator;

/**
 * User: linsen
 * Date: 17/12/20
 * Time: 下午3:06
 * Description:
 */
public class CloneTest implements Collection<String> {


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(String s) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    private static class InnerClass {

    }

    public Object clone() throws CloneNotSupportedException {
        System.out.println("test");
        return super.clone(); // 无法调用超类的clone方法，因为没有实现Cloneable接口
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        new CloneTest().clone();
    }

}
