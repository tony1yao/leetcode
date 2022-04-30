package dynamic.progromming;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // https://leetcode.com/problems/coin-change/

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i<=amount; i++) {
            for (int coin: coins) {
                if (i >= coin) {
                    if (dp[i-coin] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i-coin]+1);
                    }
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE? -1: dp[amount];
    }


}
