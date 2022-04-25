public class KthSmallestElement {

    public int kthSmallest(int[] nums, int k) {
        if(nums.length < k) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length -1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start <= end) {
            int p = partition(nums, start, end);
            if (p == k-1) {
                return nums[p];
            } else if (p > k-1) {
                return quickSelect(nums, start, p-1, k);
            } else {
                return quickSelect(nums, p+1, end, k);
            }
        }
        return -1;
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int pivotIndex = start;
        for(int i = start; i <= end; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, pivotIndex);
                pivotIndex++;
            }
        }

        swap(nums, pivotIndex, end);
        return pivotIndex;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
