package map;

/**
 * 二分搜索树实现 Map映射
 *
 * @param <K>
 * @param <V>
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private int size;
    private Node root;

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (node.key.equals(key)) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }

    }

    @Override
    public void add(K key, V value) {
        add(root, key, value);
    }

    /**
     * @param root
     * @param key
     * @param value
     */
    private Node add(Node root, K key, V value) {
        if (null == root) {
            size++;
            return new Node(key, value);
        }
        if (root.key.compareTo(key) < 0) {
            root.right = add(root.right, key, value);
        } else if (root.key.compareTo(key) > 0) {
            root.left = add(root.right, key, value);
        } else {
            root.value = value;
        }
        return root;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else {
                Node resultNOde = minimum(node.right);
                Node newNode = removeMin(node.right);
                resultNOde.left = node.left;
                resultNOde.right = newNode;
                node = null;
                size--;
                return resultNOde;
            }
        }
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node returnNode = node.right;
            node = null;
            size--;
            return returnNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (null != node) {
            node.value = newValue;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
