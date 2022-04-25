public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] leftHalf = new int[nums.length];
        int[] rightHalf = new int[nums.length];
        for(int i = 0 ; i< nums.length; i++) {
            if (i == 0) {
                leftHalf[i] = 1;
            } else {
                leftHalf[i] = leftHalf[i - 1] * nums[i - 1];
            }
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            if (j == nums.length -1 ) {
                rightHalf[j] = 1;
            } else {
                rightHalf[j] = rightHalf[j+1] * nums[j+1];
            }
        }

        int[] result = new int[nums.length];
        for(int i = 0 ; i< nums.length; i++) {
            result[i] = leftHalf[i] * rightHalf[i];
        }

        return result;
    }
}
