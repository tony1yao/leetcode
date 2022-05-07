package dynamic.progromming;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.isBlank() || text2.isBlank()) {
            return 0;
        }
        char[] sequence1 = text1.toCharArray();
        char[] sequence2 = text2.toCharArray();
        int[][] dp = new int[sequence1.length + 1][sequence2.length + 1];
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[0][1] = 0;
        for(int i = 1; i <= sequence1.length; i++) {
            for(int j = 1; j <= sequence2.length; j++) {
                if (sequence1[i-1] == sequence2[j-1]) {
                    //dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[sequence1.length][sequence2.length];
    }
}
