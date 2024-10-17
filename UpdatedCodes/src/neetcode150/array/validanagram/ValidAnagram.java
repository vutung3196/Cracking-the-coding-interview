package neetcode150.array.validanagram;

import java.util.*;

public class ValidAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        // hashtable: key: string, values: all its anagrams.
        var keyAndAnagrams = new HashMap<String, List<String>>();
        for (var str : strs) {
            var a = str.toCharArray();
            Arrays.sort(a);
            var sortedString = new String(a);
            var currentSet = keyAndAnagrams.getOrDefault(sortedString, new ArrayList<String>());
            currentSet.add(str);
            keyAndAnagrams.put(sortedString, currentSet);
        }

        var result = new ArrayList<List<String>>();
        for (var list : keyAndAnagrams.values()) {
            var curr = new ArrayList<String>();
            for (var element : list) {
                curr.add(element);
            }

            result.add(curr);
        }

        return result;
    }
}
