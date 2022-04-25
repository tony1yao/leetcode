public class MinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        return min(nums, 0, nums.length - 1);
    }

    private int min(int[]nums, int start, int end) {
        int middle = (start + end) / 2;
        if (middle == start) {
            return Math.min(nums[start], nums[end] );
        }
        if (isMin(nums, middle)) {
            return nums[middle];
        } else {
            if(nums[nums.length - 1] > nums[middle]) {
                return min(nums, start, middle);
            } else {
                return min(nums, middle, end);
            }
        }
    }

    private boolean isMin(int[] nums , int index) {
        if (index == 0) {
            return nums[index] < nums[index + 1] && nums[index] < nums[nums.length - 1];
        } else if (index == nums.length - 1) {
            return nums[index] < nums[index - 1] && nums[index] < nums[0];
        } else {
            return nums[index] < nums[index - 1] && nums[index] < nums[index + 1];
        }
    }
}
