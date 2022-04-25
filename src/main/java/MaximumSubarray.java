public class MaximumSubarray {


    public static void main(String[] args) {
        MaximumSubarraySolution maximumSubarraySolution = new MaximumSubarraySolution();
        int[] inputs = {-1,-1,-2,-2};
        int result = maximumSubarraySolution.maxSubArray(inputs);
        System.out.println("result is " + result);
    }
}


class MaximumSubarraySolution {

    public int maxSubArray2(int[] nums) {
        int sum = nums[0];
        // temp sum since the starting of the result array
        int temp = 0;
        for(int i = 0; i < nums.length; i++) {
            temp = temp < 0? 0: temp;
            temp += nums[i];
            sum = Math.max(temp, sum);
        }
        return sum;
    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];
        for(int i = 1; i< nums.length; i++) {
            if ((nums[i] >= 0 && (sum + nums[i] < nums[i])) ||
                    (nums[i] < 0 && sum <= nums[i])) {
                maxSum = nums[i];
                sum = nums[i];
            } else {
                sum = sum + nums[i];
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }
}