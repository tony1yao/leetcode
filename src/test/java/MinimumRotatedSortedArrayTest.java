import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumRotatedSortedArrayTest {
    MinimumRotatedSortedArray sortedArray = new MinimumRotatedSortedArray();

    @Test
    void findMin() {
        int[] nums = {4,5,6,7,8,9,1,2,3};
        Assertions.assertEquals(1, sortedArray.findMin(nums));
    }

    @Test
    void findMin2() {
        int[] nums = {2,1};
        Assertions.assertEquals(1, sortedArray.findMin(nums));
    }

    @Test
    void findMin3() {
        int[] nums = {5,1,2,3,4};
        Assertions.assertEquals(1, sortedArray.findMin(nums));
    }

    @Test
    void findMin4() {
        int[] nums = {11,13,15,17};
        Assertions.assertEquals(11, sortedArray.findMin(nums));
    }

    @Test
    void findMin5() {
        int[] nums = {1};
        Assertions.assertEquals(1, sortedArray.findMin(nums));
    }
}