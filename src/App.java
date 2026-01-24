public class App {
    public static void main(String[] args) throws Exception {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        System.out.println("Tree created.");
        System.out.println("");
        System.out.println("Checking to see if tree is empty");
        System.out.println("IsEmpty: " + String.valueOf(tree.isEmpty()));
        System.out.println("Size: " + tree.size() + ", should be 0.");
        System.out.println("");
        System.out.println("Adding values to tree...");

        tree.insert(50);
        System.out.println("Adding 50");
        tree.insert(30);
        System.out.println("Adding 30");
        tree.insert(70);
        System.out.println("Adding 70");
        tree.insert(10);
        System.out.println("Adding 10");
        tree.insert(20);
        System.out.println("Adding 20");
        tree.insert(40);
        System.out.println("Adding 40");
        tree.insert(60);
        System.out.println("Adding 60");
        tree.insert(55);
        System.out.println("Adding 55");
        tree.insert(65);
        System.out.println("Adding 65");

        System.out.println("Tree completed.");
        System.out.println("");
        System.out.println("Checking to see if tree contains values");
        System.out.println("Contains 50: " + String.valueOf(tree.contains(50)));
        System.out.println("Contains 33: " + String.valueOf(tree.contains(33)));
        System.out.println("Contains 55: " + String.valueOf(tree.contains(55)));
        System.out.println("Contains 70: " + String.valueOf(tree.contains(70)));
        System.out.println("");
        System.out.println("Checking to see if tree is correct size");
        System.out.println("Size: " + tree.size() + ", should be 9.");
        System.out.println("");
        System.out.println("Clearing tree...");
        tree.clear();
        System.out.println("Tree cleared!");
        System.out.println("");
        System.out.println("Checking to see if tree is empty");
        System.out.println("IsEmpty: " + String.valueOf(tree.isEmpty()));
        System.out.println("Size: " + tree.size() + ", should be 0.");

    }
}
