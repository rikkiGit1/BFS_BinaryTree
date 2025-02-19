package BFS;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

//Rikki Weinberger - BFS Assignment 

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst; 

    /**
     * Setup method that runs before each test
     */
    @BeforeEach
    public void setUp() {
        bst = new BinarySearchTree<>(); 
    }

    /**
     * Tests insertion using the iterative method
     */
    @Test
    public void testInsertionIterative() {
        bst.insertIterative(10);
        bst.insertIterative(5);
        bst.insertIterative(15);
        bst.insertIterative(3);
        bst.insertIterative(7);
        bst.insertIterative(13);
        bst.insertIterative(17);

        Iterator<Integer> iterator = bst.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next());
        assertEquals(5, iterator.next());
        assertEquals(15, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(7, iterator.next());
        assertEquals(13, iterator.next());
        assertEquals(17, iterator.next());
        assertFalse(iterator.hasNext());
    }

    /**
     * Tests insertion using the recursive method
     */
    @Test
    public void testInsertionRecursive() {
        bst.insertRecursive(10);
        bst.insertRecursive(5);
        bst.insertRecursive(15);
        bst.insertRecursive(3);
        bst.insertRecursive(7);
        bst.insertRecursive(13);
        bst.insertRecursive(17);

        Iterator<Integer> iterator = bst.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next());
        assertEquals(5, iterator.next());
        assertEquals(15, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(7, iterator.next());
        assertEquals(13, iterator.next());
        assertEquals(17, iterator.next());
        assertFalse(iterator.hasNext());
    }

    /**
     * Tests BFS iterator to ensure it correctly returns elements in BFS order
     */
    @Test
    public void testBFSIterator() {
        bst.insertIterative(10);
        bst.insertIterative(5);
        bst.insertIterative(15);
        bst.insertIterative(3);
        bst.insertIterative(7);
        bst.insertIterative(13);
        bst.insertIterative(17);

        Iterator<Integer> iterator = bst.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next());
        assertEquals(5, iterator.next());
        assertEquals(15, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(7, iterator.next());
        assertEquals(13, iterator.next());
        assertEquals(17, iterator.next());
        assertFalse(iterator.hasNext());
    }
    
    /**
     * Tests the BFS Traversal method 
     */
    @Test
    public void testBfsTraversal() {
        bst.insertIterative(10);
        bst.insertIterative(5);
        bst.insertIterative(15);
        bst.insertIterative(3);
        bst.insertIterative(7);
        bst.insertIterative(13);
        bst.insertIterative(17);

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(10, 5, 15, 3, 7, 13, 17));
        assertEquals(expected, bst.bfsTraversal());
    }
}


