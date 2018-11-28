package queue;

public class LinkedListQueue<E> implements Queue<E> {

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

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return 0 == size;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        Node oldHead = head;
        head = head.next;
        if (null == head) {
            tail = null;
        }
        oldHead.next = null;
        size--;
        return oldHead.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedListQueue length:" + getSize() + "\n");
        sb.append("head[");
        Node currentNode = head;
        while (null != currentNode) {
            sb.append(currentNode.e);
            if (null != currentNode.next) {
                sb.append(",");
            }
            currentNode = currentNode.next;
        }
        sb.append("]tail");
        return sb.toString();
    }

}
