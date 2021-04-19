package Chapter1.ArraysAndStrings.Exercise9StringRotation;

public class Solution {
    /**
     * idea: concat string erbottlewaterbottle contains waterbottle => true
     * <br> Time complexity is O(n)
     * @param input1
     * @param input2
     * @return
     */
    private static boolean isRotation(String input1, String input2) {
        if (input1.length() != input2.length()) return false;
        var newLongInput = input1 + input1;
        return newLongInput.contains(input2);
    }

    private static boolean isSubString(String shortInput, String newLongInput) {
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isRotation("erbottlewat", "waterbottle"));
    }
}
