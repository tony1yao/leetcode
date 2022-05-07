package dynamic.progromming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumIVTest {
    CombinationSumIV sumIV = new CombinationSumIV();

    @Test
    void combinationSum4() {
        int[] nums = {1,2,3};
        int target = 4;
        Assertions.assertEquals(7, sumIV.combinationSum4(nums, target));
    }

    @Test
    void combinationSum5() {
        int[] nums = {9};
        int target = 3;
        Assertions.assertEquals(0, sumIV.combinationSum4(nums, target));
    }

    @Test
    void combinationSum6() {
        int[] nums = {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
        int target = 10;
        Assertions.assertEquals(9, sumIV.combinationSum4(nums, target));
    }
}