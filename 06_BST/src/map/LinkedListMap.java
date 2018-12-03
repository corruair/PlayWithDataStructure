package map;

/**
 * LinkedList链表实现 Map映射
 *
 * @param <K>
 * @param <V>
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private int size;
    private Node dummyHead;

    private class Node {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }

    }

    private Node getNode(K key) {
        Node current = dummyHead;
        while (current.next != null) {
            if (current.next.key.equals(key)) {
                return current.next;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (null == node) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node cur = dummyHead;
        Node preNode = null;
        while (cur != null) {
            if (cur.next != null && cur.next.key.equals(key)) {
                preNode = cur;
                break;
            }
            cur = cur.next;
        }

        if (null != preNode) {
            Node delNode = preNode.next;
            preNode.next = preNode.next.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return null == node ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {

    }

    @Override
    public boolean contains(K key) {
        return getNode(key) == null ? false : true;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return 0 == size;
    }
}
