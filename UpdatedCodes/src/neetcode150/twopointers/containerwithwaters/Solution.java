package neetcode150.twopointers.containerwithwaters;

public class Solution {
    public static void main(String[] args) {
        var obj = new Solution();
        var result = obj.maxAreaOptimized(new int[] {1,8,6,2,5,4,8,3,7});
        System.out.println(result);
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                var curr = 0;
                curr = height[i] <= height[j] ? height[i] * (j - i) : height[j] * (j - i);
                maxArea = Math.max(curr, maxArea);
            }
        }
        return maxArea;
    }


    public int maxAreaOptimized(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left <= right) {
            var curr = 0;
            curr = height[left] <= height[right] ? height[left] * (right - left) : height[right] * (right - left);
            maxArea = Math.max(curr, maxArea);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
