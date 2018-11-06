/**
 * 自定义数组
 *
 * @author fty
 */
public class Array {

    private int[] array;
    private int size;

    public Array() {
        array = new int[10];
    }

    public Array(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return array.length;
    }

    public boolean isEmpty() {
        return array.length == 0;
    }

    /**
     * 向数组的最后一个位置插入一个元素
     *
     * @param e
     */
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 向第一个位置添加特定的元素
     *
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 向数组的特定位置添加特定的元素
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size >= getCapacity()) {
            throw new IllegalArgumentException("add failed,array is full");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed,index must > 0 and < size");
        }
        for (int i = size; i > index; i--) {
            array[size] = array[size - 1];
        }
        array[index] = e;
    }
}
