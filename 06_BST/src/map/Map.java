package map;

/**
 * 映射接口定义
 *
 * @param <K>
 * @param <V>
 */
public interface Map<K, V> {
    void add(K key, V value);

    V remove(K key);

    V get(K key);

    void set(K key, V newValue);

    boolean contains(K key);

    int getSize();

    boolean isEmpty();


}
