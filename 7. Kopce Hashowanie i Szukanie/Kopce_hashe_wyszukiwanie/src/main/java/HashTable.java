import java.util.Arrays;

public class HashTable {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    private Entry[] table;
    private int size;
    private int threshold;
    private double loadFactor;

    public HashTable() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashTable(int capacity, double loadFactor) {
        if (capacity <= 0 || loadFactor <= 0 || Double.isNaN(loadFactor)) {
            throw new IllegalArgumentException();
        }
        this.loadFactor = loadFactor;
        this.threshold = (int) (capacity * loadFactor);
        this.table = new Entry[capacity];
    }

    public void put(int key, String value) {
        if (value == null) {
            throw new NullPointerException();
        }
        if (size >= threshold) {
            resize(2 * table.length);
        }
        int index = hash(key);
        Entry entry = table[index];
        while (entry != null) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }
        table[index] = new Entry(key, value, table[index]);
        size++;
    }

    public String get(int key) {
        int index = hash(key);
        Entry entry = table[index];
        while (entry != null) {
            if (entry.key == key) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public boolean containsKey(int key) {
        int index = hash(key);
        Entry entry = table[index];
        while (entry != null) {
            if (entry.key == key) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void resize(int newCapacity) {
        if (newCapacity > MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }
        Entry[] newTable = new Entry[newCapacity];
        for (int i = 0; i < table.length; i++) {
            Entry entry = table[i];
            while (entry != null) {
                Entry next = entry.next;
                int index = hash(entry.key, newCapacity);
                entry.next = newTable[index];
                newTable[index] = entry;
                entry = next;
            }
        }
        table = newTable;
        threshold = (int) (newCapacity * loadFactor);
    }

    public void dump() {
        for (int i = 0; i < table.length; i++) {
            System.out.print("Bucket " + i + ": ");
            Entry entry = table[i];
            while (entry != null) {
                System.out.print(entry.key + "=" + entry.value + " ");
                entry = entry.next;
            }
            System.out.println();
        }
    }

    private int hash(int key) {
        return hash(key, table.length);
    }

    private int hash(int key, int capacity) {
        // custom hash function
        int hash = key ^ (key >>> 16);
        return (capacity - 1) & hash;
    }

    // Other ways to hash - not actually used in this implementation
    private int linearProbing(int key, int i, int capacity) {
        return (hash(key) + i) % capacity;
    }

    private int quadraticProbing(int key, int i, int capacity) {
        return (hash(key) + i*i) % capacity;
    }

    private int doubleHashing(int key, int i, int capacity) {
        int h1 = hash(key);
        int h2 = 1 + (key % (capacity - 1));
        return (h1 + i * h2) % capacity;
    }
    // ----------------------------------------------------

    private static class Entry {
        int key;
        String value;
        Entry next;

        Entry(int key, String value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}