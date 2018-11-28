package linkedList;

/**
 * 链表
 */
public class LinkedList<E> {

    private int size;
    private Node dummyHead;

    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

    }

    public LinkedList() {
        size = 0;
        dummyHead = new Node();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    /**
     * 向index位置添加数据
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index illegal");
        }
        Node targetNode = dummyHead;
        for (int i = 0; i < index; i++) {
            targetNode = targetNode.next;
        }
        Node sourceNode = new Node(e);
        sourceNode.next = targetNode.next;
        targetNode.next = sourceNode;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 查找index处的元素
     *
     * @param index 位置索引
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("size illegal");
        }
        Node currentNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * 是否包含
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        if (null == e) {
            throw new IllegalArgumentException("e is null");
        }
        Node currentNode = dummyHead.next;
        for (int i = 0; i < size - 1; i++) {
            currentNode = currentNode.next;
            if (e == currentNode.e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除index位置的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        Node preNode = dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        Node delNode = preNode.next;
        preNode.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 修改
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("index illegal");
        }
        Node currentNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.e = e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (null != node) {
                sb.append(node.e);
                if (i < size - 1) {
                    sb.append("->");
                    node = node.next;
                }
            }
        }
        sb.append("->NULL");
        return sb.toString();
    }
}
