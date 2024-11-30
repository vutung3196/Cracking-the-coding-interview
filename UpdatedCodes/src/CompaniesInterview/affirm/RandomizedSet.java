package CompaniesInterview.affirm;

import java.util.*;

class RandomizedSet {
    private final Map<Integer, Integer> valueToIndex;
    private final   List<Integer> list;
    Random rand = new Random();

    public RandomizedSet() {
        valueToIndex = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (valueToIndex.containsKey(val)) return false;
        valueToIndex.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (valueToIndex.containsKey(val)) {
            int lastElement = list.get(list.size() - 1);
            int idx = valueToIndex.get(val);
            // move to the last index
            list.set(idx, lastElement);
            valueToIndex.put(lastElement, idx);
            list.remove(list.size() - 1);
            valueToIndex.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */