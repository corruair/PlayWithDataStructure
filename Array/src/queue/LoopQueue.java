package queue;

/**
 * 循环队列
 *
 * @param <T>
 */
public class LoopQueue<T> implements Queue<T> {

    private T[] data;

    /**
     * 队列的大小
     */
    private int size;
    /**
     * 队首 和 队尾的位置
     */
    private int front, tail;

    public LoopQueue(int capacity) {
        data = (T[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(T t) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = t;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 重新设置队列的长度
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % getCapacity()];
        }
        front = 0;
        tail = getCapacity();
        data = newData;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("LopQueue is empty");
        }
        T t = data[front % data.length];

        front = (front + 1) % getCapacity();

        size--;

        if (size <= getCapacity() / 4 && getCapacity() / 2 > 0) {
            resize(getCapacity() / 2);
        }

        return t;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("LoopQueue is empty");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoopQueue length:" + getCapacity() + "\n");
        sb.append("front[");
        for (int i = 0; i < getSize(); i++) {
            sb.append(data[(front + i) % data.length]);
            if (i < getSize() - 1) {
                sb.append(",");
            }
        }
        sb.append("]tail");
        return sb.toString();
    }
}
