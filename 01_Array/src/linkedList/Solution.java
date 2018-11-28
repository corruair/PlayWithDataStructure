package linkedList;

public class Solution {

    public ListNode removeElements(ListNode head, int val) {

//        ListNode dummyNode = new ListNode(-1);
//        dummyNode.next = head;
//        ListNode currentNode = dummyNode;
//
//        while (null != currentNode.next) {
//            if (currentNode.next.val == val) {
//                currentNode.next = currentNode.next.next;
//            } else {
//                currentNode = currentNode.next;
//            }
//        }
//        return dummyNode.next;

        while (head != null) {
            if (head.val == val) {
                head = head.next;
            } else {
                break;
            }
        }

        if (head == null) {
            return head;
        }

        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * leetcode 237
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


}
