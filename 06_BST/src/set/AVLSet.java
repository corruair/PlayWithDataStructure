package set;

import AVLTree.AVLTree;

public class AVLSet<K extends Comparable<K>> implements Set<K> {

    private AVLTree<K, Object> avlTree;

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }

    @Override
    public void add(K k) {
        avlTree.add(k, null);
    }

    @Override
    public void remove(K k) {
        avlTree.remove(k);
    }

    @Override
    public boolean contains(K k) {
        return avlTree.contains(k);
    }
}
