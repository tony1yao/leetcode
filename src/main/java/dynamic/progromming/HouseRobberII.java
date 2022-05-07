package dynamic.progromming;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob2(nums, 0, nums.length-1),
                rob2(nums, 1, nums.length));
    }



    public int rob2(int[] nums, int start, int end) {
        int dp[] = new int[end - start];
        if (end - start == 1) {
            return nums[start];
        } else if (end - start  == 2) {
            return Math.max(nums[start], nums[start+1] );
        } else {
            dp[0] = nums[start];
            dp[1] = Math.max(nums[start], nums[start + 1] );
            for (int i = 2; i < end - start; i++) {
                dp[i] = Math.max(dp[i-2] + nums[start + i], dp[i-1]);
            }

            return dp[end - start -1];
        }
    }
}
