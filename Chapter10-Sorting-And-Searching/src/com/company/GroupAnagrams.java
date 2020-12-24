package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] listString = new String[] {"abc", "def", "acb", "fed"};
        var result = sortAnagramUsingHashMap(listString);
        for(List<String> s : result) {
            for(String i : s) {
                System.out.println(i);
            }
        }
    }

    public static List<List<String>> sortAnagramUsingHashMap(String[] strs) {
        // Using sorted strings
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, List<String>> ans = new HashMap<>();
        for(String str: strs) {
            // process string before comparing in HashMap
            // code
            var charArray = str.toCharArray();
            Arrays.sort(charArray);
            var comparedString = new String(charArray);
            if(!ans.containsKey(comparedString)) {
                ans.put(comparedString, new ArrayList<>());
            }
            ans.get(comparedString).add(str);
        }

        return new ArrayList<>(ans.values());
    }

}
