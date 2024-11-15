package neetcode150.twopointers.twosumwithsorted;

public class TwoSumWithSorted {
    public static void main(String[] args) {
        var obj = new TwoSumWithSorted();
        var result = obj.twoSum(new int[] {-1, 0}, -1);
        System.out.println(result[0] + " " + result[1]);
    }

    public int[] twoSum(int[] members, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = members.length - 1;

        while (left < right) {
            var currentSum = members[left] + members[right];
            if (currentSum == target) {
                left++;
                right++;
                break;
            }

            if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }

        result[0] = left;
        result[1] = right;
        return result;
    }
}
