public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums != null && nums.length > 1) {
            if (k > nums.length) {
                k = k % (nums.length-1);
            }

        }
    }

    private int nextIndex(int index, int length, int k) {
        if (index + k < length - 1) {
            return index + k;
        } else {
            return (index + k ) % (length-1);
        }
    }
}
