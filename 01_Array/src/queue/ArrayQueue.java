package queue;

import array.Array;

/**
 * 数组队列
 *
 * @param <T>
 */
public class ArrayQueue<T> implements Queue<T> {

    private Array<T> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(T t) {
        array.addLast(t);
    }

    @Override
    public T dequeue() {
        return array.remove(0);
    }

    @Override
    public T getFront() {
        return array.get(0);
    }
}
