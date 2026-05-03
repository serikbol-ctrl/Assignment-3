public class Main {
    public static void main(String[] args) {

        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>(11);

        for (int i = 0; i < 10000; i++) {
            table.put(new MyTestingClass(i), i);
        }

        table.printBucketSizes();

        System.out.println("Get key 50: " + table.get(new MyTestingClass(50)));
        System.out.println("Contains value 9999: " + table.contains(9999));
    }
}

