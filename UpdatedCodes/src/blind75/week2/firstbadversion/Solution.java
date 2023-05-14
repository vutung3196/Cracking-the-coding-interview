package blind75.week2.firstbadversion;

public class Solution {
    public static void main(String[] args) {

    }

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            // avoid overflow: don't use (low + high) / 2
            var mid = low + (high - low) / 2;
            if (isBadVersion(mid) == false) {
                low = mid+1;
            } else if (isBadVersion(mid)) {
                high = mid;
            }
        }
        return low;
    }

    private boolean isBadVersion(int n) {
        return true;
    }
}
