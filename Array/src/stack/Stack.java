package stack;

public interface Stack<T> {
    void push(T t);

    void pop();

    boolean isEmpty();

    T peek();

    int getSize();
}
