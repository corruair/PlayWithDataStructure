package set;

/**
 * 集合接口声明
 *
 * @param <E>
 */
public interface Set<E> {

    int getSize();

    boolean isEmpty();

    void add(E e);

    void remove(E e);

    boolean contains(E e);

}
