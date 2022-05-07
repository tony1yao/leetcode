package dynamic.progromming;

public class HouseRobber {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1] );
        } else {
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1] );
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            }

            return dp[nums.length -1];
        }
    }
}
