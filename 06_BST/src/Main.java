import binarySearchTree.BST;

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Integer[] integers = {12, 15, 7, 36, 9, 11, 20};
        for (Integer num : integers) {
            bst.add(num);
        }

//        bst.inOrder();

        System.out.println();
        bst.inOrderNR();

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


    }

}
