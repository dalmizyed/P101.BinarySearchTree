/*
BinarySearchTree.java

Instantiable binary search tree class for CS 400 @ University of Wisconsin-Madison.
Designed around the provided BinaryNode.java class and SortedCollection.java interface.

K. Almizyed, 01/24/2026
*/

public class BinarySearchTree<T extends Comparable<T>> implements SortedCollection<T> {
    
    protected BinaryNode<T> root = null;

    /**
     * Inserts a new data value into the sorted collection.
     * @param data the new value being inserted
     * @throws NullPointerException if data argument is null, we do not allow
     * null values to be stored within a SortedCollection
     */
    public void insert(T data) throws NullPointerException {
        if (root == null) {
            root = new BinaryNode<T>(data);
        } else {
            BinaryNode<T> newNode = new BinaryNode<T>(data);
            insertHelper(newNode, root);
        }
    }

    /**
     * Performs the naive binary search tree insert algorithm to recursively
     * insert the provided newNode (which has already been initialized with a
     * data value) into the provided tree/subtree. When the provided subtree
     * is null, this method does nothing. 
     */
    protected void insertHelper(BinaryNode<T> newNode, BinaryNode<T> subtree) {
        if (subtree != null) {
            if (newNode.getData().compareTo(subtree.getData()) <= 0) {
                if (subtree.getLeft() == null) {
                    subtree.setLeft(newNode);
                    newNode.setUp(subtree);
                } else {
                    insertHelper(newNode, subtree.getLeft());
                }
            } else {
                if (subtree.getRight() == null) {
                    subtree.setRight(newNode);
                    newNode.setUp(subtree);
                } else {
                    insertHelper(newNode, subtree.getRight());
                }
            }
        }
    }
    
    /**
     * Check whether data is stored in the tree.
     * @param find the value to check for in the collection
     * @return true if the collection contains data one or more times, 
     * and false otherwise
     */
    public boolean contains(Comparable<T> find) {
        if (root == null) {
            return false;
        } else {
            return containsHelper(find, root);
        }
    }

    /**
     * Performs a pre-order traversal to find the Comparable<T> variable provided. If it is found, 
     * then the method returns true, otherwise it will return false. When the provided subtree
     * is null, this method returns false.
     */
    private boolean containsHelper(Comparable<T> find, BinaryNode<T> subtree) {
        if (subtree == null) {
            return false;
        }

        if (find.compareTo(subtree.getData()) == 0)  {
            return true;
        } else {
            if (find.compareTo(subtree.getData()) < 0) {
                return containsHelper(find, subtree.getLeft());
            }
            if (find.compareTo(subtree.getData()) > 0) {
                return containsHelper(find, subtree.getRight());
            }
        }

        return false;
    }

    /**
     * Counts the number of values in the collection, with each duplicate value
     * being counted separately within the value returned.
     * @return the number of values in the collection, including duplicates
     */
    public int size() {
        if (root != null) {
           return sizeHelper(root);
        }
        return 0;
    }

    /**
     * Performs a pre-order traversal, counting each node visited until all subtrees have been visited.
     * @return the total number of nodes from the root node.
     * When the provided subtree is null, this method returns false.
     */
    private int sizeHelper(BinaryNode<T> subtree) {
        if (subtree != null) {
            return sizeHelper(subtree.getLeft()) + sizeHelper(subtree.getRight()) + 1;
        }
        return 0;
    }

    /**
     * Checks if the collection is empty.
     * @return true if the collection contains 0 values, false otherwise
     */
    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            int curSize = size();
            if (curSize == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Clears tree of all nodes by setting root to null.
     * Java garbage collector should delete all other nodes automatically.
     */
    public void clear() {
        root = null;
    }

    //-----------------------------------------------------------------------------------------------------------------------------//
    //                                                          TEST METHODS                                                       //
    //-----------------------------------------------------------------------------------------------------------------------------//

    /**
     * Runs the size() method.
     * Returns true if size() == 9, otherwise returns false.
     */
    public boolean test1() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        int[] data = {50, 30, 70, 40, 10, 60, 20, 55, 65};

        for (int i = 0; i < data.length; i++){
            tree.insert(data[i]);
        }

        if (tree.size() == 9) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Generates a new tree and then clears it using tree.clear().
     * Returns true if tree.isEmpty() == true, otherwise returns false.
     */
    public boolean test2() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        int[] data = {50, 30, 70, 40, 10};

        for (int i = 0; i < data.length; i++){
            tree.insert(data[i]);
        }

        tree.clear();

        return tree.isEmpty();
    }

    /**
     * Generates a new tree and checks to see if the tree contains 20.
     * Returns true if 20 is found, otherwise returns false.
     */
    public boolean test3() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        int[] data = {50, 30, 30, 70, 40, 40, 60, 20, 65};

        for (int i = 0; i < data.length; i++){
            tree.insert(data[i]);
        }

        return tree.contains(20);
    }

    /**
     * Generates a new tree and checks to see if the tree contains "CS400".
     * Returns true if "CS400" is found, otherwise returns false.
     */
    public boolean test4() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();

        String[] data = {"Hello", "world!", "CS400", "testing"};

        for (String curData : data) {
            tree.insert(curData);
        }

        return tree.contains("CS400");
    }

    /**
     * Generates a new tree and checks to see if the tree contains "Uh oh".
     * Returns true if "Uh oh" is found, otherwise returns false.
     */
    public boolean test5() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();

        String[] data = {"Hello", "world!", "CS400", "testing"};

        for (String curData : data) {
            tree.insert(curData);
        }

        return tree.contains("Uh oh");
    }

    /**
     * Generates a new tree and checks to see if the tree contains 50, the root node.
     * Returns true if 50 is found, otherwise returns false.
     */
    public boolean test6() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        int[] data = {50, 30, 70, 60, 20, 65};

        for (int i = 0; i < data.length; i++){
            tree.insert(data[i]);
        }

        return tree.contains(50);
    }

    /**
     * Generates a new tree and checks to see if the tree contains 70, a right child.
     * Returns true if 70 is found, otherwise returns false.
     */
    public boolean test7() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        int[] data = {50, 30, 70};

        for (int i = 0; i < data.length; i++){
            tree.insert(data[i]);
        }

        return tree.contains(70);
    }

    public static void main(String[] args) {
        /** 
         * According to assignment instructions, test methods must be public and non-static
         * so a tree must be instantiated to call them, even though I instantiated the trees for
         * each test method at the beginning of the function body.
        */ 

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        // If tree.size() == 9, then test1 will return true, otherwise it will return false.
        System.out.println("Running test1(), should return true: ");
        System.out.println("Test 1 = " + tree.test1());

        // Empties the tree, then checks if isEmpty() works correctly.
        System.out.println("\nRunning test2(), should return true: ");
        System.out.println("Test 2 = " + tree.test2());

        // Generates a new tree and looks for 20.
        System.out.println("\nRunning test3(), should return true: ");
        System.out.println("Test 3 = " + tree.test3());

        // Generates a new tree and looks for "CS400".
        System.out.println("\nRunning test4(), should return true: ");
        System.out.println("Test 4 = " + tree.test4());

        // Generates a new tree and looks for "Uh oh".
        System.out.println("\nRunning test5(), should return false: ");
        System.out.println("Test 5 = " + tree.test5());

        // Generates a new tree and looks for root node 50.
        System.out.println("\nRunning test6(), should return true: ");
        System.out.println("Test 6 = " + tree.test6());

        // Generates a new tree and looks for right child 70.
        System.out.println("\nRunning test7(), should return true: ");
        System.out.println("Test 7 = " + tree.test7());
    }
}
