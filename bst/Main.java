package bst;

public class Main {
    
    public static void main(String[] args) {
        
       /*  BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        System.out.println(bst.root.right.right.value);
        System.out.println(bst.contains(4)); // true
        System.out.println(bst.contains(10)); // false 
        System.out.println(bst.breadthFirstSearch()); // [5, 3, 7, 2, 4, 6, 8]*/

        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
        bst2.insert(47);
        bst2.insert(21);
        bst2.insert(76);
        bst2.insert(18);
        bst2.insert(27);
        bst2.insert(52);
        bst2.insert(82);

        //System.out.println(bst2.depthFirstSearchPreOrder()); // [47, 21, 18, 27, 76, 52, 82]
        System.out.println(bst2.depthFirstSearchInOrder()); // [18, 21, 27, 47, 52, 76, 82]

        
    }
}
