package map;

public class HashMap<K, V> {


    public HashMap() {

    }

    public static void main(String[] args) {

        System.out.println(8 & 3);
        HashMap<String, String> map = new HashMap<>(10);
        map.put("hello1", "world1");
        map.put("hello2", "world2");
        map.put("hello3", "world3");
        System.out.println(map.get("hello1"));
        System.out.println(map.get("hello2"));
        System.out.println(map.get("hello3"));
        System.out.println(map.get("hello"));
    }


    // 1 question data structure to use
    //
    // 2 question  functions
    //
    // 3 any performance concern  time complicity
    //

    // DEFAULT_INITIAL_CAPACITY = 16
    // and this is the initial bucket size
    public int capacity;

    public Entry<K, V>[] table;


    public HashMap(int capacity) {
        this.capacity = capacity;
        table = new Entry[capacity];
    }

    public V put(K key, V value) {
        //  figure out where to add
        //
        //  get the bucket which contains the entry
        //
        //  take the entry from bucket
        //
        //  if the k exist  replace it
        //
        //  if not, create new entry, append old entry to the new entry,
        //  add new entry in the table
        //


        // 1
        int hash = Math.abs(key.hashCode());
        int index = hash % capacity;

        // 2,3
        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            // ************ NOTICE**********
            // The condition here should be
            // 	1 hashCode equal
            // 	  AND
            // 	2 equal method or == tree
            // ************ NOTICE**********

            // step 4
            Object k;
            if (e.key.hashCode() == hash && ((k = e.key) == key || key.equals(k))) {
                V old = e.value;
                e.value = value;
                // dont do add entry here
                // addEntry(k, v, index, e);
                return old;
            }
        }
        /*(green) if k not exist , then cannot found in the previous for loop,
            then create new entry here, table [index] would be the new entry, old
            entry append to new Entry*/
        Entry<K, V> e = table[index];
        table[index] = new Entry<>(key, value, hash, e);
        return null;
    }


    public static class Entry<K, V> {

        public K key;

        public V value;

        Entry<K, V> next;

        // use final here  so the hash won't change
        final int hash;

        public Entry(K k, V v, int hash, Entry<K, V> next) {
            this.key = k;
            this.value = v;
            this.hash = hash;
            this.next = next;
        }
    }

    // the type of key here is Object
    public V get(Object key) {

        // find the index or the location
        //
        // retrieve the bucket
        //
        // get the entry from bucket
        //
        int hash = Math.abs(key.hashCode());
        int index = hash % capacity;
        for (Entry<K, V> e = table[index]; e != null; e = e.next) { //这个 地方其实相当于一个while loop
            Object k;
            // can not use key.hashCode() here ?
            if ((e.hash == hash) && ((k = e.key) == key || key.equals(e.key))) {
                return e.value;
            }
        }
        return null;
    }


}
