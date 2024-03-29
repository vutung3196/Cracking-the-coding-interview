package LeetCodeTopics.TwoPointers.RunningFromBothEnds;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] indice = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int v = numbers[left] + numbers[right];
            if (v == target) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            } else if (v > target) {
                right--;
            } else {
                left++;
            }
        }

        var a = new ArrayList<Integer>();

        return indice;
    }


    public static void main(String[] args) {
        List<String> list = List.of("one", "two", "three");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
