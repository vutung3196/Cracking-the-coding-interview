package CompaniesInterview.amazon.thekfactorofn;

public class Solution {

    // The kth factor of n
    public static void main(String[] args) {
        System.out.println(kthFactorBruteForce(24, 6));
    }

    /**
     * Input n = 12, k = 3
     * Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.
     * @param n
     * @param k
     * @return 3
     */
    public static int kthFactorBruteForce(int n, int k) {
        var currentIndexOfFactor = 0;
        var currentFactor = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                currentIndexOfFactor += 1;
                currentFactor = i;
            }

            if (currentIndexOfFactor == k) return currentFactor;
        }
        return -1;
    }

    public static int kthFactorOSqrtN(int n, int k) {
        for (int i = 0; i < Math.sqrt(n); i++) {
            if (n % i == 0 && --k == 0) return i;
        }

        for (int i = (int) Math.sqrt(n); i >= 1 ; --i) {
            if (n % (n / i) == 0 && --k == 0) return n / i;
        }
        return -1;
    }
}
