package set;

public class LinkListSet<E> implements Set<E> {

    private LinkedList<E> linkedList;

    public LinkListSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void add(E e) {
        if (!linkedList.contains(e)) {
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        linkedList.removeElements(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }
}
