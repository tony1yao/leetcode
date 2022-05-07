package dynamic.progromming;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++) {
            if(dp[i]) {
                int steps = nums[i];
                for (int j = 1; j <= steps; j++) {
                    if (i + j < nums.length) {
                        dp[i+j] = true;
                    } else {
                        return true;
                    }
                }
            }
        }
        return dp[nums.length-1];
    }
}
