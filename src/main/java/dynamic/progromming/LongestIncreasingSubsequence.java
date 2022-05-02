package dynamic.progromming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }


        int[] dp = new int[nums.length];
        int max = 1;
        Arrays.fill(dp, 1);
        for(int i = 1; i < nums.length; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1  );
                }
                j--;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
