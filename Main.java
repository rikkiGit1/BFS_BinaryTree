package BFS;

//Rikki Weinberger - Breadth First search assignment

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        //Default values for testing
        bst.insertIterative(10);
        bst.insertIterative(5);
        bst.insertIterative(15);
        bst.insertIterative(3);
        bst.insertIterative(7);
        bst.insertIterative(13);
        bst.insertIterative(17);

        //performs BFS traversal and prints the result
        System.out.println("BFS Traversal: " + bst.bfsTraversal());

        //uses the BFS iterator
        System.out.print("BFS Iterator: ");
        for (int value : bst) { //iterates over the binary search tree using the BFS iterator
            System.out.print(value + " ");
        }
        System.out.println(); 
    }
}
