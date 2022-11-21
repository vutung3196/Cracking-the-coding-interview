package CompaniesInterview.amazon.shoppingproductsearch;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("abcz", "azdb"));
        System.out.println(solution("armaze", "amazon"));
    }

    private static int solution(String searchWord, String resultWord) {
        int j = 0;
        for (int i = 0; i < resultWord.length(); ++i) {
            while (j < searchWord.length() && searchWord.charAt(j) != resultWord.charAt(i)) j++;

            if (j == searchWord.length()) {
                return resultWord.length() - i;
            }
            ++j;
        }
        return 0;
    }
}
