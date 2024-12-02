package CompaniesInterview.affirm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortestSubstring {
    public static void main(String[] args) {
//        Input: arr = ["cab","ad","bad","c"]
//        Output: ["ab","","ba",""]
        var arr = new String[]{"fhi","ct","s","o","o"};
        var result = shortestSubstring(arr);
        for (var str : result) {
            System.out.println(str);
        }

//        var substrings = findSubStrings("gfnt");
//        for (var str : substrings) {
//            System.out.println(str);
//        }
    }



    //    You are given an array arr of size n consisting of non-empty strings.
    //    Find a string array answer of size n such that:
    //    answer[i] is the shortest substring
    //    of arr[i] that does not occur as a substring in any other string in arr.
    //    If multiple such substrings exist, answer[i] should be the
    //    lexicographically smallest
    //    And if no such substring exists, answer[i] should be an empty string.
    //    Return the array answer.
    public static String[] shortestSubstring(String[] arr) {
        var result = new ArrayList<String>();
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            String subString = exist(str, arr, i);
            if (subString == null) {
                result.add("");
            } else {
                result.add(subString);
            }
        }
        return result.toArray(new String[0]);

    }

    public static String exist(String str, String[] arr, int index) {
        var result = new ArrayList<String>();
        var shortestStrings = new ArrayList<String>();
        var subStrings = findSubStrings(str);
        for (var string : subStrings) {
            boolean containedByAll = false;
            for (int i = 0; i < arr.length; i++) {
                if (i == index) continue;
                String comparedStr = arr[i];
                if (comparedStr.contains(string)) {
                    containedByAll = true;
                    break;
                }
            }

            if (!containedByAll) {
                result.add(string);
            }
        }

        int minLength = Integer.MAX_VALUE;
        for (String s : result) {
            if (s.length() < minLength) {
                minLength = s.length();
            }
        }

        for (String s : result) {
            if (s.length() == minLength) {
                shortestStrings.add(s);
            }
        }



        if (result.isEmpty()) {
            return null;
        }

        return Collections.min(shortestStrings);
    }

    private static List<String> findSubStrings(String str) {
        var result = new ArrayList<String>();

        for (int i = 0; i < str.length(); i++) {
            result.add(Character.toString(str.charAt(i)));
            for (int j = i+1; j <str.length() ; j++) {
                result.add(str.substring(i, j+1));
            }
        }

        return result;
    }
}
