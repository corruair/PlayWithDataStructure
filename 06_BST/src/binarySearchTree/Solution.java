package binarySearchTree;

import java.util.LinkedList;

/**
 * leetcode解题
 */
public class Solution {

    /**
     * 二叉树的深度 leetcode 104
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        return loopDepth(linkedList, 1);
    }

    private int loopDepth(LinkedList<TreeNode> linkedList, int count) {
        if (linkedList.size() <= 0) {
            return count;
        }
        LinkedList<TreeNode> tempList = new LinkedList<>();
        while (linkedList.size() > 0) {
            TreeNode node = linkedList.remove();
            if (null != node.left) {
                tempList.add(node.left);
            }
            if (null != node.right) {
                tempList.add(node.right);
            }
        }
        if (tempList.size() > 0) {
            count++;
            linkedList.addAll(tempList);
        }
        return loopDepth(linkedList, count);
    }

    /**
     * leetcode 700. 二叉搜索树中的搜索
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    /**
     * 翻转一棵二叉树。leetcode 226
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        return root;
    }

    private void invert(TreeNode root) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
