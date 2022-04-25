public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        return bSearch(nums, 0, nums.length-1, target);
    }

    private int bSearch(int[] nums, int start, int end, int target) {
        if (start == end) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
        int middle = (start + end) / 2;
        if (nums[middle] == target) {
            return middle;
        } else {
            if (middle == start) {
                return nums[end] == target? end: -1;
            } else {
                if (target < nums[middle]) {
                    if (target == nums[start]) {
                        return start;
                    } else if(target > nums[start] || nums[middle] < nums[end]) {
                        return bSearch(nums, start, middle, target);
                    } else {
                        return bSearch(nums, middle + 1, end, target);
                    }
                } else {
                    if (target == nums[end]) {
                        return end;
                    } else if (target < nums[end] || nums[middle] > nums[start]) {
                        return bSearch(nums, middle + 1, end, target);
                    } else {
                        return bSearch(nums, start, middle, target);
                    }
                }
            }
        }
    }
}
