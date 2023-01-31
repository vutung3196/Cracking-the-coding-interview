package CompaniesInterview.drw.minimumexcludedpositivenumber;

public class Solution {
    public static void main(String[] args) {

    }

    // Given an array A and B of the same length, we have to create an array C, C[i] can be either A[i] or B[i],
    // such that the MEX (Minimum Excluded Positive Integer) of C is minimized.
    // Return the MEX of C.
    // Example:
    // A = [1, 2, 3, 4, 5]
    // B = [2, 3, 4, 5, 6]
    // C = [1, 2, 3, 4, 5]
    // MEX of C = 6
    // Output: 6
    // Constraints:
    // 1 <= A.length <= 1e6
    // 1 <= A[i] <= 1e9
    // 1 <= B[i] <= 1e9
    // A and B have the same length.
    public static int findMexOfC(int[] A, int[] B) {
        int mex = 1;
        int N = A.length;
        boolean[] has = new boolean[N + 2];
        for (int i = 0; i < N; i++) {
            if (A[i] == B[i]) {
                has[A[i]] = true;
            }
        }

        for (int ans = 1; true; ++ans)
            if (has[ans] != true) {
                return ans;
            }
    }


        // next


//        Set<Integer> set = new HashSet<>();
//        for (int a : A) {
//            if (a > 0) {
//                set.add(a);
//            }
//        }
//        for (int i = 1; i <= N + 1; i++) {
//            if (!set.contains(i)) {
//                return i;
//            }
//        }
//        return -1;
}
