package neetcode150.array.containsduplicates;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {

    }


    public boolean containsDuplicate(int[] nums) {
        var containKey = new HashSet<Integer>();
        for (var num : nums) {
            if (containKey.contains(num)) {
                return true;
            }

            containKey.add(num);
        }

        return false;
    }
}
