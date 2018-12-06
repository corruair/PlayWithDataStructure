package maxHeap;

/**
 * 最大堆
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(getSize() - 1); i >= 0; i--) {
            siftDown(parent(i));
        }
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public boolean contains(E e) {
        return data.contains(e);
    }

    public E findMax() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("MaxHeap is empty");
        }
        return data.get(0);
    }

    /**
     * 获取给定节点的父节点索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("MaxHeap is empty");
        }
        if (index <= 0 || index >= data.getSize()) {
            throw new IllegalArgumentException("index illegal");
        }
        return (index - 1) / 2;
    }

    /**
     * 获取给定节点的左孩子索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 获取给定节点的右孩子索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 添加元素，添加到数组的尾部，然后执行siftUp上浮操作
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int index) {
        if (index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0) {
            data.swap(index, parent(index));
            siftUp(parent(index));
        }
    }

    /**
     * 取出堆的最大值，即index为0的元素。然后用末尾元素补充，然后执行siftDown下沉操作
     *
     * @return
     */
    public E extractMax() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("MaxHeap is empty");
        }
        E e = data.get(0);
        data.swap(0, data.getSize() - 1);
        data.remove(data.getSize() - 1);
        siftDown(0);
        return e;
    }

    private void siftDown(int index) {
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);
        int i = leftIndex;
        if (leftIndex < data.getSize()) {
            if (rightIndex < data.getSize()) {
                if (data.get(leftIndex).compareTo(data.get(rightIndex)) < 0) {
                    i = rightIndex;
                }
            }
            if (data.get(index).compareTo(data.get(i)) <= 0) {
                data.swap(index, i);
                siftDown(i);
            }
        }
    }

    /**
     * 替换最大元素
     *
     * @param e
     * @return
     */
    public E replaceMax(E e) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("MaxHeap is empty");
        }
        E ret = data.get(0);
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("array.Array : size is %d \n", getSize()));
        sb.append("[");
        for (int i = 0; i < getSize(); i++) {
            sb.append(data.get(i));
            if (i < getSize() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
