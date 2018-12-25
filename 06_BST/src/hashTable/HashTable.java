package hashTable;

import java.util.TreeMap;

/**
 * 哈希表
 *
 * @param <K>
 * @param <V>
 */
public class HashTable<K, V> {

    private final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    private TreeMap<K, V>[] treeMap;
    private int size;
    /**
     * M就是数组的长度，也就是计算index时取余的数字
     */
    private int M;

    private static final int capacityIndex = 0;
    private static final int MAX_TOL = 10;
    private static final int MIN_TOL = 2;

    public HashTable() {
        this.M = capacity[capacityIndex];
        treeMap = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            treeMap[i] = new TreeMap<>();
        }
    }


    public int getSize() {
        return size;
    }

    /**
     * 根据key的hashCode获取其应该所在的位置的索引
     *
     * @param key
     * @return
     */
    private int hash(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % M;
    }

    /**
     * 添加元素
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        int index = hash(key);
        TreeMap<K, V> tempTree = treeMap[index];

        if (tempTree.containsKey(key)) {
            tempTree.put(key, value);
        } else {
            tempTree.put(key, value);
            size++;
            //扩容
            if (size >= M * MAX_TOL && capacityIndex + 1 < capacity.length) {
                resize(capacity[capacityIndex + 1]);
            }
        }

    }

    public V remove(K key) {
        int index = hash(key);
        TreeMap<K, V> tempTree = treeMap[index];

        V value = null;
        if (tempTree.containsKey(key)) {
            value = tempTree.remove(key);
            size--;

            if (size <= M * MIN_TOL && capacityIndex - 1 >= 0) {
                resize(capacity[capacityIndex - 1]);
            }
        }
        return value;
    }

    public void set(K key, V value) {
        int index = hash(key);
        TreeMap<K, V> tempTree = treeMap[index];

        if (tempTree.containsKey(key)) {
            tempTree.put(key, value);
        } else {
            throw new IllegalArgumentException("no key");
        }
    }

    public boolean contains(K key) {
        int index = hash(key);
        TreeMap<K, V> tempTree = treeMap[index];
        return tempTree.containsKey(key);
    }

    public V get(K key) {
        return treeMap[hash(key)].get(key);
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newTreeMap = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newTreeMap[i] = new TreeMap<>();
        }

        M = newM;
        for (int i = 0; i < treeMap.length; i++) {
            TreeMap<K, V> temp = treeMap[i];
            for (K key : temp.keySet()) {
                newTreeMap[hash(key)].put(key, temp.get(key));
            }
        }
        this.treeMap = newTreeMap;
    }
}
