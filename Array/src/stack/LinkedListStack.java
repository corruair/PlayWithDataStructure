package stack;

import linkedList.LinkedList;

public class LinkedListStack<T> implements Stack<T> {

    private LinkedList<T> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public void push(T t) {
        list.addFirst(t);
    }

    @Override
    public void pop() {
        list.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public T peek() {
        return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TOP[");
        for (int i = 0; i < list.getSize(); i++) {
            sb.append(list.get(i));
            if (i < list.getSize() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
