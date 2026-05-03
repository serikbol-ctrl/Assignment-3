class MyHashTable<K, V> {

    // Node class
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11; // bucket саны
    private int size;

    // Default constructor
    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }

    // Custom size constructor
    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }

    // Hash function
    private int hash(K key) {
        return Math.abs(key.hashCode()) % M;
    }

    // Put method
    public void put(K key, V value) {
        int index = hash(key);

        HashNode<K, V> head = chainArray[index];

        // Егер key бар болса → update
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Жаңа node қосу (head-қа)
        size++;
        head = chainArray[index];
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        chainArray[index] = newNode;
    }

    // Get method
    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    // Remove method
    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];
        HashNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                size--;

                if (prev != null) {
                    prev.next = head.next;
                } else {
                    chainArray[index] = head.next;
                }

                return head.value;
            }

            prev = head;
            head = head.next;
        }

        return null;
    }

    // Contains value
    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> head = chainArray[i];

            while (head != null) {
                if (head.value.equals(value)) {
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }

    // Get key by value
    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> head = chainArray[i];

            while (head != null) {
                if (head.value.equals(value)) {
                    return head.key;
                }
                head = head.next;
            }
        }
        return null;
    }

    // Bucket sizes (for testing)
    public void printBucketSizes() {
        for (int i = 0; i < M; i++) {
            int count = 0;
            HashNode<K, V> head = chainArray[i];

            while (head != null) {
                count++;
                head = head.next;
            }

            System.out.println("Bucket " + i + ": " + count);
        }
    }
}