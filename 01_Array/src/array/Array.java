package array;

/**
 * 自定义数组
 *
 * @author fty
 */
public class Array<T> {

    private T[] data;
    private int size;

    public Array() {
        data = (T[]) new Object[10];
    }

    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return data.length == 0;
    }

    /**
     * 向数组的最后一个位置插入一个元素
     *
     * @param e
     */
    public void addLast(T e) {
        add(size, e);
    }

    /**
     * 向第一个位置添加特定的元素
     *
     * @param e
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * 向数组的特定位置添加特定的元素
     *
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed,index must > 0 and < size");
        }
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        for (int i = size; i > index; i--) {
            data[size] = data[size - 1];
        }
        data[index] = e;
        size++;
    }

    /**
     * 为特定位置赋值
     *
     * @param index
     * @param e
     */
    public void set(int index, T e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed,index is illegal");
        }
        data[index] = e;
    }

    /**
     * 获取特定位置的元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed,index is illegal");
        }
        return data[index];
    }

    /**
     * 是否包含某个元素
     *
     * @param e
     * @return
     */
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找某个元素在数组中的位置
     *
     * @param e
     * @return
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除index位置的元素并返回其值
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        T result = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        if (size <= getCapacity() / 4 && getCapacity() / 2 > 0) {
            resize(getCapacity() / 2);
        }
        return result;
    }

    /**
     * 从数组中删除特定元素
     *
     * @param e
     */
    public void removeElement(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                remove(i);
            }
        }
    }

    /**
     * 重新设置数组的大小
     *
     * @param newCapacity
     */
    public void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("array.Array : size is %d,capacity is %d \n", size, getCapacity()));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
