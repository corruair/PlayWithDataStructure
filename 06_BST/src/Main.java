import binarySearchTree.BST;
import maxHeap.MaxHeap;

import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        BST<Integer> bst = new BST<>();
//        Integer[] integers = {12, 15, 7, 36, 9, 11, 20};
//        for (Integer num : integers) {
//            bst.add(num);
//        }

//        bst.inOrder();
//
//        System.out.println();
//        bst.inOrderNR();

//        bst.levelOrder();

//        System.out.println(bst.minimum());

//        bst.removeMin();
//
//        System.out.println();
//        bst.inOrderNR();

//        bst.removeMax();
//
//        System.out.println();
//        bst.inOrderNR();

//        bst.remove(36);
//        System.out.println();
//        bst.inOrderNR();

//        LinkedList<Integer> linkedList = new LinkedList<>();
//        MaxHeap<Integer> maxHeap = new MaxHeap<>();
//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            maxHeap.add(random.nextInt(100));
//        }
//        for (int i = 0; i < 10; i++) {
//            linkedList.add(maxHeap.extractMax());
//        }
//        for (int i = 0; i < linkedList.size() - 1; i++) {
//            if (linkedList.get(i) < linkedList.get(i + 1)) {
//                System.out.println("fail");
//            }
//        }
//        System.out.println(maxHeap.toString());
//
//        maxHeap.replaceMax(5);
//        System.out.println(maxHeap.toString());

        Solution solution = new Solution();
        String str = solution.frequencySort("tree");
        System.out.println(str);
    }

}
