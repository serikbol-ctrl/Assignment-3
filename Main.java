public class Main {
    public static void main(String[] args) {

        BST<Integer, String> tree = new BST<>();

        tree.put(5, "A");
        tree.put(3, "B");
        tree.put(7, "C");
        tree.put(2, "D");
        tree.put(4, "E");

        System.out.println("Get 3: " + tree.get(3));

        tree.delete(3);

        // Iterator (in-order)
        for (BST.Entry<Integer, String> elem : tree.iterator()) {
            System.out.println("key is " + elem.getKey() +
                    " and value is " + elem.getValue());
        }

        System.out.println("Size: " + tree.size());
    }
}