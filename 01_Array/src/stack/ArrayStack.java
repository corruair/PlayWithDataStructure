package stack;

import array.Array;

/**
 * 栈
 * @param <T>
 */
public class ArrayStack<T> implements Stack<T> {

    private Array<T> array;

    /**
     * 有参数构造方法
     *
     * @param capacity
     */
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * 无参构造方法
     */
    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public void push(T t) {
        array.addLast(t);
    }

    @Override
    public void pop() {
        array.remove(array.getSize() - 1);
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public T peek() {
        return array.get(array.getSize() - 1);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if (i < array.getSize() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
