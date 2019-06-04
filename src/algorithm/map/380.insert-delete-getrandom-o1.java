package algorithm.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


class InsertDeleteGetRandomO1 {

    Map<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandomO1() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        if (index < list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(index, last);
            map.put(last, index);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        //todo  just use some random number
        return 0;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
