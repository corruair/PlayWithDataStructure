package binarySearchTree;

/**
 * 二分搜索树
 */
public class BST<T extends Comparable<T>> {
    private class Node {
        private T t;
        private Node left, right;

        public Node(T t) {
            this.t = t;
            left = null;
            right = null;
        }
    }

    private int size;
    private Node root;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素
     *
     * @param t
     */
    public void add(T t) {
        root = add(root, t);
    }

    /**
     * @param root
     * @param t
     */
    private Node add(Node root, T t) {
        if (null == root) {
            size++;
            return new Node(t);
        }
        if (root.t.compareTo(t) < 0) {
            root.right = add(root.right, t);
        } else if (root.t.compareTo(t) > 0) {
            root.left = add(root.left, t);
        }
        return root;
    }

    /**
     * 是否包含
     *
     * @param t
     * @return
     */
    public boolean contains(T t) {
        return contains(root, t);
    }

    private boolean contains(Node node, T t) {
        if (null == node) {
            return false;
        }

        if (t.compareTo(node.t) == 0) {
            return true;
        } else if (t.compareTo(node.t) < 0) {
            contains(node.left, t);
        } else {
            contains(node.right, t);
        }
        return false;
    }

}
