package CompaniesInterview.drw.maximalsizeofsquare;

public class Solution {
    public static void main(String[] args) {

    }

    //Given M units of 1 by 1 square, and N units of 2 by 2 squares. Find the maximum size of square that you can make with them.
    //Example:
    //M = 3, N = 1
    //Output: 2
    //Explanation: You can make a 2 by 2 square with 1 unit of 2 by 2 square and 1 unit of 1 by 1 square.
    //M = 5, N = 1
    //Output: 3
    //Explanation: You can make a 3 by 3 square with 1 unit of 2 by 2 square and 1 unit of 1 by 1 square.
    //Output: 2
    //Constraints:
    //0 <= M <= 1e9
    //0 <= N <= 1e9
    // not sure how to solve this problem
    public static int solution(int M, int N) {
        int count = 0;
        while (M > 0 && N > 0) {
            M = M - 2;
            N = N - 1;
            count++;
        }
        return count;
}
