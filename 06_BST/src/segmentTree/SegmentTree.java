package segmentTree;

/**
 * 数组实现线段树
 *
 * @param <E>
 */
public class SegmentTree<E> {

    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] array, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }
        tree = (E[]) new Object[array.length * 4];

        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在index的位置表示[left...right]区间的线段树
     *
     * @param index
     * @param left
     * @param right
     */
    private void buildSegmentTree(int index, int left, int right) {
        if (left == right) {
            tree[index] = data[left];
            return;
        }
        int middle = left + (right - left) / 2;
        buildSegmentTree(leftChild(index), left, middle);
        buildSegmentTree(rightChild(index), middle + 1, right);

        tree[index] = merger.merge(tree[leftChild(index)], tree[rightChild(index)]);
    }

    public int getSize() {
        return data.length;
    }

    public boolean isEmpty() {
        return data.length == 0;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 查询[leftTarget,rightTarget]区间内的线段树的值
     *
     * @param leftTarget
     * @param rightTarget
     * @return
     */
    public E query(int leftTarget, int rightTarget) {
        if (leftTarget < 0 || leftTarget >= data.length || rightTarget < 0 || rightTarget >= data.length || leftTarget > rightTarget) {
            throw new IllegalArgumentException("error");
        }

        return query(0, 0, data.length - 1, leftTarget, rightTarget);

    }

    /**
     * 查询指定线段的值
     *
     * @param treeIndex   当前树节点的索引
     * @param leftIndex   当前树节点对应的线段起点索引
     * @param rightIndex  当前树节点对应的线段终点索引
     * @param leftTarget  需要查询的线段起点
     * @param rightTarget 需要查询的线段终点
     * @return
     */
    private E query(int treeIndex, int leftIndex, int rightIndex, int leftTarget, int rightTarget) {
        if (leftIndex == leftTarget && rightIndex == rightTarget) {
            return tree[treeIndex];
        }
        int middle = leftIndex + (rightIndex - leftIndex) / 2;
        if (leftTarget > middle) {
            return query(rightChild(treeIndex), middle + 1, rightIndex, leftTarget, rightTarget);
        } else if (rightTarget <= middle) {
            return query(leftChild(treeIndex), leftIndex, middle, leftTarget, rightTarget);
        } else {
            E e1 = query(leftChild(treeIndex), leftIndex, middle, leftTarget, middle);
            E e2 = query(rightChild(treeIndex), middle + 1, rightIndex, middle + 1, rightTarget);
            return merger.merge(e1, e2);
        }
    }

    public void set(int index, E e) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("index illegal");
        }

        data[index] = e;
        set(0, 0, getSize() - 1, index, e);

    }

    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);
        int middle = l + (r - l) / 2;

        if (index <= middle) {
            set(leftIndex, l, middle, index, e);
        } else {
            set(rightIndex, middle + 1, r, index, e);
        }

        tree[treeIndex] = merger.merge(tree[leftIndex], tree[rightIndex]);


    }

}
