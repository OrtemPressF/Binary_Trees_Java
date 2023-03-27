import java.util.LinkedList;

public class HashTable {

    public static class HTObject {
        public String key;
        public Integer value;
    }

    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.70f;

    private LinkedList<HTObject>[] table;
    private int capacity;
    private int size;
    private float loadFactor;

    public HashTable() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashTable(int initialCapacity, float loadFactor) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Invalid initial capacity: " + initialCapacity);
        }

        if (loadFactor <= 0 || loadFactor >= 1) {
            throw new IllegalArgumentException("Invalid load factor: " + loadFactor);
        }

        this.capacity = initialCapacity;
        this.loadFactor = loadFactor;
        this.size = 0;
        this.table = new LinkedList[capacity];
    }

    private int getIndex(String key) {
        int hashCode = key.hashCode();
        return hashCode % capacity;
    }

    public Integer get(String key) {
        LinkedList<HTObject> bucket = table[getIndex(key)];
        if (bucket == null) {
            return null;
        }
        for (HTObject obj : bucket) {
            if (obj.key.equals(key)) {
                return obj.value;
            }
        }
        return null;
    }

    public void put(String key, Integer value) {
        int index = getIndex(key);

        LinkedList<HTObject> bucket = table[index];
        if (bucket == null) {
            bucket = new LinkedList<>();
            table[index] = bucket;
        }

        for (HTObject obj : bucket) {
            if (obj.key.equals(key)) {
                throw new IllegalArgumentException("Key already exists: " + key);
            }
        }

        HTObject obj = new HTObject();
        obj.key = key;
        obj.value = value;
        bucket.add(obj);

        size++;

        if ((float) size / capacity > loadFactor) {
            resize(capacity * 2);
        }
    }

    public void delete(HashTable value, String key) {
        int index = getIndex(key);

        LinkedList<HTObject> bucket = table[index];
        if (bucket == null) {
            return;
        }

        for (HTObject obj : bucket) {
            if (obj.key.equals(key)) {
                bucket.remove(obj);
                size--;
                return;
            }
        }
    }

    public void resize(int newCapacity) {
        LinkedList<HTObject>[] newTable = new LinkedList[newCapacity];
        for (LinkedList<HTObject> bucket : table) {
            if (bucket != null) {
                for (HTObject obj : bucket) {
                    int newIndex = getIndex(obj.key);
                    LinkedList<HTObject> newBucket = newTable[newIndex];
                    if (newBucket == null) {
                        newBucket = new LinkedList<>();
                        newTable[newIndex] = newBucket;
                    }
                    newBucket.add(obj);
                }
            }
        }
        this.capacity = newCapacity;
        this.table = newTable;
    }

    public String[] keys() {
        String[] keys = new String[size];
        int i = 0;
        for (LinkedList<HTObject> bucket : table) {
            if (bucket != null) {
                for (HTObject obj : bucket) {
                    keys[i++] = obj.key;
                }
            }
        }
        return keys;
    }
}
