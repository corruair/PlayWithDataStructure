package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.t);
        if (null != node.left) {
            preOrder(node.left);
        }
        if (null != node.right) {
            preOrder(node.right);
        }
    }

    /**
     * 前序遍历非递归实现
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        if (null == root) {
            return;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.t);
            if (null != cur.right) {
                stack.push(cur.right);
            }
            if (null != cur.left) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inorder(root);
    }

    private void inorder(Node node) {
        if (null == node) {
            return;
        }
        inorder(node.left);
        System.out.println(node.t);
        inorder(node.right);
    }

    /**
     * 中序遍历非递归实现
     */
    public void inOrderNR() {
        Stack<Node> stack = new Stack<>();
        if (null == root) {
            return;
        }
        stack.push(root);
        if (null != root.left) {
            pushLeft(stack, root);
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.t);
            if (null != node.right) {
                stack.push(node.right);
                pushLeft(stack, node.right);
            }
        }
    }

    private void pushLeft(Stack<Node> stack, Node node) {
        while (null != node.left) {
            stack.push(node.left);
            node = node.left;
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (null == node) {
            return;
        }
        inorder(node.left);
        System.out.println(node.t);
        inorder(node.right);
    }

    /**
     * 广度优先遍历
     */
    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println(node.t);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 获取最小元素
     *
     * @return
     */
    public T minimum() {
        if (root == null) {
            throw new IllegalArgumentException("BST is empty");
        }

//        Node cur = root;
//        while (cur.left != null) {
//            cur = cur.left;
//        }
//        return cur.t;

        return minimum(root).t;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 获取最大元素
     *
     * @return
     */
    public T maximum() {
        if (root == null) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.t;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node);
    }

    /**
     * 删除最小元素
     *
     * @return
     */
    public T removeMin() {
        if (root == null) {
            throw new IllegalArgumentException("BST is empty");
        }
        T t = minimum();
        root = removeMin(root);
        return t;
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

    /**
     * 删除最大元素
     *
     * @return
     */
    public T removeMax() {
        if (root == null) {
            throw new IllegalArgumentException("BST is empty");
        }
        T t = maximum();
        root = removeMax(root);
        return t;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node returnNode = node.left;
            node = null;
            size--;
            return returnNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除任意元素
     *
     * @param t
     */
    public void remove(T t) {
        root = remove(root, t);
    }

    private Node remove(Node node, T t) {
        if (node == null) {
            return null;
        }
        if (t.compareTo(node.t) < 0) {
            node.left = remove(node.left, t);
            return node;
        } else if (t.compareTo(node.t) > 0) {
            node.right = remove(node.right, t);
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

}
