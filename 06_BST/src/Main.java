import AVLTree.AVLTree;

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

//        Solution solution = new Solution();
//        String str = solution.frequencySort("tree");
//        System.out.println(str);

//        Integer[] array = new Integer[]{1, 2, 3, -1, -2, -3};
//        SegmentTree<Integer> segmentTree = new SegmentTree<Integer>(array, (a, b) -> a + b);
//        System.out.println(segmentTree.query(0, 5));

//        Trie trie = new Trie();
//        trie.add("face");
//        trie.add("fuck");
//        trie.add("panda");
//        trie.add("pan");
//        System.out.println(trie.isPreFix("panZ"));

        AVLTree<Integer,Integer> avlTree = new AVLTree<Integer, Integer>();
        avlTree.add(23,1);
        avlTree.add(20,1);
        avlTree.add(29,1);
        avlTree.add(14,1);
        avlTree.add(17,1);
        avlTree.add(55,1);
        avlTree.add(30,1);
        avlTree.add(9,1);
        avlTree.add(69,1);
        System.out.println(avlTree.isBST());
        System.out.println(avlTree.isBalanced());

    }

}
