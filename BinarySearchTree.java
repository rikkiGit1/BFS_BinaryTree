package BFS;
import java.util.*;

//Rikki Weinberger - Binary Search Tree Class

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {
    private BNode<T> root; //root node of the BST

    /**
     * Method inserts a value into the BST iteratively
     * @param value Value to insert
     */
    public void insertIterative(T value) {
        if (root == null) { //if the tree is empty
            root = new BNode<>(value); //a new root node is created
            return;
        }

        BNode<T> current = root; //starts traversal from the root
        
        //loop that runs until the node is inserted
        while (true) { 
            if (value.compareTo(current.getData()) < 0) { //if value is smaller than the node value, it goes to the left
                if (current.getLC() == null) { //if the left child is null 
                    current.setLC(new BNode<>(value)); //new node created and inserted
                    return; //exits the loop once node is created and inserted
                }
                current = current.getLC(); //otherwise, moves left and continues searching
            } 
            //otherwise, if value is greater or equal than the node value, it goes to the right
            else { 
                if (current.getRC() == null) { //if the right child is null
                    current.setRC(new BNode<>(value)); //a new node created and inserted
                    return; //exits the loop once node is created and inserted
                }
                current = current.getRC(); //otherwise, moves right and continues searching
            }
        }
    }

    /**
     * Method inserts a value into the BST recursively
     * @param value Value to insert
     */
    public void insertRecursive(T value) {
        root = insertRec(root, value); //calls helper method to insert recursively, passing in the initially the root and value 
    }

    private BNode<T> insertRec(BNode<T> node, T value) {
        if (node == null) { //base case: if node is null, and insertion point is found
        	return new BNode<>(value); //a new node is created and returned
        }

        if (value.compareTo(node.getData()) < 0) { //if the value is smaller than the node value, it goes to the left
            node.setLC(insertRec(node.getLC(), value)); //calls insertRec recursively with next left child
        } 
        //otherwise, if value is greater or equal than the node value, it goes to the right
        else { 
            node.setRC(insertRec(node.getRC(), value)); //calls insertRec recursively with next right child
        }
        return node; //returns the modified node to ensure parent node is linked to it
    }

    /**
     * Method performs breadth first search traversal on the BST
     * @return List of nodes in BFS order
     */
    public ArrayList<T> bfsTraversal() {
        ArrayList<T> result = new ArrayList<>(); //arraylist stores BFS output
        if (root == null) { //if the tree is empty
        	return result; //returns the empty list 
        }

        Queue<BNode<T>> queue = new LinkedList<>(); //queue for BFS traversal
        queue.offer(root); //adds root to the queue

        while (!queue.isEmpty()) { //while queue is not empty
            BNode<T> current = queue.poll(); //dequeues front node
            result.add(current.getData()); //adds node's value to result list

            if (current.getLC() != null) { //if the left child exists
            	queue.offer(current.getLC()); //enqueues left child 
            }
            
            if (current.getRC() != null) { //if the right child exists
            	queue.offer(current.getRC()); //enqueues right child 
            }
        }

        return result; //returns BFS traversal result
    }

    /**
     * BFS iterator implementation
     * @return Iterator for BFS traversal
     */
    @Override
    public Iterator<T> iterator() {
        return new BFSIterator(root); //returns the BFS iterator
    }

    /**
     * Inner class to implement the BFS iterator
     */
    private class BFSIterator implements Iterator<T> {
        private final Queue<BNode<T>> queue = new ArrayDeque<>(); //queue to store nodes for BFS

        /**
         * constructor adds the node passed in to the queue
         * @param root
         */
        public BFSIterator(BNode<T> root) {
            if (root != null) { //if the tree is not empty
            	queue.offer(root); //root added to queue
            }
        }

        /**
         * Method checks if there is another element to iterate over 
         */
        @Override
        public boolean hasNext() {
            return !queue.isEmpty(); //returns true if queue is not empty
        }

        /**
         * Method returns the next element iterated over 
         */
        @Override
        public T next() {
            if (!hasNext()) { //if no more elements 
            	throw new NoSuchElementException(); //throws exception if no elements left
            }
            BNode<T> node = queue.poll(); //dequeues front node

            if (node.getLC() != null) { //if the left child exists
            	queue.offer(node.getLC()); //enqueues left child
            }
            if (node.getRC() != null) { //if the right child exists
            	queue.offer(node.getRC()); //enqueues right child 
            }
            return node.getData(); //returns the node's value
        }
    }
}

