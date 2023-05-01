package leetcodecontest.leetcode343.winnerofbowlinggame;

public class Solution {

    // Link: https://leetcode.com/problems/determine-the-winner-of-a-bowling-game/description/
    public static void main(String[] args) {

    }

    public static int isWinner(int[] player1, int[] player2) {
        int score1 = getScore(player1);
        int score2 = getScore(player2);
        if (score1 > score2) return 1;
        if (score2 > score1) return 2;
        return 0;
    }

    private static int getScore(int[] player) {
        int score = 0;
        for (int i = 0; i < player.length; i++) {
            if (i >= 1 && player[i-1] == 10) {
                score += player[i] * 2;
            } else if (i >=2 && (player[i-2] == 10 || player[i-1] == 10)) {
                score += player[i] * 2;
            } else {
                score += player[i];
            }
        }
        return score;
    }
}
