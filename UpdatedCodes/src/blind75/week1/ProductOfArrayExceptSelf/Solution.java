package blind75.week1.ProductOfArrayExceptSelf;


import java.util.Arrays;

public class Solution {
    // Given an integer array nums, return an array answer
    // such that answer[i] is equal to the product of all the elements of nums except nums[i].
    // You must write an algorithm that runs in O(n) time and without using the division operation.
    // Using the two pointer techniques
    // không được dùng phép chia lol!!!
    public static int[] productExceptSelf(int[] nums) {
        // initialize the result
        int[] result = new int[nums.length];
        for (int i = 0, temp = 1; i < nums.length; i++) {
            result[i] = temp;
            temp *= nums[i];
        }
        for (int i = nums.length - 1, temp = 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }

        return result;
    }


    public static void main(String[] args) {
        var input = new int[] {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(input)));
    }
}
