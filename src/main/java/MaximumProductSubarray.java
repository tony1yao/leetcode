public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for(int i = 1;i < nums.length; i++) {
            int tempMax = max * nums[i];
            int tempMin = min * nums[i];

            max = Math.max(nums[i], Math.max(tempMax, tempMin));
            min = Math.min(nums[i], Math.min(tempMin, tempMax));

            result = Math.max(result, max);
        }
        return result;
    }
}
