package Chapter1.ArraysAndStrings.Exercise5OneAway;

/**
 * Given two strings, write a function to check if they are one edit awy
 * pale, ple -> true
 * pales, pale -> true
 * pale -> bake -> false
 */
public class Solution {
    private static boolean isOneAway(String source, String target) {
        // edit
        if (Math.abs(source.length() - target.length()) > 1) return false;
        if (source.length() == target.length()) {
            return canEditInOneWay(source, target);
        }

        if (source.length() > target.length())
            return canAddOrReplaceInOneWay(source, target);
        else
            return canAddOrReplaceInOneWay(target, source);
    }

    private static boolean canAddOrReplaceInOneWay(String longerString, String shorterString) {
        for (int i = 0; i < shorterString.length(); i++) {
            if (longerString.charAt(i) != shorterString.charAt(i)) {
                if (shorterString.charAt(i) != longerString.charAt(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean canEditInOneWay(String source, String target) {
        boolean isOneEditing = false;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                if (isOneEditing) {
                    return false;
                } else {
                    isOneEditing = true;
                }
            }
        }
        return true;
    }

    /**
     * Two pointers technique
     */
    private static boolean isOneAwayCleanSolution(String input1, String input2) {
        if (Math.abs(input1.length() - input2.length()) > 1) return false;
        String shorterString = input1.length() < input2.length() ? input1 : input2;
        String longerString = input1.length() < input2.length() ? input2 : input1;
        int index1 = 0, index2 = 0;
        boolean foundDifference = false;
        while (index1 < shorterString.length() && index2 < longerString.length()) {
            if (shorterString.charAt(index1) != longerString.charAt(index2)) {
                if (foundDifference) return false;

                foundDifference = true;
                // insert mode
                if (shorterString.length() < longerString.length()) {
                    index2++;
                }
            }
            index1++;
            index2++;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isOneAwayCleanSolution("bcdefqhjk", "abcdefghjk"));
        System.out.println(isOneAwayCleanSolution("abc", "aaa"));
        System.out.println(isOneAwayCleanSolution("abc", "ebc"));
        System.out.println(isOneAwayCleanSolution("pale", "ple"));
        System.out.println(isOneAwayCleanSolution("pales", "pale"));
        System.out.println(isOneAwayCleanSolution("abc", "defg"));
        System.out.println(isOneAwayCleanSolution("abcd", "bcd"));
        System.out.println(isOneAwayCleanSolution("bcd", "cd"));
    }
}
