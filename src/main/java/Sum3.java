import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public static void main(String[] args) {
        Sum3 sum3 = new Sum3();
        int[] inputs = {0,0,0,0};
        System.out.print(sum3.threeSum(inputs).toString());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);


        for(int i = 0; i< nums.length; i++) {
            if (i - 1 >= 0) {
                if (nums[i] == nums[i-1]) {
                    continue;
                }
            }
            int leftP = i + 1;
            int rightP = nums.length - 1;
            while (leftP < rightP) {
                int temp = nums[i] + nums[leftP] + nums[rightP];
                if (temp < 0) {
                    int currentLeft = leftP;
                    leftP++;
                    while(nums[currentLeft] == nums[leftP] && leftP < rightP) {
                        leftP++;
                    }
                } else if (temp > 0) {
                    int currentRight = rightP;
                    rightP--;
                    while(nums[currentRight] == nums[rightP] && leftP < rightP) {
                        rightP--;
                    }
                } else {
                    result.add(List.of(nums[i],nums[leftP], nums[rightP]));
                    int currentLeft = leftP;
                    leftP++;
                    while(nums[currentLeft] == nums[leftP] && leftP < rightP) {
                        leftP++;
                    }
                }
            }
        }
        return result;
    }
}
